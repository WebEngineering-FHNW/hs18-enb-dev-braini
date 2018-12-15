<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'module.label', default: 'Module')}" />
        <title>Modul editieren</title>
    </head>
    <body>
        <div class="nav-back">
            <asset:image src="icons/arrow-left.svg" alt="arrow left" />
            <g:link class="list" action="index">Zurück zu "Dashboard"</g:link>
        </div>

        <div id="edit-module" class="content scaffold-edit" role="main">
            <h1>Modul editieren</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.module}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.module}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.module}" method="PUT">
                <g:hiddenField name="version" value="${this.module?.version}" />
                <fieldset class="form">
                    <f:all bean="module"/>
                </fieldset>
                <fieldset class="buttons">
                    <input class="save btn btn-success" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
