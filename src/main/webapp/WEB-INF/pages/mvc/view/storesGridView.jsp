<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/includes.jsp" %>

<div id="mainContent" class="mainContent radius">

    <script type="text/javascript">
        $(document).ready(function () {
            $(function () {
                loadStores(); 
            });
        });

    </script>

    <div>
        <div style="height: 30px; vertical-align: middle;" class="bodySubject">
            <p class="mhl bodySubject" style="margin-top: 30px; alignment-adjust: central; text-align: center;">Stores</p>
        </div>
    </div> 
    <br>

    <div>
        <div style="margin:0px;">
            <!--<img src="http://res.cloudinary.com/titorobe/image/upload/v1492051601/pdf-icon_p18bbl.png" style="float:right; cursor: pointer;" onclick="openAllPDF()"/>--> 
            <!--<img src="/BlitzTracker/resources/images/icon/pdf-icon.png" style="float:right; cursor: pointer;" onclick="openAllPDF()"/>--> 
        </div>
        <div style="clear: both"></div>

        <div style="margin-left:5%; margin-right:5%;">
            <table id="list5" style="width: 80%"></table>
            <div id="pager5"></div>
            <br/><!--
            <c:if test="${total != null}">
                Total registers loaded: <c:out value="${total}"/>
            </c:if>
                 -->
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

