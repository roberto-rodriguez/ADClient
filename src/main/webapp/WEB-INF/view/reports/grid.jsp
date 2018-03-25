<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html"  pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<head>
    <title>Table V01</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->	 
    <link rel="icon" type="image/png" href="<c:url value="/resources/grid/images/icons/favicon.ico"/>"  />
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/grid/vendor/bootstrap/css/bootstrap.min.css"/>"  />
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/grid/fonts/font-awesome-4.7.0/css/font-awesome.min.css"/>"  />
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/grid/vendor/animate/animate.css"/>"  />
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/grid/vendor/select2/select2.min.css"/>"  />
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/grid/vendor/perfect-scrollbar/perfect-scrollbar.css"/>"  />
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/grid/css/util.css"/>"  />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/grid/css/main.css"/>"  />
    <!--===============================================================================================-->
</head>
 

<div > 
    <div class="limiter">
        <div class="container-table100">
            <div class="wrap-table100">
                <div class="table100">
                    <table >
                        <thead>
                            <tr class="table100-head">
                                <th class="column1">Fecha</th>
                                <th class="column2">Estatus</th>
                                <th class="column3">Remitente</th>
                                <th class="column4">Destinatario</th>
                                <th class="column5">Código</th>
                                <th class="column6">Pais</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="t" items="${list}"> 
                                <tr>
                                    <td class="column1">${t.fecha}</td>
                                    <td class="column2">${t.estatus}</td>
                                    <td class="column3">${t.nomRemite}</td>
                                    <td class="column4">${t.nomDestinatario}</td>
                                    <td class="column5">${t.codEnvio}</td>
                                    <td class="column6">${t.codPaisDestinatario}</td>
                                </tr>
                                <tr style="height: 30px;">
                                    <td class="column1">Entregado: ${t.dineroEntregado}</td>
                                    <td class="column2">Com: ${t.comision}</td>
                                    <td class="column3">Total a pagar: ${t.totalPagar}</td>
                                    <td class="column4">Entregar: ${t.montoEntregar}</td>
                                    <td class="column5">Tarifa: ${t.tarifa}</td>
                                    <td class="column6">CAD: ${t.comisionAD}</td>
                                </tr>
                            </c:forEach>  
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>




    <!--===============================================================================================-->	
    <script src="<c:url value="/resources/grid/vendor/jquery/jquery-3.2.1.min.js"/>"></script>
    <!--===============================================================================================-->
    <script src="<c:url value="/resources/grid/vendor/bootstrap/js/popper.js"/>"></script>
    <script src="<c:url value="/resources/grid/vendor/bootstrap/js/bootstrap.min.js"/>"></script>
    <!--===============================================================================================-->
    <script src="<c:url value="/resources/grid/vendor/select2/select2.min.js"/>"></script>
    <!--===============================================================================================-->
    <script src="<c:url value="/resources/grid/js/main.js"/>"></script>

</div>

