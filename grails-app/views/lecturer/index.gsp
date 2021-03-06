<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'lecturer.label', default: 'Lecturer')}" />
        <title>Lehrer</title>
    </head>
    <body>
        <div id="list-lecturer" class="content scaffold-list" role="main">
            <h1>Lehrer</h1>

            <g:if test="${!lecturerList}">
                <div class="alert alert-primary" style="position: absolute;">
                    Noch keine Lehrer eingetragen.
                </div>
            </g:if>

            <g:if test="${flash.lecturerList}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${lecturerList}" />

            <div class="new-entity">
                <g:link class="btn btn-success pull-right" action="create">+ Lehrer hinzufügen</g:link>
            </div>

            <div class="pagination">
                <g:paginate total="${lecturerCount ?: 0}" />
            </div>
        </div>
    </body>
</html>