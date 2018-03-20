
$(document).ready(function () {
    var loading = true;

    if (!$('#codPaisDestinatario').val())
        $('#codPaisDestinatario').val('GTM');

    $('#tarifaIncluidaCheckbox').prop('checked', $('#incluyeComision').val() == 'true');
    createCombo('codPaisDestinatarioSelect', host + 'config/paises');
    createCombo('codCorresponsalSelect');
    createCombo('formaPagoSelect');
    createCombo('tipoCambioSelect');

    $("#codPaisDestinatarioSelect").on('change', function () {
        var val = $(this).val();
        createCombo('codCorresponsalSelect', val && host + 'config/corresponsales/' + val );
    });

    $("#codCorresponsalSelect").on('change', function (e) {
        var val = $(this).val();
       
         $('#codCorresponsalLabel').val(e.args && e.args.item && e.args.item.label);
         $('#moneda').val(e.args && e.args.item && e.args.item.originalItem  && e.args.item.originalItem.moneda);
   
        if (!val) {
            $('#formaPago').val('');
            createCombo('formaPagoSelect');
        } else {
            createCombo('formaPagoSelect', val && host + 'config/formasEntrega/' + $('#codPaisDestinatarioSelect').val() + '/' + val);
        }
    });

    $("#codPaisDestinatarioSelect,#codCorresponsalSelect").on('change', function (e) {
        $('#' + this.id.split('Select')[0]).val($(this).val());
        validateCotizarForm(); 
        var id = $(this) && $(this)[0] && $(this)[0].id
        
        if( id === 'codPaisDestinatarioSelect'){
             $('#codPaisDestinatarioLabel').val(e.args && e.args.item && e.args.item.label);
        }
    });

    $("#formaPagoSelect").on('change', function (e) {
        $('#formaPagoLabel').val(e.args && e.args.item && e.args.item.label);
          
        $('#' + this.id.split('Select')[0]).val($(this).val());
        if (validateCotizarForm() && loading) {
            loading = false;
            cot(true);
        }
    });

    $("#tarifaIncluidaCheckbox").on('change', function () {
        $('#incluyeComision').val($('#tarifaIncluidaCheckbox').is(":checked"));
    });


    $("#tipoCambioSelect").on('change', function (e) {
        $('#tasaDeCambio').val($(this).val());
       
        var tipoCambio = e.args && e.args.item && e.args.item.originalItem && e.args.item.originalItem.nombre;
        $('#tipoCambio').val(tipoCambio);

        if (tipoCambio) {
//            var incluyeComision = $('#tarifaIncluidaCheckbox').prop('checked');
            $('#totalPagar').val(e.args && e.args.item && e.args.item.originalItem && e.args.item.originalItem.totalPagar);
            $('#montoRealAEnviar').val(e.args && e.args.item && e.args.item.originalItem && e.args.item.originalItem.montoEntregar);
            $('#dineroEntregado').val(e.args && e.args.item && e.args.item.originalItem && e.args.item.originalItem.dineroEntregado);
            $('#tarifaTagId').val(e.args && e.args.item && e.args.item.originalItem && e.args.item.originalItem.tarifaTagId);
//            $('#totalPagar').val(parseFloat($('#montoEntregar').val()) + parseFloat((incluyeComision ? tipoCambio : 0)));
//            $('#dineroEntregado').val(parseFloat($('#montoEntregar').val()) - parseFloat((incluyeComision ? 0 : tipoCambio)));
//            $('#montoRealAEnviar').val(parseFloat($('#dineroEntregado').val()) * parseFloat($('#tipoCambio').val()));
        }
//        else {
//            cleanResultFields();
//        }
    });

    $('#montoEntregar').on('blur', function () {
        validateCotizarForm();
    });
//debugger;
//    if (validateCotizarForm()) {
//        console.log('cotizar...');
//        cot(true);
//    }
});

function cot(keepTasaDeCambio) {
    if (!$('#cotizar').data('active'))
        return;

    // cleanResultFields(keepTasaDeCambio);

    var data = {
        monto: $('#montoEntregar').val() + "",
        corresponsal: $('#codCorresponsal').val() + "",
        formaEntrega: $('#formaPago').val() + "",
        incluyeComision: $('#incluyeComision').val() + ""
    };

    $.get(host + "config/cotizar",
            data,
            function (resultData) {
                var source = {
                    localdata: resultData,
                    datatype: "json",
                    datafields: [
//                        {name: 'tipoCambio'},
                        {name: 'tarifaTagId'},
                        {name: 'montoEntregar'},
                        {name: 'dineroEntregado'},
                        {name: 'totalPagar'},
                        {name: 'tarifaTagId'},
                        {name: 'nombre'},
                        {name: 'codigo'}
                    ]
                };

                var dataAdapter = new $.jqx.dataAdapter(source, {
                    loadComplete: function (values) {
                    }
                });

                $('#tipoCambioSelect').jqxComboBox(
                        {
                            source: dataAdapter,
                            width: 173,
                            height: 25,
                            displayMember: 'nombre',
                            valueMember: 'codigo',
                            autoDropDownHeight: true
                        });

                $("#tipoCambioSelect").ready(function () {
                    if ($('#tipoCambio').val()) {
                        $("#tipoCambioSelect").jqxComboBox('val', $('#tipoCambio').val());
                    } else {
                        $("#tipoCambioSelect").jqxComboBox('selectedIndex', 0);
                    }

                    var currentData = $.grep(resultData, function (elem) {
                        return elem.tarifa == $("#tipoCambioSelect").val()
                    })
 
                    if (currentData.length > 0){
                        currentData = currentData[0];
                        
                        $('#totalPagar').val(currentData.totalPagar);
                        $('#montoRealAEnviar').val(currentData.montoEntregar);
                        $('#dineroEntregado').val(currentData.dineroEntregado);
                        $('#tarifaTagId').val(currentData.tarifaTagId);
                    }
                });

            }
    );
}


function validateCotizarForm() {
    var valid = $('#codPaisDestinatario').val() && $('#montoEntregar').val() && $('#codCorresponsal').val() && $('#formaPago').val();

    $('#cotizar').data('active', valid);
    $('#cotizar').css('background-color', valid ? '#333' : 'grey');
    return valid;
}

function cleanResultFields(keepTasaDeCambio) {
    $('#montoRealAEnviar').val('');
    $('#totalPagar').val('');
    $('#dineroEntregado').val('');
    $('#tipoCambio').val('');

    if (!keepTasaDeCambio) {
        $('#tasaDeCambio').val('');
    }
}