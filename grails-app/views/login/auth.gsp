<html>
<head>
    <meta name="layout" content="${gspLayout ?: 'main'}"/>
    <title><g:message code='springSecurity.login.title'/></title>
</head>

<body>
    <!-- Login form -->
    <form action="${postUrl ?: '/login/authenticate'}" method="POST" id="loginForm" class="text-center m-auto mb-5" style="max-width: 300px; min-height: 500px;" autocomplete="off">
                <asset:image class="mb-4" src="grademanager.png" alt="grademanager logo" width="140" />
        <h1 class="h3 font-weight-normal">GradeManager</h1>
        <h1 class="h5 mb-3 font-weight-normal">Bitte anmelden</h1>

        <label for="username" class="sr-only mt-1">E-Mail Adresse</label>
        <input type="email" name="username" id="username" class="form-control mt-4" placeholder="E-Mail Adresse" required="" autofocus="">

        <label for="password" class="sr-only">Passwort</label>
        <input type="password" name="password" id="password" class="form-control" placeholder="Passwort" required="" style="margin-top: 8px;">

        <div class="checkbox mt-2 mb-3">
            <label>
                <input type="checkbox" name="${rememberMeParameter ?: 'remember-me'}" id="remember_me" <g:if test='${hasCookie}'>checked="checked"</g:if>> Angemeldet bleiben
            </label>
        </div>

        <!-- Error messages -->
        <g:if test='${flash.message}'>
            <div class="alert alert-danger mb-4">${flash.message}</div>
        </g:if>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Anmelden</button>
        <a class="d-inline-block mt-2" href="javascript: ;" onclick="document.getElementById('username').value = 'markus.winter@students.fhnw.ch'; document.getElementById('password').value = 'markus87';">Demo Anmeldedaten</a>
    </form>

    <script>
        (function() {
            document.forms['loginForm'].elements['${usernameParameter ?: 'username'}'].focus();
        })();
    </script>
</body>
</html>