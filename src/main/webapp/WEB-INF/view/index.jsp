<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html"  pageEncoding="UTF-8"%> 
<%@ include file="/WEB-INF/view/includes.jsp" %>
<!DOCTYPE html>

<script type="text/javascript">
    $(document).ready(function () {
        $.get( host + "payment-flow.htm", function(data){ $( '#content' ).html( data );} );
    });

</script>
<div id="mainContent" class="mainContent"> 
    <div id="content">
        
    </div>
</div>
 
<footer>
    Copyright &copy; 2018. All rights reserved. 
</footer>

</body>

</html>
