
$(document).ready(function () {
    createCombo('codEstadoRemiteSelect', host + 'config/state/US');
    createCombo('nomCiudadRemiteSelect');

    $("#codEstadoRemiteSelect").on('change', function () {
        var val = $(this).val();
        createCombo('nomCiudadRemiteSelect', val && host + 'config/city/' + val);
    });

    $("#codEstadoRemiteSelect,#nomCiudadRemiteSelect").on('change', function () {
        $('#' + this.id.split('Select')[0]).val($(this).val()); 
    });

    $("#remitenteTelefono").on('blur', function () {
        validateTelefono();
    });
 
});

function validateTelefono() { 
    $.get(host + "config/remitente/" + $('#remitenteTelefono').val(),
            function (resultData) {
                if (resultData) {
                    $('#remitenteNombre').val(resultData.name);
                    $('#dirRemite').val(resultData.direccion);
                    $('#remitenteZipcode').val(resultData.zipcode);
                    jQuery('#codEstadoRemiteSelect').jqxComboBox('val', resultData.estado);
                    $('#codEstadoRemite').val(resultData.estado);
                    $('#nomCiudadRemite').val(resultData.ciudad);
                    createCombo('nomCiudadRemiteSelect', resultData.estado && host + 'config/city/' + resultData.estado);
                }
            }
    );
}
 