<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<head>
    <meta charset="UTF-8">
    <link href="../resource/bootstrap.min.css" rel="stylesheet">
</head>
<#if error??>
<h2 style="text-align: center; color: red">${error}</h2>
</#if>
<#if success??>
<h2 style="text-align: center; color: green">${success}</h2>
</#if>
<div>
    <div class="form-group">
        <form id="loginForm" action="j_spring_security_check" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <h1>Login Form</h1>
            <div>
                <input type="text" placeholder="Username" name="j_username"/>
            </div>
            <div>
                <input type="password" placeholder="Password" name="j_password"/>
            </div>
            <div>
                <input name="remember-me" type="checkbox"/>
                <label for="remember-me">Запомнить меня</label>
            </div>
            <div>
                <input type="submit" value="Log in"/>
            </div>
            <div>
                <br/>
                <p>
                    <a href="/sign-up" class="to_register"><i class="fa fa-registered"></i>Зарегестрироваться</a>
                </p>
            </div>
        </form>
    </div>
</div>