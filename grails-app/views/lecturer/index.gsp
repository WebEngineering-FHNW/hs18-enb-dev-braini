<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'lecturer.label', default: 'Lecturer')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div id="list-lecturer" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${lecturerList}" />

            <div class="new-entity">
                <g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link>
            </div>

            <div class="pagination">
                <g:paginate total="${lecturerCount ?: 0}" />
            </div>
        </div>
    </body>
</html>