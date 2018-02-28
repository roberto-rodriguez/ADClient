
$(document).ready(function () {
    var formaPago = $('#formaPagoLabel').val();
    if(formaPago && formaPago === 'VENTANILLA'){
        $('#numeroCuentaTD').show();
    }else{
        $('#numeroCuentaTD').hide();
    }
    
    createCombo('codEstadoDestinatarioSelect', host + 'config/state/' + $('#codPaisDestinatario').val());

    $("#codEstadoDestinatarioSelect").on('change', function () {  
        $('#codEstadoDestinatarioLabel').val(e.args && e.args.item && e.args.item.label);
        $('#' + this.id.split('Select')[0]).val($(this).val());
    });
    
     $("#destinatarioIdSelect").on('change', function (e) { 
         var id = $(this).val();
        $('#destinatarioId').val(id);

            $('#nomDestinatario').val(id != 0 ? e.args.item && e.args.item.originalItem && e.args.item.originalItem.nombre : '');
            $('#telDestinatario').val(id != 0 ? e.args.item && e.args.item.originalItem && e.args.item.originalItem.telefono : '');
            $('#dirDestinatario').val(id != 0 ? e.args.item && e.args.item.originalItem && e.args.item.originalItem.direccion : '');
            $('#codEstadoDestinatario').val(id != 0 ? e.args.item && e.args.item.originalItem && e.args.item.originalItem.departamento : '');
            $('#nomCiudadDestinatario').val(id != 0 ? e.args.item && e.args.item.originalItem && e.args.item.originalItem.municipio : '');

            $("#codEstadoDestinatarioSelect").jqxComboBox('val', $('#codEstadoDestinatario').val());
    });

    tieneDestinatarios();
    
    
});

function tieneDestinatarios() {
    $.get(host + "config/destinatario/" + $('#telRemite').val(),
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
                    if ($('#destinatarioId').val()) {
                        $("#destinatarioIdSelect").jqxComboBox('val', $('#destinatarioId').val());
                    } else {
                        $("#destinatarioIdSelect").jqxComboBox('selectedIndex', 0);
                        $("#destinatarioIdSelect").change();
                    }
                });
            });

}