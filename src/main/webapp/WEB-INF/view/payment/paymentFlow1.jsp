<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<script type="text/javascript" src="<c:url value="/resources/js/payment/paymentFlow1.js"/>"></script>

<input type="hidden" id="flowExecutionUrl" value="${flowExecutionUrl}"/>

<div class="top-bar">
    <p class="top-bar-left" onclick="javascript:back()"></p>
    <p class="top-bar-center">Tarifas y Punto de Pago</p> 
    <p class="top-bar-right" onclick="javascript:next()">Next</p>
</div>

<form:form commandName="command">
    <div style="visibility: hidden">
        <form:input path="codPaisDestinatario" id="codPaisDestinatario" />
        <form:input path="codCorresponsal" id="codCorresponsal"/>
        <form:input path="formaPago" id="formaPago"/>
        <form:input path="incluyeComision"  id="incluyeComision"/>
        <form:input path="tipoCambio"  id="tipoCambio"/>
        <form:input path="tarifaTagId"  id="tarifaTagId"/>
        <form:input path="formaPagoLabel"  id="formaPagoLabel"/>
        <form:input path="codCorresponsalLabel"  id="codCorresponsalLabel"/>
    </div>
    <table class="form-table" style="border-bottom: inset 1px #333;padding-bottom:20px">
        <tr>
            <td>
                Pais<div id="codPaisDestinatarioSelect"></div> 
            </td>
            <td>
                Corresponsal (Pto de Pago):<div id="codCorresponsalSelect"></div>  
            </td>
            <td>
                <p>Forma de Entrega: </p><div id="formaPagoSelect"></div>  
            </td>
        </tr>
        <tr>
            <td>
                <input type="button" value="Cotizar" class="button" onclick="javascript:cot()" id="cotizar" data-active="false" style="background-color:gray"/> 
            </td>
            <td>
                <p>Monto a Enviar: </p><form:input path="montoEntregar" id="montoEntregar"/> 
            </td>
            <td> 
                Tarifa Incluida: <input id="tarifaIncluidaCheckbox" type="checkbox">
            </td>
        </tr>
    </table>

    <table class="form-table" style="border-spacing: 0px;">
        <tr>
            <td style="width: 270px;">
                <p>Tarifa:</p><div id="tipoCambioSelect"></div>  
            </td>
            <td colspan="2" class="td-border-left">
                <p>Monto Real a Enviar:</p> <form:input path="montoRealAEnviar" id="montoRealAEnviar"/> 
            </td>   
        </tr>
        <tr>
            <td style="width: 270px;">
                <p>Tasa de Cambio: </p><form:input path="tasaDeCambio" id="tasaDeCambio"/> 
            </td>
            <td colspan="2" class="td-border-left">
                <p>Monto Real a Pagar: </p><form:input path="dineroEntregado" id="dineroEntregado"/> 
            </td>   
        </tr>
        <tr>
            <td style="width: 270px;">
                <input type="button" value="Continuar" class="button" onclick="javascript:next()"/> 
            </td>
            <td colspan="2"  class="td-border-left">
                <p>Total a Pagar: </p><form:input path="totalPagar" id="totalPagar"/> 
            </td>   
        </tr>
    </table> 

</form:form>
