<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title>Benutzer</title>
    </head>
    <body>
        <div id="list-user" class="content scaffold-list" role="main">
            <h1>Benutzer</h1>

            <g:if test="${!userList}">
                <div class="alert alert-primary" style="position: absolute;">
                    Noch keine Benutzer eingetragen.
                </div>
            </g:if>

            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${userList}" />

            <div class="new-entity">
                <g:link class="btn btn-success pull-right" action="create">Benutzer hinzufügen</g:link>
            </div>

            <div class="pagination">
                <g:paginate total="${userCount ?: 0}" />
            </div>
        </div>
    </body>
</html>