<%-- 
    Document   : reports
    Created on : Mar 19, 2018, 9:10:38 PM
    Author     : rrodriguez
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="<c:url value="/resources/js/reports.js"/>"></script>

<div> 
    <div class="topBar toRight">
        <a class="pg-buton" style="background-color: transparent; margin-right: 15px;"
            onclick="javascript:toogleSearchForm(true)">
            <img src="<c:url value="/resources/images/icon/filter.png" />" style="height: 30px;">
        </a>
<!--        <a href="" class="topLink">
            <img src="<c:url value="/resources/images/icon/pdf.png" />" >
        </a>-->
        <a class="topLink" onclick="javascript:doReport('excel')">
            <img src="<c:url value="/resources/images/icon/xls.png" />">
        </a>
    </div> 
    
    <div class="search-form">
        <input type="button" value="X" class="closeBtn" onclick="javascript:toogleSearchForm()"/>

        <table>
            <tr>
                <td  align="center">
                    <p class="p-search">Reference #:</p> <input type="text" id="reference"/>
                </td>
                <td align="center">
                    <p class="p-search">Desde:</p> <input id="fechaDel" type="text"/>
                </td>
                <td align="center">
                    <p class="p-search">Hasta:</p> <input id="fechaAl" type="text"/>
                </td> 
            </tr>
            <tr>
                <td> 
                </td>
                <td align="center">
                    <p class="p-search">Remitente:</p> <input id="nombreR" type="text"/>
                </td>
                <td align="center">
                    <p class="p-search">Destinatario:</p> <input id="nombreD" type="text"/>
                </td> 
            </tr>
        </table>

    </div>

    <div id="pagination" style="margin:15px">
        <div class="pg-column">
            <input type="button" value="<" class="pg-buton" onclick="javascript:doSearch(-1)">
            <input type="text" id="page" value="1" class="pg-input" />
            <input type="button" value=">" class="pg-buton" style="margin-left: 0px;"  onclick="javascript:doSearch(1)">
        </div>
        <div class="pg-column">
            <div class="centered">
                <input type="button" value="Buscar" class="pg-buton" style="width: 80px; height: 26px;" onclick="javascript:doSearch()">
            </div>
        </div>
        <div class="pg-column">
            <div class="toRight">
                <p style=" display: inline-block">Rows per Page:</p>
                <input type="text" id="limit" value="5" class="pg-input" />
            </div> 
        </div>
    </div>

    <div id="results" style="margin:15px;">

    </div>
</div>
