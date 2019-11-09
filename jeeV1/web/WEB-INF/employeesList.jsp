<%@include file="header.jsp"%>

<h2>List of Employees</h2>
<form method="post" >
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
                    <td><c:out value="${employee.firstName}"/></td>
                    <td><c:out value="${employee.telHome}"/></td>
                    <td><c:out value="${employee.telMob}"/></td>
                    <td><c:out value="${employee.telPro}"/></td>
                    <td><c:out value="${employee.address}"/></td>
                    <td><c:out value="${employee.postalCode}"/></td>
                    <td><c:out value="${employee.city}"/></td>
                    <td><c:out value="${employee.email}"/></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <button type="submit" class="btn btn-primary" name="action" value="Delete" formaction="employeesList">Delete</button>
    <button type="submit" class="btn btn-primary" name="action" value="Detail" formaction="employeeDetails">Detail</button>
    <button type="submit" class="btn btn-primary" name="action" value="Add" formaction="employeesList">Add</button>
</form>

<%@include file="footer.jsp"%>