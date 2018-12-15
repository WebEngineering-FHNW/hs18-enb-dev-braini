<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'module.label', default: 'Module')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>

        <div class="row">
            <g:each in="${moduleList.sort{a,b-> a.name.compareTo(b.name)}}" var="module" >
                <div class="col-12 col-md-6 col-lg-6 col-xl-4 mb-5 px-4">
                    <div class="card card-module bg-light mb-3">
                        <div class="card-header text-center">
                            <h5>${module.name}</h5>
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
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item"><strong>Prüfungen</strong></li>

                            <g:each in="${ module.exams.sort{a,b-> a.date.compareTo(b.date)} }" var="exam">
                                <li class="list-group-item">
                                    <div class="d-flex bd-highlight">
                                        <div class="pr-2 bd-highlight" style="min-width: 71px;"><g:formatDate format="dd.MM.yy" date="${exam.date}"/></div>
                                        <div class="px-2 bd-highlight">${exam.description}</div>
                                        <div class="ml-auto bd-highlight text-right" style="min-width: 46px;">
                                            <span class="badge badge-pill badge-<g:if test="${!exam.grade}">light</g:if><g:elseif test="${exam.grade < 4}">danger</g:elseif><g:else>success</g:else> p-2 d-block"><strong>
                                                ${exam.grade}
                                                <g:if test="${!exam.grade}"> ? </g:if>
                                            </strong></span>
                                        </div>
                                    </div>
                                </li>
                            </g:each>

                            <g:if test="${!module.exams}">
                                <li class="list-group-item text-black-50">
                                    Noch keine Prüfungen eingetragen.
                                </li>
                            </g:if>

                        </ul>
                    </div>
                </div>
            </g:each>
        </div>

    </body>
</html>