<%-- 
    Document   : WebVenta
    Created on : 14/08/2023, 11:58:20 AM
    Author     : carli
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" href="css/vistas.css"
        <title>Pagina ventas</title>
    </head>
    <body style="background: currentColor">
        <div class="d-flex">
            <div class="card col-sm-4" style="background-color: currentColor">
                <div class="card-body" style="background-color: currentColor">
                    <form action="Controlador?menu=Venta" action="Controlador?menu=Empleado" method="POST">
                        <div class="form-group">
                            <label style="color: #fff">Fecha de Venta: </label>
                            <input type="date" value="${venta.getFechaVenta()}" name="txtFechaVenta" class="sm-form-control">
                        </div >
                        <div class="form-group">
                            <label style="color: #fff">Hora de Venta:</label>
                            <input type="time" value="${venta.getHoraVenta()}" name="txtHoraVenta" class="sm-form-control">
                        </div>
                        <div class="form-group">
                            <label style="color: #fff">Total de Venta:</label>
                            <input type="text" value="${venta.getTotalVenta()}" name="txtTotalVenta" class="form-control">
                        </div>
                        <div class="form-group">
                            <label style="color: #fff">Estado de Venta:</label>
                            <input type="text" value="${venta.isEstadoVenta()}" name="txtEstadoVenta" class="form-control">
                        </div>
                        <div class="form-group">
                            <label style="color: #fff">Codigo de Empleado:</label>
                            <%-- <input type="Number" value="${venta.getCodigoEmpleado()}" name="txtCodigoEmpleado" class="form-control" > --%>
                            <select name="txtCodigoEmpleado">
                                <option disabled selected value="0">Seleccione una opción</option>
                                <c:forEach var="empleado" items="${empleados}">
                                    <option value="${empleado.getCodigoEmpleado()}">${empleado.getCodigoEmpleado()}. ${empleado.getPrimerNombre()}</option>
                                </c:forEach>
                            </select>
                                    
                        </div>
                        <div class="form-group">
                            <label style="color: #fff">Codigo de Cliente:</label>
                           <%-- <input type="Number" value="${venta.getCodigoCliente()}" name="txtCodigoCliente" class="form-control" > --%>
                            <select name="txtCodigoCliente">
                                <option disabled selected value="0">Seleccione una opción</option>
                                <c:forEach var="cliente" items="${clientes}">
                                    <option value="${cliente.getCodigoCliente()}">${cliente.getCodigoCliente()}.${cliente.getNombres()}</option>
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
                        <tr>
                            <td style="color: #fff"><strong>CODIGO</strong></td>
                            <td align='center' style="color: #fff"><strong>FECHA</strong></td>
                            <td style="color: #fff"><strong>HORA</strong></td>
                            <td style="color: #fff"><strong>TOTAL</strong></td>
                            <td style="color: #fff"><strong>ESTADO</strong></td>
                            <td style="color: #fff"><strong>CODIGO EMPLEADO</strong></td>
                            <td style="color: #fff"><strong>CODIGO CLIENTE</strong></td>
                            <td align='center'><strong>ACCIONES</strong></td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="venta" items="${ventas}">
                        <tr>
                            <td style="color: #fff" align='center'>${venta.getCodigoVenta()}</td>
                            <td style="color: #fff">${venta.getFechaVenta()}</td>
                            <td style="color: #fff">${venta.getHoraVenta()}</td>
                            <td style="color: #fff">Q ${venta.getTotalVenta()}</td>
                            <td style="color: #fff" align='center'>${venta.isEstadoVenta()}</td>
                            <td style="color: #fff" align='center'>${venta.getCodigoEmpleado()}</td>
                            <td style="color: #fff" align='center'>${venta.getCodigoCliente()}</td>
                            <td>
                                <a class="btn btn-custom-editar" href="Controlador?menu=Venta&accion=Editar&codigoVenta=${venta.getCodigoVenta()}" >Editar</a>
                                <a class="btn btn-danger" href="Controlador?menu=Venta&accion=Eliminar&codigoVenta=${venta.getCodigoVenta()}">Eliminar</a>
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