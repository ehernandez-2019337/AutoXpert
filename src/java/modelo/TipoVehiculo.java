
package modelo;


public class TipoVehiculo {
    private int codigoTipoVehiculo;
    private String categoria;
    private String descripcion;
    private boolean estadoActivo;

    public TipoVehiculo() {
    }

    public TipoVehiculo(int codigoTipoVehiculo, String categoria, String descripcion, boolean estadoActivo) {
        this.codigoTipoVehiculo = codigoTipoVehiculo;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.estadoActivo = estadoActivo;
    }

    public int getCodigoTipoVehiculo() {
        return codigoTipoVehiculo;
    }

    public void setCodigoTipoVehiculo(int codigoTipoVehiculo) {
        this.codigoTipoVehiculo = codigoTipoVehiculo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstadoActivo() {
        return estadoActivo;
    }

    public void setEstadoActivo(boolean estadoActivo) {
        this.estadoActivo = estadoActivo;
    }

    @Override
    public String toString() {
        return codigoTipoVehiculo + " | " + categoria;
    }

  
    
    
    

    

   
    
}
