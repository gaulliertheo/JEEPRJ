<%@include file="header.jsp"%>

<h2>Add an employee : </h2>
<form method="post">
    <div class="form-group row">
        <label for="inputName" class="col-sm-2 col-form-label text-right">Name</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="inputName" required="true">
        </div>
    </div>
    <div class="form-group row">
        <label for="inputFirstName" class="col-sm-2 col-form-label text-right">First name</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="inputFirstName" required="true">
        </div>
    </div>
    <div class="form-group row">
        <label for="inputHomePhone" class="col-sm-2 col-form-label text-right">Home phone</label>
        <div class="col-sm-10">
            <input type="tel" class="form-control" name="inputHomePhone" required="true">
        </div>
    </div>
    <div class="form-group row">
        <label for="inputMobilePhone" class="col-sm-2 col-form-label text-right">Mobile phone</label>
        <div class="col-sm-10">
            <input type="tel" class="form-control" name="inputMobilePhone" required="true">
        </div>
    </div>
    <div class="form-group row">
        <label for="inputWorkPhone" class="col-sm-2 col-form-label text-right">Work phone</label>
        <div class="col-sm-10">
            <input type="tel" class="form-control" name="inputWorkPhone" required="true">
        </div>
    </div>
    <div class="form-group row">
        <label for="inputAddress" class="col-sm-2 col-form-label text-right">Address</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="inputAddress" required="true">
        </div>
    </div>
    <div class="form-group row">
        <label for="inputPostalCode" class="col-sm-2 col-form-label text-right">Postal code</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="inputPostalCode" required="true">
        </div>
    </div>
    <div class="form-group row">
        <label for="inputCity" class="col-sm-2 col-form-label text-right">Ville</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" name="inputCity" required="true">
        </div>
        <label for="inputEmail" class="col-sm-2 col-form-label text-right">Email</label>
        <div class="col-sm-4">
            <input type="email" class="form-control" name="inputEmail" required="true">
        </div>
    </div>
    <div class="form-group row d-flex justify-content-end">
        <button type="submit" class="btn btn-primary mr-2" name="action" value="Add" formaction="controller">Save</button>
        <button type="submit" class="btn btn-light mr-3" name="action" value="Cancel" onclick="rtn()">Cancel</button>
    </div>
</form>

<%@include file="footer.jsp"%>

<script>
    function rtn() {
        window.history.back();
    }
</script>