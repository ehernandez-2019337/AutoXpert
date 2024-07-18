<%-- 
    Document   : DetalleCompra
    Created on : 14/08/2023, 12:26:43 PM
    Author     : estra
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" href="css/vistas.css"></link>
        <title>DetalleCompra</title>
    </head>
    <body style="background: currentColor;">
        <div class="d-flex" style=" background-color: ">
            <div class="card col-sm-4"  style=" background-color: currentColor; ">  
                <div class="card-body"  style=" background-color: currentColor; ">
                    <form action="Controlador?menu=DetalleCompra" method="POST">
                        
                        <div class="form-group">
                            <label style="color: #fff"> Código Vehiculo </label>
                            <!-- <input type="text" value="${detalleCompra.getCodigoVehiculo()}" name="txtCodigoVehiculo" class="form-control"> -->
                            <select name="cmbCodigoVehiculo">
                                <option disabled selected value="0">Seleccione una opción</option>
                                <c:forEach var="vehiculo" items="${vehiculos}">
                                    <option value="${vehiculo.getCodigoVehiculo()}" >${vehiculo.getCodigoVehiculo()} | ${vehiculo.getMarca()}</option>
                                </c:forEach>
                                    
                            </select>
                        </div>
                        <div class="form-group">
                            <label style="color: #fff"> Cantidad </label>
                            <input type="text" value="${detalleCompra.getCantidad()}" name="txtCantidadDetalleCompra" class="form-control">
                        </div>
                        <div class="form-group">
                            <label style="color: #fff"> Precio </label>
                            <input type="text" value="${detalleCompra.getPrecio()}" name="txtPrecioDetalleCompra" class="form-control">
                        </div>
                        <div class="form-group">
                            <label style="color: #fff"> Código Compra </label>
                            <select name="cmbCodigoCompra">
                                <option disabled selected value="">Seleccione una opción</option>
                                <c:forEach var="compra" items="${compras}">
                                    <option value="${compra.getCodigoCompra()}">${compra.getCodigoCompra()} | ${compra.getNumeroCompra()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-custom-agregar">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-custom-actualizar">
                    </form>
                </div>
            </div>       
            <div class="col-sm-8" style="background: currentColor">
                <table class="table table-hover" >
                    <thead>
                        <tr style="color: #fff">
                            <td><strong>CODIGO DETALLE COMPRA</strong></td>
                            <td><strong>CODIGO VEHICULO</strong></td>
                            <td><strong>CANTIDAD</strong></td>
                            <td><strong>PRECIO</strong></td>
                            <td><strong>CODIGO COMPRA</strong></td>
                            <td><strong>ACCIONES</strong></td>
                        </tr>
                    </thead>
                    <tbody style="background: currentColor;">
                        <c:forEach var="detallecompra" items="${detallecompras}">
                        <tr>
                            <td style="color: #fff" align="center">${detallecompra.getCodigoDetalleCompra()}</td>
                            <td style="color: #fff" align="center">${detallecompra.getCodigoVehiculo()}</td>
                            <td style="color: #fff" align="center">${detallecompra.getCantidad()}</td>
                            <td style="color: #fff">Q.${detallecompra.getPrecio()}</td>
                            <td style="color: #fff" align="center">${detallecompra.getCodigoCompra()}</td>
                            <td>
                                <a class="btn btn-custom-editar" href="Controlador?menu=DetalleCompra&accion=Editar&codigoDetalleCompra=${detallecompra.getCodigoDetalleCompra()}">Editar</a>
                                <a class="btn btn-danger" href="Controlador?menu=DetalleCompra&accion=Eliminar&codigoDetalleCompra=${detallecompra.getCodigoDetalleCompra()}">Eliminar</a>
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