<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<script type="text/javascript" src="<c:url value="/resources/js/payment/paymentFlow3.js"/>"></script>
<input type="hidden" id="flowExecutionUrl" value="${flowExecutionUrl}"/>

<div class="top-bar">
    <p class="top-bar-left" onclick="javascript:back()">Back</p>
    <p class="top-bar-center">Destinatario</p> 
    <p class="top-bar-right" onclick="javascript:next()">Next</p>
</div>

<br>
<div id="destinatariosSection" style="margin:20px 10% 0px 10%;border-bottom: inset 1px #333;padding-bottom:20px" hidden="true">
    Destinatarios Guardados
    <div id="destinatarioIdSelect"></div> 
</div>

<form:form commandName="command">
    <div style="visibility: hidden">
        <form:input path="telRemite" id="telRemite"/> 
        <form:input path="destinatarioId" id="destinatarioId"/>
        <form:input path="codEstadoDestinatario" id="codEstadoDestinatario"/>
        <form:input path="formaPagoLabel" id="formaPagoLabel"/>
     </div>
    <table class="form-table" style="padding-bottom:20px">
        <tr>
            <td>
                <p>Nombre:</p><form:input path="nomDestinatario" id="nomDestinatario"/> 
             </td>
            <td>
                <p>Teléfono:</p><form:input path="telDestinatario" id="telDestinatario"/> 
            </td>
            <td>
                <p>Dirección</p><form:input path="dirDestinatario" id="dirDestinatario"/> 
            </td>
        </tr>
        <tr>
            <td>
                <p>País </p><form:input path="codPaisDestinatario" id="codPaisDestinatario" disabled="true"/>  
            </td>
            <td>  
                <p>Estado: </p><div id="codEstadoDestinatarioSelect"></div> 
            </td>
            <td>
                <p>Ciudad:</p><form:input path="nomCiudadDestinatario" id="nomCiudadDestinatario"/> 
            </td>
        </tr>
        <tr>
            <td id="numeroCuentaTD">
                <p>Número de Cuenta </p><form:input path="numeroCuenta" id="numeroCuenta"/> 
            </td> 
        </tr>
        <tr>
            <td>
                <input type="button" value="Continuar" class="button" onclick="javascript:next()"/>
            </td> 
        </tr>
    </table>
</form:form>
