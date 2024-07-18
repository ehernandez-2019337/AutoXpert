/*
 *  Christian Emanuel Itzep Lemus
 *  2019528
 *  IN5AM
 *  Fecha de creación
 *      17/07/2023
 */
package modelo;

import config.Conexion;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;



public class EmpleadoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;
    
    public Empleado validar (String usuario, String DPIEmpleado){
        Empleado empleado = new Empleado();
        String sql = "Select * from Empleado where usuario = ? and DPIEmpleado = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            ps.setString(1, usuario);
            ps.setString(2, DPIEmpleado);
            rs = ps.executeQuery();
            while (rs.next()){
                empleado.setCodigoEmpleado(rs.getInt("codigoEmpleado"));
                empleado.setDPIEmpleado(rs.getString("DPIEmpleado"));
                empleado.setPrimerNombre(rs.getString("primerNombre"));
                empleado.setApellidos(rs.getString("apellidos"));
                empleado.setUsuario(rs.getString("usuario"));
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
            return empleado;
        }
    //Lista fotos
    public void listarImagen(int codigoEmpleado, HttpServletResponse response){
        String sql = "select * from Empleado where codigoEmpleado="+codigoEmpleado;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        response.setContentType("img/*");
        try{
            outputStream = response.getOutputStream();
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                inputStream = rs.getBinaryStream("foto");
            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            int i = 0;
            while((i=bufferedInputStream.read())!=-1){
                bufferedOutputStream.write(i);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    
    //Listar
    public List listar(){
        String sql = "select * from Empleado";
        List <Empleado> listaEmpleado = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Empleado em = new Empleado();
                em.setCodigoEmpleado(rs.getInt(1));
                em.setDPIEmpleado(rs.getString(2));
                em.setPrimerNombre(rs.getString(3));
                em.setOtrosNombres(rs.getString(4));
                em.setApellidos(rs.getString(5));
                em.setTelefonoEmpleado(rs.getString(6));
                em.setDireccionEmpleado(rs.getString(7));
                em.setEstadoEmpleado(rs.getBoolean(8));
                em.setUsuario(rs.getString(9));
                em.setFoto(rs.getBinaryStream(10));
                em.setCodigoSucursal(rs.getInt(11));
                em.setCodigoTipoEmpleado(rs.getInt(12));
                listaEmpleado.add(em);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaEmpleado;
    }
    //Agregar
    public int agregar (Empleado emp){
        String sql = "Insert into Empleado (DPIEmpleado, primerNombre, otrosNombres, apellidos, telefonoEmpleado, direccionEmpleado, estadoEmpleado, usuario, foto, codigoSucursal, codigoTipoEmpleado) values (?,?,?,?,?,?,?,?,?,?,?)";
        try{
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            ps.setString(1, emp.getDPIEmpleado());
            ps.setString(2, emp.getPrimerNombre());
            ps.setString(3, emp.getOtrosNombres());
            ps.setString(4, emp.getApellidos());
            ps.setString(5, emp.getTelefonoEmpleado());
            ps.setString(6, emp.getDireccionEmpleado());
            ps.setBoolean(7, emp.getEstadoEmpleado());
            ps.setString(8, emp.getUsuario());
            ps.setBlob(9, emp.getFoto());
            ps.setInt(10, emp.getCodigoSucursal());
            ps.setInt(11, emp.getCodigoTipoEmpleado());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("No se agrego el registro");
        }
        return resp;
    }
    //Buscar por código
    public Empleado listaCodigoEmpleado(int id){
        Empleado emp = new Empleado();
        String sql = "Select * from Empleado where codigoEmpleado = " +id;
        try{
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                emp.setDPIEmpleado(rs.getString(2));
                emp.setPrimerNombre(rs.getString(3));
                emp.setOtrosNombres(rs.getString(4));
                emp.setApellidos(rs.getString(5));
                emp.setTelefonoEmpleado(rs.getString(6));
                emp.setDireccionEmpleado(rs.getString(7));
                emp.setEstadoEmpleado(rs.getBoolean(8));
                emp.setUsuario(rs.getString(9));
//                emp.setFoto(rs.getBinaryStream(10));
                emp.setCodigoSucursal(rs.getInt(10));
                emp.setCodigoTipoEmpleado(rs.getInt(11));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return emp;
    }
    //Editar
    public int actualizar(Empleado emp){
        String sql = "Update Empleado set DPIEmpleado =?, primerNombre =?, otrosNombres =?, apellidos =?, telefonoEmpleado =?, direccionEmpleado =?, estadoEmpleado=?, usuario=?, foto=?" + "where codigoEmpleado = ?";
        try{
            con = cn.Conexion();
            ps  = con.prepareCall(sql);
            ps.setString(1, emp.getDPIEmpleado());
            ps.setString(2, emp.getPrimerNombre());
            ps.setString(3, emp.getOtrosNombres());
            ps.setString(4, emp.getApellidos());
            ps.setString(5, emp.getTelefonoEmpleado());
            ps.setString(6, emp.getDireccionEmpleado());
            ps.setBoolean(7, emp.getEstadoEmpleado());
            ps.setString(8, emp.getUsuario());
            ps.setBinaryStream(9, emp.getFoto());
            ps.setInt(10, emp.getCodigoEmpleado());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    //Eliminar
    public void eliminar (int id){
        String sql = "Delete from Empleado where codigoEmpleado = "+id;
        try{
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            ps.executeUpdate();   
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
