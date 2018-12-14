<!DOCTYPE html>
<html lang="de"><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="GradeManager">
    <meta name="author" content="Markus Winter">
    <link rel="icon" type="image/png" href="/assets/grademanager.png" />

    <title>
        <g:layoutTitle default="GradeManager"/>
    </title>

    <!-- Bootstrap core CSS (EXTERNAL) -->
    <asset:stylesheet src="bootstrap-4.1.3.min.css"/>

    <!-- Main CSS -->
    <asset:stylesheet src="style.css"/>
</head>

<body data-gr-c-s-loaded="true">

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        <div class="container">
            <a class="navbar-brand" href="#">GradeManager</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#nav" aria-controls="nav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse justify-content-md-end" id="nav">
                <ul class="navbar-nav">
                    <li class="nav-item mx-2 active">
                        <a class="nav-link" href="#">Dashboard</a>
                    </li>
                    <li class="nav-item mx-2">
                        <a class="nav-link" href="#">Benutzer</a>
                    </li>
                    <li class="nav-item mx-2">
                        <a class="nav-link" href="#">Lehrer</a>
                    </li>
                    <li class="nav-item mx-2">
                        <a class="nav-link" href="#">Module</a>
                    </li>
                    <li class="nav-item mx-2">
                        <a class="nav-link" href="#">Prüfungen</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <main class="container">
        <g:layoutBody/>

        <footer class="pt-4 my-md-5 pt-md-5 border-top">
            <div class="row">
                <div class="col-12 col-md">
                    <small class="d-block mb-3 text-muted">&copy; 2018 - Markus Winter</small>
                </div>
            </div>
        </footer>
    </main>

<!-- Bootstrap core and jQueryJavaScript (EXTERNAL) -->
<script src="/assets/jquery-3.3.1.slim.min.js?compile=false"></script>
<script src="/assets/bootstrap.bundle-4.1.3.min.js?compile=false"></script>

</body></html>