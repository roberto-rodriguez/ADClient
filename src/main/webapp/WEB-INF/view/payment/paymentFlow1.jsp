<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   

<script type="text/javascript">
    function getData() {
        var data = {};

        $('input[type="text"]').each(function (i, e) {
            data[e.id] = $(e).val();
        });

        data['tarifaIncluida'] = $('#tarifaIncluida').is(":checked");

        return data;
    }
 
    $(document).ready(function () { 
        createCombo('paisSelect', '/ADClient/config/paises');
        createCombo('corresponsalSelect');
        createCombo('formaDeEntregaSelect');

        $("#paisSelect").on('change', function () { 
            var val = $(this).val();
            createCombo('corresponsalSelect', val && '/ADClient/config/corresponsales/' + val);
              
        });

        $("#corresponsalSelect").on('change', function () {
             var val = $(this).val();
             if(!val){
                 $('#formaDeEntrega').val('');
                 createCombo('formaDeEntregaSelect'); 
             }else{
                createCombo('formaDeEntregaSelect', val && '/ADClient/config/formasEntrega/' + $('#paisSelect').val() + '/' + val);  
             } 
        });

        $("#paisSelect,#corresponsalSelect,#formaDeEntregaSelect").on('change', function () { 
            $('#' + this.id.split('Select')[0]).val($(this).val());
        });
 
    });

    function createCombo(id, url) {
        var source = url ?
                {
                    datatype: "json",
                    datafields: [
                        {name: 'nombre'},
                        {name: 'codigo'}
                    ],
                    url: url,
                    async: true
                } : {};

        var dataAdapter = new $.jqx.dataAdapter(source, {
            loadComplete: function (values) { 
                var previousValue = $('#' + id.split('Select')[0]).val(); 
                if(previousValue && $.grep(values, function(elem){return elem.codigo == previousValue}).length > 0){
                    jQuery('#' + id).jqxComboBox('val', previousValue); 
                }else{
                    var newVal = values.length == 1 ? values[0].codigo : null; 
                    jQuery('#' + id).jqxComboBox('val', newVal);
                    jQuery('#' + id).change(); 
                }
                   
            }
        });

        $('#' + id).jqxComboBox(
                {
                    source: dataAdapter,
                    width: 173,
                    height: 25,
                    // selectedIndex: 0,
                    displayMember: 'nombre',
                    valueMember: 'codigo',
                    autoDropDownHeight: true
                }); 
    }


</script>

<input type="hidden" id="flowExecutionUrl" value="${flowExecutionUrl}"/>

<div class="top-bar">
    <p class="top-bar-left" onclick="javascript:back()">Back</p>
    <p class="top-bar-center">Tarifas y Punto de Pago</p> 
    <p class="top-bar-right" onclick="javascript:next()">Next</p>
</div>

<form:form commandName="command">

    <table class="form-table" style="border-bottom: inset 1px #333;padding-bottom:20px">
        <tr>
            <td>
                Pais<div id="paisSelect"></div>
                <form:input path="pais" id="pais"/> 
            </td>
            <td>
                Corresponsal (Pto de Pago):<div id="corresponsalSelect"></div> 
                <form:input path="corresponsal" id="corresponsal"/>   
            </td>
            <td>
                <p>Forma de Entrega: </p><div id="formaDeEntregaSelect"></div> 
                <form:input path="formaDeEntrega" id="formaDeEntrega"/>  
            </td>
        </tr>
        <tr>
            <td>
                <input type="button" value="Cotizar" class="button"/> 
            </td>
            <td>
                <p>Monto a Enviar: </p><form:input path="montoAEnviar" />
                <!--<input id="montoAEnviar" type="text" value="${command.montoAEnviar}">--> 
            </td>
            <td>
                Tarifa Incluida:<form:checkbox path="tarifaIncluida" />
                <!--<input id="tarifaIncluida" type="checkbox"  value="${command.tarifaIncluida}">-->
            </td>
        </tr>
    </table>

    <table class="form-table" style="border-spacing: 0px;">
        <tr>
            <td style="width: 270px;">
                <p>Tarifa: </p><form:input path="tarifa" />
                <!--<input id="tarifa"  type="text"  value="${command.tarifa}">--> 
            </td>
            <td colspan="2" class="td-border-left">
                <p>Monto Real a Enviar:</p> <form:input path="montoRealAEnviar" />
                <!--<input id="montoRealAEnviar" type="text"  value="${command.montoRealAEnviar}">--> 
            </td>   
        </tr>
        <tr>
            <td style="width: 270px;">
                <p>Tasa de Cambio: </p><form:input path="tasaDeCambio" />
                <!--<input id="tasaDeCambio" type="text"  value="${command.tasaDeCambio}">--> 
            </td>
            <td colspan="2" class="td-border-left">
                <p>Monto Real a Pagar: </p><form:input path="montoRealAPagar" />
                <!--<input id="montoRealAPagar" type="text"  value="${command.montoRealAPagar}">--> 
            </td>   
        </tr>
        <tr>
            <td style="width: 270px;">
                <input type="button" value="Continuar" class="button"/> 
            </td>
            <td colspan="2"  class="td-border-left">
                <p>Total a Pagar: </p><form:input path="totalAPagar" />
                <!--<input id="totalAPagar" type="text"  value="${command.totalAPagar}">--> 
            </td>   
        </tr>
    </table> 

</form:form>
