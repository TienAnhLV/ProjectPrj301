<%-- 
    Document   : contact
    Created on : Jan 29, 2024, 10:28:16 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Zay Shop - Contact</title>
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

        <!-- Load map styles -->
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css" integrity="sha512-xodZBNTC5n17Xt2atTPuE1HxjVMSvLVW9ocqUKLsCC5CXdbqCmblAshOMAS6/keqq/sMZMZ19scR4PsZChSR7A==" crossorigin="" />

    </head>

    <body>



        <!-- Header -->
        <jsp:include page="header.jsp"></jsp:include>
            <!-- Close Header -->



            <!-- Start Content Page -->
            <div class="container-fluid bg-light py-5">
                <div class="col-md-6 m-auto text-center">
                    <h1 class="h1">Contact with ZayShop</h1>
                    <p>
                        We will support you 24/7 every day of the week
                    </p>
                </div>
            </div>



            <!-- Start Contact -->
            <!--            <div class="container py-5">
                            <div class="row py-5">
                                <form class="col-md-9 m-auto" action="contact" method="post" role="form">
                                    <div class="row">
                                        <div class="form-group col-md-6 mb-3">
                                            <label for="inputname">Name</label>
                                            <input type="text" class="form-control mt-1" id="name" name="name" placeholder="Name">
                                        </div>
                                        <div class="form-group col-md-6 mb-3">
                                            <label for="inputemail">Email</label>
                                            <input type="email" class="form-control mt-1" id="email" name="email" placeholder="Email">
                                        </div>
                                    </div>
                                    <div class="mb-3">
                                        <label for="inputsubject">Subject</label>
                                        <input type="text" class="form-control mt-1" id="subject" name="subject" placeholder="Subject">
                                    </div>
                                    <div class="mb-3">
                                        <label for="inputmessage">Message</label>
                                        <textarea class="form-control mt-1" id="message" name="message" placeholder="Message" rows="8"></textarea>
                                    </div>
                                    <div class="row">
                                        <div class="col text-end mt-2">
                                            <button type="submit" class="btn btn-success btn-lg px-3">Send</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>-->
            <div>
                
                <p style="text-align: center; font-weight: bold;"><i class="fa-solid fa-earth-asia"></i>Location<i class="fa-solid fa-earth-asia"></i></p>
                
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3724.5062169040166!2d105.52271427471399!3d21.012421688340613!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135abc60e7d3f19%3A0x2be9d7d0b5abcbf4!2zVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBGUFQ!5e0!3m2!1svi!2s!4v1706842062663!5m2!1svi!2s" 
                        width="100%" height="600px" style="border:0;" allowfullscreen="" 
                        loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
            </div>

            <!-- End Contact -->


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
    </body>

</html>
