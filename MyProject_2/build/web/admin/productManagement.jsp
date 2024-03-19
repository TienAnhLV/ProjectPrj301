<%-- 
    Document   : productManagement
    Created on : Feb 27, 2024, 3:49:10 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>CRUD PRODUCT</title>

        <link rel="apple-touch-icon" href="assets/img/apple-icon.png">
        <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"/>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <style>
            body {
                color: #566787;
                background: #f5f5f5;
                font-family: 'Varela Round', sans-serif;
                font-size: 13px;
            }

            .table-responsive {
                margin: 30px 0;
            }

            .table-wrapper {
                background: #fff;
                padding: 20px 25px;
                border-radius: 3px;
                min-width: 1000px;
                box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
            }

            .table-title {
                padding-bottom: 15px;
                background: #435d7d;
                color: #fff;
                padding: 16px 30px;
                min-width: 100%;
                margin: -20px -25px 10px;
                border-radius: 3px 3px 0 0;
            }

            .table-title h2 {
                margin: 5px 0 0;
                font-size: 24px;
            }

            .table-title .btn-group {
                float: right;
            }

            .table-title .btn {
                color: #fff;
                float: right;
                font-size: 13px;
                border: none;
                min-width: 50px;
                border-radius: 2px;
                border: none;
                outline: none !important;
                margin-left: 10px;
            }

            .table-title .btn i {
                float: left;
                font-size: 21px;
                margin-right: 5px;
            }

            .table-title .btn span {
                float: left;
                margin-top: 2px;
            }

            table.table tr th,
            table.table tr td {
                border-color: #e9e9e9;
                padding: 12px 15px;
                vertical-align: middle;
            }

            table.table tr th:first-child {
                width: 60px;
            }

            table.table tr th:last-child {
                width: 100px;
            }

            table.table-striped tbody tr:nth-of-type(odd) {
                background-color: #fcfcfc;
            }

            table.table-striped.table-hover tbody tr:hover {
                background: #f5f5f5;
            }

            table.table th i {
                font-size: 13px;
                margin: 0 5px;
                cursor: pointer;
            }

            table.table td:last-child i {
                opacity: 0.9;
                font-size: 22px;
                margin: 0 5px;
            }

            table.table td a {
                font-weight: bold;
                color: #566787;
                display: inline-block;
                text-decoration: none;
                outline: none !important;
            }

            table.table td a:hover {
                color: #2196F3;
            }

            table.table td a.edit {
                color: #FFC107;
            }

            table.table td a.delete {
                color: #F44336;
            }

            table.table td i {
                font-size: 19px;
            }

            table.table .avatar {
                border-radius: 50%;
                vertical-align: middle;
                margin-right: 10px;
            }

            .pagination {
                float: right;
                margin: 0 0 5px;
            }

            .pagination li a {
                border: none;
                font-size: 13px;
                min-width: 30px;
                min-height: 30px;
                color: #999;
                margin: 0 2px;
                line-height: 30px;
                border-radius: 2px !important;
                text-align: center;
                padding: 0 6px;
            }

            .pagination li a:hover {
                color: #666;
            }

            .pagination li.active a,
            .pagination li.active a.page-link {
                background: #03A9F4;
            }

            .pagination li.active a:hover {
                background: #0397d6;
            }

            .pagination li.disabled i {
                color: #ccc;
            }

            .pagination li i {
                font-size: 16px;
                padding-top: 6px
            }

            .hint-text {
                float: left;
                margin-top: 10px;
                font-size: 13px;
            }



            /* Modal styles */
            .modal .modal-dialog {
                max-width: 400px;
            }

            .modal .modal-header,
            .modal .modal-body,
            .modal .modal-footer {
                padding: 20px 30px;
            }

            .modal .modal-content {
                border-radius: 3px;
                font-size: 14px;
            }

            .modal .modal-footer {
                background: #ecf0f1;
                border-radius: 0 0 3px 3px;
            }

            .modal .modal-title {
                display: inline-block;
            }

            .modal .form-control {
                border-radius: 2px;
                box-shadow: none;
                border-color: #dddddd;
            }

            .modal textarea.form-control {
                resize: vertical;
            }

            .modal .btn {
                border-radius: 2px;
                min-width: 100px;
            }

            .modal form label {
                font-weight: normal;
            }

            .exit::after{
                content: '\f057';
                font-family: "Font Awesome 6 Free";
                color: red;
                margin-left: 20px;
            }

            .img img{
                height: 200px;
            }
        </style>

    </head>

    <body>
        <div class="container-xl">
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-5">
                                <h2>Manage <b>Product</b></h2>
                            </div>

                            <div class="col-sm-3">
                                <form id="searchForm" action="productManagement?action=search" method="post">
                                    <input type="text" name="productname" id="searchInput" class="form-control" placeholder="Search Product name">
                                    <button type="submit" name="searchSubmit" id="searchSubmit"><i class="fa fa-search"></i></button>
                                </form>
                            </div>
                            <div class="col-sm-4">
                                <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i
                                        class="material-icons">&#xE147;</i> <span>Add New Product</span></a>

                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover">



                        <c:if test="${listP.size() == 0}">
                            <h3><strong class="exit">NO PRODUCT EXITS</strong></h3>
                        </c:if>

                        <c:if test="${listP.size() != 0}">
                            <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>Product name</th>
                                    <th>price</th>
                                    <th>img</th>
                                    <th>description</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:set var = "stt" value = "${1}"/>
                                <c:forEach items="${listP}" var="i">
                                    <tr>

                                        <td>${stt}</td>
                                        <c:set var = "stt" value = "${stt+1}"/>
                                        <td>${i.productName}</td> 
                                        <td>${i.price}</td>
                                        <td class="img">
                                            <img src="${i.img}" alt="alt"/>
                                        </td>
                                        <td>${i.description}</td>

                                        <td>
                                            <a href="#editEmployeeModal" onclick="editCustomer(${i.productID})" class="edit"
                                               data-toggle="modal"><i class="material-icons" data-toggle="tooltip"
                                                                   title="Edit">&#xE254;</i></a>

                                            <a href="#deleteEmployeeModal" onclick="deleteCustomer(${i.productID})" class="delete"
                                               data-toggle="modal"><i class="material-icons" data-toggle="tooltip"
                                                                   title="Delete">&#xE872;</i></a>
                                        </td>


                                    </tr>
                                </c:forEach>
                            </tbody>
                        </c:if>





                    </table>
                    <div class="clearfix">
                        <a href="adminPage">Back To AdminPage</a>
                        <!--                        <ul class="pagination">
                                          <li class="page-item disabled"><a href="#">Previous</a></li>
                                          <li class="page-item"><a href="#" class="page-link">1</a></li>
                                          <li class="page-item"><a href="#" class="page-link">2</a></li>
                                          <li class="page-item active"><a href="#" class="page-link">3</a></li>
                                          <li class="page-item"><a href="#" class="page-link">4</a></li>
                                          <li class="page-item"><a href="#" class="page-link">5</a></li>
                                          <li class="page-item"><a href="#" class="page-link">Next</a></li>
                                      </ul>-->
                    </div>
                </div>
            </div>
        </div>
        <!-- Edit Modal HTML -->
        <div id="addEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form name="formProduct" action="productManagement?action=add" method="post" onsubmit="return validateForm()">
                        <div class="modal-header">
                            <h4 class="modal-title">Add Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label>product Name</label>
                                <input type="text" name="productName" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>price</label>
                                <input type="text" name="price" class="form-control" id="checkInputNumber" required>
                            </div>
                            <div class="form-group">
                                <label>img</label>
                                <input type="text" name="img" class="form-control" placeholder="url img" required>
                            </div>
                            <div class="form-group">
                                <label>description</label>
                                <input type="text" name="des" class="form-control" required>
                            </div>

                            <div class="form-group">
                                <label>category</label>
                                <select name="categoryID">
                                    <c:forEach items="${listC}" var="itemC">
                                        <option value="${itemC.categoryID}">${itemC.categoryName}</option>                                       
                                    </c:forEach>

                                </select>
                            </div>

                            <div class="form-group">
                                <label>sale</label>

                                <select name="saleID">
                                    <option value="1" selected>10%</option>
                                    <option value="2">20%</option>
                                    <option value="3">30%</option>
                                    <option value="4">40%</option>
                                    <option value="5">50%</option>
                                    <option value="6">60%</option>
                                    <option value="7">70%</option>
                                    <option value="8">80%</option>
                                    <option value="9">90%</option>
                                    <option value="0">0%</option>
                                </select>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" value="Add">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Edit Modal HTML -->
        <div id="editEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="productManagement?action=edit" method="post">
                        <div class="modal-header">
                            <h4 class="modal-title">Edit Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">

                                <label>Product Name</label>
                                <input type="text" name="productName" class="form-control" required="">
                                <input id="editUser" name="productId" class="form-control" type="hidden">


                            </div>
                            <div class="form-group">
                                <label>price</label>
                                <input type="text" id="checkInputNumber" name="price" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>img</label>
                                <input type="text" name="img" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>desciption</label>
                                <input type="text" name="des" class="form-control" required>
                            </div>

                            <div class="form-group">
                                <label>category</label>
                                <select name="categoryID">
                                    <c:forEach items="${listC}" var="itemC">
                                        <option value="${itemC.categoryID}">${itemC.categoryName}</option>                                       
                                    </c:forEach>

                                </select>
                            </div>

                            <div class="form-group">
                                <label>sale</label>

                                <select name="saleID">
                                    <option value="1" selected>10%</option>
                                    <option value="2">20%</option>
                                    <option value="3">30%</option>
                                    <option value="4">40%</option>
                                    <option value="5">50%</option>
                                    <option value="6">60%</option>
                                    <option value="7">70%</option>
                                    <option value="8">80%</option>
                                    <option value="9">90%</option>
                                    <option value="0">0%</option>
                                </select>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" value="EDIT">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Delete Modal HTML -->
        <div id="deleteEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="productManagement?action=delete" method="post">
                        <input name="productId" id="inputProductID" type="hidden">



                        <div class="modal-header">
                            <h4 class="modal-title">Delete product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            
                            <p>Are you sure you want to delete productID=<span style="font-weight: bold; " id="valueDelte"></span> ?</p>
                            <p class="text-warning"><small>This action cannot be undone.</small></p>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-danger" value="Delete">
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <script>
            function validateForm() {

                let inputNumber = document.getElementById('checkInputNumber').value;

                const usingSplit = inputNumber.split('');

                for (var i = 0; i < usingSplit.length; i++) {
                    if (isCharLetter(usingSplit[i])) {
                        alert('You must be enter the number in field price');
                        return false;
                    }
                }
                return true;
            }
            function isCharLetter(char) {
                return /^[a-z]$/i.test(char);
            }
            
            function editCustomer(productID){
                document.getElementById('editUser').value = productID;
                
            }
            
            function deleteCustomer(id){
                document.getElementById('inputProductID').value = id;
                document.getElementById('valueDelte').innerHTML = id;
            }
        </script>

    </body>

</html>
