<%-- 
    Document   : Sucursal
    Created on : 16/08/2023, 02:54:40 PM
    Author     : 24gab
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" href="css/vistas.css"></link>
        <title>Sucursal</title>
    </head>
    <body  style="background: currentColor;">
        <div class="d-flex" style=" background-color: ">
            <div class="card col-sm-4" style=" background-color: currentColor; ">
                <div class="card-body" style=" background-color: currentColor; ">
                    <form action="Controlador?menu=Sucursal" method="POST">
                        
 
                        <div class="form-group">
                            <label style="color: #fff" >Nombre de la Sucursal:</label>
                            <input type="text"  value="${sucursal.getNombreSucursal()}" name="txtNombreSucursal" class="form-control">
                        </div>
                        <div class="form-group">
                            <label style="color: #fff">Dirección:</label>
                            <input type="text" value="${sucursal.getDireccion()}" name="txtDireccion"  class="form-control">
                        </div>
                        <div class="form-group">
                            <label style="color: #fff">Telefono:</label>
                            <input type="text" value="${sucursal.getTelefonoSucursal()}" name="txtTelefonoSucursal"  class="form-control">
                        </div>
                        <div class="form-group">
                            <label style="color: #fff">Correo:</label>
                            <input type="text" value="${sucursal.getCorreoSucursal()}" name="txtCorreoSucursal"  class="form-control">
                        </div>
                        <div class="form-group">
                            <label style="color: #fff">Estado:</label>
                            <input type="text"  value="${sucursal.getEstadoSucursal()}" name="txtEstadoSucursal"  class="form-control">
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
                            <td class="text-center">CODIGO</td>
                            <td class="text-center">NOMBRE</td>
                            <td class="text-center">DIRECCION</td>
                            <td class="text-center">TELEFONO</td>
                            <td class="text-center">CORREO</td>
                            <td class="text-center">ESTADO</td> 
                        </tr>
                    </thead>
                    <tbody  style="background: currentColor;">
                        <c:forEach var="sucursal" items="${sucursales}">
                        <tr style="color: #fff">
                            <td  style="color: #fff">${sucursal.getCodigoSucursal()}</td>
                            <td style="color: #fff">${sucursal.getNombreSucursal()}</td>
                            <td style="color: #fff">${sucursal.getDireccion()}</td>
                            <td style="color: #fff">${sucursal.getTelefonoSucursal()}</td>
                            <td style="color: #fff">${sucursal.getCorreoSucursal()}</td>
                            <td style="color: #fff">${sucursal.getEstadoSucursal()}</td>
                            <td>
                                <a class="btn btn-custom-editar" href="Controlador?menu=Sucursal&accion=Editar&codigoSucursal=${sucursal.getCodigoSucursal()}">Editar</a>
                                <a class="btn btn-danger" href="Controlador?menu=Sucursal&accion=Eliminar&codigoSucursal=${sucursal.getCodigoSucursal()}">Eliminar</a>
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
