<%-- 
    Document   : orderMangement
    Created on : Feb 29, 2024, 10:24:40 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>CRUD CUSTOMER</title>

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

            .view::after{
                content: '\f06e';
                font-family: "Font Awesome 6 Free";
                color: black;
                margin-left: 20px;
            }
        </style>

    </head>

    <body>
        <div class="container-xl">
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-6">
                                <h2>Manage <b>Order</b></h2>
                            </div>

                            <div class="col-sm-3">
                                <form id="searchForm" action="orderManagement" method="get">
                                    <input type="text" name="username" id="searchInput" class="form-control" placeholder="Search name">
                                    <button type="submit" ><i class="fa fa-search"></i></button>
                                </form>
                            </div>
                            <div class="col-sm-3">
                                <form id="searchForm" action="orderManagement?action=searchByStatus" method="post">

                                    <select name="searchByStatus">
                                        <option value="1" ${status == 1 ? 'selected':''}>Approved</option>
                                        <option value="0" ${status == 0 ? 'selected':''}>Reject</option>
                                        <option value="-1" ${status == -1 ? 'selected':''}>Process</option>
                                    </select>
                                    <button type="submit" ><i class="fa fa-search"></i></button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover">



                        <c:if test="${listOrderCart.size() == 0}">
                            <h3><strong class="exit">NO ORDER EXITS</strong></h3>
                        </c:if>

                        <c:if test="${listOrderCart.size() != 0}">
                            <thead>
                                <tr>


                                    <th>STT</th>
                                    <th>Name</th>
                                    <th>LocationOrder</th>
                                    <th>Total</th>

                                    <th>Status</th>
                                    <th>Comment</th>
                                    <th>Detail Order</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:set var = "stt" value = "${1}"/>
                                <c:forEach items="${listOrderCart}" var="i">
                                    <tr>

                                        <td>${stt}</td>
                                        <c:set var = "stt" value = "${stt+1}"/>
                                        <td>${i.nameUser}</td>
                                        <td>${i.locationOrder}</td>
                                        <td>${i.total}</td>
                                        <td>
                                            <c:if test="${i.status == 1}">
                                                Approved
                                            </c:if>

                                            <c:if test="${i.status == 0}">
                                                Reject
                                            </c:if>

                                            <c:if test="${i.status == -1}">

                                                <button onclick="chanageStatus(this, ${i.orderDeitalID}, 1)">Approved</button>
                                                <button onclick="chanageStatus(this, ${i.orderDeitalID}, 0)">Reject</button>

                                            </c:if> 
                                        </td>
                                        <td>
                                            <c:if test="${i.comment == null || i.comment == ''}">
                                                NO COMMENT
                                            </c:if>
                                            <c:if test="${i.comment != null && i.comment != ''}">
                                                <p>${i.comment}</p>
                                            </c:if>
                                        </td>
                                        <td><a href="detailBill?orderDetailID=${i.orderDeitalID}" class="view">View</a></td>
                                        <td>
                                            <a href="#editEmployeeModal" 
                                               onclick="editOrder('${i.orderDeitalID}', '${i.nameUser}', '${i.locationOrder}', '${i.total}', '${i.comment}')" class="edit"
                                               data-toggle="modal"><i class="material-icons" data-toggle="tooltip"
                                                                   title="Edit">&#xE254;</i></a>

                                            <a href="#deleteEmployeeModal" onclick="deleteOrder(${i.orderDeitalID})" class="delete"
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
        <div id="editEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="orderManagement?action=edit" method="post">
                        <div class="modal-header">
                            <h4 class="modal-title">Edit Order</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">

                                <label>Name</label>
                                <input id="name" name="user" value="" class="form-control" required="" readonly="">

                                <input type="hidden" id="orderID" name="orderID" value="" class="form-control" required="" readonly="">
                            </div>

                            <div class="form-group">
                                <label>LocationOrder</label>
                                <input id="location" type="text" name="location" class="form-control" required>
                            </div>

                            <div class="form-group">
                                <label>Total</label>
                                <input id="total" type="text" name="total" value="" class="form-control" required readonly="">
                            </div>

                            <div class="form-group">
                                <label>Status</label>
                                <select name="status">
                                    <option value="0">Reject</option>
                                    <option value="-1">Process</option>
                                    <option value="1">Accept</option>
                                </select>
                            </div>

                            <div class="form-group">
                                <label>Comment</label>
                                <input id="comment" type="text" name="comment" value="" class="form-control" required>
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
                    <form action="orderManagement?action=delete" method="post">
                        <input name="userId" id="inputAccountID" type="hidden">



                        <div class="modal-header">
                            <h4 class="modal-title">Delete Order</h4>
                            <input type="hidden" name="orderDetailID" id="orderDetailID">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <p>Are you sure you want to delete <span style="font-weight: bold; " id="valueDelte"></span> ?</p>
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



    </body>
    <script>
        function editOrder(orderDeitalID, name, location, total, comment) {

            document.getElementById('orderID').value = orderDeitalID;

            document.getElementById('name').value = name;

            document.getElementById('location').value = location;

            document.getElementById('total').value = total;

            document.getElementById('comment').value = comment;
        }

        function deleteOrder(orderDeitalID) {
            document.getElementById('orderDetailID').value = orderDeitalID;

        }
        
       
        
        function chanageStatus(btn, eid, s) {
            var text = btn.textContent;//get text cua button(chu trong btn)
            btn.parentElement.innerHTML = text;//cho td = text cua minh la duoc
            //su ajax toi con servlet change
            $.ajax({
                url: '/myProject_2/orderManagement?action=changeSatus',
                type: 'POST',
                data: {//truyen id va status
                    orderDetailID: eid,
                    status: s
                },

                success: function (response) {
                    //do something
                    alert('update status sucessfully');
                }

            });

        }

    </script>
</html>