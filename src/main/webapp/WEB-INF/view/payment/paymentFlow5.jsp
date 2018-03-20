
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<input type="hidden" id="flowExecutionUrl" value="${flowExecutionUrl}"/>

<div class="top-bar"> 
    <p class="top-bar-center" style="width:100%">Transacción Enviada</p>  
</div> 

<table class="resumen-table">
    <c:choose>
        <c:when test="${transferencia.success}">
             <tr>
                <td>
                    <p style="font-size: 24px; color: green;">Satisfactoriamente</p>
                </td> 
            </tr> 
             <tr>
                <td>
                    <p style="font-size: 20px">Clave de Pago:</p>
                    <p style="font-size:30px;">${transferencia.clavePago}</p>
                </td> 
            </tr>
        </c:when>    
        <c:otherwise>
            <tr>
                <td>
                    <p style="font-size: 24px; color: red;">Transacción Pendiente</p>
                </td> 
            </tr> 
            <tr>
                <td>
                    <p style="font-size: 20px">Por favor llame a Servicio al Cliente y use la referencia: (${transferencia.codEnvio})</p>
                </td> 
            </tr>
        </c:otherwise>
    </c:choose>
    
    <tr>
        <td>
            <p style="font-size: 20px">Número de Envio:</p>
            <p style="font-size:30px">${transferencia.codEnvio}</p>
        </td> 
    </tr>  
    <tr>
        <td>
            <input type="button" value="Imprimir Recibo"  onclick="javascript:generateReceipt()" class="button" style="background-color: #E8BE01; color:#333"/> 
        </td> 
    </tr>
    <tr>
        <td>
            <input type="button" value="Otra Transacción"  onclick="javascript:next()" class="button"/> 
        </td> 
    </tr>
</table> 