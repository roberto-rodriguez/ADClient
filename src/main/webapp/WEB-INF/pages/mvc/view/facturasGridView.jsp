<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/includes.jsp" %>
<script type="text/javascript" src="<c:url value="/resources/js/mvc/facturasGridView.js" />"></script> 

<div id="mainContent" class="mainContent radius">

    <script type="text/javascript">
        $(document).ready(function () {
            $(function () {
                $('#fromField').datepicker();
                $('#toField').datepicker();
                loadFacturas();
            });
        });
        
        function doSearch(){
          $('#list5').trigger( 'reloadGrid' );
        }
    </script>

    <div>
        <div style="height: 30px; vertical-align: middle;" class="bodySubject">
            <p class="mhl bodySubject" style="margin-top: 30px; alignment-adjust: central; text-align: center;">Facturas</p>
        </div>
    </div>

    <div>
        <div style="margin-left: 5%; margin-right: 5%;">
            <table style="width:100%">
                <tr>
                    <td>
                        <input  class="login-boton" type="button" value="Search" style="height:30px;width: 100px;" onclick="javascript:doSearch()"/>  
                    </td>
                    <td>
                        <p>Client Id</p>
                    </td>
                    <td>
                        <input type="text" id="clientIdField"/>
                    </td>
                    <td>
                        <p>From:</p>
                    </td>
                    <td>
                        <input type="text" id="fromField"/>
                    </td>
                    <td>
                        <p>To:</p>
                    </td>
                    <td>
                        <input type="text" id="toField"/>
                    </td>
                    <td>
                        <img src="http://res.cloudinary.com/titorobe/image/upload/v1492051601/pdf-icon_p18bbl.png" style="cursor: pointer;" onclick="javascript:generateResumenPDF()"/>
                    </td>
                </tr>
            </table>
        </div>
        <div style="clear: both"></div>

        <div style="margin-left:5%; margin-right:5%;width:90%">
            <table id="list5" style="width:100%"></table>
            <div id="pager5"></div>
            <br/>

            <c:if test="${total != null}">
                Total registers loaded: <c:out value="${total}"/>
            </c:if>
        </div>

        <br>
        <br>
    </div>

</div>
<!--<div id="fb-root"></div>-->
<footer class="radius blueBorder pFont" style="color: #FFF !important; font-size: 13px!important;">
    Copyright &copy; 2017. All rights reserved.

</footer>

</body>

</html>

