<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="header.jsp" />

<div class="card-header">
    Goobye
</div>
<div class="card-body">
    <form method="POST" action="controller">
        <div class="form-group">
            <p>Hope we will see you soon !</p>
        </div>
        <button type="submit" class="btn btn-primary" name="action" value="NewLogin">Login again !</button>
    </form>
</div>


<c:import url="footer.jsp" />