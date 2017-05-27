
$(document).ready(function () {
    if (!$('#pais').val())
        $('#pais').val('GTM');

    $('#tarifaIncluidaCheckbox').prop('checked', $('#tarifaIncluida').val() == 'true');
    createCombo('paisSelect', '/ADClient/config/paises');
    createCombo('corresponsalSelect');
    createCombo('formaDeEntregaSelect');
    createCombo('tarifaSelect');

    $("#paisSelect").on('change', function () {
        var val = $(this).val();
        createCombo('corresponsalSelect', val && '/ADClient/config/corresponsales/' + val);
    });

    $("#corresponsalSelect").on('change', function () {
        var val = $(this).val();
        if (!val) {
            $('#formaDeEntrega').val('');
            createCombo('formaDeEntregaSelect');
        } else {
            createCombo('formaDeEntregaSelect', val && '/ADClient/config/formasEntrega/' + $('#paisSelect').val() + '/' + val);
        }
    });

    $("#paisSelect,#corresponsalSelect,#formaDeEntregaSelect").on('change', function () {
        $('#' + this.id.split('Select')[0]).val($(this).val());
        validateCotizarForm();
    });

    $("#tarifaIncluidaCheckbox").on('change', function () {
        $('#tarifaIncluida').val($('#tarifaIncluidaCheckbox').is(":checked"));
    });

    $("#tarifaSelect").on('change', function (e) {
        $('#tasaDeCambio').val($(this).val());
        debugger;
        var tarifa = e.args && e.args.item && e.args.item.originalItem && e.args.item.originalItem.nombre;
//        var tarifa = e.args && e.args.item && e.args.item.originalItem && e.args.item.originalItem.tarifa;
        $('#tarifa').val(tarifa);

        if (tarifa) {
            var tarifaIncluida = $('#tarifaIncluidaCheckbox').prop('checked');
            $('#totalAPagar').val(parseFloat($('#montoAEnviar').val()) + parseFloat((tarifaIncluida ? tarifa : 0)));

            $('#montoRealAPagar').val(parseFloat($('#montoAEnviar').val()) - parseFloat((tarifaIncluida ? 0 : tarifa)));
            $('#montoRealAEnviar').val(parseFloat($('#montoRealAPagar').val()) * parseFloat($('#tasaDeCambio').val()));
        } else {
            cleanResultFields();
        }
    });

    $('#montoAEnviar').on('blur', function () {
        validateCotizarForm();
    });

    if (validateCotizarForm()) {
        cot();
    }
});

function cot() {
    if (!$('#cotizar').data('active'))
        return;

    cleanResultFields();

    var data = {
        monto: $('#montoAEnviar').val() + "",
        corresponsal: $('#corresponsal').val() + "",
        formaEntrega: $('#formaDeEntrega').val() + "",
        incluyeComision: $('#tarifaIncluida').val() + ""
    };

    $.get("/ADClient/config/cotizar",
            data,
            function (resultData) {
                var source = {
                    localdata: resultData,
                    datatype: "json",
                    datafields: [
//                        {name: 'tarifa'},
//                        {name: 'tasaDeCambio'},
//                        {name: 'montoEntregar'},
//                        {name: 'dineroEntregado'},
//                        {name: 'totalPagar'},
//                        {name: 'tarifaTagId'},
                        {name: 'nombre'},
                        {name: 'codigo'}
                    ]
                };

                var dataAdapter = new $.jqx.dataAdapter(source, {
                    loadComplete: function (values) {
//                        var id = 'tarifaSelect',
//                                previousValue = $('#tarifa').val();
//                        debugger;
//                        if (previousValue && $.grep(values, function (elem) {
//                            return elem.nombre == previousValue
//                        }).length > 0) {
//                            jQuery('#' + id).jqxComboBox('val', previousValue);
//                        } else {
//                            var newVal = values.length > 0 ? values[0].nombre : null;
//                            jQuery('#' + id).jqxComboBox('val', newVal);
//                            jQuery('#' + id).change();
//                        }
                    }
                });

                $('#tarifaSelect').jqxComboBox(
                        {
                            source: dataAdapter,
                            width: 173,
                            height: 25,
                            displayMember: 'nombre',
                            valueMember: 'codigo',
                            autoDropDownHeight: true
                        });


                $("#tarifaSelect").ready(function () {
                    if($('#tarifa').val()){
                        $("#tarifaSelect").jqxComboBox('val', $('#tarifa').val()); 
                    }else{
                        $("#tarifaSelect").jqxComboBox('selectedIndex', 0); 
                    }
                   
                });
            }
    );
}


function validateCotizarForm() {
    var valid = $('#pais').val() && $('#montoAEnviar').val() && $('#corresponsal').val() && $('#formaDeEntrega').val();

    $('#cotizar').data('active', valid);
    $('#cotizar').css('background-color', valid ? '#333' : 'grey');
    return valid;
}

function cleanResultFields() {
    $('#montoRealAEnviar').val('');
    $('#totalAPagar').val('');
    $('#montoRealAPagar').val('');
}