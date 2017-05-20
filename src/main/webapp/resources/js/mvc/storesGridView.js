 

function loadStores() {
    console.log('loadStores...');
    selectedCampId = -1;

    var pageWidth = $("#list5").parent().width();

    console.log('pageWidth = ' + pageWidth);
    console.log('column = ' + (pageWidth * 0.25));

    var searchString = {sopt: ['eq', 'ne', 'bw', 'bn', 'ew', 'en', 'cn', 'nc']};
    var searchNumber = {sopt: ['numberEQ', 'numberNE', 'lt', 'le', 'gt', 'ge']};
 
    jQuery("#list5").jqGrid({
//        url:'http://adreporttomcat-env.us-east-1.elasticbeanstalk.com/stores/listStores.htm', 
        url:host + 'stores/listStores.htm', 
        datatype: "json",
        colNames: ['Login Id', 'Nombre', 'Apellido', 'Dirección', 'Telefono','Email','Fecha'],
        colModel: [
            {name: 'loginId', index: 'loginId', width: (pageWidth * 0.10), searchoptions: searchString},
            {name: 'name', index: 'salesPromotion', width: (pageWidth * 0.13), align: "left", searchoptions: searchString},
            {name: 'lastName', index: 'totalToPay', width: (pageWidth * 0.13), align: "left", searchoptions: searchString},
            {name: 'address', index: 'commission', width: (pageWidth * 0.27), align: "left", searchoptions: searchString},
            {name: 'phone', index: 'url', width: (pageWidth * 0.10), align: "left", searchoptions: searchString},
            {name: 'email', index: 'url', width: (pageWidth * 0.12), align: "left", searchoptions: searchString},
            {name: 'creationDateStr', index: 'url', width: (pageWidth * 0.15), align: "left", searchoptions: searchString}
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
        caption: "Stores",
        height: '230px', 
        info: false,
        loadComplete: function (data) {
            $('#pager5_left').find('td').each(function (p, e) {
                $(e).remove();
            });
            $('#list5').find('tr').not('tr:first').find('td').css('text-align','center'); 
        }
    }).navGrid("#pager5");

 
}
 