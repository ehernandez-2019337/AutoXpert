<%-- 
    Document   : Cliente
    Created on : 14/08/2023, 11:48:33 AM
    Author     : Hans
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Página Cliente</title>
        <script>
            function deshabilitarSelect() {
                var selectElement = document.getElementById("TipoCliente");
                selectElement.disabled = true;
            }
            
        </script>
    </head>
    <body style="background: currentColor;">    
        <div class="d-flex" style=" background-color:">
            <div class="card col-sm-4" style=" background-color: currentColor; ">
                <div class="card-body" style=" background-color: currentColor; ">
                    <form action="Controlador?menu=Cliente"method="POST">
                        <div class="form-group">
                            <label style="color: #fff">Nombres:</label>
                            <input type="text" value="${cliente.getNombres()}" name="txtNombresCliente" class="form-control">
                        </div>
                        <div class="form-group">
                            <label style="color: #fff">Apellidos:</label>
                            <input type="text" value="${cliente.getApellidos()}" name="txtApellidoCliente" class="form-control">
                        </div>
                        <div class="form-group">
                            <label style="color: #fff">NIT:</label>
                            <input type="text" value="${cliente.getNit()}" name="txtNitCliente" class="form-control">
                        </div>
                        <div class="form-group">
                            <label style="color: #fff">Telefono Cliente:</label>
                            <input type="text" value="${cliente.getTelefonoCliente()}" name="txtTelefonoCliente" class="form-control">
                        </div>
                        <div class="form-group">
                            <label style="color: #fff">Dirección Cliente:</label>
                            <input type="text" value="${cliente.getDireccionCliente()}" name="txtDireccionCliente" class="form-control">
                        </div>
                        <div class="form-group">
                            <label style="color: #fff">Correo Cliente</label>
                            <input type="text" value="${cliente.getCorreoCliente()}" name="txtCorreoCliente" class="form-control">
                        </div>
                        <div class="form-group">
                            <label style="color: #fff">Estado Cliente</label>
                            <input type="text" value="${cliente.EstadoCliente()}" name="txtEstadoCliente" class="form-control">
                        </div>
                         <div class="form-group">
                            <label style="color: #fff">Codigo de TipoCliente:</label>
                            <select id="TipoCliente" name="cmbTipoClien">
                                <option disabiled selected value="">Selecciona una opción</option>
                                <c:forEach var="tipoCliente" items="${tipoClientes}">
                                    <option value="${tipoCliente.getCodigoTipoCliente()}">${tipoCliente.getCodigoTipoCliente()}. ${tipoCliente.getDescripcion()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-warning">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-primary">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr style="color: #fff">
                        <td><strong>CODIGO</strong></td>
                        <td><strong>NOMBRES</strong></td>
                        <td><strong>APELLIDOS</strong></td>
                        <td><strong>NIT</strong></td>
                        <td><strong>TELÉFONO</strong></td>
                        <td><strong>DIRRECCIÓN</strong></td>
                        <td><strong>CORREO</strong></td>
                        <td><strong>ESTADO</strong></td>
                        <td align='center'><strong>CODIGO TIPOCLIENTE</strong></td>
                        <td align='center'><strong>ACCIONES</strong></td>
                        </tr>
                    </thead>
                    <tbody style="background: currentColor;">
                    <c:forEach var="cliente" items="${clientes}">
                        <tr>
                        <td style="color: #fff" align="center">${cliente.getCodigoCliente()}</td>
                        <td style="color: #fff" align="center">${cliente.getNombres()}</td>
                        <td style="color: #fff" align="center">${cliente.getApellidos()}</td>
                        <td style="color: #fff" align="center">${cliente.getNit()}</td>
                        <td style="color: #fff" align="center">${cliente.getTelefonoCliente()}</td>
                        <td style="color: #fff" align="center">${cliente.getDireccionCliente()}</td>
                        <td style="color: #fff" align="center">${cliente.getCorreoCliente()}</td>
                        <td style="color: #fff" align="center">${cliente.EstadoCliente()}</td>
                        <td style="color: #fff" align="center">${cliente.getCodigoTipoCliente()}</td>
                        <td>
                             
                          <a class="btn btn-secondary" href="Controlador?menu=Cliente&accion=Editar&codigoCliente=${cliente.getCodigoCliente()}">Editar</a>
                          <a class="btn btn-danger" href="Controlador?menu=Cliente&accion=Eliminar&codigoCliente=${cliente.getCodigoCliente()}">Eliminar</a>
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
