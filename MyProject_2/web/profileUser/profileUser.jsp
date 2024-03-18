<%-- 
    Document   : profileUser
    Created on : Jan 25, 2024, 8:32:24 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>User Information</title>
        <!-- Link to Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <style>
            /* Custom style for centering text */
            .card-header h5 {
                text-align: center;
                margin-bottom: 0;
            }

            /* Custom style for better appearance */
            .card {
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            }

            /* Custom style for button */
            .btn-update {
                background-color: #007bff;
                color: #fff;
            }
        </style>
    </head>

    <body>

        <div class="container mt-5">
            <div class="row justify-content-center">
                <h2 style="color: red">
                    ${errDuplicateUser != null?"UserName Exit!!!":""}
                </h2>
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-header bg-primary text-white">
                            <h5>
                                User Information <h5>${acc.roleID==1?"Amin":"Customer"}</h5>
                            </h5>
                        </div>
                        <div class="card-body">
                            <!-- Replace the content inside this form with user information -->
                            <form action="profile" method="post">
                                <div class="form-group">
                                    <label for="username">UserID:</label>
                                    <input type="text" class="form-control" name="UserId" value="${acc.userID}" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="fullName">UserName:</label>
                                    <input type="text" class="form-control" name="UserName" value="${acc.username}" readonly>
                                </div>
                                <div class="form-group">
                                    <label for="email">Full Name:</label>
                                    <input type="text" class="form-control" name="fullName" value="${acc.fullName}">
                                </div>
                                <!-- Add more fields as needed -->
                                <div class="form-group">
                                    <label for="username">Email:</label>
                                    <input type="email" class="form-control" name="email" value="${acc.email}" readonly="">
                                </div>
                                <div class="form-group">
                                    <label for="fullName">Phone:</label>
                                    <input type="text" class="form-control" name="phone" value="${acc.phone}">
                                </div>
                                <div class="form-group">
                                    <label for="email">Location:</label>
                                    <input type="text" class="form-control" name="location" value="${acc.location}">
                                </div>



                                <!-- Update button -->
                                <div class="text-center">
                                    <a class="btn btn-update" href="homePage">back</a>
                                    <button type="submit" class="btn btn-info">Update</button>  
                                </div>


                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Link to Bootstrap JS and Popper.js -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    </body>

</html>
