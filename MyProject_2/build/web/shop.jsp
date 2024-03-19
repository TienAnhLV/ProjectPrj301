<%-- 
    Document   : shop
    Created on : Jan 23, 2024, 10:49:04 AM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Zay Shop - Product Listing Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="apple-touch-icon" href="assets/img/apple-icon.png">
        <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/templatemo.css">
        <link rel="stylesheet" href="assets/css/custom.css">

        <!-- Load fonts style after rendering the layout styles -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
        <link rel="stylesheet" href="assets/css/fontawesome.min.css">
        <!--
            
       
        
        
        -->
    </head>

    <body>



        <!-- Header -->
        <jsp:include page="header.jsp"></jsp:include>
            <!-- Close Header -->

            <!-- Modal -->
            <div class="modal fade bg-white" id="templatemo_search" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="w-100 pt-1 mb-5 text-right">
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="" method="get" class="modal-content modal-body border-0 p-0">
                        <div class="input-group mb-2">
                            <input type="text" class="form-control" id="inputModalSearch" name="q" placeholder="Search ...">
                            <button type="submit" class="input-group-text bg-success text-light">
                                <i class="fa fa-fw fa-search text-white"></i>
                            </button>
                        </div>
                    </form>
                </div>
            </div>



            <!-- Start Content -->
            <div class="container py-5">
                <div class="row">

                    <div class="col-lg-3">
                        <h1 class="h2 pb-4">Categories</h1>

                    <c:forEach items="${listC}" var="i">
                        <ul class="list-unstyled">
                            <li class="pb-3">
                                <a class="collapsed d-flex justify-content-between h3 text-decoration-none" 
                                   href="loadProductByCategory?cid=${i.categoryID}" 
                                   style="color: black;">

                                    <c:if test="${cid == i.categoryID}">
                                        <strong>${i.categoryName}</strong>
                                    </c:if>

                                    <c:if test="${cid != i.categoryID}">
                                        ${i.categoryName}
                                    </c:if>
                                </a>
                            </li>
                        </ul>
                    </c:forEach>

                </div>

                <div class="col-lg-9">
                    <div class="row">
                        <div class="col-md-4">
                            <ul class="list-inline shop-top-menu pb-3 pt-1">
                                <li class="list-inline-item">
                                    <a class="h3 text-dark text-decoration-none mr-3" href="shop">All</a>
                                </li>
                            </ul>
                        </div>
                        <div class="col-md-4 pb-4">


                            <form action="searchShop" method="get"> 
                                <div class="input-group">
                                    <input type="text" class="form-control" name="txtsearch" placeholder="Search...">
                                    <div class="input-group-append">
                                        <button class="btn btn-outline-secondary" type="submit">Search Name</button>
                                    </div>
                                </div>
                            </form>

                            <form action="searchShopByPrice" method="get"> 
                                <div class="input-group">
                                    <input type="text" class="form-control" name="Start" placeholder="Start">
                                    <input type="text" class="form-control" name="end" placeholder="End">
                                    <div class="input-group-append">
                                        <button class="btn btn-outline-secondary" type="submit">search</button>
                                    </div>
                                </div>
                            </form>
                        </div>

                    </div>
                    <!--                        product-->
                    <div class="row">

                        <c:forEach items="${listPage}" var="i">
                            <div class="col-md-4">
                                <div class="card mb-4 product-wap rounded-0">
                                    <div class="card rounded-0">
                                        <img class="card-img rounded-0 img-fluid" src="${i.img}">
                                        <div class="card-img-overlay rounded-0 product-overlay d-flex align-items-center justify-content-center">
                                            <ul class="list-unstyled">

                                                <li><a class="btn btn-success text-white mt-2" href="detailProduct?pid=${i.productID}">Detail Product</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="card-body">
                                        <a href="shop-single.html" class="h3 text-decoration-none">${i.productName}</a>
                                        <ul class="w-100 list-unstyled d-flex justify-content-between mb-0">

                                            <li class="pt-2">
                                                <span class="product-color-dot color-dot-red float-left rounded-circle ml-1"></span>
                                                <span class="product-color-dot color-dot-blue float-left rounded-circle ml-1"></span>
                                                <span class="product-color-dot color-dot-black float-left rounded-circle ml-1"></span>
                                                <span class="product-color-dot color-dot-light float-left rounded-circle ml-1"></span>
                                                <span class="product-color-dot color-dot-green float-left rounded-circle ml-1"></span>
                                            </li>
                                        </ul>

                                        <p class="text-center mb-0"><span style="color: red; font-weight: bold">$</span>${i.price}</p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>



                    </div>

                    <c:if test="${endP >= 1}">
                        <div class="row">
                            <ul class="pagination pagination-lg justify-content-end">

                                <c:forEach begin="1" end="${endP}" var="i">

                                    <c:if test="${cid != null}">
                                        <li class="page-item" style="cursor: pointer">
                                            <a class="page-link ${tag==i?"active":""} rounded-0 mr-3 shadow-sm border-top-0 border-left-0" href="loadProductByCategory?cid=${cid}&index=${i}" >${i}</a>
                                        </li>
                                    </c:if>

                                    <c:if test="${cid == null}">
                                        <li class="page-item" style="cursor: pointer">
                                            <a class="page-link ${tag==i?"active":""} rounded-0 mr-3 shadow-sm border-top-0 border-left-0" href="shop?index=${i}" >${i}</a>
                                        </li>
                                    </c:if>

                                </c:forEach>

                            </ul>
                        </div>
                    </c:if>


                </div>

            </div>
        </div>
        <!-- End Content -->




        <!-- Start Footer -->
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- End Footer -->

        <!-- Start Script -->
        <script src="assets/js/jquery-1.11.0.min.js"></script>
        <script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
        <script src="assets/js/bootstrap.bundle.min.js"></script>
        <script src="assets/js/templatemo.js"></script>
        <script src="assets/js/custom.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha512-/kbo0M7uY39O1OSU3fwhF+J2Jp3+Z0AdHJx2X/MG7KBE7SeTtIjNj6pZxQTasMzRl+JhM7gNNVpZZeRK7ESZ8g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

        <!-- End Script -->
    </body>

</html>
