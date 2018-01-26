<input type="hidden" id="flowExecutionUrl" value="${flowExecutionUrl}"/>

<div class="top-bar"> 
    <p class="top-bar-center" style="width:100%">Transacción Enviada</p>  
</div> 

<table class="resumen-table">
    <tr>
        <td>
            <p style="font-size: 24px; color: black;">Transacción Pendiente</p>
        </td> 
    </tr> 
    <tr>
        <td>
            <p style="font-size: 20px">Por favor llame a Servicio al Cliente y use la referencia: (001T32)</p>
        </td> 
    </tr> 
    <tr>
        <td>
            <p style="font-size: 20px">Número de Envio:</p>
            <p style="font-size:36px;color: red;">001T32</p>
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