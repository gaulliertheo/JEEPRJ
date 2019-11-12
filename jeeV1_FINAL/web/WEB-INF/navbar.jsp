<nav class="navbar navbar-light bg-light justify-content-end">
    <a class="navbar-brand"></a>
    <p class="mr-sm-2 my-auto">Hello <c:out value='${user.name}'/> ! Your account is active</p>
<form method="post"><button type="submit" name="action" formaction="controller" value="Logout"><img src="power-off-button.png" class="rounded float-right my-auto" alt="Logout"></button></form>
</nav>