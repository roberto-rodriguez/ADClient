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
        <p class="top-bar-center">Resumen</p> 
        <p class="top-bar-right">Next</p>
    </div>

    <table class="form-table">
        <tr>
            <td>
                <b>Remitente</b>
            </td>
            <td>
                <p>Nombre: Roberto Rodriguez</p>  
            </td>
            <td>
                <p>Teléfono: 786-454-0209</p> 
            </td>
        </tr>
        <tr  style="border-bottom: inset 1px #333;padding-bottom:20px">
            <td> 
            </td>
            <td colspan="2">
                <p>Dirección: 9840 Palmetto Club Dr, Miami FL, 30067</p> 
            </td> 
        </tr>

        <tr>
            <td class="border-top"> 
                <b>Destinatario</b>
            </td>
            <td class="border-top">
                <p>Nombre: Phuong Tran</p>  
            </td>
            <td class="border-top">
                <p>Teléfono: 786-454-0209</p> 
            </td>
        </tr>
        <tr>
            <td> 
            </td>
            <td colspan="2">
                <p>Dirección: 9840 Palmetto Club Dr, Miami FL, 30067</p> 
            </td> 
        </tr>
        <tr>
            <td> 
            </td>
            <td colspan="2">
                <p>Cuenta: 1234567890</p> 
            </td> 
        </tr>


        <tr>
            <td class="border-top"> 
                <b>Datos del Envío</b>
            </td>
            <td class="border-top">
                <p>Monto a Enviar: USD 100.0</p>  
            </td>
            <td class="border-top">
                <p>Punto de Pago: BANRURAL</p> 
            </td>
        </tr>
        <tr>
            <td> 
            </td>
            <td>
                <p>Método de Entrega: DEPOSITO</p> 
            </td> 
            <td>
                <p>Tarifa: USD 10.0</p> 
            </td> 
        </tr>
        <tr>
            <td> 
            </td>
            <td>
                <p>Tasa de Cambio: 7.82</p> 
            </td> 
            <td>
                <p>Monto a Entregar en GUATEMALA: GTQ 782.0</p> 
            </td> 
        </tr>
        <tr>
            <td> 
            </td>
            <td>
                <p>Total a Pagar: USD 110.0</p> 
            </td>  
        </tr>
        <tr>
            <td>
                <input type="button" value="Continuar" class="button"/>
            </td> 
        </tr>
    </table>

</div>

<footer>
    Copyright &copy; 2017. All rights reserved. 
</footer>

</body>

</html>
