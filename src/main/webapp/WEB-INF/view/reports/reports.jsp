<%-- 
    Document   : reports
    Created on : Mar 19, 2018, 9:10:38 PM
    Author     : rrodriguez
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="<c:url value="/resources/js/reports.js"/>"></script>

<div>
    <div  class="search-form">
        <table>
            <tr style="background-color: #f5f5f5;">
                <td  align="center">
                    <p class="p-search">Reference #:</p> <input type="text"/>
                </td>
                <td align="center">
                    <p class="p-search">Desde:</p> <input type="text"/>
                </td>
                <td align="center">
                    <p class="p-search">Hasta:</p> <input type="text"/>
                </td>
            </tr>
            <tr>
                <td> 
                </td>
                <td align="center">
                    <p class="p-search">Remitente:</p> <input type="text"/>
                </td>
                <td align="center">
                    <p class="p-search">Destinatario:</p> <input type="text"/>
                </td>
            </tr>
        </table>
    </div>

    <div id="pagination" style="margin:15px">
        <div class="pg-column">
            <input type="button" value="<" class="pg-buton">
            <input type="text" value="1" class="pg-input" />
            <input type="button" value=">" class="pg-buton" style="margin-left: 0px;">
        </div>
        <div class="pg-column">
            <div class="centered">
                <input type="button" value="Search" class="pg-buton" style="width: 80px; height: 26px;">
            </div>
        </div>
        <div class="pg-column">
            <div class="toRight">
                <p style=" display: inline-block">Rows per Page:</p>
                <input type="text" value="5" class="pg-input" />
            </div> 
        </div>
    </div>

    <div id="results" style="margin:15px; border-color: #212529; border-width:1px; border-style: solid;">

    </div>
</div>
