<%-- 
    Document   : Sucursal_has_Compra
    Created on : 14/08/2023, 04:03:04 PM
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
        <title>Página Sucursales y Compras</title>
    </head>
    <body style="background: currentColor">
        <div class="d-flex">
            <div class="card col-sm-4" style="background-color: currentColor">
                <div class="card-body" style="background-color: currentColor">
                    <form action="Controlador?menu=Sucursal_has_Compra" method="POST">
                        <div class="form-group">
                            <label style="color: #fff">Código Sucursal:</label>
                            <select id="Sucursal" name="cmbCodigoSucursal">
                                <option disabled selected value="">Selecciona una opción</option>
                                <c:forEach var="sucursal" items="${sucursales}">
                                    <option value="${sucursal.getCodigoSucursal()}">${sucursal.getCodigoSucursal()}. ${sucursal.getNombreSucursal()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label style="color: #fff">Código Compra:</label>
                            <select id="Compra" name="cmbCodigoCompra">
                                <option disabled selected value="">Selecciona una opción</option>
                                <c:forEach var="compra" items="${compras}">
                                    <option value="${compra.getCodigoCompra()}">${compra.getCodigoCompra()}. ${compra.getTotalCompra()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-custom-agregar">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr style="color: #fff">
                            <td style="text-align: center">CÓDIGO SUCURSAL Y COMPRA</td>
                            <td style="text-align: center">CÓDIGO SUCURSAL</td>
                            <td style="text-align: center">CÓDIGO COMPRA</td>
                            <td style="text-align: center">ACCIONES</td>
                        </tr>
                    </thead>
                    <tbody style="background: currentColor">
                        <c:forEach var="succom" items="${sucursales_has_compras}">
                            <tr style="color: #fff">
                                <td style="color: #fff; text-align: center">${succom.getSucursal_codigoSucursal()}</td>
                                <td style="color: #fff; text-align: center">${succom.getCodigoSucursal()}</td>
                                <td style="color: #fff; text-align: center">${succom.getCodigoCompra()}</td>
                                <td>
                                    <a class="btn btn-danger" href="Controlador?menu=Sucursal_has_Compra&accion=Eliminar&Sucursal_codigoSucursal=${succom.getSucursal_codigoSucursal()}">Eliminar</a>
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
