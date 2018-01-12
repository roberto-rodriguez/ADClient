
$(document).ready(function () { 
     
     $('#afidavitHiddenFields').children().each(function(index, c){ 
         var id = c.id;
         $('#' + id + 'Checkbox').prop('checked', $('#' + id).val() == 'true');
        $('#' + id + 'Checkbox').on('change', function () {
            $('#' + id).val($('#' + id + 'Checkbox').is(":checked"));
        });
     })
         
});
 