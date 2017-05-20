<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />"/> 
        <link rel="stylesheet" href="<c:url value="/resources/css/general.css" />"/>  
        <link rel="stylesheet" href="<c:url value="/resources/css/ui.jqgrid.css" />"/>
        <link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui-custom.css" />"/>

        <script type="text/javascript" src="<c:url value="/resources/js/lib/jquery-2.1.1.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/lib/jquery-ui.js" />"></script> 
        <script type="text/javascript" src="<c:url value="/resources/js/lib/jquery.alerts.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/lib/jquery.jqGrid.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/lib/jquery-ui-custom.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/i18n/grid.locale-en.js" />"></script>

        <!-- Optional -->
        <script type="text/javascript" src="<c:url value="/resources/js/main.js"/>"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/redirect.js" />"></script> 
        <script type="text/javascript" src="<c:url value="/resources/js/reports.js" />"></script> 
        <script type="text/javascript" src="<c:url value="/resources/js/mvc/storesGridView.js" />"></script> 

        <title>ADClient</title>
    </head>
    <body class="body" >
        <header class="mainHeader headerBorder"> 
            <div class="banner ">

<!--                <div class="art-logo"  >
                    <h1> 
                        <a href="#" class="art-logo-name">Alo Diga Reports</a>
                    </h1>
                    <div id="slogan-text" class="art-logo-text">Maximize your productivity...</div>
                </div>-->
                <div style="float: left;margin:50px;">
                    <img src="<c:url value="/resources/images/adlogo.png" />">
                </div>
            </div>
            <div id="navbar" class="nav-bar">
                <div id="lavaWrapper"  style="float: left;">
                    <ul class="lavaLamp" >
                        <li><a id="home" class="menuItem" href="javascript:goTo('index')">Home</a></li> 
                        <li><a id="facturasMenu" class="menuItem" href="javascript:goTo('facturas/facturasView')">Facturas</a></li> 
                        <li><a id="storesMenu" class="menuItem" href="javascript:goTo('stores/storesView')">Stores</a></li> 
                    </ul>
                </div> 
            </div>
        </header> 
