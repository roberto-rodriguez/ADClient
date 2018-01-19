<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html"  pageEncoding="UTF-8"%> 

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
        <link rel="stylesheet" href="<c:url value="/resources/css/jqx.base.css" />"/> 
        <link rel="stylesheet" href="<c:url value="/resources/css/jquery-ui-custom.css" />"/>

        <script type="text/javascript" src="<c:url value="/resources/js/lib/jquery-2.1.1.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/lib/jquery-ui.js" />"></script>   
        <script type="text/javascript" src="<c:url value="/resources/js/lib/jquery-ui-custom.min.js" />"></script>


        <script type="text/javascript" src="<c:url value="/resources/js/lib/jqxcore.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/lib/jqxdata.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/lib/jqxlistbox.js" />"></script>
        <script type="text/javascript" src="<c:url value="/resources/js/lib/jqxbuttons.js" />"></script> 

        <!-- Optional -->
        <script type="text/javascript" src="<c:url value="/resources/js/main.js"/>"></script>

        <title>ADClient</title>
    </head>
    <body class="body" >
        <header class="mainHeader headerBorder"> 
            <div class="banner "> 
                <div style="float:left;">
                    <img src="<c:url value="/resources/images/atencion-al-cliente.png"/>" style="height:160px;margin:36px 0px 0px 60px;">
                </div>
                <div style="float:right;margin:60px 80px 0px 0px;">
                    <img src="<c:url value="/resources/images/adlogo.png" />">
                </div>

            </div>
            <div id="navbar" class="nav-bar"> 
                
            </div>
        </header>  

        <div id="mainContent" class="mainContent" style="text-align: center; vertical-align: middle;  background-color: white; height: 300px; width:100%"> 
            <form:form commandName="loginCommand" method="post" action="/ADClient/login">
                <div style="display: inline-block; vertical-align: middle; height: 120px; width: 200px; margin-top: 90px">
                    <form:input  path="username" id="username" placeholder="Usuario" />
                    <form:password path="password" id="password" placeholder="Password" style="margin: 15px"/>
                    <input type="submit" value="Login" class="button" onclick="javascript:login()"/> 
                    <c:if test="${loginCommand.invalidCredentials}">
                        <span id='errorMsg' style="color:red; margin-top: 15px">Invalid Login Credentials</span>
                    </c:if> 
                </div>
            </form:form>
        </div>

        <footer>
            Copyright &copy; 2018. All rights reserved. 
        </footer>

    </body>

</html>
