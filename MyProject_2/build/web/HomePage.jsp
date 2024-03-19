<%-- 
    Document   : HomePage
    Created on : Jan 22, 2024, 2:13:27 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Zay Shop</title>
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

    </head>

    <body>


        <!-- Header -->
        <jsp:include page="header.jsp"></jsp:include>
         <!-- Close Header -->

            <!--         Modal -->
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



            <!-- Start Banner Hero -->
            <div id="template-mo-zay-hero-carousel" class="carousel slide" data-bs-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="0" class="active"></li>
                    <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="1"></li>
                    <li data-bs-target="#template-mo-zay-hero-carousel" data-bs-slide-to="2"></li>
                </ol>

                <!--  product1-->

                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <div class="container">
                            <div class="row p-5">
                                <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
                                    <img class="img-fluid" src="./assets/img/banner_img_04.jpg" alt="">
                                </div>
                                <div class="col-lg-6 mb-0 d-flex align-items-center">
                                    <div class="text-align-left align-self-center">
                                        <h1>Sắp ra mắt</h1>
                                        <h3 class="h2">Iphone 16 pro max</h3>
                                        <p>
                                            iPhone 16 Pro Max đem lại một diện mạo hoàn toàn mới và sở hữu nhiều tính năng ưu việt cùng công nghệ tiên tiến. Hãy khám phá các đánh giá chi
                                            tiết về sản phẩm về khía cạnh thiết kế, màn hình, hiệu năng, 
                                            thời lượng pin và bộ camera độc đáo 
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="carousel-item">
                        <div class="container">
                            <div class="row p-5">
                                <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
                                    <img class="img-fluid" src="./assets/img/banner_img_05.jpg" alt="">
                                </div>
                                <div class="col-lg-6 mb-0 d-flex align-items-center">
                                    <div class="text-align-left">
                                        <h1 class="h1">Sắp ra mắt</h1>
                                        <h3 class="h2">Galaxy S25 Ultra 8GB/256GB CTY</h3>
                                        <p>
                                            Samsung Galaxy S25 Ultra 256GB tiếp tục đi theo phong cách tối giản khi đặt trực tiếp các ống kính lên mặt lưng máy. 
                                            Sau sự thành công của phiên bản <strong>Galaxy S24 Ultra</strong>, thiết kế này nhận được rất nhiều lời khen từ phía người dùng. 
                                            Phần đông đều công nhận rằng ngoại hình này giúp chiếc smartphone tuy có kích thước lớn song vẫn rất tinh tế và đẳng cấp.
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="carousel-item">
                        <div class="container">
                            <div class="row p-5">
                                <div class="mx-auto col-md-8 col-lg-6 order-lg-last">
                                    <img class="img-fluid" src="./assets/img/banner_img_06.jpg" alt="">
                                </div>
                                <div class="col-lg-6 mb-0 d-flex align-items-center">
                                    <div class="text-align-left">
                                        <h1 class="h1">Sắp ra mắt</h1>
                                        <h3 class="h2">Redmi Note 18 Pro </h3>
                                        <p>
                                            Xiaomi dự kiến sẽ trình làng Redmi Note 18 Pro tại Trung Quốc vào ngày 21 tháng 5 sắp tới. 
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <a class="carousel-control-prev text-decoration-none w-auto ps-3" href="#template-mo-zay-hero-carousel" role="button" data-bs-slide="prev">
                    <i class="fas fa-chevron-left"></i>
                </a>
                <a class="carousel-control-next text-decoration-none w-auto pe-3" href="#template-mo-zay-hero-carousel" role="button" data-bs-slide="next">
                    <i class="fas fa-chevron-right"></i>
                </a>
            </div>
            <!-- End Banner Hero -->


            <!-- Start Categories of The Month -->
            <section class="container py-5">
                <div class="row text-center pt-3">
                    <div class="col-lg-6 m-auto">
                        <h1 class="h1">BEST SELLER</h1>
                    </div>
                </div>
                <div class="row">

                <c:forEach items="${listPSale}" var="i">
                    <div class="col-12 col-md-4 p-5 mt-3">
                        <div class="position-relative">
                            <a href="detailProduct?pid=${i.productID}">
                                <img src="${i.img}" class="img-fluid rounded-square border">
                                <!-- Thêm nhãn giảm giá -->
                                <div class="position-absolute top-0 end-0 bg-danger text-white p-2 rounded-start">-${i.saleID * 10}%</div>
                            </a>
                        </div>
                        <h5 class="text-center mt-3 mb-3">${i.productName}</h5>
                        <p class="text-center"><a class="btn btn-success" href="shoppingCartController?action=cart&id=${i.productID}">Buy Now</a></p>
                        <!-- Thêm phần giá tiền -->
                        <p class="text-center font-weight-bold text-decoration-line-through" style="color: red">$${ (i.saleID*300)}</p>
                        <p class="text-center font-weight-bold">$${i.price}</p>

                    </div>
                </c:forEach>



            </div>
        </section>



        <!-- End Categories of The Month -->


        <!-- Start Featured Product -->
        <section class="bg-light">
            <div class="container py-5">
                <div class="row text-center py-3">
                    <div class="col-lg-6 m-auto">
                        <h1 class="h1">PHONE HOT IN 2024</h1>
                    </div>
                </div>
                <div class="row">

                    <c:forEach items="${listHSale}" var="i">
                        <div class="col-12 col-md-4 mb-4">
                            <div class="card h-100">
                                <a href="detailProduct?pid=${i.productID}">
                                    <img src="${i.img}" class="card-img-top" alt="...">
                                </a>
                                <div class="card-body">
                                    <ul class="list-unstyled d-flex justify-content-between">
                                        <li class="text-right">${i.price}</li>
                                    </ul>
                                    <a href="shop-single.html" class="h2 text-decoration-none text-dark">${i.productName}</a>
                                    <p class="card-text">
                                        ${i.description}
                                    </p>

                                    <!-- Hiển thị nút "Buy Now" khi hover -->
                                    <p class="text-center buy-now-overlay d-none"><a href="shoppingCartController?action=cart&id=${i.productID}" class="btn btn-success">Buy Now</a></p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>



                </div>
            </div>
        </section>




        <!-- End Featured Product -->


        <!-- Start Footer -->
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- End Footer -->

        <!-- Start Script -->
        <script src="assets/js/jquery-1.11.0.min.js"></script>
        <script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
        <script src="assets/js/bootstrap.bundle.min.js"></script>
        <script src="assets/js/templatemo.js"></script>
        <script src="assets/js/custom.js"></script>
        <script>

            var myCarousel = new bootstrap.Carousel(document.getElementById('template-mo-zay-hero-carousel'), {
                interval: 2000, // Đặt thời gian chờ giữa các slide (5 giây trong ví dụ)
                pause: 'hover', // Tạm dừng chạy tự động khi rê chuột vào slider
                wrap: true  // Cho phép quay vòng khi đến slide cuối cùng
            });
        </script>
        <!-- End Script -->
        <!-- Sử dụng jQuery để thêm hiệu ứng -->
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
        <script>
            // Sử dụng jQuery để thêm hiệu ứng hover
            $(document).ready(function () {
                $(".card").hover(
                        function () {
                            $(this).find(".buy-now-overlay").removeClass("d-none");
                        },
                        function () {
                            $(this).find(".buy-now-overlay").addClass("d-none");
                        }
                );
            });
        </script>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    </body>

</html>