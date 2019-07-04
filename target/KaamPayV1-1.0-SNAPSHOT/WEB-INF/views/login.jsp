<%@include file="shared/header.jsp" %>
<h1> Login </h1>
<c:if test="${param.inactive!=null}">
    <div style="background:red;color:#fff;font-weight:bold">
        Sorry your account is not activated
    </div>
</c:if>

<c:if test="${param.error!=null}">
    <div style="background:red;color:#fff;font-weight:bold">
        UserName/Password is incorrect.
    </div>
</c:if>
<form action="" method="post">
    <div>
        <label>Email</label>
        <input type="email" name="email" required='required'/>
    </div>

    <div>
        <label>Password</label>
        <input type="password" name="password" required='required'/>
    </div>

    <button type="submit">Login</button>
    <a href="${SITE_URL}/register">Register</a>

</form>

<%@include file="shared/footer.jsp" %>


