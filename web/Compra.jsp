<%-- 
    Document   : Compra
    Created on : 14/08/2023, 04:02:32 PM
    Author     : Manuel Eduardo González Avalos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" href="css/vistas.css">
        <title>Página Compra</title>
    </head>
    <body style="background: currentColor">
        <div class="d-flex">
            <div class="card col-sm-4" style="background-color: currentColor">
                <div class="card-body" style="background-color: currentColor">
                    <form action="Controlador?menu=Compra" method="POST">
                        <div class="form-group">
                            <label style="color: #fff">Número de compra:</label>
                            <input type="text" name="txtNumeroCompra" value="${compra.getNumeroCompra()}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label style="color: #fff">Fecha de Compra:</label>
                            <input type="date" name="txtFechaCompra" value="${compra.getFechaCompra()}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label style="color: #fff">Total de Compra:</label>
                            <input type="text" name="txtTotalCompra" value="${compra.getTotalCompra()}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label style="color: #fff">Código del Proveedor:</label>
                            <select id="Proveedor" name="cmbCodigoProveedor">
                                <option disabled selected value="">Selecciona una opción</option>
                                <c:forEach var="proveedor" items="${proveedores}">
                                    <option value="${proveedor.getCodigoProveedor()}">${proveedor.getCodigoProveedor()}. ${proveedor.getNombreProveedor()}</option>
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
                            <td style="text-align: center">CÓDIGO</td>
                            <td style="text-align: center">NÚMERO COMPRA</td>
                            <td style="text-align: center">FECHA COMPRA</td>
                            <td style="text-align: center">TOTAL COMPRA</td>
                            <td style="text-align: center">CÓDIGO PROVEEDOR</td>
                            <td style="text-align: center">ACCIONES</td>
                        </tr>
                    </thead>
                    <tbody style="background: currentColor">
                        <c:forEach var="compra" items="${compras}">
                            <tr style="color: #fff">
                                <td style="text-align: center; color: #fff">${compra.getCodigoCompra()}</td>
                                <td style="text-align: center; color: #fff">${compra.getNumeroCompra()}</td>
                                <td style="text-align: center; color: #fff">${compra.getFechaCompra()}</td>
                                <td style="color: #fff">Q   ${compra.getTotalCompra()}</td>
                                <td style="text-align: center; color: #fff">${compra.getCodigoProveedor()}</td>
                                <td>
                                    <a class="btn btn-custom-editar" href="Controlador?menu=Compra&accion=Editar&codigoCompra=${compra.getCodigoCompra()}">Editar</a>
                                    <a class="btn btn-danger" href="Controlador?menu=Compra&accion=Eliminar&codigoCompra=${compra.getCodigoCompra()}">Eliminar</a>
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
