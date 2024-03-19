<%-- 
    Document   : changePassword
    Created on : Jan 25, 2024, 4:55:26 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Change Password</title>
    <!-- Link to Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Link to Font Awesome CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
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
            <div class="col-md-6">
                <div class="card">
                    
                    <c:if test="${errOldPass != null}">
                        <h3 style="color: red">${errOldPass}</h3>
                    </c:if>
                    
                        
                    <c:if test="${errNewPass != null}">
                        <h3 style="color: red">${errNewPass}</h3>
                    </c:if>    
                        
                    <div class="card-header bg-primary text-white">
                        <h5>Change Password</h5>
                    </div>
                    <div class="card-body">
                        <!-- Replace the content inside this form with password change fields -->
                        <form action="changePass" method="post">
                            <div class="form-group">
                                <label for="currentPassword">Current Password:</label>
                                <div class="input-group">
                                    <input type="password" class="form-control" name="currentPassword" id="currentPassword" required>
                                    <div class="input-group-append">
                                        <span class="input-group-text">
                                            <i class="fas fa-eye" id="toggleCurrentPassword"></i>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="newPassword">New Password:</label>
                                <div class="input-group">
                                    <input type="password" name="newPassword" class="form-control" id="newPassword" required>
                                    <div class="input-group-append">
                                        <span class="input-group-text">
                                            <i class="fas fa-eye" id="toggleNewPassword"></i>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="confirmPassword">Confirm New Password:</label>
                                <div class="input-group">
                                    <input type="password" name="confirmPassword" class="form-control" id="confirmPassword" required>
                                    <div class="input-group-append">
                                        <span class="input-group-text">
                                            <i class="fas fa-eye" id="toggleConfirmPassword"></i>
                                        </span>
                                    </div>
                                </div>
                            </div>

                            <!-- Update button -->
                            <div class="text-center">
                                <button type="submit" class="btn btn-update">Change Password</button>
                                <a href="homePage" class="btn btn-link">Back</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Link to Bootstrap JS, Popper.js, and Font Awesome JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <script>
        // Toggle password visibility
        function togglePasswordVisibility(inputId, iconId) {
            const passwordInput = document.getElementById(inputId);
            const icon = document.getElementById(iconId);

            icon.addEventListener('click', () => {
                const type = passwordInput.type === 'password' ? 'text' : 'password';
                passwordInput.type = type;
                icon.classList.toggle('fa-eye-slash');
                icon.classList.toggle('fa-eye');
            });
        }

        // Toggle visibility for each password field
        togglePasswordVisibility('currentPassword', 'toggleCurrentPassword');
        togglePasswordVisibility('newPassword', 'toggleNewPassword');
        togglePasswordVisibility('confirmPassword', 'toggleConfirmPassword');
    </script>

</body>

</html>




