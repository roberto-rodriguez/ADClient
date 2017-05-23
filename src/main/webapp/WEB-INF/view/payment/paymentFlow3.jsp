<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<input type="hidden" id="flowExecutionUrl" value="${flowExecutionUrl}"/>

<div class="top-bar">
    <p class="top-bar-left" onclick="javascript:back()">Back</p>
    <p class="top-bar-center">Destinatario</p> 
    <p class="top-bar-right" onclick="javascript:next()">Next</p>
</div>

<form:form commandName="command">
    <table class="form-table" style="padding-bottom:20px">
        <tr>
            <td>
                <p>Nombre:</p><form:input path="destinatarioNombre" />
                <!--<p>Nombre:</p> <input type="text" value="${command.destinatarioNombre}">--> 
            </td>
            <td>
                <p>Teléfono:</p><form:input path="destinatarioTelefono" />
<!--                <input type="text" value="${command.destinatarioTelefono}"> -->
            </td>
            <td>
                <p>Dirección</p><form:input path="destinatarioDirecion" />
                <!--<input type="text" value="${command.destinatarioDirecion}">--> 
            </td>
        </tr>
        <tr>
            <td>
                <p>País </p><form:input path="destinatarioPais" />
                <!--<input type="text" value="${command.destinatarioPais}">-->
            </td>
            <td>  
                <p>Estado: </p><form:input path="destinatarioEstado" />
                <!--<input type="text" value="${command.destinatarioEstado}">--> 
            </td>
            <td>
                <p>Ciudad:</p><form:input path="destinatarioCiudad" />
                <!--<input type="text" value="${command.destinatarioCiudad}">--> 
            </td>
        </tr>
        <tr>
            <td>
                <p>Número de Cuenta </p><form:input path="numeroDeCuenta" />
                <!--<input type="text" value="${command.numeroDeCuenta}">-->
            </td> 
        </tr>
        <tr>
            <td>
                <input type="button" value="Continuar" class="button"/>
            </td> 
        </tr>
    </table>
</form:form>
