<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="style.css">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <title>Login Page</title>
    </head>
    <body>
        <div class="container h-100">
            <div class="row align-items-center h-100">
                <div class="offset-4 col-4 my-auto card px-0">
                    <c:if test = "${!empty erreur}">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            <c:out value='${erreur}'/>
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                    </c:if>
                    <div class="card-header">
                        Login
                    </div>
                    <div class="card-body">
                        <form method="POST" action="controller">
                            <div class="form-group">
                                <input type="text" class="form-control" name="inputLogin" placeholder="Login">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" name="inputPassword" placeholder="Password">
                            </div>
                            <button type="submit" class="btn btn-primary" name="action" value="Login">Login</button>
                        </form>
                    </div>
                </div>
            </div>
    </body>
</html>