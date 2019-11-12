<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="style.css">
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-light bg-light justify-content-end">
            <a class="navbar-brand"></a>
            <p class="mr-sm-2 my-auto">Hello <c:out value='${user.name}'/> ! Your account is active</p>
            <form method="post"><button type="submit" name="action" formaction="employeesList" value="Logout"><img src="power-off-button.png" class="rounded float-right my-auto" alt="Logout"></button></form>
        </nav>
        <div class="container h-100">
            <div class="row align-items-start pt-3 h-100">
                <div class="offset-1 col-10 card px-0 border-0">