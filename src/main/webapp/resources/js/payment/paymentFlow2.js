
$(document).ready(function () {
     var isCuba = $('#pais').val() === 'CUB';
     
     if(!isCuba){
          $('#cubaForm').hide();
     } 
    
    createCombo('codEstadoRemiteSelect', host + 'config/state/US');
    createCombo('nomCiudadRemiteSelect');
 
    $("#codEstadoRemiteSelect").on('change', function (e) {
        var val = $(this).val();
         $('#codEstadoRemiteLabel').val(e.args && e.args.item && e.args.item.label);
        createCombo('nomCiudadRemiteSelect', val && host + 'config/city/' + val);
    });

    $("#codEstadoRemiteSelect,#nomCiudadRemiteSelect").on('change', function () {
        $('#' + this.id.split('Select')[0]).val($(this).val()); 
    });

    $("#telRemite").on('blur', function () {
        validateTelefono();
    });
 
   
    
    if(isCuba){
        $('#fechaNacRemite').datepicker({dateFormat: 'dd-mm-yy'});//.datepicker("setDate", new Date()); 
        $('#fechaExpiracion').datepicker({dateFormat: 'dd-mm-yy'});//.datepicker("setDate", new Date()); 
        
        $('#remitentePresenteCheckbox').prop('checked', $('#remitentePresente').val() == 'true');
        $("#remitentePresenteCheckbox").on('change', function () {
            $('#remitentePresente').val($('#remitentePresenteCheckbox').is(":checked"));
        });
         
        var tipoId = [
            "Identificación Nacional",
            "Pasaporte",
            "Licencia de Conducción",
            "Matrícula Consular"
        ]; 
        
        var relation = [
            "Padre",
            "Madre",
            "Esposo",
            "Hijo",
            "Hermano",
            "Tio",
            "Abuelo",
            "Nieto",
            "Primo",
            "Sobrino",
            "Otro"
        ]
        
        $("#tipoIdSelect").jqxComboBox({ source: tipoId, selectedIndex: 0});
        $("#relacionDestinatarioSelect").jqxComboBox({ source: relation, selectedIndex: 0});

        $("#tipoIdSelect,#relacionDestinatarioSelect").on('change', function () {
              $('#' + this.id.split('Select')[0]).val($(this).val()); 
              $('#' + this.id.split('Select')[0] + 'Index').val($(this).jqxComboBox('selectedIndex')); 
          });
          
          if($('#tipoIdIndex').val()){
             $("#tipoIdSelect").jqxComboBox({ selectedIndex: $('#tipoIdIndex').val()}); 
          }
          
          if($('#relacionDestinatarioIndex').val()){
             $("#relacionDestinatarioSelect").jqxComboBox({ selectedIndex: $('#relacionDestinatarioIndex').val()}); 
          }
    }
 
});

function validateTelefono() { 
    $.get(host + "config/remitente/" + $('#telRemite').val(),
            function (resultData) {
                if (resultData) {
                    $('#nomRemite').val(resultData.name);
                    $('#dirRemite').val(resultData.direccion);
                    $('#dirPostalRemite').val(resultData.zipcode);
                    jQuery('#codEstadoRemiteSelect').jqxComboBox('val', resultData.estado);
                    $('#codEstadoRemite').val(resultData.estado);
                    $('#nomCiudadRemite').val(resultData.ciudad);
                    createCombo('nomCiudadRemiteSelect', resultData.estado && host + 'config/city/' + resultData.estado);
                }
            }
    );
}
 