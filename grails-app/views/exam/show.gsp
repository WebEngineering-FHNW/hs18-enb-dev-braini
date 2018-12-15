<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'exam.label', default: 'Exam')}" />
        <title>Prüfung anzeigen</title>
    </head>
    <body>
        <div class="nav-back">
            <asset:image src="icons/arrow-left.svg" alt="arrow left" />
            <g:link class="list" action="index">Zurück zu "Prüfungen"</g:link>
        </div>

        <div id="show-exam" class="content scaffold-show" role="main">
            <h1>Prüfung anzeigen</h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:display bean="exam" />
            <g:form resource="${this.exam}" method="DELETE">
                <fieldset class="buttons">
                    <input class="delete btn btn-danger" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                    <g:link class="edit btn btn-success" action="edit" resource="${this.exam}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
