

function generatePDF(clientId) {
    console.log('generatePDF -> clientId = ' + clientId); 
    window.open(host + "facturas/facturasReport/" + clientId, 'window',  'HEIGHT=660,resizable=yes,scrollbars=yes,WIDTH=710,target="blank_"');
//    window.open("/ADReport/facturas/facturasReport/" + clientId, 'window',  'HEIGHT=660,resizable=yes,scrollbars=yes,WIDTH=710,target="blank_"');
 }
 
 function generateResumenPDF(clientId) {
    console.log('generatePDF -> clientId = ' + clientId); 
    window.open(host + "facturas/resumenReport?clientId=" + $('#clientIdField').val() + "&from=" + $('#fromField').val() + "&to=" + $('#toField').val(), 'window',  'HEIGHT=660,resizable=yes,scrollbars=yes,WIDTH=710,target="blank_"'); 
 }
 

function openAllPDF() {
    console.log('openAllPDF');  
    var list = $('#list5').find('tr').not('tr:first').find('td:last').find('img');

    rec(list,0);
}

function rec(list, i){
    if(i === list.length)return;
    
    $(list[i]).click();
    
    setTimeout(function () {console.log('i =  ' + i);  rec(list, ++i); }, 2000);
}
