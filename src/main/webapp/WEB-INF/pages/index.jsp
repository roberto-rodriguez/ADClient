<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html"  pageEncoding="UTF-8"%> 
<%@ include file="/WEB-INF/pages/includes.jsp" %>
<!DOCTYPE html>

<script type="text/javascript">
    $(document).ready(function () {
        //  alert('start');
    });

</script>
<div id="mainContent" class="mainContent">
    <div class="top-bar">
        <p class="top-bar-left">Back</p>
        <p class="top-bar-center">Transacción Enviada</p> 
        <p class="top-bar-right">Next</p>
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
                <input type="button" value="Otra Transacción" class="button"/> 
            </td> 
        </tr>
    </table>
   <br>
   <br>
</div>

<footer>
    Copyright &copy; 2017. All rights reserved. 
</footer>

</body>

</html>
