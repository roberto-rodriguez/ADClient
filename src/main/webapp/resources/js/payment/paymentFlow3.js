
$(document).ready(function () {
    createCombo('destinatarioEstadoSelect', '/ADClient/config/state/' + $('#pais').val());

    $("#destinatarioEstadoSelect").on('change', function () {
        $('#' + this.id.split('Select')[0]).val($(this).val());
    });

});

function tieneDestinatarios() {
    $.get("/ADClient/config/destinatario/" + $('#remitenteTelefono').val(),
            {},
            function (resultData) {
                var source = {
                    localdata: resultData,
                    datatype: "json",
                    datafields: [
                        {name: 'id'},
                        {name: 'nombre'},
                        {name: 'lastName'},
                        {name: 'direccion'},
                        {name: 'municipio'},
                        {name: 'departamento'},
                        {name: 'pais'},
                        {name: 'telefono'}
                    ]
                };

                var dataAdapter = new $.jqx.dataAdapter(source, {
                    loadComplete: function (values) {
                        if(!values || values.length == 0)return;
                        
                        $('#destinatariosSection').show();
                        var id = 'destinatarioIdSelect',
                         previousValue = $('#' + id.split('Select')[0]).val();
                 
                        if (previousValue && $.grep(values, function (elem) {
                            return elem.codigo == previousValue
                        }).length > 0) {
                            jQuery('#' + id).jqxComboBox('val', previousValue);
                        } else {
                            var newVal = values.length > 0 ? values[0].codigo : null;
                            jQuery('#' + id).jqxComboBox('val', newVal);
                            jQuery('#' + id).change();
                        }
                    }
                });

                $('#tarifaSelect').jqxComboBox(
                        {
                            source: dataAdapter,
                            width: 173,
                            height: 25,
                            selectedIndex: 0,
                            displayMember: 'nombre',
                            valueMember: 'id',
                            autoDropDownHeight: true
                        });
            });

}