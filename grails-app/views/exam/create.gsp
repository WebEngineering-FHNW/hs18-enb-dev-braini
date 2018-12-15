<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'exam.label', default: 'Exam')}" />
        <title>Prüfung hinzufügen</title>
    </head>
    <body>
        <div id="create-exam" class="content scaffold-create" role="main">
            <h1>Prüfung hinzufügen</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.exam}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.exam}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.exam}" method="POST">
                <fieldset class="form">
                    <f:all bean="exam"/>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save btn btn-success" value="Prüfung hinzufügen" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
