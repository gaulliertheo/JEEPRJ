<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="header.jsp" />

<h2>List of Employees</h2>

<form method="post" action="controller">
    <table class="table table-striped">
        <thead >
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
                <c:forEach var="employee" items="${employees}">
                    <tr>
                        <td><input type= "radio" name="inputId" value="<c:out value='${employee.id}'/>" checked="true"></td>
                        <td><c:out value="${employee.name}"/></td>
                        <td><c:out value="${employee.firstname}"/></td>
                        <td><c:out value="${employee.telhome}"/></td>
                        <td><c:out value="${employee.telmob}"/></td>
                        <td><c:out value="${employee.telpro}"/></td>
                        <td><c:out value="${employee.address}"/></td>
                        <td><c:out value="${employee.postalcode}"/></td>
                        <td><c:out value="${employee.city}"/></td>
                        <td><c:out value="${employee.email}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
    </table>
    
    <c:if test = "${empty employees}">
            <div class="alert alert-danger" role="alert">The company has no employee!</div>
    </c:if>

    <c:if test = "${user.statut == 'a'}">
        <c:if test = "${!empty employees}">
            <button type="submit" class="btn btn-primary" name="action" value="Delete">Delete</button>
            <button type="submit" class="btn btn-primary" name="action" value="Detail">Detail</button>
        </c:if>
        <button type="submit" class="btn btn-primary" name="action" value="AddEmployee">Add</button>
    </c:if>

</form>

<c:import url="footer.jsp" />