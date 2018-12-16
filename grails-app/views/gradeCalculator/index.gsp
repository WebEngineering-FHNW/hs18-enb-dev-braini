<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Noten-Rechner</title>
</head>

<body>
<div>
    <h1>Noten-Rechner</h1>

    <form id="grade-form" action="#">
        <table class="table w-25 mt-4" id="grade-table">
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
                    <td><strong>-</strong></td>
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
