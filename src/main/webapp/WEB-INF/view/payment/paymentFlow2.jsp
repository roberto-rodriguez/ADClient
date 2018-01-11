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
        <%--<form:input path="codPaisDestinatario"  id="pais"/>--%> 
        <form:input path="codEstadoRemite"  id="codEstadoRemite"/>
        <form:input path="nomCiudadRemite" id="nomCiudadRemite"/>
    </div>

    <table class="form-table" style="padding-bottom:20px">
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
        <tr>
            <td>
                <input type="button" value="Continuar" class="button" onclick="javascript:next()"/>
            </td> 
        </tr>
    </table>

</form:form>