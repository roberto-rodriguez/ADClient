
$(document).ready(function () {
    createCombo('remitenteEstadoSelect', '/ADClient/config/state/US');
    createCombo('remitenteCiudadSelect');

    $("#remitenteEstadoSelect").on('change', function () {
        var val = $(this).val();
        createCombo('remitenteCiudadSelect', val && '/ADClient/config/city/' + val);
    });

    $("#remitenteEstadoSelect,#remitenteCiudadSelect").on('change', function () {
        $('#' + this.id.split('Select')[0]).val($(this).val()); 
    });

    $("#remitenteTelefono").on('blur', function () {
        validateTelefono();
    });
 
});

function validateTelefono() { 
    $.get("/ADClient/config/remitente/" + $('#remitenteTelefono').val(),
            function (resultData) {
                if (resultData) {
                    $('#remitenteNombre').val(resultData.name);
                    $('#remitenteDireccion').val(resultData.direccion);
                    $('#remitenteZipcode').val(resultData.zipcode);
                    jQuery('#remitenteEstadoSelect').jqxComboBox('val', resultData.estado);
                    $('#remitenteEstado').val(resultData.estado);
                    $('#remitenteCiudad').val(resultData.ciudad);
                    createCombo('remitenteCiudadSelect', resultData.estado && '/ADClient/config/city/' + resultData.estado);
                }
            }
    );
}
 