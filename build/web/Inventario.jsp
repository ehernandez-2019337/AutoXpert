<%-- 
    Document   : Inventario
    Created on : 12/09/2023, 04:26:38 PM
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
              <title></title>
    </head>
    <body>
        <div class="container mt-4">
            <div class="row">
                <c:forEach var="vehiculo" items="${vehiculos}">
                    <div class="col-sm-4">
                        <div class="card">
                            <div class="card-header">
                                <center><label>${vehiculo.getMarca()}</label>
                                    <label>${vehiculo.getModelo()}</label></center>
                            </div>
                            <div class="card-body">
                                    <center><c:choose>
                                        <c:when test="${not empty vehiculo.getImagen()}">
                                            <img src="ControladorFoto?vehiculo=Vehiculo&codigoVehiculo=${vehiculo.getCodigoVehiculo()}" onerror="this.src='img/vehiculonotfound.jpg'" width="100" height="80">
                                        </c:when>
                                        <c:otherwise>
                                            <img src="img/vehiculonotfound.jpg" onerror="this.src='img/vehiculonotfound.jpg'" width="100" height="80">
                                        </c:otherwise>
                                    </c:choose></center>

                                    </div>
                                    <div class="card-footer text-center">
                                        <i>${vehiculo.getPrecio()}</i><br>
                                        <br>
                                        <label>EL ${vehiculo.getMarca()} ${vehiculo.getModelo()} tiene un total de ${vehiculo.getCantidadPuertas()} puertas</label>
                                        <br>
                                        <div>
                                            <a href="Controlador?menu=Inventario&accion=AgregarCarrito&codigoVehiculo=${vehiculo.getCodigoVehiculo()}" class="btn btn-outline-info">Agregar a Carrito</a>
                                            
                                        </div>
                                    </div>
                                </div>
                                <br>
                            </div>  
                            </c:forEach>
                        </div>
                    </div>
                </body>
            </html>
