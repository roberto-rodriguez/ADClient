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

    <table class="form-table" style="padding-bottom:20px">
        <tr>
            <td>
                <p>Nombre:</p><form:input path="remitenteNombre" id="remitenteNombre"/> 
                <form:input path="pais"  id="pais"/> 
            </td>
            <td>
                <p>Teléfono:</p><form:input path="remitenteTelefono" id="remitenteTelefono"/> 
            </td>
            <td>
                <p>Dirección</p><form:input path="remitenteDireccion" id="remitenteDireccion"/> 
            </td>
        </tr>
        <tr>
            <td>
                <p>ZipCode: </p><form:input path="remitenteZipcode" id="remitenteZipcode"/> 
            </td>
            <td> 
                <p>Estado: </p><div id="remitenteEstadoSelect"></div>
                <form:input path="remitenteEstado"  id="remitenteEstado"/> 
            </td>
            <td>
                <p>Ciudad:</p><div id="remitenteCiudadSelect"></div>
                <form:input path="remitenteCiudad" id="remitenteCiudad"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="button" value="Continuar" class="button"/>
            </td> 
        </tr>
    </table>

</form:form>