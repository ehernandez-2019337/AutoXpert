<%-- 
    Document   : TipoEmpleado
    Created on : 16/08/2023, 07:35:30 PM
    Author     : Santiago
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" href="css/vistas.css"></link>
        <!-- Titulo de la vista -->
        <title>Tipo Empleado</title>
    </head>
    
     <body style="background: currentColor;">
       <div class="d-flex" style=" background-color: ">
            <div class="card col-sm-4"  style=" background-color: currentColor; ">  
                <div class="card-body"  style=" background-color: currentColor; ">
                    <!-- Colocar el método y action -->
                    <form action="Controlador?menu=TipoEmpleado" method="POST">

                        <!-- División donde se colocan los datos -->                                                
                        <div class="form-group">
                            <label style="color: #fff">Descripción:</label>
                            <input type="text" value="${tipoem.getDescripcion()}" name="txtDescripcion" class="form-control">                              
                        </div>

                        <div class="form-group">
                            <label style="color: #fff">Sueldo Base</label>
                            <input type="text" value="${tipoem.getSueldoBase()}" name="txtSueldoBase" class="form-control">

                        </div>

                        <div class="form-group">
                            <label style="color: #fff">Bonificación</label>
                            <input type="text" value="${tipoem.getBonificacion()}" name="txtBonificacion" class="form-control">

                        </div>
                        <div class="form-group">
                            <label style="color: #fff">Bonificación Empresa</label>
                            <input type="text" value="${tipoem.getBonificacionEmpresa()}" name="txtBonificacionEmpresa" class="form-control">

                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-custom-agregar">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-custom-actualizar">
                    </form>
                </div>
            </div>



            <div class="col-sm-8" style="background: currentColor">
                <!-- División de la cabecera de las tablas -->
                <table class="table table-hover">
                    <thead>
                        <tr style="color: #fff">
                            <td style="text-align: center">CODIGO TIPO EMPLEADO</td>
                            <td style="text-align: center">DESCRIPCIÓN</td>
                            <td style="text-align: center">SUELDO BASE</td>
                            <td style="text-align: center">BONIFICACIÓN</td>
                            <td style="text-align: center">BONIFICACION EMPRESA</td>

                            <td>ACCIONES</td>

                        </tr>                        
                    </thead>
                    <tbody style="background: currentColor;">

                        <!-- Parte de los "get" en Java -->
                        <!--Necesito el item del controlador -->
                        <c:forEach var="tipoem" items="${tipoempleado}">
                            <tr>
                                <td style="color: #fff" align="center">${tipoem.getCodigoTipoEmpleado()}</td>
                                <td style="color: #fff">${tipoem.getDescripcion()}</td>
                                <td style="color: #fff">Q   ${tipoem.getSueldoBase()}</td>      
                                <td style="color: #fff">Q   ${tipoem.getBonificacion()}</td>
                                <td style="color: #fff">Q   ${tipoem.getBonificacionEmpresa()}</td>                            

                                <td>
                                    <a class="btn btn-custom-editar" href="Controlador?menu=TipoEmpleado&accion=Editar&codigoTipoEmpleado=${tipoem.getCodigoTipoEmpleado()}">Editar</a>
                                   <a class="btn btn-danger" href="#" onclick="confirmarEliminacion('${tipoem.getCodigoTipoEmpleado()}')">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>



                    <script>
                        function confirmarEliminacion(codigoTipoEmpleado) {
                            var confirmacion = confirm("¿Estás seguro de que deseas eliminar este elemento?");

                            if (confirmacion) {
                                window.location.href = "Controlador?menu=TipoEmpleado&accion=Eliminar&codigoTipoEmpleado=" + codigoTipoEmpleado;
                            } else {

                            }
                        }
                    </script>


                    </tbody>
                </table>                                
            </div>

        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>

    </body>
</html>
