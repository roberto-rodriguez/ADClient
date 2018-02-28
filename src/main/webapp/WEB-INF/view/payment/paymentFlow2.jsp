<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<script type="text/javascript" src="<c:url value="/resources/js/payment/paymentFlow2.js"/>"></script>

<input type="hidden" id="flowExecutionUrl" value="${flowExecutionUrl}"/>

<div class="top-bar">
    <p class="top-bar-left" onclick="javascript:back()">Back</p>
    <p class="top-bar-center">Remitente</p> 
    <p class="top-bar-right" onclick="javascript:next()">Next</p>
</div>

<form:form commandName="command">
    <div style="visibility: hidden">
        <form:input path="codPaisDestinatario"  id="pais"/> 
        <form:input path="codEstadoRemite"  id="codEstadoRemite"/>
        <form:input path="nomCiudadRemite" id="nomCiudadRemite"/>
        <form:input path="remitentePresente" id="remitentePresente"/> 
        <form:input path="tipoId" id="tipoId"/> 
        <form:input path="tipoIdIndex" id="tipoIdIndex"/> 
        <form:input path="relacionDestinatario" id="relacionDestinatario"/> 
        <form:input path="relacionDestinatarioIndex" id="relacionDestinatarioIndex"/> 
        <form:input path="codEstadoRemiteLabel"  id="codEstadoRemiteLabel"/>
    </div>

    <table class="form-table" >
        <tr>
            <td>
                <p>Nombre:</p><form:input path="nomRemite" id="nomRemite"/>  
            </td>
            <td>
                <p>Teléfono:</p><form:input path="telRemite" id="telRemite"/> 
            </td>
            <td>
                <p>Dirección</p><form:input path="dirRemite" id="dirRemite"/> 
            </td>
        </tr>
        <tr>
            <td>
                <p>ZipCode: </p><form:input path="dirPostalRemite" id="dirPostalRemite"/> 
            </td>
            <td> 
                <p>Estado: </p><div id="codEstadoRemiteSelect"></div> 
            </td>
            <td>
                <p>Ciudad:</p><div id="nomCiudadRemiteSelect"></div> 
            </td>
        </tr> 
    </table>
            
    <table class="form-table" id="cubaForm"  style="border-top: inset 1px #333;">
         <tr> 
             <td colspan="3">
                <p style="color:grey">Datos adicionales para envios a Cuba</p>  
            </td>
        </tr>
        <tr>
            <td>
                <p>Apellido Materno:</p><form:input path="apellidoMaterno" id="apellidoMaterno"/>  
            </td>
            <td>
                <p>Fecha de Nacimiento:</p><form:input path="fechaNacRemite" id="fechaNacRemite"/> 
            </td>
            <td>
                <p>Tipo de Identificación: </p><div id="tipoIdSelect"></div>  
            </td>
        </tr>
        <tr>
            <td>
                <p>Número de Identificación</p><form:input path="numId" id="numId"/> 
            </td> 
            <td> 
                <p>Fecha de Expiración</p><form:input path="fechaExpiracion" id="fechaExpiracion"/> 
            </td>
            <td> 
                <p>Relación con el destinatario </p><div id="relacionDestinatarioSelect"></div>
            </td>
        </tr> 
         <tr> 
             <td colspan="3"> 
                <p>Remitente está presente?</p><input id="remitentePresenteCheckbox" type="checkbox">
            </td>
        </tr> 
    </table>
            
     <table class="form-table" style="padding-bottom:20px"> 
        <tr>
            <td>
                <input type="button" value="Continuar" class="button" onclick="javascript:next()"/>
            </td> 
        </tr>
    </table> 
</form:form>