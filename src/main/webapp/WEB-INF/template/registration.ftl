<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<head>
    <meta charset="UTF-8">
    <link href="../resource/css/bootstrap.min.css" rel="stylesheet">
    <link href="../resource/css/forms_style.css" rel="stylesheet">
    <>
</head>
<body>
<script src="../resource/js/validate.js"></script>
<div>
    <div class="registration_form">
    <@form.form commandName="regForm" action="/sign-up" acceptCharset="UTF-8" method="post" role="post" >
        <h1>Регистрация</h1>
        <#if error??>
            <h2 class="error_message">${error}</h2>
        </#if>
        <div class="form-group">
            <@form.input path="username" placeholder = "login" cssClass="form-control login" onblur="LoginValid()"/>
                    <@form.errors path="username" cssClass="error_message" id="err_login"/>
        </div>
        <div class="form-group">
            <@form.password path="password" placeholder="Password" cssClass="form-control" id="password"
            onblur="PasswordValid()"/>
                    <@form.errors path="password" cssClass="error_message" id="err_password"/>
        </div>
        <div class="form-group">
            <@form.password path="confirmPassword" placeholder="confirm_password" cssClass="form-control"
            id="confirm_password" onblur = "ConfirmPasswordValid()"/>
                    <@form.errors path="confirmPassword" cssClass="error_message" id ="err_confirm_password"/>
        </div>
        <div>
            <input type="submit" value="Регистрация" class="btn btn-default">
        </div>
    </@form.form>
    </div>
</div>
</body>