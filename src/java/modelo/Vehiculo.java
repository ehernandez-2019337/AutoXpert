package modelo;

import java.io.InputStream;

/**
 *
 * @author Joshua Elí Isaac Realiquez Sosa
 * 2019342
 * IN5AM
 * Fecha de creación:
 * 18/07/2023
 */
public class Vehiculo {
    private int codigoVehiculo;
    private String marca;
    private String modelo;
    private String color;
    private int cantidadPuertas;
    private double precio;
    private int stock;
    private InputStream imagen;
    private boolean estadoVehiculo;
    private int codigoTipoVehiculo;
    
    public Vehiculo(){}

    public Vehiculo(int codigoVehiculo, String marca, String modelo, String color, int cantidadPuertas, double precio, int stock, InputStream imagen, boolean estadoVehiculo, int codigoTipoVehiculo) {
        this.codigoVehiculo = codigoVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.cantidadPuertas = cantidadPuertas;
        this.precio = precio;
        this.stock = stock;
        this.imagen = imagen;
        this.estadoVehiculo = estadoVehiculo;
        this.codigoTipoVehiculo = codigoTipoVehiculo;
    }

    
    
    public int getCodigoVehiculo() {
        return codigoVehiculo;
    }

    public void setCodigoVehiculo(int codigoVehiculo) {
        this.codigoVehiculo = codigoVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCantidadPuertas() {
        return cantidadPuertas;
    }

    public void setCantidadPuertas(int cantidadPuertas) {
        this.cantidadPuertas = cantidadPuertas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public InputStream getImagen() {
        return imagen;
    }

    public void setImagen(InputStream imagen) {
        this.imagen = imagen;
    }

    public boolean isEstadoVehiculo() {
        return estadoVehiculo;
    }

    public void setEstadoVehiculo(boolean estadoVehiculo) {
        this.estadoVehiculo = estadoVehiculo;
    }

    public int getCodigoTipoVehiculo() {
        return codigoTipoVehiculo;
    }

    public void setCodigoTipoVehiculo(int codigoTipoVehiculo) {
        this.codigoTipoVehiculo = codigoTipoVehiculo;
    }

    
    
    @Override
    public String toString() {
        return codigoVehiculo + "| " + marca + ", " + modelo;
    }
}

    
    
    
    
    
    
