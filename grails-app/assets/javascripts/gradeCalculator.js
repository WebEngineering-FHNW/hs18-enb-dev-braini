// find some elements
var gradeTable     = $('#grade-table');
var gradeForm      = $('#grade-form');
var grade          = $('#grade');
var weighting      = $('#weighting');

/**
 * Recalculate the grade average and write it to DOM
 */
function recalculateAvg() {
    var gradeAvg       = 0;
    var gradeWeighting = 0;

    // find all grade and calculate the average
    gradeTable.find('tr.grade-entry').each(function () {
        var grade     = $(this).find('td.grade').html();
        var weighting = $(this).find('td.weighting').html();
        gradeAvg += grade*weighting;
        gradeWeighting += weighting*1;
    });

    // round on 2 decimals
    gradeAvg = (gradeAvg/gradeWeighting).toFixed(2);

    // set average to - in case if there are no grades
    if(isNaN(gradeAvg)) gradeAvg = '-';

    // write average to DOM
    gradeTable.find('tr.grade-avg td:first strong').html(gradeAvg);

    // set correct badge color class
    var className = "success";
    if (gradeAvg == '-') className = "light";
    if (gradeAvg < 4) className = "danger";

    gradeTable.find('tr.grade-avg td:first span').removeClass('badge-light badge-success badge-danger');
    gradeTable.find('tr.grade-avg td:first span').addClass('badge-' + className);
}

/**
 * Delete grade input field and focus it
 */
function cleanUpForm() {
    $(weighting).val(100);
    $(grade).val('').focus();
}

/**
 * Delete a grade and recalculate
 */
function deleteRow(row) {
    row.remove();
    recalculateAvg();
}

/**
 * Add given values to the table
 */
$(document).on('submit',gradeForm,function(e){
    e.preventDefault();

    $('#grade-table tr.add-form').before('<tr class="grade-entry">' +
        '<td class="grade">' + grade.val() + '</td>' +
        '<td class="weighting">' + weighting.val() + '</td>' +
        '<td class="del"><img onclick="deleteRow($(this).parents(\'tr\'))" src="/assets/icons/circle-x.svg" alt="delete"></td>' +
        '</tr>');

    cleanUpForm();
    recalculateAvg();
});

/**
 * Delete all grade rows
 */
$('#gradeCalculatorReset').click(function (e) {
    e.preventDefault();

    gradeTable.find('tr.grade-entry').each(function () {
        $(this).remove();
    });

    cleanUpForm();
    recalculateAvg();
});

// focus the grade input field
$('#grade').focus();