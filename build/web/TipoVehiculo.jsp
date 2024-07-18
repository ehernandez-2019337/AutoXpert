<%-- 
    Document   : TipoVehiculo
    Created on : 16/08/2023, 11:21:35 PM
    Author     : emers
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" href="css/vistas.css"></link>
       
        <title>Pagina Tipo Vehiculo</title>
    </head>
    <body style="background: currentColor;">
        <div class="d-flex" style=" background-color: ">
            <div class="card col-sm-4"  style=" background-color: currentColor; ">
                <div class="card-body" style=" background-color: currentColor; ">
                    <form action="Controlador?menu=TipoVehiculo" method="POST">
                        <div class="form-group">
                            <label style="color: #fff">Categoria:</label>
                            <input type="text" value="${tipoVehiculo.getCategoria()}" name="txtCategoria" class="form-control">
                        </div>
                        
                        <div class="form-group">
                            <label style="color: #fff">Descripcion:</label>
                            <input type="text" value="${tipoVehiculo.getDescripcion()}" name="txtDescripcion" class="form-control">
                        </div>
                        <div class="form-group">
                            <label style="color: #fff">Estado Activo:</label>
                            <input type="text" value="${tipoVehiculo.isEstadoActivo()}" name="txtEstado" class="form-control">
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
                            <td>CODIGO</td>
                            <td>CATEGORIA</td>
                            <td>DESCRIPCION</td>
                            <td>ESTADO ACTIVO</td>
                            <td>ACCIONES</td>
                        </tr>
                    </thead> 
                    <tbody style="background: currentColor;">
                        <c:forEach var="tipoVe" items="${tipoVe}">
                        <tr>
                             <td style="color: #fff" align="left">${tipoVe.getCodigoTipoVehiculo()} </td>
                             <td style="color: #fff" align="left">${tipoVe.getCategoria()} </td>
                             <td style="color: #fff" align="left">${tipoVe.getDescripcion()} </td>
                             <td style="color: #fff" align="left">${tipoVe.isEstadoActivo()} </td>
                            
                            <td>
                               <a class="btn btn-custom-editar" href="Controlador?menu=TipoVehiculo&accion=Editar&codigoTipoVehiculo=${tipoVe.getCodigoTipoVehiculo()}">Editar</a>
                                <a class="btn btn-danger" href="Controlador?menu=TipoVehiculo&accion=Eliminar&codigoTipoVehiculo=${tipoVe.getCodigoTipoVehiculo()}">Eliminar</a>
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

