/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class TipoVehiculoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps; 
    ResultSet rs;
    int resp;
    
    // Listar
     public List listar(){
        String sql = "select * from TipoVehiculo";
        List<TipoVehiculo> listaTipoVehiculo = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                TipoVehiculo tv = new TipoVehiculo();
                tv.setCodigoTipoVehiculo(rs.getInt(1));
                tv.setCategoria(rs.getString(2));
                tv.setDescripcion(rs.getString(3));
                tv.setEstadoActivo(rs.getBoolean(4));
                listaTipoVehiculo.add(tv);
            }     
        }catch(Exception e){
            e.printStackTrace();
         }
         return listaTipoVehiculo;
    } 
     
     
    // Agregar
    public int agregar(TipoVehiculo tv){
       String sql = "Insert into TipoVehiculo(categoria, descripcion, estadoActivo) values(?,?,?)";
       try{
           con = cn.Conexion();
           ps = con.prepareStatement(sql);
           ps.setString(1, tv.getCategoria());
           ps.setString(2, tv.getDescripcion());
           ps.setBoolean(3, tv.isEstadoActivo());
           ps.executeUpdate();
       }catch(Exception e){
           e.printStackTrace();
       }
        return resp;
    }
    
    // Listar por codigoVehiculo
    public TipoVehiculo listarCodigoTipoVehiculo(int id){
        TipoVehiculo tv = new TipoVehiculo();
        String sql = "Select * from TipoVehiculo where codigoTipoVehiculo = "+ id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                tv.setCategoria(rs.getString(2));
                tv.setDescripcion(rs.getString(3));
                tv.setEstadoActivo(rs.getBoolean(4));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return tv;
    }
    
    // Editar
    public int editar(TipoVehiculo tv){
         String sql = "Update TipoVehiculo set  categoria = ?, descripcion = ?, estadoActivo = ? where codigoTipoVehiculo = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, tv.getCategoria());
            ps.setString(2, tv.getDescripcion());
            ps.setBoolean(3, tv.isEstadoActivo());
            ps.setInt(4, tv.getCodigoTipoVehiculo());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
        return resp;
    }
    
    // ELiminar
    public void eliminar(int id){
        String sql = "delete from TipoVehiculo where codigoTipoVehiculo = "+id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}




