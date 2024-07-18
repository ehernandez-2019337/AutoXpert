package modelo;

public class DetalleCompra{
	private int codigoDetalleCompra;
	private int codigoVehiculo;
	private int cantidad;
	private double precio;
	private int codigoCompra;

	public DetalleCompra(){
	}

    public DetalleCompra(int codigoDetalleCompra, int codigoVehiculo, int cantidad, double precio, int codigoCompra) {
        this.codigoDetalleCompra = codigoDetalleCompra;
        this.codigoVehiculo = codigoVehiculo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.codigoCompra = codigoCompra;
    }

    public int getCodigoDetalleCompra() {
        return codigoDetalleCompra;
    }

    public void setCodigoDetalleCompra(int codigoDetalleCompra) {
        this.codigoDetalleCompra = codigoDetalleCompra;
    }

    public int getCodigoVehiculo() {
        return codigoVehiculo;
    }

    public void setCodigoVehiculo(int codigoVehiculo) {
        this.codigoVehiculo = codigoVehiculo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(int codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

        
}