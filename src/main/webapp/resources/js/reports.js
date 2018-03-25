
$(document).ready(function () {
    doSearch();
    $('#fechaDel').datepicker();
    $('#fechaAl').datepicker();
});


function doSearch(increment) {
    var page = parseInt($('#page').val()) + (increment || 0)

    if (page < 1)
        return;

    var request = {
        page: page,
        limit: $('#limit').val(),
        fechaDel: $('#fechaDel').val(),
        fechaAl: $('#fechaAl').val(),
        nombreR: $('#nombreR').val(),
        nombreD: $('#nombreD').val(),
        codEnvio: $('#reference').val(),
    }

    $.ajax({
        url: host + "reports/search",
        type: "POST",
        data: JSON.stringify(request),
        contentType: "application/json",
        success: function (response) {
            $('#page').val(page);
            $('#results').html(response);
        }
    })
}

function doReport(type){
    window.open(host + "reports/" + type);
}

function toogleSearchForm(show){ 
    debugger;
    var searchForm = $(".search-form");
    if(show){
        searchForm.show();
    }else{
        searchForm.hide();
    }
}
 