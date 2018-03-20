
var host = "/ADClient/";
 
//var host = "/"; 

function login() {
    window.location = host + "login?username=" + $('#username').val()
//    $.get(host + "login", 
//            function (result) {
//                debugger;
//            }
//    )


}


function next() {
    goTo('next');
}

function back() {
    goTo('back');
}

function getData() {
    var data = {};

    $('input[type="text"]').each(function (i, e) {
        data[e.id] = $(e).val();
    });

    return data;
}

function goTo(event) {
    $.ajax({
        type: "GET",
        url: $("#flowExecutionUrl").val() + "&_eventId=" + event,
        data: getData(),
        success: function (data) {
            $('#content').html(data);
        },
        error: function (response) {
            alert('error');
        }
    });
}

function nav(path) {
    $.get(host + path, function (data) {
            $('#content').html(data);
        }) 
}

function createCombo(id, url ) {
    var source = url ?
            {
                datatype: "json",
                datafields: [
                    {name: 'nombre'},
                    {name: 'codigo'},
                    {name: 'moneda'} // For corresponsal 
                ],
                url: url,
                async: true
            } : {};

    var dataAdapter = new $.jqx.dataAdapter(source, {
        loadComplete: function (values) { 
            var previousValue = $('#' + id.split('Select')[0]).val();
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

    var config = {
        source: dataAdapter,
        width: 173,
        height: 25,
        displayMember: 'nombre',
        valueMember: 'codigo',
        autoDropDownHeight: true
    };


    $('#' + id).jqxComboBox(config);

}


function generateReceipt() {
    console.log('generatePDF'); 
    window.open(host + "reports/receipt" , 'window',  'HEIGHT=660,resizable=yes,scrollbars=yes,WIDTH=710,target="blank_"');
//    window.open("/ADReport/facturas/facturasReport/" + clientId, 'window',  'HEIGHT=660,resizable=yes,scrollbars=yes,WIDTH=710,target="blank_"');
 }