<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'module.label', default: 'Module')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>

        <content tag="stylesheets">
            <asset:stylesheet src="gradeDashboard.css"/>
        </content>
    </head>
    <body>

        <div class="row">
            <g:if test="${moduleList}">
                <g:each in="${moduleList.sort{a,b-> a.name.compareTo(b.name)}}" var="module" >
                    <div class="col-12 col-md-6 col-lg-6 col-xl-4 mb-5 px-4">
                        <div class="card card-module bg-light mb-3">
                            <div class="card-header text-center">
                                <h5>${module.name}</h5>
                                <div class="module-actions">
                                    <g:link action="edit" title="Modul editieren" resource="${module}"><asset:image src="icons/pencil.svg" alt="edit"/></g:link>
                                    <form action="/module/delete/${module.id}" method="post" class="d-inline-block"><input type="hidden" name="_method" value="DELETE">
                                        <a href="javascript: " onclick="c = confirm('Sind Sie sicher?'); if(c) parentNode.submit();"><img src="/assets/icons/circle-x.svg" alt="delete"></a>
                                    </form>
                                </div>
                            </div>
                            <div class="card-body">
                                <p class="card-text">
                                    <asset:image src="icons/person.svg" alt="person"/>
                                    ${module.lecturer.firstname} ${module.lecturer.lastname}
                                    <br>
                                    <asset:image src="icons/envelope-closed.svg" alt="envelope closed"/>
                                    <a href="mailto:${module.lecturer.email}">${module.lecturer.email}</a>
                                    <br>
                                    <asset:image src="icons/map-marker.svg" alt="map marker"/>
                                    ${module.location}
                                </p>
                            </div>
                            <ul class="list-group list-group-flush exam-list">
                                <div class="d-none">
                                    ${examCount = 0}
                                    ${examAvgGrade = 0}

                                    <g:each in="${ module.exams }" var="exam">
                                        <g:if test="${exam.grade}">
                                            ${examCount++}
                                            ${examAvgGrade += exam.grade}
                                        </g:if>
                                    </g:each>

                                    ${examAvgGrade = examAvgGrade/(double)examCount}}
                                    ${examAvgGrade = (examAvgGrade as double).round(2)}

                                    <g:if test="${examAvgGrade.isNaN()}">
                                        ${examAvgGrade = "?"}
                                    </g:if>
                                </div>

                                <li class="list-group-item padding">
                                    <strong>Prüfungen</strong>
                                    <div style="float:right;" class="d-inline-block  p-2 badge badge-pill badge-<g:if test="${examAvgGrade == "?"}">light</g:if><g:elseif test="${examAvgGrade < 4}">danger</g:elseif><g:else>success</g:else>"><strong>
                                        &empty; ${examAvgGrade}
                                    </strong></div>
                                </li>

                                <g:each in="${ module.exams.sort{a,b-> a.date.compareTo(b.date)} }" var="exam">
                                    <li class="list-group-item ">
                                        <g:link action="show" class="exam-link" resource="${exam}">
                                            <div class="d-flex bd-highlight">
                                                <div class="pr-2 bd-highlight" style="min-width: 71px;"><g:formatDate format="dd.MM.yy" date="${exam.date}"/></div>
                                                <div class="px-2 bd-highlight">${exam.description}</div>
                                                <div class="ml-auto bd-highlight text-right" style="min-width: 46px;">
                                                    <span class="badge badge-pill badge-<g:if test="${!exam.grade}">light</g:if><g:elseif test="${exam.grade < 4}">danger</g:elseif><g:else>success</g:else> p-2 d-block">
                                                        ${exam.grade}
                                                        <g:if test="${!exam.grade}"> ? </g:if>
                                                    </span>
                                                </div>
                                            </div>
                                        </g:link>
                                    </li>
                                </g:each>

                                <g:if test="${!module.exams}">
                                    <li class="list-group-item text-black-50 padding">
                                        Noch keine Prüfungen eingetragen.
                                    </li>
                                </g:if>

                                <li class="list-group-item">
                                    <g:link action="create" resource="exam" params="['module.id': module.id]">+ Prüfung hinzufügen</g:link>
                                </li>

                            </ul>
                        </div>
                    </div>
                </g:each>
            </g:if>

            <g:if test="${!moduleList}">
                <div class="alert alert-primary position-absolute">
                    Noch keine Module eingetragen.
                </div>
            </g:if>

            <div class="text-right d-block w-100 pr-3">
                <g:link class="btn btn-success mr-1" action="create">+ Modul hinzufügen</g:link>
            </div>
        </div>

    </body>
</html>