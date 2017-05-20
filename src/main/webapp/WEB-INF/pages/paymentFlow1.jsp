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
        <p class="top-bar-center">Tarifas y Punto de Pago</p> 
        <p class="top-bar-right">Next</p>
    </div>

    <table class="form-table" style="border-bottom: inset 1px #333;padding-bottom:20px">
        <tr>
            <td>
                <p>País:</p><input type="text"> 
            </td>
            <td>
                <p>Corresponsal (Pto de Pago):</p> <input type="text"> 
            </td>
            <td>
                <p>Forma de Entrega: </p><input type="text"> 
            </td>
        </tr>
        <tr>
            <td>
                <input type="button" value="Cotizar" class="button"/> 
            </td>
            <td>
                <p>Monto a Enviar: </p><input type="text"> 
            </td>
            <td>
                Tarifa Incluida: <input type="checkbox">
            </td>
        </tr>
    </table>

    <table class="form-table" style="border-spacing: 0px;">
        <tr>
            <td style="width: 270px;">
                <p>Tarifa: </p><input type="text"> 
            </td>
            <td colspan="2" class="td-border-left">
                <p>Monto Real a Enviar:</p> <input type="text"> 
            </td>   
        </tr>
        <tr>
            <td style="width: 270px;">
                <p>Monto Real a Pagar: </p><input type="text"> 
            </td>
            <td colspan="2" class="td-border-left">
                <p>Monto Real a Enviar: </p><input type="text"> 
            </td>   
        </tr>
        <tr>
            <td style="width: 270px;">
                <input type="button" value="Continuar" class="button"/> 
            </td>
            <td colspan="2"  class="td-border-left">
                <p>Total a Pagar: </p><input type="text"> 
            </td>   
        </tr>
    </table> 
</div>
 
<footer>
    Copyright &copy; 2017. All rights reserved. 
</footer>

</body>

</html>
