/*
    Manuel Eduardo González Avalos
    2021391
    IN5AM
    Fecha de Creación: 18-07-2023
*/
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Sucursal_has_CompraDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement PS;
    ResultSet RS;
    int resp;
    
    public List listar(){
        String sql = "SELECT * FROM Sucursal_has_Compra";
        List<Sucursal_has_Compra> listaSucursal = new ArrayList<>();
        try{
            con = cn.Conexion();
            PS = con.prepareStatement(sql);
            RS = PS.executeQuery();
            while(RS.next()){
                Sucursal_has_Compra SC = new Sucursal_has_Compra();
                SC.setSucursal_codigoSucursal(RS.getInt(1));
                SC.setCodigoSucursal(RS.getInt(2));
                SC.setCodigoCompra(RS.getInt(3));
                listaSucursal.add(SC);
            }
        }catch(Exception SQL){
            SQL.printStackTrace();
        }
        return listaSucursal;
    }
    
    public int agregar(Sucursal_has_Compra sucursal_compra) {
        String sql = "INSERT INTO Sucursal_has_Compra(codigoSucursal, codigoCompra)" +
            "VALUES (?, ?)";
        try{
            con = cn.Conexion();
            PS = con.prepareStatement(sql);
            PS.setInt(1, sucursal_compra.getCodigoSucursal());
            PS.setInt(2, sucursal_compra.getCodigoCompra());
            PS.executeUpdate();
        }catch(Exception SQL){
            SQL.printStackTrace();
        }
        return resp;
    }
    
    public Sucursal_has_Compra listarSucursal_has_Compra(int ID){
        Sucursal_has_Compra SC = new Sucursal_has_Compra();
        String sql = "SELECT * FROM Sucursal_has_Compra WHERE Sucursal_codigoSucursal = " + ID;
        try{
            con = cn.Conexion();
            PS = con.prepareStatement(sql);
            RS = PS.executeQuery();
            while(RS.next()){
                SC.setCodigoSucursal(RS.getInt(2));
                SC.setCodigoCompra(RS.getInt(3));
            }
        }catch(Exception SQL){
            SQL.printStackTrace();
        }
        return SC;
    }
    
    public int actualizar(Sucursal_has_Compra sucursal_compra){
        String sql="UPDATE Sucursal_has_Compra SET codigoSucursal = ?, codigoCompra = ? WHERE Sucursal_codigoSucursal = ?";
        try{
            con = cn.Conexion();
            PS = con.prepareStatement(sql);
            PS.setInt(1, sucursal_compra.getCodigoSucursal());
            PS.setInt(2, sucursal_compra.getCodigoCompra());
            PS.setInt(3, sucursal_compra.getSucursal_codigoSucursal());
            PS.executeUpdate();
        }catch(Exception SQL){
            SQL.printStackTrace();
        }
        return resp;
    }
    
    public int eliminar(int ID){
        String sql="DELETE FROM Sucursal_has_Compra WHERE Sucursal_codigoSucursal = " + ID;
        try{
            con = cn.Conexion();
            PS = con.prepareStatement(sql);
            PS.executeUpdate();
        }catch(Exception SQL){
            SQL.printStackTrace();
        }
        return resp;
    }
}
