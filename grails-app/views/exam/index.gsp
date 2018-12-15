<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'exam.label', default: 'Exam')}" />
        <title>Prüfungen</title>
    </head>
    <body>
        <div id="list-exam" class="content scaffold-list" role="main">
            <h1>Prüfungen</h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${examList}" />

            <div class="new-entity">
                <g:link class="btn btn-success pull-right" action="create">Prüfung anlegen</g:link>
            </div>

            <div class="pagination">
                <g:paginate total="${examCount ?: 0}" />
            </div>
        </div>
    </body>
</html>