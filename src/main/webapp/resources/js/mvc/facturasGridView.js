var selectedCampId = -1;

function loadFacturas() {
    console.log('OnLoad');
    selectedCampId = -1;

    var pageWidth = $("#list5").parent().width();

    console.log('pageWidth = ' + pageWidth);
    console.log('column = ' + (pageWidth * 0.25));

    var searchString = {sopt: ['eq', 'ne', 'bw', 'bn', 'ew', 'en', 'cn', 'nc']};
    var searchNumber = {sopt: ['numberEQ', 'numberNE', 'lt', 'le', 'gt', 'ge']};

    jQuery("#list5").jqGrid({
//        url:'http://adreporttomcat-env.us-east-1.elasticbeanstalk.com/facturas/listFacturas.htm',
        url: host + 'facturas/listFacturas.htm',
        postData: {
            clientId: function () {
                return $('#clientIdField').val();
            },
            from:function(){
                return $('#fromField').val();
            },
            to:function(){
                return $('#toField').val();
            }
        },
        datatype: "json",
        colNames: ['Client ID','Period', 'Sales', 'Discount', 'Net to Pay', 'Promotion', 'Download'],
        colModel: [
            {name: 'clientId', index: 'clientId', width: (pageWidth * 0.15), searchoptions: searchString},
            {name: 'period', index: 'period', width: (pageWidth * 0.18), searchoptions: searchString},
            {name: 'sales', index: 'sales', width: (pageWidth * 0.15), align: "left", searchoptions: searchString},
            {name: 'commissionStr', index: 'commissionStr', width: (pageWidth * 0.15), align: "left", searchoptions: searchString},
            {name: 'net2payStr', index: 'net2payStr', width: (pageWidth * 0.15), align: "left", searchoptions: searchString},
            {name: 'salesPromotion', index: 'salesPromotion', width: (pageWidth * 0.15), align: "left", searchoptions: searchString},
            {name: 'url', index: 'url', width: (pageWidth * 0.07), align: "left", searchoptions: searchString}
        ],
        onSelectRow: function (id) {
            selectedCampId = id;
        },
        ondblClickRow: function (rowid) {
            showCampaignChartDialog();
        },
        rowNum: 10,
        rowList: [10, 20, 30],
        pager: '#pager5',
        sortname: 'name',
        viewrecords: true,
        caption: "Facturas",
        height: '230px',
        info: false,
        loadComplete: function (data) {
            $('#pager5_left').find('td').each(function (p, e) {
                $(e).remove();
            });
            $('#list5').find('tr').not('tr:first').find('td').css('text-align', 'center');
            var link = '<img src="http://res.cloudinary.com/titorobe/image/upload/v1492051601/pdf-icon_p18bbl.png" style="cursor: pointer;" onclick="javascript:generatePDF(clientId)"/>';

            $.each($('#list5').find('tr').not('tr:first').find('td:last'), function (i, e) {
                $(e).html(link.replace('clientId', $(e).html()));
            });
        }
    }).navGrid("#pager5");


}
 