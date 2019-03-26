<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Login page</title>
    <asset:stylesheet src="login/login.css"/>
    <script type="text/javascript">
        var homeUrl = '${g.createLink(controller: 'home', action: 'index')}';
        var ajaxUrl = '${g.createLink(controller: 'login', action: 'ajaxCheckUser')}';
    </script>
</head>

<body>
<div class="main-wrapper">
    <g:form name="loginForm" onsubmit="return triggerValidateAndXmlAjaxSend(ajaxUrl);">
        <fieldset class="form">
            <div class="fieldcontain required">
                <label for="loginId"><g:message code="label.text.login"/></label>
                <g:textField name="loginId" value=""/>
            </div>

            <div class="fieldcontain required">
                <label for="password"><g:message code="label.text.password"/></label>
                <g:passwordField name="password"/>
            </div>
        </fieldset>

        <div class="validate-content"></div>
        <fieldset class="buttons">
            <g:submitButton name="submit" value="Submit"/>
        </fieldset>
    </g:form>
</div>
<div id="eventTest">
    <p>Test event</p>
    <input type="button" name="asd" value="Кнопка">
</div>

<asset:javascript src="login/login.js"/>

</body>
</html>