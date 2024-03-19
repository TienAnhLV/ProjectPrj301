<%-- 
    Document   : deltailProduct
    Created on : Jan 23, 2024, 10:49:38 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Zay Shop - Product Detail Page</title>
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

        <!-- Slick -->
        <link rel="stylesheet" type="text/css" href="assets/css/slick.min.css">
        <link rel="stylesheet" type="text/css" href="assets/css/slick-theme.css">
        <link rel="stylesheet" type="text/css" href="notication/animations.styl">
        <link rel="stylesheet" type="text/css" href="notication/layouts.styl">
        <link rel="stylesheet" type="text/css" href="notication/style.styl">
        <link rel="stylesheet" type="text/css" href="notication/themes.styl">
        <link rel="stylesheet" type="text/css" href="notication/toast.styl">

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



            <!-- Open Content -->
            <section class="bg-light">
                <div class="container pb-5">
                    <div class="row">
                        <div class="col-lg-5 mt-5">
                            <div class="card mb-3">
                                <img class="card-img img-fluid" src="${product.img}" alt="Card image cap" id="product-detail">
                        </div>

                    </div>
                    <!-- col end -->
                    <div class="col-lg-7 mt-5">
                        <div class="card">
                            <div class="card-body">
                                <h1 class="h2">${product.productName}</h1>
                                <p class="h3 py-2">$${product.price}</p>



                                <h6>Description:</h6>
                                <p>${product.description}</p>

                                <form action="" method="GET">
                                    <input type="hidden" name="product-title" value="Activewear">
                                    <div class="row">

                                        <!--                                        <div class="col-auto">
                                                                                    <ul class="list-inline pb-3">
                                                                                        <li class="list-inline-item text-right">
                                                                                            Quantity
                                                                                            <input type="hidden" name="product-quanity" id="product-quanity" value="1">
                                                                                        </li>
                                                                                        <li class="list-inline-item"><span class="btn btn-success" id="btn-minus">-</span></li>
                                                                                        <li class="list-inline-item"><span class="badge bg-secondary" id="var-value">1</span></li>
                                                                                        <li class="list-inline-item"><span class="btn btn-success" id="btn-plus">+</span></li>
                                                                                    </ul>
                                                                                </div>-->
                                    </div>
                                    <div class="row pb-3">

                                        <div class="col d-grid">
                                            <!--<button type="submit" class="btn btn-success btn-lg" name="submit" value="addtocard">Add To Cart</button>-->
                                            <a href="shoppingCartController?action=put&pid=${product.productID}" class="btn btn-success btn-lg btn-add-to-cart" name="submit" value="addtocard">Add To Cart</a>
                                        </div>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Close Content -->

        <!-- Start Article -->

        <!-- End Article -->
        <div class="pt-5">
            <h6 class="mb-0"><a href="shop" class="text-body"><i
                        class="fas fa-long-arrow-alt-left me-2"></i>Back to shop</a></h6>
        </div>

        <!-- Start Footer -->

        <jsp:include page="footer.jsp"></jsp:include>
        <!-- End Footer -->

        <!-- Start Script -->
        <script src="assets/js/jquery-1.11.0.min.js"></script>
        <script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
        <script src="assets/js/bootstrap.bundle.min.js"></script>
        <script src="assets/js/templatemo.js"></script>
        <script src="assets/js/custom.js"></script>
        <!-- End Script -->

        <!-- Start Slider Script -->
        <script src="assets/js/slick.min.js"></script>
        <script>
                                                $('#carousel-related-product').slick({
                                                    infinite: true,
                                                    arrows: false,
                                                    slidesToShow: 4,
                                                    slidesToScroll: 3,
                                                    dots: true,
                                                    responsive: [{
                                                            breakpoint: 1024,
                                                            settings: {
                                                                slidesToShow: 3,
                                                                slidesToScroll: 3
                                                            }
                                                        },
                                                        {
                                                            breakpoint: 600,
                                                            settings: {
                                                                slidesToShow: 2,
                                                                slidesToScroll: 3
                                                            }
                                                        },
                                                        {
                                                            breakpoint: 480,
                                                            settings: {
                                                                slidesToShow: 2,
                                                                slidesToScroll: 3
                                                            }
                                                        }
                                                    ]
                                                });
        </script>



        <!-- End Slider Script -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    </body>

</html>