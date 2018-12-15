<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'module.label', default: 'Module')}" />
        <title>Modul hinzufügen</title>
    </head>
    <body>
        <div id="create-module" class="content scaffold-create" role="main">
            <h1>Modul hinzufügen</h1>
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
            <g:form resource="${this.module}" method="POST">
                <fieldset class="form">
                    <f:all bean="module"/>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save btn btn-success" value="Modul hinzufügen" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
