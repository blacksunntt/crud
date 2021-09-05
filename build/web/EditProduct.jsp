<%-- 
    Document   : AddProduct
    Created on : Aug 13, 2021, 10:31:33 AM
    Author     : thanh
--%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Manage Products</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <script src="js/function.js" type="text/javascript"></script>
    </head>
    
    <body>
        <div class="container-xl">
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-6">
                                <h2>Edit <b>Products</b></h2>
                                <div><a href="ManageProducts">Home</a></div>
                            </div>
                        </div>
                    </div>
                    <form action="EditProduct" method="POST">
                        <div class="modal-body">					
                            <div class="form-group">
                                <input type="text" name="id" value="${product.id}" class="form-control" hidden="" required>
                                <br>
                                <label>Name</label>
                                <input type="text" name="name" value="${product.name}" class="form-control" required>
                                <br>
                                <label>Image</label>
                                <br>
                                <img id="image" src="${product.image}" style="width:300px;height:220px"><br><br>
                                <input type="text" name="imageFile" value="${product.image}" class="form-control" required>
                                <br>
                                <label>Price</label>
                                <input type="number" step="any" name="price" value="${product.price}" class="form-control" required>
                                <br>
                                <input type="button" onclick="window.location.href='ManageProducts'" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                <input type="submit" class="btn btn-success" value="Save">
                            </div>					
                        </div>
                    </form>
                </div>
            </div>        
        </div>
        
    </body>
</html>
