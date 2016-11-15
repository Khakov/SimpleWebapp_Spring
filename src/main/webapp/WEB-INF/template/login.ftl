<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<head>
    <meta charset="UTF-8">
    <link href="../resource/css/bootstrap.min.css" rel="stylesheet">
    <link href="../resource/css/forms_style.css" rel="stylesheet">

</head>
<#if error??>
<h2 class="error_message">${error}</h2>
</#if>
<#if success??>
<h2 class="success_message">${success}</h2>
</#if>
<div class="registration_form">
    <form id="loginForm" action="j_spring_security_check" method="post" role="form">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <h1>Login Form</h1>
        <div class="form-group">
            <input class="form-control" type="text" placeholder="Username" name="j_username"/>
        </div>
        <div class="form-group">
            <input class="form-control" type="password" placeholder="Password" name="j_password"/>
        </div>
        <div>
            <input name="remember-me" type="checkbox"/>
            <label for="remember-me">Запомнить меня</label>
        </div>
        <div>
            <input type="submit" class="btn btn-default" value="Log in"/>
        </div>
        <div>
            <br/>
            <p>
                <a href="/sign-up">Зарегестрироваться</a>
            </p>
        </div>
    </form>
</div>