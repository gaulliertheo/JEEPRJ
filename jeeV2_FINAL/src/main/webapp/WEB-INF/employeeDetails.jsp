<%@include file="header.jsp"%>

<h2>Details of employee : </h2>
<form method="post">
    <div class="form-group row">
        <label for="inputName" class="col-sm-2 col-form-label text-right">Name</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="inputName" value="<c:out value='${employee.name}'/>" required="true">
        </div>
    </div>
    <div class="form-group row">
        <label for="inputFirstName" class="col-sm-2 col-form-label text-right">First name</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="inputFirstName" value="<c:out value='${employee.firstname}'/>" required="true">
        </div>
    </div>
    <div class="form-group row">
        <label for="inputHomePhone" class="col-sm-2 col-form-label text-right">Home phone</label>
        <div class="col-sm-10">
            <input type="tel" class="form-control" name="inputHomePhone" value="<c:out value='${employee.telhome}'/>" required="true">
        </div>
    </div>
    <div class="form-group row">
        <label for="inputMobilePhone" class="col-sm-2 col-form-label text-right">Mobile phone</label>
        <div class="col-sm-10">
            <input type="tel" class="form-control" name="inputMobilePhone" value="<c:out value='${employee.telmob}'/>" required="true">
        </div>
    </div>
    <div class="form-group row">
        <label for="inputWorkPhone" class="col-sm-2 col-form-label text-right">Work phone</label>
        <div class="col-sm-10">
            <input type="tel" class="form-control" name="inputWorkPhone" value="<c:out value='${employee.telpro}'/>" required="true">
        </div>
    </div>
    <div class="form-group row">
        <label for="inputAddress" class="col-sm-2 col-form-label text-right">Address</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="inputAddress" value="<c:out value='${employee.address}'/>" required="true">
        </div>
    </div>
    <div class="form-group row">
        <label for="inputPostalCode" class="col-sm-2 col-form-label text-right">Postal code</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="inputPostalCode" value="<c:out value='${employee.postalcode}'/>" required="true">
        </div>
    </div>
    <div class="form-group row">
        <label for="inputCity" class="col-sm-2 col-form-label text-right">Ville</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" name="inputCity" value="<c:out value='${employee.city}'/>" required="true">
        </div>
        <label for="inputEmail" class="col-sm-2 col-form-label text-right">Email</label>
        <div class="col-sm-4">
            <input type="email" class="form-control" name="inputEmail" value="<c:out value='${employee.email}'/>" required="true">
        </div>
    </div>
    <div class="form-group row d-flex justify-content-end">
        <button type="submit" class="btn btn-primary mr-2" name="action" formaction="controller?id=<c:out value='${employee.id}'/>" value="Modify">Save</button>
        <button type="submit" class="btn btn-light mr-3" name="action" value="Cancel" onclick="rtn()">Cancel</button>
    </div>
</form>

<%@include file="footer.jsp"%>

<script>
    function rtn() {
        window.history.back();
    }
</script>