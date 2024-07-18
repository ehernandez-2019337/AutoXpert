<%-- 
    Document   : carrito
    Created on : 12/09/2023, 06:43:06 PM
    Author     : carli
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous"></link>
        <link rel="stylesheet" href="css/style.css"></link>
        <link rel="shortcut icon" href="img/Logo.png" type="image/x-icon">
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar">
                <img src="img/logosinFondo.png" alt="Logo" width="100px" height="auto" class="">
                <!-- <h2>AutoXpert</h2>-->
            </a> 
            <div class="dropdown">
                <button style="border: none; color:#fff;" class="btn btn-outline-info dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown"arial-haspopup="true" aria-expanded="false">
                    Extras
                </button>
                <div class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton">
                     <li class="nav-item">
                         <a class="nav-link" href="Principal.jsp"><i class="fas fa-cart-plus"><label style="color: orange">${contador}</label></i>Seguir Comprando</a>
                     </li>
                </div>
            </div>
            <div class="dropleft">
                <button style="border: none" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown"arial-haspopup="true" aria-expanded="false">
                    ${usuario.getPrimerNombre()}
                </button>
                <div class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton">
                    <div class="div-user">
                        <a class="dropdown-item" href="#">
                            <img src="ControladorFoto?menu=Empleado&codigoEmpleado=${usuario.getCodigoEmpleado()}" alt="60" width="10"/>
                        </a>
                    </div>
                    <a class="dropdown-item" href="#">
                        ${usuario.getUsuario()}
                    </a>
                    <a class="dropdown-item" href="#">
                        ${usuario.getUsuario()}@gmail.com
                    </a>
                    <div class="dropdown-divider">
                    </div>
                    <form action="Validar" method="POST">
                        <button name="accion" name="Salir" class="dropdown-item">Salir</button>
                    </form>
                </div>
            </div>
        </nav>
                    <div class="m-4" style="height: 400px">
                        <br><br><br>
                        <div class="m-4" style="height: 600px; background: currentColor">
                            <br>
                    <div class="container mt-4">
                        <h3><font color="white">Carrito de Compras</font></h3>
                        <div class="row">
                            <div class="col-sm-8">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th><font color="white">ITEM</font></th>
                                            <th><font color="white">MARCA</font></th>
                                            <th><font color="white">MODELO</font></th>
                                            <th><font color="white">PRECIO</font></th>
                                            <th><font color="white">CANT</font></th>
                                            <th><font color="white">SUBTOTAL</font></th>
                                    <th><center><font color="white">ACCION</font></center></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="car" items="${carrito}">
                                        <tr>
                                            <td><font color="white">${car.getIdProducto()}</font></td>
                                            <td><font color="white">${car.getMarca()}</font></td>
                                            <td><font color="white">${car.getModeloCarro()}</font></td>
                                            <td><font color="white">${car.getPrecioCompra()}</font></td>
                                            <td><font color="white">${car.getCantidad()}</font></td>
                                            <td><font color="white">${car.getSubTotal()}0</font></td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>  
                            </div>
                            <div class="col-sm-4">
                                <div class="card">
                                    <div class="card-header" style="background: currentColor">
                                        <h3><font color="white">Generar Compra</font></h3>
                                    </div>
                                    <div class="card-body" style="background: currentColor">
                                        <label><font color="white">Subtotal:</font></label>
                                        <input type="text" value="${totalPagar}0" readonly="" class="form-control"> 
                                        <label><font color="white">Total a Pagar</font></label>
                                        <input type="text" value="${totalPagar}0" readonly="" class="form-control"> 
                                    </div>
                                    <div class="card-footer" style="background: currentColor">
                                        <a href="#" class="btn btn-info btn-block">Realizar Pago</a>
                                        <a href="Controlador?menu=Inventario&accion=cancelar" class="btn btn-danger btn-block">Cancelar Carrito</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
        </div>
                    </div>
        <div>
            <img src="img/fondo1.png" alt="">
        </div>        
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    
    </body>
</html>
