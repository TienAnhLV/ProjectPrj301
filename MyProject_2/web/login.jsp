<%-- 
    Document   : login
    Created on : Jan 23, 2024, 11:55:14 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Sign in ZayShop</title>
        <link rel="apple-touch-icon" href="assets/img/apple-icon.png">
        <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">
        <!-- Font Icon -->
        <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>

        <div class="main">


            <section class="sign-in">
                <div class="container">
                    <div class="signin-content">
                        <div class="signin-image">
                            <figure><a href="homePage"><img src="assets/img/apple-icon.png" alt="sing up image"></a></figure>
                            <a href="signup" class="signup-image-link">Create an account</a>
                            <br>
                            <a href="fogetPassword" class="signup-image-link">Forget Password</a>
                        </div>

                        <div class="signin-form">
                            <h2 class="form-title">Sign up</h2>
                            <c:if test="${errLogin != null}">
                                <h3 style="color: red">${errLogin}</h3>
                            </c:if>
                            <form action="login" method="POST" class="register-form" id="login-form">
                                <div class="form-group">
                                    <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                    <input type="text" name="user" id="your_name" value="${userC}" placeholder="Your Name"/>
                                </div>
                                <div class="form-group">
                                    <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                                    <input type="password" name="password" id="your_pass" value="${passC}" placeholder="Password"/>
                                </div>
                                <div class="form-group">
                                    <input type="checkbox" name="remember" id="remember-me" class="agree-term" value="1"/>
                                    <label for="remember-me" class="label-agree-term"><span><span></span></span>Remember me</label>


                                </div>
                                <div class="form-group form-button">
                                    <input type="submit" name="signin" id="signin" class="form-submit" value="Login"/>
                                </div>
                            </form>

                            <c:if test="${errLoginWithGoogle != null}">
                                <h4 style="color: red; font-weight: bold;">${errLoginWithGoogle}</h4>    
                            </c:if>   



                            <div class="social-login">
                                <span class="social-label">Or login with</span>
                                <ul class="socials">
                                    <li><a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/myProject_2/LoginGoogleHandler&response_type=code&client_id=191624818438-s99ebl49mgp3hvs7m7jekt99oft5b823.apps.googleusercontent.com&approval_prompt=force"><i class="display-flex-center zmdi zmdi-google"></i></a></li>
                                    
                                   
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </div>

        <!-- JS -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="js/main.js"></script>
    </body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>
