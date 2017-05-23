<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

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
                <p>Nombre:</p><form:input path="remitenteNombre" />
                <!--<p>Nombre:</p> <input type="text" value="${command.remitenteNombre}">-->  
            </td>
            <td>
                <p>Teléfono:</p><form:input path="remitenteTelefono" />
                <!--<input type="text" value="${cmmand.remitenteTelefono}">--> 
            </td>
            <td>
                <p>Dirección</p><form:input path="remitenteDirecion" />
                <!--<input type="text" value="${cmmand.remitenteDirecion}">--> 
            </td>
        </tr>
        <tr>
            <td>
                <p>ZipCode: </p><form:input path="remitenteZipcode" />
                <!--<input type="text" value="${cmmand.remitenteZipcode}">--> 
            </td>
            <td> 
                <p>Estado: </p><form:input path="remitenteEstado" />
                <!--<input type="text" value="${cmmand.remitenteEstado}">--> 
            </td>
            <td>
                <p>Ciudad:</p><form:input path="remitenteCiudad" />
                <!--<input type="text" value="${cmmand.remitenteCiudad}">--> 
            </td>
        </tr>
        <tr>
            <td>
                <input type="button" value="Continuar" class="button"/>
            </td> 
        </tr>
    </table>

</form:form>