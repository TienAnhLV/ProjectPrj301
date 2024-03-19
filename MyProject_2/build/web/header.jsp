<%-- 
    Document   : header
    Created on : Jan 23, 2024, 10:46:21 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Header -->
<nav class="navbar navbar-expand-lg navbar-light shadow">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"/>
    <div class="container d-flex justify-content-between align-items-center">

        <a class="navbar-brand text-success logo h1 align-self-center" href="homePage">
            Zay
        </a>

        <button class="navbar-toggler border-0" type="button" data-toggle="collapse" data-target="#templatemo_main_nav" aria-controls="templatemo_main_nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="align-self-center collapse navbar-collapse flex-fill d-lg-flex justify-content-lg-between" id="templatemo_main_nav">
            <div class="flex-fill">
                <ul class="nav navbar-nav d-flex justify-content-between mx-lg-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="homePage">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="contact">Contact</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="about">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="shop">Shop</a>
                    </li>

                    <c:if test="${acc != null}">
                        <li class="nav-item">
                            <span class="nav-link" style="font-weight: 600;"><i class="fa-solid fa-hand-point-right"></i>Hello ${acc.username}<i class="fa-solid fa-hand-point-left"></i></span>
                        </li>
                    </c:if>

                </ul>


            </div>



            <div class="navbar align-self-center d-flex">

                <c:if test="${acc != null && acc.roleID == 0}">
                    <div class="dropdown" id="userDropdownWrapper">
                        <div class="nav-icon position-relative text-decoration-none" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fa fa-fw fa-user text-dark mr-3"></i>
                            <span class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark"></span>
                        </div>
                        <div class="dropdown-menu" aria-labelledby="userDropdown" id="userDropdownMenu">
                            <!-- Dropdown content goes here -->
                            <a class="dropdown-item" href="profile">Profile</a>
                            <a class="dropdown-item" href="changePass">Change Password</a>
                            <a class="dropdown-item" href="myOrder?userID=${acc.userID}">My Order</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="logout">Logout</a>
                        </div>
                    </div>


                </c:if>

                <a class="nav-icon position-relative text-decoration-none" href="shoppingCartController?action=get">
                    <i class="fa fa-fw fa-cart-arrow-down text-dark mr-1"></i>
                    <span class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark">${sessionScope.cart.getSize()}</span>
                </a>


                <c:if test="${acc == null}">
                    <a href="login">
                        LOGIN
                    </a>
                </c:if>


            </div>
        </div>

    </div>
</nav>

<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
    $(document).ready(function () {
        var dropdownWrapper = $('#userDropdownWrapper');
        var dropdownMenu = $('#userDropdownMenu');

        dropdownWrapper.hover(
                function () {
                    dropdownMenu.show(); // Show the dropdown on hover
                },
                function () {
                    dropdownMenu.hide(); // Hide the dropdown when not hovered
                }
        );
    });
</script>
<!-- Close Header -->
