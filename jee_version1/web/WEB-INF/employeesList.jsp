<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JEEPRJ</title>
    </head>
    <body>
        <h1>List of employees</h1>
        <form method="post"action="employeesList">
            <table>
                <thead>
                    <tr>
                        <th>Sél</th>
                        <th>NAME</th>
                        <th>FIRST NAME</th>
                        <th>HOME PHONE</th>
                        <th>MOBILE PHONE</th>
                        <th>WORK PHONE</th>
                        <th>ADDRESS</th>
                        <th>POSTAL CODE</th>
                        <th>CITY</th>
                        <th>EMAIL</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="employee" items="${ employees }">
                        <tr>
                            <td><INPUT type= "radio" name="sel" value="????"></td>
                            <th><c:out value="Aaaaaaaa"/></th>
                            <th>FIRST NAME</th>
                            <th>HOME PHONE</th>
                            <th>MOBILE PHONE</th>
                            <th>WORK PHONE</th>
                            <th>ADDRESS</th>
                            <th>POSTAL CODE</th>
                            <th>CITY</th>
                            <th>EMAIL</th>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </form>
    </body>
</html>
