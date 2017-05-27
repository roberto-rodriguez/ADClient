<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<script type="text/javascript" src="<c:url value="/resources/js/payment/paymentFlow1.js"/>"></script>
  
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
                <form:input path="pais" id="pais" /> 
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
                <input type="button" value="Cotizar" class="button" onclick="javascript:cot()" id="cotizar" data-active="false" style="background-color:gray"/> 
            </td>
            <td>
                <p>Monto a Enviar: </p><form:input path="montoAEnviar" id="montoAEnviar" value="100"/>
                <!--<input id="montoAEnviar" type="text" value="${command.montoAEnviar}">--> 
            </td>
            <td>
                <form:input path="tarifaIncluida"  id="tarifaIncluida"/>
                Tarifa Incluida: <input id="tarifaIncluidaCheckbox" type="checkbox">
            </td>
        </tr>
    </table>

    <table class="form-table" style="border-spacing: 0px;">
        <tr>
            <td style="width: 270px;">
                <p>Tarifa:</p><div id="tarifaSelect"></div> 
                <form:input path="tarifa"  id="tarifa"/>
                <!--<input id="tarifa"  type="text"  value="${command.tarifa}">--> 
            </td>
            <td colspan="2" class="td-border-left">
                <p>Monto Real a Enviar:</p> <form:input path="montoRealAEnviar" id="montoRealAEnviar"/>
                <!--<input id="montoRealAEnviar" type="text"  value="${command.montoRealAEnviar}">--> 
            </td>   
        </tr>
        <tr>
            <td style="width: 270px;">
                <p>Tasa de Cambio: </p><form:input path="tasaDeCambio" id="tasaDeCambio"/>
                <!--<input id="tasaDeCambio" type="text"  value="${command.tasaDeCambio}">--> 
            </td>
            <td colspan="2" class="td-border-left">
                <p>Monto Real a Pagar: </p><form:input path="montoRealAPagar" id="montoRealAPagar"/>
                <!--<input id="montoRealAPagar" type="text"  value="${command.montoRealAPagar}">--> 
            </td>   
        </tr>
        <tr>
            <td style="width: 270px;">
                <input type="button" value="Continuar" class="button"/> 
            </td>
            <td colspan="2"  class="td-border-left">
                <p>Total a Pagar: </p><form:input path="totalAPagar" id="totalAPagar"/>
                <!--<input id="totalAPagar" type="text"  value="${command.totalAPagar}">--> 
            </td>   
        </tr>
    </table> 

</form:form>
