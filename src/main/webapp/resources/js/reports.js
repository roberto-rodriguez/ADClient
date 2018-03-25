
    $(document).ready(function () {
        
        $.get( host + "reports/search", function(response){
            $('#results').html(response);
        }); 
        
    });