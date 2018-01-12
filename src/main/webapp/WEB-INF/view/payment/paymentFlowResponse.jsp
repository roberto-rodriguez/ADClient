<input type="hidden" id="flowExecutionUrl" value="${flowExecutionUrl}"/> 

<div class="top-bar"> 
    <p class="top-bar-center" style="width:100%">Transacción Enviada</p>  
</div> 

<table class="resumen-table">
    <tr>
        <td>
            <p style="font-size: 24px; color: black;">Response received from Server:</p>
        </td> 
    </tr> 
    <tr>
        <td>
            <p>${resp}</p>
        </td> 
    </tr>  
    <tr>
        <td>
            <input type="button" value="Otra Transacción"  onclick="javascript:next()" class="button"/> 
        </td> 
    </tr>
</table> 