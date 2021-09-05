<%-- 
    Document   : ManageProducts
    Created on : Aug 11, 2021, 2:38:23 PM
    Author     : thanh
--%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
                                <h2>Manage <b>Products</b></h2>
                                <div><a href="ManageProducts">Home</a></div>
                            </div>
                            
                            <div class="col-sm-6">
                                <div class="search-container">
                                    <br>
                                    <form action="SearchProducts" method="GET">
                                        <input type="text" name="q" placeholder="Search.." name="search">
                                        <button type="submit"><i class="fa fa-search"></i></button>
                                    </form>
                                </div>
                                <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Product</span></a>				
                            </div>
                        </div>
                    </div>
                    <h6 class="notification">${notification}</h6>
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Image</th>
                                <th>Price</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${products}" var="p">
                                <tr>
                                    <td><label id="id">${p.id}</label></td>
                                    <td><label id="name">${p.name}</label></td>
                                    <td>
                                        <img id="image" src="${p.image}" style="width:150px;height:120px">
                                    </td>
                                    <fmt:setLocale value = "vi_VN"/>
                                    <fmt:formatNumber value = "${p.price}" currencySymbol="VND" type = "currency" var="priceFmt"/>
                                    <td><label id="price">${priceFmt}</label></td>
                                    <td>
                                        <a href="EditProduct?pid=${p.id}" class="edit"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                        <a href="DeleteProduct?pid=${p.id}" class="delete" ><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
                                    </td>
                                </tr>
                            </c:forEach> 
                        </tbody>
                    </table>
                    <div class="clearfix">
                        <div class="hint-text" hidden="">Showing <b>5</b> out of <b>${totalpage}</b> entries</div>
                        <div class="pagination">
                            <div id="bottomPagger"></div>
                        </div>
                    </div>
                    <div class="clearfix">
                        <div class="hint-text">Page-views: <b>${pageviews}</b></div>
                    </div>
                </div>
            </div>        
        </div>

        <!-- Add Modal HTML -->
        <div id="addEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="AddProduct" method="POST" enctype="multipart/form-data">
                        <div class="modal-header">						
                            <h4 class="modal-title">Add Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <input name="id" hidden="">
                            <div class="form-group">
                                <label>Name</label>
                                <input type="text" name="name" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Image</label>
                                <div id="imageAdd"></div>
                                <input type="text" id="imgAdd" name="imageFile" class="form-control" onchange="handleAction()" required>
                            </div>
                            <div class="form-group">
                                <label>Price</label>
                                <input type="number" step="any" name="price" class="form-control" required>
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
        <div id="editProduct" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="EditProduct" method="POST">
                        <div class="modal-header">						
                            <h4 class="modal-title">Edit Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <input type="number" id="edit-id" name="edit-id" value="" hidden="">
                            <div class="form-group">
                                <label>Name</label>
                                <input type="text" id="edit-name" name="name" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Image</label>
                                <input type="text" id="edit-image" name="imageFile" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Price</label>
                                <input type="number" id="edit-price" name="price" class="form-control" required>
                            </div>					
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-info" value="Save">
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- Delete Modal HTML -->
        <div id="deleteProduct" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form>
                        <div class="modal-header">						
                            <h4 class="modal-title">Delete Employee</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <p>Are you sure you want to delete these Records?</p>
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
            renderPager("bottomPagger",${pageIndex},${totalPage},${pageGap});
        </script>

    </body>
</html>