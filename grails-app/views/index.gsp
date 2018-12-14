
<html>
<head>
    <meta name="layout" content="main"/>
</head>
<body>

    <div class="row">
        <% def count=6 %>
        <g:each in="${(1..count).toList()}" var="c" >
        <div class="col-12 col-md-6 col-lg-6 col-xl-4 mb-5 px-4">
            <div class="card card-module bg-light mb-3">
                <div class="card-header text-center">
                    <h5>webeC</h5>
                </div>
                <div class="card-body">
                    <p class="card-text">
                        <asset:image src="icons/person.svg" alt="person"/>
                        Christian Ribeaud
                        <br>
                        <asset:image src="icons/envelope-closed.svg" alt="envelope closed"/>
                        <a href="mailto:christian.ribeaud@fhnw.ch">christian.ribeaud@fhnw.ch</a>
                        <br>
                        <asset:image src="icons/map-marker.svg" alt="map marker"/>
                        5.2H14
                    </p>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item"><strong>Prüfungen</strong></li>
                    <li class="list-group-item">
                        <div class="d-flex bd-highlight">
                            <div class="pr-2 bd-highlight" style="min-width: 71px;">28.11.18</div>
                            <div class="px-2 bd-highlight">Zwischenprüfung 1</div>
                            <div class="ml-auto bd-highlight text-right" style="min-width: 46px;">
                                <span class="badge badge-pill badge-danger p-2 d-block"><strong>3.1</strong></span>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div class="d-flex bd-highlight">
                            <div class="pr-2 bd-highlight" style="min-width: 71px;">27.01.19</div>
                            <div class="px-2 bd-highlight">Zwischenprüfung 2</div>
                            <div class="ml-auto bd-highlight text-right" style="min-width: 46px;">
                                <span class="badge badge-pill badge-success p-2 d-block"><strong>4.73</strong></span>
                            </div>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div class="d-flex bd-highlight">
                            <div class="pr-2 bd-highlight" style="min-width: 71px;">27.01.19</div>
                            <div class="px-2 bd-highlight">MSP</div>
                            <div class="ml-auto bd-highlight text-right" style="min-width: 46px;">
                                <span class="badge badge-pill badge-light p-2 d-block"><strong>?</strong></span>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        </g:each>
    </div>

</body>
</html>