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
    <form:input path="destinatarioId" id="destinatarioId"/>
</div>

<form:form commandName="command">
    <table class="form-table" style="padding-bottom:20px">
        <tr>
            <td>
                <p>Nombre:</p><form:input path="destinatarioNombre" />
                <form:input path="remitenteTelefono" id="remitenteTelefono"/>
                 
            </td>
            <td>
                <p>Teléfono:</p><form:input path="destinatarioTelefono" />
                <form:input path="destinatarioId" id="destinatarioId"/>
            </td>
            <td>
                <p>Dirección</p><form:input path="destinatarioDirecion" />
                <form:input path="destinatarioId" id="destinatarioId"/>
            </td>
        </tr>
        <tr>
            <td>
                <p>País </p><form:input path="pais" id="pais" disabled="true"/> 
            </td>
            <td>  
                <p>Estado: </p><div id="destinatarioEstadoSelect"></div> 
                <form:input path="destinatarioEstado" id="destinatarioEstado"/> 
            </td>
            <td>
                <p>Ciudad:</p><form:input path="destinatarioCiudad" /> 
            </td>
        </tr>
        <tr>
            <td>
                <p>Número de Cuenta </p><form:input path="numeroDeCuenta" /> 
            </td> 
        </tr>
        <tr>
            <td>
                <input type="button" value="Continuar" class="button"/>
            </td> 
        </tr>
    </table>
</form:form>
