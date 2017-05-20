 <input type="hidden" id="flowExecutionUrl" value="${flowExecutionUrl}"/>
     
     <div class="top-bar">
        <p class="top-bar-left" onclick="javascript:back()">Back</p>
        <p class="top-bar-center">Destinatario</p> 
        <p class="top-bar-right" onclick="javascript:next()">Next</p>
    </div>

    <table class="form-table" style="padding-bottom:20px">
        <tr>
            <td>
                <p>Nombre:</p> <input type="text"> 
            </td>
            <td>
                <p>Teléfono:</p><input type="text"> 
            </td>
            <td>
                <p>Dirección</p><input type="text"> 
            </td>
        </tr>
        <tr>
            <td>
                <p>País </p><input type="text">
            </td>
            <td>  
                <p>Estado: </p><input type="text"> 
            </td>
            <td>
                <p>Ciudad:</p><input type="text"> 
            </td>
        </tr>
        <tr>
            <td>
                <p>Número de Cuenta </p><input type="text">
            </td> 
        </tr>
        <tr>
            <td>
                <input type="button" value="Continuar" class="button"/>
            </td> 
        </tr>
    </table>

 