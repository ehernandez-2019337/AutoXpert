package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetalleCompraDAO{
	Conexion cn = new Conexion();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int resp;

	public List listar(){
		String sql = "Select * from detalleCompra";
		List<DetalleCompra> listaDetalleCompra = new ArrayList<>();
		try{
			con = cn.Conexion();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				DetalleCompra dc = new DetalleCompra();
				dc.setCodigoDetalleCompra(rs.getInt(1));
				dc.setCodigoVehiculo(rs.getInt(2));
				dc.setCantidad(rs.getInt(3));
				dc.setPrecio(rs.getDouble(4));
				dc.setCodigoCompra(rs.getInt(5));
                                listaDetalleCompra.add(dc);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return listaDetalleCompra;
	}

	public int agregar(DetalleCompra detc){
		String sql = "insert into DetalleCompra (codigoVehiculo, cantidad, precio, codigoCompra) values (?,?,?,?)";
		try{
			con = cn.Conexion();
			ps = con.prepareStatement(sql);
                        ps.setInt(1, detc.getCodigoVehiculo());
			ps.setInt(2, detc.getCantidad());
			ps.setDouble(3, detc.getPrecio());
			ps.setInt(4, detc.getCodigoCompra());
                        ps.executeUpdate();
		} catch (Exception e){
			e.printStackTrace();
		}
		return resp;
	}
        
        public Compra listarCodigoCompra(int Id) {
        Compra compra = new Compra();
        String sql = "SELECT * FROM Compra WHERE codigoCompra = " + Id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                compra.setNumeroCompra(rs.getInt(2));
                compra.setFechaCompra(rs.getDate(3));
                compra.setTotalCompra(rs.getDouble(4));
                compra.setCodigoProveedor(rs.getInt(5));
            }
        }catch(Exception SQL){
            SQL.printStackTrace();
        }
        return compra;
    }

        public Vehiculo listarCodigoVehiculo(int Id) {
        Vehiculo vehiculo = new Vehiculo();
        String sql = "SELECT * FROM Vehiculo WHERE codigoVehiculo = " + Id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                vehiculo.setMarca(rs.getString(2));
                vehiculo.setModelo(rs.getString(3));
                vehiculo.setColor(rs.getString(4));
                vehiculo.setCantidadPuertas(rs.getInt(5));
                vehiculo.setStock(rs.getInt(6));
                vehiculo.setEstadoVehiculo(rs.getBoolean(7));
                vehiculo.setCodigoTipoVehiculo(rs.getInt(8));
            }
        }catch(Exception SQL){
            SQL.printStackTrace();
        }
        return vehiculo;
    }
        
	public DetalleCompra listarCodigoDetalleCompra(int id){
		DetalleCompra detc = new DetalleCompra();
		String sql = "Select * from DetalleCompra where codigoDetalleCompra = " + id;
		try {
			con = cn.Conexion();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				detc.setCodigoVehiculo(rs.getInt(2));
				detc.setCantidad(rs.getInt(3));
				detc.setPrecio(rs.getDouble(4));
				detc.setCodigoCompra(rs.getInt(5));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return detc;
	}

	public int actualizar(DetalleCompra detc){
		String sql = "update DetalleCompra set cantidad = ? , precio = ?"
                        + "where codigoDetalleCompra = ?";
		try{
			con = cn.Conexion();
			ps = con.prepareStatement(sql);
			ps.setInt(1, detc.getCantidad());
			ps.setDouble(2, detc.getPrecio());
			ps.setInt(3, detc.getCodigoDetalleCompra());
			ps.executeUpdate();
		}catch(SQLException error){
			error.printStackTrace();
		}catch(Exception e){
                        e.printStackTrace();
                }
		return resp;
	}

	public void eliminar(int id){
		String sql = "delete from DetalleCompra where codigoDetalleCompra = " + id;
		try{
			con = cn.Conexion();
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

    public void listarCodigoVehiculo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}