/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.InputStream;
import static java.lang.Boolean.parseBoolean;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.CarritoCompras;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Compra;
import modelo.CompraDAO;
import modelo.DetalleCompra;
import modelo.DetalleCompraDAO;
import modelo.DetalleVenta;
import modelo.DetalleVentaDAO;
import modelo.Empleado;
import modelo.EmpleadoDAO;
import modelo.Proveedor;
import modelo.ProveedorDAO;
import modelo.Sucursal;
import modelo.SucursalDAO;
import modelo.Sucursal_has_Compra;
import modelo.Sucursal_has_CompraDAO;
import modelo.TipoCliente;
import modelo.TipoClienteDAO;
import modelo.TipoEmpleado;
import modelo.TipoEmpleadoDAO;
import modelo.TipoVehiculo;
import modelo.TipoVehiculoDAO;
import modelo.Vehiculo;
import modelo.VehiculoDAO;
import modelo.Venta;
import modelo.VentaDAO;

/**
 *
 * @author DELL
 *
 */
@MultipartConfig

public class Controlador extends HttpServlet {

    Empleado empleado = new Empleado();
    EmpleadoDAO empleadoDao = new EmpleadoDAO();
    Vehiculo vehiculo = new Vehiculo();
    VehiculoDAO vehiculoDao = new VehiculoDAO();
    int codVehiculo;
    Proveedor proveedor = new Proveedor();
    ProveedorDAO proveedorDao = new ProveedorDAO();
    int codProveedor;
    int codEmpleado;
    int codSucursal;
    Sucursal sucursal = new Sucursal();
    SucursalDAO sucursalDao = new SucursalDAO();
    Compra compra = new Compra();
    CompraDAO compraDao = new CompraDAO();
    int codCompra;
    Sucursal_has_Compra sucursal_compra = new Sucursal_has_Compra();
    Sucursal_has_CompraDAO sucursal_compraDao = new Sucursal_has_CompraDAO();
    int codSucursalCompra;
    //Tipo Empleado
    int codTipoEmpleado;
    TipoEmpleado tipoempleado = new TipoEmpleado();
    TipoEmpleadoDAO tipoEmpleadoDao = new TipoEmpleadoDAO();

    DetalleVenta detalleVenta = new DetalleVenta();
    DetalleVentaDAO detalleVentaDao = new DetalleVentaDAO();

    //Detalle Compra
    DetalleCompra detalleCompra = new DetalleCompra();
    DetalleCompraDAO detalleCompraDao = new DetalleCompraDAO();
    int codDetalleCompra;

    Venta venta = new Venta();
    VentaDAO ventaDao = new VentaDAO();
    int codVenta;
    Cliente cliente = new Cliente();
    ClienteDAO clienteDao = new ClienteDAO();
    TipoCliente tipoCliente = new TipoCliente();
    TipoClienteDAO tipoClienteDao = new TipoClienteDAO();
    int codTipoCliente;
    TipoVehiculo tipoVe = new TipoVehiculo();
    TipoVehiculoDAO tipoVDao = new TipoVehiculoDAO();
    int codTipoVehiculo;
    int codDetalleVenta;
    int codCliente;
    List<CarritoCompras> listaCarrito = new ArrayList<>();
    int item;
    double totalPagar = 0.0;
    int cantidad = 1;
    int stock;
    //Variables del Carrito de Compras

    int idp;
    CarritoCompras car;
    boolean carroLista = false;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        } else if (menu.equals("Empleado")) {
            switch (accion) {
                case "Listar":
                    List listaEmpleados = empleadoDao.listar();
                    request.setAttribute("empleados", listaEmpleados);
                    List listaSucursales = sucursalDao.listar();
                    request.setAttribute("sucursales", listaSucursales);
                    List listaTipoEmpleado = tipoEmpleadoDao.listar();
                    request.setAttribute("tipoempleado", listaTipoEmpleado);
                    break;
                case "Agregar":
                    String DPI = request.getParameter("txtDPIEmpleado");
                    String primer = request.getParameter("txtPrimerNombre");
                    String otros = request.getParameter("txtOtrosNombres");
                    String ape = request.getParameter("txtApellidos");
                    String tel = request.getParameter("txtTelefono");
                    String dire = request.getParameter("txtDireccion");
                    Boolean est = Boolean.parseBoolean(request.getParameter("txtEstado"));
                    String user = request.getParameter("txtUsuario");
                    Part part = request.getPart("imagen");
                    InputStream input = part.getInputStream();
                    int sucu = Integer.parseInt(request.getParameter("cmbSucursal"));
                    int tipo = Integer.parseInt(request.getParameter("cmbTipoEm"));
                    empleado.setDPIEmpleado(DPI);
                    empleado.setPrimerNombre(primer);
                    empleado.setOtrosNombres(otros);
                    empleado.setApellidos(ape);
                    empleado.setTelefonoEmpleado(tel);
                    empleado.setDireccionEmpleado(dire);
                    empleado.setEstadoEmpleado(true);
                    empleado.setUsuario(user);
                    empleado.setFoto(input);
                    empleado.setCodigoSucursal(sucu);
                    empleado.setCodigoTipoEmpleado(tipo);
                    empleadoDao.agregar(empleado);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codEmpleado = Integer.parseInt(request.getParameter("codigoEmpleado"));
                    Empleado e = empleadoDao.listaCodigoEmpleado(codEmpleado);
                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String DPIactu = request.getParameter("txtDPIEmpleado");
                    String primeractu = request.getParameter("txtPrimerNombre");
                    String otrosactu = request.getParameter("txtOtrosNombres");
                    String apeactu = request.getParameter("txtApellidos");
                    String telactu = request.getParameter("txtTelefono");
                    String direactu = request.getParameter("txtDireccion");
                    Boolean estactu = Boolean.parseBoolean(request.getParameter("txtEstado"));
                    String useractu = request.getParameter("txtUsuario");
                    Part paractu = request.getPart("imagen");
                    InputStream inputactu = paractu.getInputStream();
                    empleado.setDPIEmpleado(DPIactu);
                    empleado.setPrimerNombre(primeractu);
                    empleado.setOtrosNombres(otrosactu);
                    empleado.setApellidos(apeactu);
                    empleado.setTelefonoEmpleado(telactu);
                    empleado.setDireccionEmpleado(direactu);
                    empleado.setEstadoEmpleado(estactu);
                    empleado.setUsuario(useractu);
                    empleado.setFoto(inputactu);
                    empleado.setCodigoEmpleado(codEmpleado);
                    empleadoDao.actualizar(empleado);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codEmpleado = Integer.parseInt(request.getParameter("codigoEmpleado"));
                    empleadoDao.eliminar(codEmpleado);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
            //Sucursal
        } else if (menu.equals("Sucursal")) {
            switch (accion) {
                case "Listar":
                    List listaSucursales = sucursalDao.listar();
                    request.setAttribute("sucursales", listaSucursales);
                    break;
                case "Agregar":
                    String nombreSucursal = request.getParameter("txtNombreSucursal");
                    String direccion = request.getParameter("txtDireccion");
                    String telefonoSucursal = request.getParameter("txtTelefonoSucursal");
                    String correoSucursal = request.getParameter("txtCorreoSucursal");
                    boolean estadoSucursal = Boolean.valueOf(request.getParameter("txtEstadoSucursal"));
                    sucursal.setNombreSucursal(nombreSucursal);
                    sucursal.setDireccion(direccion);
                    sucursal.setTelefonoSucursal(telefonoSucursal);
                    sucursal.setCorreoSucursal(correoSucursal);
                    sucursal.setEstadoSucursal(estadoSucursal);
                    sucursalDao.agregar(sucursal);
                    request.getRequestDispatcher("Controlador?menu=Sucursal&accion=Listar").forward(request, response);
                    break;
                //Editar de sucursal
                case "Editar":
                    codSucursal = Integer.parseInt(request.getParameter("codigoSucursal"));
                    Sucursal s = sucursalDao.listaCodigoSucursal(codSucursal);
                    request.setAttribute("sucursal", s);
                    request.getRequestDispatcher("Controlador?menu=Sucursal&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nombreSucu = request.getParameter("txtNombreSucursal");
                    String dire = request.getParameter("txtDireccion");
                    String telefonoSucu = request.getParameter("txtTelefonoSucursal");
                    String correoSucu = request.getParameter("txtCorreoSucursal");
                    Boolean estadoSucu = parseBoolean(request.getParameter("txtEstadoSucursal"));
                    sucursal.setNombreSucursal(nombreSucu);
                    sucursal.setDireccion(dire);
                    sucursal.setTelefonoSucursal(telefonoSucu);
                    sucursal.setCorreoSucursal(correoSucu);
                    sucursal.setEstadoSucursal(estadoSucu);
                    sucursal.setCodigoSucursal(codSucursal);
                    sucursalDao.actualizar(sucursal);
                    request.getRequestDispatcher("Controlador?menu=Sucursal&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codSucursal = Integer.parseInt(request.getParameter("codigoSucursal"));
                    sucursalDao.eliminar(codSucursal);
                    request.getRequestDispatcher("Controlador?menu=Sucursal&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Sucursal.jsp").forward(request, response);
        } else if (menu.equals("Vehiculo")) {
            switch (accion) {
                case "Listar":

                    List listaVehiculos = vehiculoDao.listar();
                    List listaTipoVehiculo = tipoVDao.listar();

                    request.setAttribute("vehiculos", listaVehiculos);//podemos colocar cualquier nombre
                    request.setAttribute("listaTipoVehiculo", listaTipoVehiculo);

                    break;
                case "Agregar":
                    String marca = request.getParameter("txtMarcaVehiculo");
                    String modelo = request.getParameter("txtModeloVehiculo");
                    String color = request.getParameter("txtColorVehiculo");
                    String cantPuertas = request.getParameter("cmbCantPuertas");
                    double precio = Double.parseDouble(request.getParameter("numberPrecio"));
                    System.out.println("ESTE ES EL PRECIO: " + precio);
                    stock = Integer.parseInt(request.getParameter("txtStockVehiculo"));

                    Part part = request.getPart("imagenVehiculo");
                    InputStream input = part.getInputStream();

                    String disponibilidad = request.getParameter("cmbDisponible");
                    String codigoTipoVehiculo = request.getParameter("cmbTipoVehiculo");

                    vehiculo.setMarca(marca);
                    vehiculo.setModelo(modelo);
                    vehiculo.setColor(color);
                    vehiculo.setCantidadPuertas(Integer.parseInt(cantPuertas));
                    vehiculo.setPrecio(precio);
                    vehiculo.setStock(stock);
                    vehiculo.setImagen(input);
                    if ("1".equals(disponibilidad)) {
                        vehiculo.setEstadoVehiculo(true);
                    } else {
                        vehiculo.setEstadoVehiculo(false);
                    }

                    vehiculo.setCodigoTipoVehiculo(Integer.parseInt(codigoTipoVehiculo));

                    vehiculoDao.agregarVehiculo(vehiculo);
                    request.getRequestDispatcher("Controlador?menu=Vehiculo&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codVehiculo = Integer.parseInt(request.getParameter("codigoVehiculo"));
                    Vehiculo v2 = vehiculoDao.listarCodigoVehiculo(codVehiculo);
                    request.setAttribute("vehiculo", v2);
                    request.getRequestDispatcher("Controlador?menu=Vehiculo&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":

                    String marc = request.getParameter("txtMarcaVehiculo");
                    String model = request.getParameter("txtModeloVehiculo");
                    String colo = request.getParameter("txtColorVehiculo");
                    String cantPuerta = request.getParameter("cmbCantPuertas");
                    stock = Integer.parseInt(request.getParameter("txtStockVehiculo"));
                    double preciomodificado = Double.parseDouble(request.getParameter("numberPrecio"));
                    Part part2 = request.getPart("imagenVehiculo");
                    InputStream input2 = part2.getInputStream();

                    int disponibilida = Integer.parseInt(request.getParameter("cmbDisponible"));
                    int codigoTipoVehicul = Integer.parseInt(request.getParameter("cmbTipoVehiculo"));

                    vehiculo.setCodigoVehiculo(codVehiculo);
                    vehiculo.setMarca(marc);
                    vehiculo.setModelo(model);
                    vehiculo.setColor(colo);
                    vehiculo.setCantidadPuertas(Integer.parseInt(cantPuerta));
                    vehiculo.setPrecio(preciomodificado);
                    vehiculo.setStock(stock);
                    vehiculo.setImagen(input2);
                    if (disponibilida == 1) {
                        vehiculo.setEstadoVehiculo(true);
                    } else {
                        vehiculo.setEstadoVehiculo(false);
                    }

                    vehiculo.setCodigoTipoVehiculo(codigoTipoVehicul);

                    vehiculoDao.editar(vehiculo);
                    request.getRequestDispatcher("Controlador?menu=Vehiculo&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codVehiculo = Integer.parseInt(request.getParameter("codigoVehiculo"));
                    vehiculoDao.eliminar(codVehiculo);
                    request.getRequestDispatcher("Controlador?menu=Vehiculo&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Vehiculo.jsp").forward(request, response);
            //proveedor
        } else if (menu.equals("Proveedor")) {
            switch (accion) {
                case "Listar":
                    List listaProveedor = proveedorDao.listar();
                    request.setAttribute("proveedores", listaProveedor);
                    break;
                case "Agregar":
                    String nombre = request.getParameter("txtNombreProveedor");
                    String nit = request.getParameter("txtNitProveedor");
                    String telefono = request.getParameter("txtTelefonoProveedor");
                    String direccion = request.getParameter("txtDireccionProveedor");
                    Boolean est = Boolean.parseBoolean(request.getParameter("txtEstadoProveedor"));
                    System.out.println(nombre + " " + nit + " " + telefono + " " + direccion + " " + est);

                    proveedor.setNombreProveedor(nombre);
                    proveedor.setNitProveedor(nit);
                    proveedor.setTelefonoProveedor(telefono);
                    proveedor.setDireccionProveedor(direccion);
                    proveedor.setEstadoProveedor(est);
                    proveedorDao.agregar(proveedor);
                    request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codProveedor = Integer.parseInt(request.getParameter("codigoProveedor"));
                    Proveedor p = proveedorDao.listarCodigoProveedor(codProveedor);
                    request.setAttribute("proveedor", p);
                    request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nombrePro = request.getParameter("txtNombreProveedor");
                    String nitPro = request.getParameter("txtNitProveedor");
                    String telefonoPro = request.getParameter("txtTelefonoProveedor");
                    String direccionPro = request.getParameter("txtDireccionProveedor");
                    Boolean estPro = Boolean.parseBoolean(request.getParameter("txtEstadoProveedor"));

                    proveedor.setCodigoProveedor(codProveedor);
                    proveedor.setNombreProveedor(nombrePro);
                    proveedor.setNitProveedor(nitPro);
                    proveedor.setTelefonoProveedor(telefonoPro);
                    proveedor.setDireccionProveedor(direccionPro);
                    proveedor.setEstadoProveedor(estPro);
                    proveedorDao.editar(proveedor);
                    request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codProveedor = Integer.parseInt(request.getParameter("codigoProveedor"));
                    proveedorDao.eliminar(codProveedor);
                    request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Proveedor.jsp").forward(request, response);
        } else if (menu.equals("Compra")) {
            switch (accion) {
                case "Listar":
                    List listaCompra = compraDao.listar();
                    request.setAttribute("compras", listaCompra);
                    List listaProveedor = proveedorDao.listar();
                    request.setAttribute("proveedores", listaProveedor);
                    break;
                case "Agregar":
                    int Numero = Integer.parseInt(request.getParameter("txtNumeroCompra"));
                    Date Fecha = Date.valueOf(request.getParameter("txtFechaCompra"));
                    Double Total = Double.parseDouble(request.getParameter("txtTotalCompra"));
                    int Proveedor = Integer.parseInt(request.getParameter("cmbCodigoProveedor"));
                    compra.setNumeroCompra(Numero);
                    compra.setFechaCompra(Fecha);
                    compra.setTotalCompra(Total);
                    compra.setCodigoProveedor(Proveedor);
                    compraDao.agregar(compra);
                    request.getRequestDispatcher("Controlador?menu=Compra&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codCompra = Integer.parseInt(request.getParameter("codigoCompra"));
                    Compra C = compraDao.listarCodigoCompra(codCompra);
                    request.setAttribute("compra", C);
                    request.getRequestDispatcher("Controlador?menu=Compra&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    compra.setCodigoCompra(codCompra);
                    int NumeroCompra = Integer.parseInt(request.getParameter("txtNumeroCompra"));
                    Date FechaCompra = Date.valueOf(request.getParameter("txtFechaCompra"));
                    Double TotalCompra = Double.parseDouble(request.getParameter("txtTotalCompra"));
                    compra.setNumeroCompra(NumeroCompra);
                    compra.setFechaCompra(FechaCompra);
                    compra.setTotalCompra(TotalCompra);
                    compraDao.actualizar(compra);
                    request.getRequestDispatcher("Controlador?menu=Compra&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codCompra = Integer.parseInt(request.getParameter("codigoCompra"));
                    compraDao.eliminar(codCompra);
                    request.getRequestDispatcher("Controlador?menu=Compra&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Compra.jsp").forward(request, response);
        } else if (menu.equals("Sucursal_has_Compra")) {
            switch (accion) {
                case "Listar":
                    List listaSucursalCompra = sucursal_compraDao.listar();
                    request.setAttribute("sucursales_has_compras", listaSucursalCompra);
                    List listaSucursal = sucursalDao.listar();
                    request.setAttribute("sucursales", listaSucursal);
                    List listaCompra = compraDao.listar();
                    request.setAttribute("compras", listaCompra);
                    break;
                case "Agregar":
                    int CodSucursal = Integer.parseInt(request.getParameter("cmbCodigoSucursal"));
                    int CodCompra = Integer.parseInt(request.getParameter("cmbCodigoCompra"));
                    sucursal_compra.setCodigoSucursal(CodSucursal);
                    sucursal_compra.setCodigoCompra(CodCompra);
                    sucursal_compraDao.agregar(sucursal_compra);
                    request.getRequestDispatcher("Controlador?menu=Sucursal_has_Compra&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codSucursalCompra = Integer.parseInt(request.getParameter("Sucursal_codigoSucursal"));
                    sucursal_compraDao.eliminar(codSucursalCompra);
                    request.getRequestDispatcher("Controlador?menu=Sucursal_has_Compra&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Sucursal_has_Compra.jsp").forward(request, response);
        } //Parte de Tipo Empleado
        else if (menu.equals("TipoEmpleado")) {
            switch (accion) {
                case "Listar":
                    List TipoEmpleado = tipoEmpleadoDao.listar();
                    request.setAttribute("tipoempleado", TipoEmpleado);
                    break;
                case "Agregar":
                    String descripcionTipoEmpleado = request.getParameter("txtDescripcion");
                    Double sueldoB = Double.parseDouble(request.getParameter("txtSueldoBase"));
                    Double bonific = Double.parseDouble(request.getParameter("txtBonificacion"));
                    Double bonificaciomEm = Double.parseDouble(request.getParameter("txtBonificacionEmpresa"));
                    tipoempleado.setDescripcion(descripcionTipoEmpleado);
                    tipoempleado.setSueldoBase(sueldoB);
                    tipoempleado.setBonificacion(bonific);
                    tipoempleado.setBonificacionEmpresa(bonificaciomEm);
                    tipoEmpleadoDao.agregar(tipoempleado);
                    request.getRequestDispatcher("Controlador?menu=TipoEmpleado&accion=Listar").forward(request, response);

                    break;
                case "Editar":
                    codTipoEmpleado = Integer.parseInt(request.getParameter("codigoTipoEmpleado"));
                    TipoEmpleado tp = tipoEmpleadoDao.listaTipoEmpleado(codTipoEmpleado);
                    request.setAttribute("tipoem", tp);
                    request.getRequestDispatcher("Controlador?menu=TipoEmpleado&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":
                    String descripcionTipoEm = request.getParameter("txtDescripcion");
                    Double sueldoBa = Double.parseDouble(request.getParameter("txtSueldoBase"));
                    Double bonifica = Double.parseDouble(request.getParameter("txtBonificacion"));
                    Double bonificacionEmpre = Double.parseDouble(request.getParameter("txtBonificacionEmpresa"));
                    tipoempleado.setDescripcion(descripcionTipoEm);
                    tipoempleado.setSueldoBase(sueldoBa);
                    tipoempleado.setBonificacion(bonifica);
                    tipoempleado.setBonificacionEmpresa(bonificacionEmpre);
                    tipoempleado.setCodigoTipoEmpleado(codTipoEmpleado);
                    tipoEmpleadoDao.actualizar(tipoempleado);
                    request.getRequestDispatcher("Controlador?menu=TipoEmpleado&accion=Listar").forward(request, response);
                    break;

                case "Eliminar":
                    codTipoEmpleado = Integer.parseInt(request.getParameter("codigoTipoEmpleado"));
                    tipoEmpleadoDao.eliminar(codTipoEmpleado);
                    request.getRequestDispatcher("Controlador?menu=TipoEmpleado&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("TipoEmpleado.jsp").forward(request, response);
            // Finzaliza Tipo Empleado
        } else if (menu.equals("DetalleVenta")) {
            switch (accion) {
                case "Listar":
                    List DetalleVenta = detalleVentaDao.listar();
                    List Vehiculo = vehiculoDao.listar();
                    List Venta = ventaDao.listarVenta();
                    request.setAttribute("ventas", Venta);
                    request.setAttribute("vehiculos", Vehiculo);
                    request.setAttribute("detalleVentas", DetalleVenta);
                    break;
                case "Agregar":
                    int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
                    int codigoVehiculo = Integer.parseInt(request.getParameter("cmbCodigoVehiculo"));
                    int codigoVenta = Integer.parseInt(request.getParameter("cmbCodigoVenta"));
                    detalleVenta.setCantidad(cantidad);
                    detalleVenta.setCodigoVehiculo(codigoVehiculo);
                    detalleVenta.setCodigoVenta(codigoVenta);
                    detalleVentaDao.agregar(detalleVenta);
                    request.getRequestDispatcher("Controlador?menu=DetalleVenta&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codDetalleVenta = Integer.parseInt(request.getParameter("codigoDetalleVenta"));
                    DetalleVenta dv = detalleVentaDao.listarCodigoDetalleVenta(codDetalleVenta);
                    request.setAttribute("detalleVenta", dv);
                    request.getRequestDispatcher("Controlador?menu=DetalleVenta&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    int cantidadDv = Integer.parseInt(request.getParameter("txtCantidad"));
                    int codigoVehiculoDv = Integer.parseInt(request.getParameter("txtCodigoVehiculo"));
                    int codigoVentaDv = Integer.parseInt(request.getParameter("txtCodigoVenta"));
                    detalleVenta.setCantidad(cantidadDv);
                    detalleVenta.setCodigoVehiculo(codigoVehiculoDv);
                    detalleVenta.setCodigoVenta(codigoVentaDv);
                    detalleVenta.setCodigoDetalleVenta(codDetalleVenta);
                    detalleVentaDao.actualizar(detalleVenta);
                    request.getRequestDispatcher("Controlador?menu=DetalleVenta&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codDetalleVenta = Integer.parseInt(request.getParameter("codigoDetalleVenta"));
                    detalleVentaDao.eliminar(codDetalleVenta);
                    request.getRequestDispatcher("Controlador?menu=DetalleVenta&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("DetalleVenta.jsp").forward(request, response);
        } else if (menu.equals("DetalleCompra")) {
            switch (accion) {
                case "Listar":
                    List DetalleCompra = detalleCompraDao.listar();
                    List Vehiculo = vehiculoDao.listar();
                    List Compra = compraDao.listar();
                    request.setAttribute("compras", Compra);
                    request.setAttribute("vehiculos", Vehiculo);
                    request.setAttribute("detallecompras", DetalleCompra);
                    break;
                case "Agregar":
                    int codigoVehiculo = Integer.parseInt(request.getParameter("cmbCodigoVehiculo"));
                    int cantidad = Integer.parseInt(request.getParameter("txtCantidadDetalleCompra"));
                    Double precio = Double.parseDouble(request.getParameter("txtPrecioDetalleCompra"));
                    int codigoCompra = Integer.parseInt(request.getParameter("cmbCodigoCompra"));
                    detalleCompra.setCodigoVehiculo(codigoVehiculo);
                    detalleCompra.setCantidad(cantidad);
                    detalleCompra.setPrecio(precio);
                    detalleCompra.setCodigoCompra(codigoCompra);
                    detalleCompraDao.agregar(detalleCompra);
                    request.getRequestDispatcher("Controlador?menu=DetalleCompra&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codDetalleCompra = Integer.parseInt(request.getParameter("codigoDetalleCompra"));
                    DetalleCompra dc = detalleCompraDao.listarCodigoDetalleCompra(codDetalleCompra);
                    request.setAttribute("detalleCompra", dc);
                    request.getRequestDispatcher("Controlador?menu=DetalleCompra&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    int codigoVehiculoDc = Integer.parseInt(request.getParameter("cmbCodigoVehiculo"));
                    int cantidadDc = Integer.parseInt(request.getParameter("txtCantidadDetalleCompra"));
                    Double precioDc = Double.parseDouble(request.getParameter("txtPrecioDetalleCompra"));
                    int codigoCompraDc = Integer.parseInt(request.getParameter("cmbCodigoCompra"));
                    detalleCompra.setCodigoVehiculo(codigoVehiculoDc);
                    detalleCompra.setCantidad(cantidadDc);
                    detalleCompra.setPrecio(precioDc);
                    detalleCompra.setCodigoCompra(codigoCompraDc);
                    detalleCompra.setCodigoDetalleCompra(codDetalleCompra);
                    detalleCompraDao.actualizar(detalleCompra);
                    request.getRequestDispatcher("Controlador?menu=DetalleCompra&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codDetalleCompra = Integer.parseInt(request.getParameter("codigoDetalleCompra"));
                    detalleCompraDao.eliminar(codDetalleCompra);
                    request.getRequestDispatcher("Controlador?menu=DetalleCompra&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("DetalleCompra.jsp").forward(request, response);
        } else if (menu.equals("Venta")) {
            switch (accion) {
                case "Listar":
                    List listaVentas = ventaDao.listarVenta();
                    request.setAttribute("ventas", listaVentas);
                    List listaEmpleado = empleadoDao.listar();
                    request.setAttribute("empleados", listaEmpleado);
                    List listaCliente = clienteDao.listar();
                    request.setAttribute("clientes", listaCliente);
                    break;
                case "Agregar":
                    String fecha = request.getParameter("txtFechaVenta");
                    String hora = request.getParameter("txtHoraVenta");
                    Double total = Double.valueOf(request.getParameter("txtTotalVenta"));
                    Boolean estado = Boolean.valueOf(request.getParameter("txtEstadoVenta"));
                    int codEmpleado = Integer.parseInt(request.getParameter("txtCodigoEmpleado"));
                    int codCliente = Integer.parseInt(request.getParameter("txtCodigoCliente"));
                    venta.setFechaVenta(Date.valueOf(fecha));
                    venta.setHoraVenta(hora);
                    venta.setTotalVenta(total);
                    venta.setEstadoVenta(estado);
                    venta.setCodigoEmpleado(codEmpleado);
                    venta.setCodigoCliente(codCliente);
                    ventaDao.agregarVenta(venta);
                    request.getRequestDispatcher("Controlador?menu=Venta&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codVenta = Integer.parseInt(request.getParameter("codigoVenta"));
                    Venta v = ventaDao.buscarVenta(codVenta);
                    request.setAttribute("venta", v);
                    request.getRequestDispatcher("Controlador?menu=Venta&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String fechas = request.getParameter("txtFechaVenta");
                    String horas = request.getParameter("txtHoraVenta");
                    Double totales = Double.valueOf(request.getParameter("txtTotalVenta"));
                    Boolean estados = Boolean.valueOf(request.getParameter("txtEstadoVenta"));
                    int codEmpleados = Integer.parseInt(request.getParameter("txtCodigoEmpleado"));
                    int codClientes = Integer.parseInt(request.getParameter("txtCodigoCliente"));
                    venta.setFechaVenta(Date.valueOf(fechas));
                    venta.setHoraVenta(horas);
                    venta.setTotalVenta(totales);
                    venta.setEstadoVenta(estados);
                    venta.setCodigoEmpleado(codEmpleados);
                    venta.setCodigoCliente(codClientes);
                    venta.setCodigoVenta(codVenta);
                    ventaDao.editarVenta(venta);
                    request.getRequestDispatcher("Controlador?menu=Venta&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codVenta = Integer.parseInt(request.getParameter("codigoVenta"));
                    ventaDao.eliminarVenta(codVenta);
                    request.getRequestDispatcher("Controlador?menu=Venta&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("WebVenta.jsp").forward(request, response);
        } else if (menu.equals("Cliente")) {
            switch (accion) {
                case "Listar":
                    List listaClientes = clienteDao.listar();
                    request.setAttribute("clientes", listaClientes);
                    List listarTipoCliente = tipoClienteDao.listar();
                    request.setAttribute("tipoClientes", listarTipoCliente);

                    break;
                case "Agregar":
                    String nombres = request.getParameter("txtNombresCliente");
                    String apellidos = request.getParameter("txtApellidoCliente");
                    String nit = request.getParameter("txtNitCliente");
                    String telefonoCliente = request.getParameter("txtTelefonoCliente");
                    String direccionCliente = request.getParameter("txtDireccionCliente");
                    String correoCliente = request.getParameter("txtCorreoCliente");
                    boolean estadoCliente = Boolean.parseBoolean(request.getParameter("txtEstadoCliente"));
                    int codigoTipoCliente = Integer.parseInt(request.getParameter("cmbTipoClien"));
                    cliente.setNombres(nombres);
                    cliente.setApellidos(apellidos);
                    cliente.setNit(nit);
                    cliente.setTelefonoCliente(telefonoCliente);
                    cliente.setDireccionCliente(direccionCliente);
                    cliente.setCorreoCliente(correoCliente);
                    cliente.setEstadoCliente(estadoCliente);
                    cliente.setCodigoTipoCliente(codigoTipoCliente);
                    clienteDao.agregar(cliente);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codCliente = Integer.parseInt(request.getParameter("codigoCliente"));
                    Cliente c = clienteDao.listarCodigoCliente(codCliente);
                    request.setAttribute("cliente", c);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nombresClien = request.getParameter("txtNombresCliente");
                    String apellidosClien = request.getParameter("txtApellidoCliente");
                    String nitClien = request.getParameter("txtNitCliente");
                    String TelefonoClien = request.getParameter("txtTelefonoCliente");
                    String direClien = request.getParameter("txtDireccionCliente");
                    String correoClien = request.getParameter("txtCorreoCliente");
                    boolean esCliente = Boolean.parseBoolean(request.getParameter("txtEstadoCliente"));
                    cliente.setNombres(nombresClien);
                    cliente.setApellidos(apellidosClien);
                    cliente.setNit(nitClien);
                    cliente.setTelefonoCliente(TelefonoClien);
                    cliente.setDireccionCliente(direClien);
                    cliente.setCorreoCliente(correoClien);
                    cliente.setEstadoCliente(esCliente);
                    cliente.setCodigoCliente(codCliente);
                    clienteDao.actualizar(cliente);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codCliente = Integer.parseInt(request.getParameter("codigoCliente"));
                    clienteDao.eliminar(codCliente);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Cliente.jsp").forward(request, response);
        } else if (menu.equals("TipoCliente")) {
            switch (accion) {
                case "Listar":
                    List listaTipoClientes = tipoClienteDao.listar();
                    request.setAttribute("tipoClientes", listaTipoClientes);
                    break;
                case "Agregar":
                    String tipo = request.getParameter("txtTipoCliente");
                    String descripcion = request.getParameter("txtDescripcion");
                    boolean estado = Boolean.parseBoolean(request.getParameter("txtEstado"));
                    tipoCliente.setTipoCliente(tipo);
                    tipoCliente.setDescripcion(descripcion);
                    tipoCliente.setEstadoTipoCliente(estado);
                    tipoClienteDao.agregar(tipoCliente);
                    request.getRequestDispatcher("Controlador?menu=TipoCliente&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    codTipoCliente = Integer.parseInt(request.getParameter("codigoTipoCliente"));
                    TipoCliente tp = tipoClienteDao.listarTipoCliente(codTipoCliente);
                    request.setAttribute("tipoCliente", tp);
                    request.getRequestDispatcher("Controlador?menu=TipoCliente&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String tipoCli = request.getParameter("txtTipoCliente");
                    String descripcionCli = request.getParameter("txtDescripcion");
                    boolean estadoCli = Boolean.parseBoolean(request.getParameter("txtEstado"));
                    tipoCliente.setTipoCliente(tipoCli);
                    tipoCliente.setDescripcion(descripcionCli);
                    tipoCliente.setEstadoTipoCliente(estadoCli);
                    tipoCliente.setCodigoTipoCliente(codTipoCliente);
                    tipoClienteDao.actualizar(tipoCliente);
                    request.getRequestDispatcher("Controlador?menu=TipoCliente&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    codTipoCliente = Integer.parseInt(request.getParameter("codigoTipoCliente"));
                    tipoClienteDao.eliminar(codTipoCliente);
                    request.getRequestDispatcher("Controlador?menu=TipoCliente&accion=Listar").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("TipoCliente.jsp").forward(request, response);
        } else if (menu.equals("TipoVehiculo")) {
            switch (accion) {
                case "Listar":
                    List listaTipoVehiculo = tipoVDao.listar();
                    request.setAttribute("tipoVe", listaTipoVehiculo);
                    break;
                case "Agregar":
                    String categoria = request.getParameter("txtCategoria");
                    String descrip = request.getParameter("txtDescripcion");
                    boolean estado = Boolean.parseBoolean(request.getParameter("txtEstado"));
                    tipoVe.setCategoria(categoria);
                    tipoVe.setDescripcion(descrip);
                    tipoVe.setEstadoActivo(true);
                    tipoVDao.agregar(tipoVe);
                    request.getRequestDispatcher("Controlador?menu=TipoVehiculo&accion=Listar").forward(request, response);

                    break;
                case "Editar":
                    codTipoVehiculo = Integer.parseInt(request.getParameter("codigoTipoVehiculo"));
                    TipoVehiculo t = tipoVDao.listarCodigoTipoVehiculo(codTipoVehiculo);
                    request.setAttribute("tipoVehiculo", t);
                    request.getRequestDispatcher("Controlador?menu=TipoVehiculo&accion=Listar").forward(request, response);
                    break;

                case "Actualizar":
                    String categoriaT = request.getParameter("txtCategoria");
                    String descripT = request.getParameter("txtDescripcion");
                    boolean estadoT = Boolean.parseBoolean(request.getParameter("txtEstado"));
                    tipoVe.setCategoria(categoriaT);
                    tipoVe.setDescripcion(descripT);
                    tipoVe.setEstadoActivo(estadoT);
                    tipoVe.setCodigoTipoVehiculo(codTipoVehiculo);
                    tipoVDao.editar(tipoVe);
                    request.getRequestDispatcher("Controlador?menu=TipoVehiculo&accion=Listar").forward(request, response);

                    break;
                case "Eliminar":
                    codTipoVehiculo = Integer.parseInt(request.getParameter("codigoTipoVehiculo"));
                    tipoVDao.eliminar(codTipoVehiculo);
                    request.getRequestDispatcher("Controlador?menu=TipoVehiculo&accion=Listar").forward(request, response);
                    break;

            }
            request.getRequestDispatcher("TipoVehiculo.jsp").forward(request, response);
        } else if (menu.equals("Inventario")) {
            switch (accion) {
                case "Comprar":
                    totalPagar = 0.0;
                    idp = Integer.parseInt(request.getParameter("codigoVehiculo"));
                    vehiculo = vehiculoDao.listarCodigoVehiculo(idp);
                    item = item + 1;
                    car = new CarritoCompras();
                    car.setItem(item);
                    car.setIdProducto(vehiculo.getCodigoVehiculo());
                    car.setMarca(vehiculo.getMarca());
                    car.setModeloCarro(vehiculo.getModelo());
                    car.setPrecioCompra(vehiculo.getPrecio());
                    car.setCantidad(cantidad);
                    car.setSubTotal(cantidad * vehiculo.getPrecio());
                    listaCarrito.add(car);
                    for (int i = 0; i < listaCarrito.size(); i++) {
                        totalPagar = totalPagar + listaCarrito.get(i).getSubTotal();
                    }
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("carrito", listaCarrito);
                    request.setAttribute("contador", listaCarrito.size());
                    request.getRequestDispatcher("carrito.jsp").forward(request, response);
                case "Listar":
                    try {
                        List listaVehiculos = vehiculoDao.listar();
                        request.setAttribute("vehiculos", listaVehiculos);//podemos colocar cualquier nombre
                        request.getRequestDispatcher("Inventario.jsp").forward(request, response);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "AgregarCarrito":
                    idp = Integer.parseInt(request.getParameter("codigoVehiculo"));
                    vehiculo = vehiculoDao.listarCodigoVehiculo(idp);
                    
                    car = new CarritoCompras();
                    
                    car.setIdProducto(vehiculo.getCodigoVehiculo());
                    car.setMarca(vehiculo.getMarca());
                    car.setModeloCarro(vehiculo.getModelo());
                    car.setPrecioCompra(vehiculo.getPrecio());
                    car.setCantidad(cantidad);
                    

                    for (int i = 0; i < listaCarrito.size(); i++) {
                        if (listaCarrito.get(i).getIdProducto() == vehiculo.getCodigoVehiculo()) {
                            
                            listaCarrito.get(i).setCantidad(listaCarrito.get(i).getCantidad() + cantidad);
                            listaCarrito.get(i).setSubTotal((listaCarrito.get(i).getCantidad())*car.getPrecioCompra());
                            
                            carroLista = true;
                        }
                    }
                    
                    if (!carroLista) {
                        item = item + 1;
                        car.setItem(item);
                        car.setSubTotal(car.getCantidad() * vehiculo.getPrecio());
                        listaCarrito.add(car);
                    }
                    carroLista = false;
                    request.setAttribute("contador", listaCarrito.size());
                    request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
                    break;
                case "Carrito":
                    totalPagar = 0.0;
                    request.setAttribute("carrito", listaCarrito);
                    for (int i = 0; i < listaCarrito.size(); i++) {
                        totalPagar = totalPagar + listaCarrito.get(i).getSubTotal();
                    }
                    request.setAttribute("totalPagar", totalPagar);
                    request.getRequestDispatcher("carrito.jsp").forward(request, response);
                    break;
                case "cancelar":
                    listaCarrito.clear();
                    request.getRequestDispatcher("Controlador?menu=Inventario&accion=Carrito").forward(request, response);
                    break;
            }
            request.getRequestDispatcher("Inventario.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
