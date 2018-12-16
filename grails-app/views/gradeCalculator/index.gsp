<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Noten-Rechner</title>

    <content tag="stylesheets">
        <asset:stylesheet src="gradeCalculator.css"/>
    </content>
</head>

<body>
<div>
    <h1 class="text-center">Noten-Rechner</h1>

    <form id="grade-form">
        <table class="table" id="grade-table">
            <thead>
                <tr>
                    <th>Note</th>
                    <th>Gewichtung</th>
                    <th></th>
                </tr>
            </thead>

            <tbody>
                <tr class="add-form">
                    <td><input type="number" id="grade" min="1" max="6" step="0.01" required></td>
                    <td><input type="number" id="weighting" min="1" max="100" value="100" required></td>
                    <td><button class="btn btn-sm btn-success" type="submit" id="add">Hinzufügen</button></td>
                </tr>
                <tr class="grade-avg">
                    <td><span class="badge badge-pill badge-light p-2"><strong>-</strong></span></td>
                    <td colspan="2"><strong>Gewichteter Durchschnitt</strong></td>
                </tr>
            </tbody>
        </table>
    </form>
</div>

<content tag="scripts">
    <script src="/assets/gradeCalculator.js?compile=false"></script>
</content>

</body>
</html>
