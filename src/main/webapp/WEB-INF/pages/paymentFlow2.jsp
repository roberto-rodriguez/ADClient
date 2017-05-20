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
        <p class="top-bar-center">Remitente</p> 
        <p class="top-bar-right">Next</p>
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
                <p>ZipCode: </p><input type="text"> 
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
