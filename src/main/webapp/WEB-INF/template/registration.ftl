<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<head>
    <meta charset="UTF-8">
    <link href="../resource/bootstrap.min.css" rel="stylesheet">
</head>
<div>
    <section class="form-group">
    <@form.form commandName="regForm" action="/sign-up" acceptCharset="UTF-8" method="post" >
        <h1>Create Account</h1>
        <#if error??>
            <h2 style="text-align: center; color: red">${error}</h2>
        </#if>
        <div>
            <@form.input path="username" placeholder = "login"/>
                    <@form.errors path="username" cssStyle="color: red;" />
        </div>
        <div>
            <@form.password path="password" placeholder="Password"/>
                    <@form.errors path="password" cssStyle="color: red;" />
        </div>
        <div>
            <@form.password path="confirmPassword" placeholder="confirm password"/>
                    <@form.errors path="confirmPassword" cssStyle="color: red;" />
        </div>
        <div>
            <input type="submit" value="Регистрация">
        </div>
    </@form.form>
    </section>
</div>