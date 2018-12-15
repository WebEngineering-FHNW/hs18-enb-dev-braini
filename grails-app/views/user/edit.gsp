<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title>Benutzer aktualisieren</title>
    </head>
    <body>
        <div class="nav-back">
            <asset:image src="icons/arrow-left.svg" alt="arrow left" />
            <g:link class="list" action="index">Zurück zu "Benutzer"</g:link>
        </div>

        <div id="edit-user" class="content scaffold-edit" role="main">
            <h1>Benutzer aktualisieren</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.user}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.user}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.user}" method="PUT">
                <g:hiddenField name="version" value="${this.user?.version}" />
                <fieldset class="form">
                    <f:all bean="user"/>
                </fieldset>
                <fieldset class="buttons">
                    <input class="save btn btn-success" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
