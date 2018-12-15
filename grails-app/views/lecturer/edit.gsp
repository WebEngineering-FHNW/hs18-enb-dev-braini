<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'lecturer.label', default: 'Lecturer')}" />
        <title>Lehrer anzeigen</title>
    </head>
    <body>
        <div class="nav-back">
            <asset:image src="icons/arrow-left.svg" alt="arrow left" />
            <g:link class="list" action="index">Zurück zu "Lehrer"</g:link>
        </div>

    <div id="edit-lecturer" class="content scaffold-edit" role="main">
            <h1>Lehrer anzeigen</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.lecturer}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.lecturer}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.lecturer}" method="PUT">
                <g:hiddenField name="version" value="${this.lecturer?.version}" />
                <fieldset class="form">
                    <f:all bean="lecturer"/>
                </fieldset>
                <fieldset class="buttons">
                    <input class="save btn btn-success" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
