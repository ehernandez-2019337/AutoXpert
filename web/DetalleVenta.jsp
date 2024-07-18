<%-- 
    Document   : DetalleVenta
    Created on : 15/08/2023, 10:21:10 PM
    Author     : andres
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" href="css/vistas.css">
        <title>Página Detalle Venta</title>
    </head>
    <body style="background: currentColor;">
        <div class="d-flex" style="background-color: ">
            <div class="card col-sm-4" style="background-color: currentColor;">
                <div class="card-body" style="background-color: currentColor;">
                    <form class="dark-form" action="Controlador?menu=DetalleVenta" method="POST">
                        <div class="form-group">
                            <label style="color: #fff">Cantidad:</label>
                            <input type="text" value="${detalleVenta.getCantidad()}" name="txtCantidad" class="form-control">
                        </div>
                        <div class="form-group">
                            <label style="color: #fff">Código Vehiculo:</label>
                            <select id="codigoVehiculo" name="cmbCodigoVehiculo">
                                <option disabled selected value="">Selecciona una opción</option>
                                <c:forEach var="vehiculo" items="${vehiculos}">
                                    <option value="${vehiculo.getCodigoVehiculo()}">${vehiculo.getCodigoVehiculo()}. ${vehiculo.getMarca()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label style="color: #fff">Código Venta:</label>
                            <select id="codigoVenta" name="cmbCodigoVenta">
                                <option disabled selected value="">Selecciona una opción</option>
                                <c:forEach var="venta" items="${ventas}">serv
                                    <option value="${venta.getCodigoVenta()}">${venta.getCodigoVenta()}. ${venta.getFechaVenta()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-custom-agregar">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-custom-actualizar">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr style="color: #fff">
                            <td class="text-center"><strong>CODIGO</strong></td>
                            <td class="text-center"><strong>CANTIDAD</strong></td>
                            <td class="text-center"><strong>CODIGO VEHICULO</strong></td>
                            <td class="text-center"><strong>CODIGO VENTA</strong></td>
                            <td class="text-center"><strong>ACCIONES</strong></td>
                        </tr>
                    </thead>
                    <tbody style="background: currentColor;">
                        <c:forEach var="detalleVenta" items="${detalleVentas}">
                            <tr>
                                <td style="color: #fff" class="text-center">${detalleVenta.getCodigoDetalleVenta()}</td>
                                <td style="color: #fff">${detalleVenta.getCantidad()}</td>
                                <td style="color: #fff" class="text-center">${detalleVenta.getCodigoVehiculo()}</td>
                                <td style="color: #fff" class="text-center">${detalleVenta.getCodigoVenta()}</td>
                                <td style="color: #fff" class="text-center">
                                    <a class="btn btn-custom-editar" href="Controlador?menu=DetalleVenta&accion=Editar&codigoDetalleVenta=${detalleVenta.getCodigoDetalleVenta()}">Editar</a>
                                    <a class="btn btn-danger" href="Controlador?menu=DetalleVenta&accion=Eliminar&codigoDetalleVenta=${detalleVenta.getCodigoDetalleVenta()}">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    </body>
</html>