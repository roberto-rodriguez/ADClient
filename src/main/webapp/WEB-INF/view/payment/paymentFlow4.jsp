 <input type="hidden" id="flowExecutionUrl" value="${flowExecutionUrl}"/>
     
     <div class="top-bar">
        <p class="top-bar-left" onclick="javascript:back()">Back</p>
        <p class="top-bar-center">Resumen</p> 
        <p class="top-bar-right" onclick="javascript:next()">Next</p>
    </div>

    <table class="form-table">
        <tr>
            <td>
                <b>Remitente</b>
            </td>
            <td>
                <p>Nombre: ${command.nomRemite}</p>  
            </td>
            <td>
                <p>Teléfono: ${command.telRemite}</p> 
            </td>
        </tr>
        <tr  style="border-bottom: inset 1px #333;padding-bottom:20px">
            <td> 
            </td>
            <td colspan="2">
                <p>Dirección: ${command.dirRemite}</p> 
            </td> 
        </tr>

        <tr>
            <td class="border-top"> 
                <b>Destinatario</b>
            </td>
            <td class="border-top">
                <p>Nombre: ${command.nomDestinatario}</p>  
            </td>
            <td class="border-top">
                <p>Teléfono: ${command.telDestinatario}</p> 
            </td>
        </tr>
        <tr>
            <td> 
            </td>
            <td colspan="2">
                <p>Dirección: ${command.dirDestinatario}</p> 
            </td> 
        </tr>
        <tr>
            <td> 
            </td>
            <td colspan="2">
                <p>Cuenta: ${command.numeroCuenta}</p> 
            </td> 
        </tr>


        <tr>
            <td class="border-top"> 
                <b>Datos del Envío</b>
            </td>
            <td class="border-top">
                <p>Monto a Enviar: USD ${command.montoEntregar}</p>  
            </td>
            <td class="border-top">
                <p>Punto de Pago: ${command.codCorresponsalLabel}</p> 
            </td>
        </tr>
        <tr>
            <td> 
            </td>
            <td>
                <p>Método de Entrega: ${command.formaPagoLabel}</p> 
            </td> 
            <td>
                <p>Tarifa: USD ${command.tipoCambio}</p> 
            </td> 
        </tr>
        <tr>
            <td> 
            </td>
            <td>
                <p>Tasa de Cambio: ${command.tasaDeCambio}</p> 
            </td> 
            <td>
                <p>Monto a Entregar en ${command.codPaisDestinatario}: ${command.moneda} ${command.dineroEntregado}</p> 
            </td> 
        </tr>
        <tr>
            <td> 
            </td>
            <td>
                <p>Total a Pagar: USD ${command.totalPagar}</p> 
            </td>  
        </tr>
        <tr>
            <td>
                <input type="button" value="Continuar" class="button" onclick="javascript:next()"/>
            </td> 
        </tr>
    </table>
 