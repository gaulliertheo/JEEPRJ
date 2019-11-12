<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="header.jsp" />

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

<c:import url="footer.jsp" />
