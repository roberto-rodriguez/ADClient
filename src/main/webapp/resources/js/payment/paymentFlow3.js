
$(document).ready(function () {
    createCombo('destinatarioEstadoSelect', '/ADClient/config/state/' + $('#pais').val());

    $("#destinatarioEstadoSelect").on('change', function () { 
        $('#' + this.id.split('Select')[0]).val($(this).val());
    });
    
     $("#destinatarioIdSelect").on('change', function (e) { 
         var id = $(this).val();
        $('#destinatarioId').val(id);

            $('#destinatarioNombre').val(id != 0 ? e.args.item && e.args.item.originalItem && e.args.item.originalItem.nombre : '');
            $('#destinatarioTelefono').val(id != 0 ? e.args.item && e.args.item.originalItem && e.args.item.originalItem.telefono : '');
            $('#destinatarioDireccion').val(id != 0 ? e.args.item && e.args.item.originalItem && e.args.item.originalItem.direccion : '');
            $('#destinatarioEstado').val(id != 0 ? e.args.item && e.args.item.originalItem && e.args.item.originalItem.departamento : '');
            $('#destinatarioCiudad').val(id != 0 ? e.args.item && e.args.item.originalItem && e.args.item.originalItem.municipio : '');

            $("#destinatarioEstadoSelect").jqxComboBox('val', $('#destinatarioEstado').val());
    });destinatarioEstado

    tieneDestinatarios();
});

function tieneDestinatarios() {
    $.get("/ADClient/config/destinatario/" + $('#remitenteTelefono').val(),
            {},
            function (resultData) {
                debugger;
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
                        if (!values || values.length > 1){
                           $('#destinatariosSection').show(); 
                        } 
                    }
                });

                $('#destinatarioIdSelect').jqxComboBox(
                        {
                            source: dataAdapter,
                            width: 173,
                            height: 25,
                            selectedIndex: 0,
                            displayMember: 'nombre',
                            valueMember: 'id',
                            autoDropDownHeight: true
                        });

                $("#destinatarioIdSelect").ready(function () {
                    debugger;
                    if ($('#destinatarioId').val()) {
                        $("#destinatarioIdSelect").jqxComboBox('val', $('#destinatarioId').val());
                    } else {
                        $("#destinatarioIdSelect").jqxComboBox('selectedIndex', 0);
                        $("#destinatarioIdSelect").change();
                    }
                });
            });

}