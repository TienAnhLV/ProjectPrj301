<%-- 
    Document   : bill
    Created on : Feb 22, 2024, 9:38:00 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>



        <title>Zay Bill</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="billCss.css">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
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

        <!------ Include the above in your HEAD tag ---------->

        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="invoice-title">
                        <h2>Bill</h2>
                        <h3 class="pull-right">Order #${orderDetail.orderDetailID}</h3>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-xs-6">
                            <address>
                                <strong>Billed To:</strong><br>
                                ZayShop<br>
                                0123456789<br>
                                Khu Công Nghệ Cao Hòa Lạc, km 29, Đại lộ, Thăng Long, Hà Nội
                            </address>
                        </div>
                        <div class="col-xs-6 text-right">
                            <address>
                                <strong>Shipped To:</strong><br>
                                ${acc.fullName}<br>
                                ${acc.phone}<br>
                                ${orderDetail.locationOrder}
                            </address>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-6">
                            <address>
                                <strong>Payment Method:</strong><br>

                                <c:if test="${orderDetail.payMethod == 1}">
                                    direct payment
                                </c:if>
                                <c:if test="${orderDetail.payMethod == 2}">
                                    transfer

                                    <img style="height: 300px; width: 300px;" 
                                         src='https://img.vietqr.io/image/MB-0001199784841-compact.png'/>
                                </c:if>
                            </address>
                        </div>
                        <div class="col-xs-6 text-right">
                            <address>
                                <strong>Order Date:</strong><br>
                                ${orderDetail.orderDate}<br><br>
                            </address>

                            <address>
                                <strong>Order Status:</strong><br>

                                <c:if test="${orderDetail.status == 0}">
                                    reject<br><br>
                                </c:if>
                                <c:if test="${orderDetail.status == -1}">
                                    process<br><br>
                                </c:if>
                                <c:if test="${orderDetail.status == 1}">
                                    accpect<br><br>
                                </c:if>

                            </address>

                            <address>
                                <strong>Order Comment:</strong><br>

                                <c:if test="${orderDetail.comment == null || orderDetail.equals('')}">
                                    NO COMMENT<br><br>
                                </c:if>
                                <c:if test="${orderDetail.comment != null && !orderDetail.equals('')}">
                                    ${orderDetail.comment}<br><br>
                                </c:if>

                            </address>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title"><strong>Order summary</strong></h3>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-condensed">
                                    <thead>
                                        <tr>
                                            <td><strong>Item</strong></td>
                                            <td class="text-center"><strong>Price</strong></td>
                                            <td class="text-center"><strong>Quantity</strong></td>
                                            <td class="text-right"><strong>Totals</strong></td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <!-- foreach ($order->lineItems as $line) or some such thing here -->
                                        <c:set var="total" value="0"/>
                                        <c:forEach items="${list}" var="i">
                                            <tr>
                                                <td>${i.productName}</td>
                                                <td class="text-center">$${i.price}</td>
                                                <td class="text-center">${i.quanity}</td>
                                                <td class="text-right">$${i.quanity * i.price}</td>
                                                <c:set var="total" value="${total + (i.quanity * i.price)}"/>
                                            </tr>
                                        </c:forEach>




                                        <tr>
                                            <td class="no-line"></td>
                                            <td class="no-line"></td>
                                            <td class="no-line text-center"><strong>Total</strong></td>
                                            <td class="no-line text-right">$${total}</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="container text-center">
                <h4>Thank you for your order! We will contact you via phone or email shortly.</h4>
                <p> <a href="orderManagement">Back</a></p>
            </div>

        </div>

        <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    </body>

</html>
