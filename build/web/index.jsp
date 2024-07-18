<%-- 
    Document   : index
    Created on : 13/08/2023, 06:58:54 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link><link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous"></link>
        <link rel="stylesheet" type="text/css" href="css/styleLogin.css">
        <title>AutoXpert</title>
    </head>
    <body>
        <div class="limiter">
            <div class="container-login100" style="background-image: url('img/fondo1.png');">
                <div class="wrap-login100">
                    <form class="form-sign" action="Validar" method="POST">
                        <span class="login100-form-logo">
                            <i class="zmdi zmdi-landscape"></i>
                            <div class="form-group text-center">
                                <img src="img/Logo.png" alt="70" width="130"/><br>
                            </div>
                        </span>
                        <br>
                        <span class="login100-form-title p-b-34 p-t-27" style="font-family: arial black"> Bienvenidos al Sistema </span>
                        <br>

                        <div class="wrap-input100 validate-input" data-validate = "Enter username">
                            <span class="focus-input100"></span>
                            <input type="text" name="txtUser" class="input100" placeholder="Usuario">
                        </div>

                        <div class="wrap-input100 validate-input" data-validate="Enter password">
                            <span class="focus-input100"></span>
                            <input type="password" name="txtPass" class="input100" placeholder="Contraseña">
                        </div>
                        <br>                     

                        <div class="container-login100-form-btn">
                            <button class="login100-form-btn" type="submit" name="accion" value="Ingresar"> Ingresar</button>
                        </div>
                        <div>
                            <h3 style="font-size:12px ; color: #FFF"> &copy;AutoXpert-2023</h3>
                        </div>
                </div>
                </form>
            </div>
        </div>
    </div>

    <div id="dropDownSelect1"></div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
    <script> (function ($) {
            "use strict";

            $('.input100').each(function () {
                $(this).on('blur', function () {
                    if ($(this).val().trim() != "") {
                        $(this).addClass('has-val');
                    } else {
                        $(this).removeClass('has-val');
                    }
                })
            })

            var input = $('.validate-input .input100');

            $('.validate-form').on('submit', function () {
                var check = true;

                for (var i = 0; i < input.length; i++) {
                    if (validate(input[i]) == false) {
                        showValidate(input[i]);
                        check = false;
                    }
                }

                return check;
            });


        })(jQuery);</script>
</body>
</html>
