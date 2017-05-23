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
                <p>Nombre: ${command.remitenteNombre}</p>  
            </td>
            <td>
                <p>Teléfono: ${command.remitenteTelefono}</p> 
            </td>
        </tr>
        <tr  style="border-bottom: inset 1px #333;padding-bottom:20px">
            <td> 
            </td>
            <td colspan="2">
                <p>Dirección: ${command.remitenteDirecion}</p> 
            </td> 
        </tr>

        <tr>
            <td class="border-top"> 
                <b>Destinatario</b>
            </td>
            <td class="border-top">
                <p>Nombre: ${command.destinatarioNombre}</p>  
            </td>
            <td class="border-top">
                <p>Teléfono: ${command.destinatarioTelefono}</p> 
            </td>
        </tr>
        <tr>
            <td> 
            </td>
            <td colspan="2">
                <p>Dirección: ${command.destinatarioDirecion}</p> 
            </td> 
        </tr>
        <tr>
            <td> 
            </td>
            <td colspan="2">
                <p>Cuenta: ${command.numeroDeCuenta}</p> 
            </td> 
        </tr>


        <tr>
            <td class="border-top"> 
                <b>Datos del Envío</b>
            </td>
            <td class="border-top">
                <p>Monto a Enviar: USD ${command.montoAEnviar}</p>  
            </td>
            <td class="border-top">
                <p>Punto de Pago: ${command.corresponsal}</p> 
            </td>
        </tr>
        <tr>
            <td> 
            </td>
            <td>
                <p>Método de Entrega: ${command.formaDeEntrega}</p> 
            </td> 
            <td>
                <p>Tarifa: USD ${command.tarifa}</p> 
            </td> 
        </tr>
        <tr>
            <td> 
            </td>
            <td>
                <p>Tasa de Cambio: ${command.tasaDeCambio}</p> 
            </td> 
            <td>
                <p>Monto a Entregar en ${command.pais}: GTQ ${command.montoRealAPagar}</p> 
            </td> 
        </tr>
        <tr>
            <td> 
            </td>
            <td>
                <p>Total a Pagar: USD ${command.totalAPagar}</p> 
            </td>  
        </tr>
        <tr>
            <td>
                <input type="button" value="Continuar" class="button"/>
            </td> 
        </tr>
    </table>
 