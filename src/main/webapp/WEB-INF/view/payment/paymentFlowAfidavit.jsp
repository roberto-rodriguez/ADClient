<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<script type="text/javascript" src="<c:url value="/resources/js/payment/paymentFlowAfidavit.js"/>"></script>

<input type="hidden" id="flowExecutionUrl" value="${flowExecutionUrl}"/> 
  

<div class="top-bar">
    <p class="top-bar-left" onclick="javascript:back()">Back</p>
    <p class="top-bar-center">Afidavit</p> 
    <p class="top-bar-right" onclick="javascript:next()">Next</p>
</div>


<form:form commandName="command">
    <div style="visibility: hidden" id="afidavitHiddenFields">
        <form:input path="declaracionRemitente"  id="declaracionRemitente"/>  
        <form:input path="confirmacionFamilia"  id="confirmacionFamilia"/>  
        <form:input path="confirmacionNoGobierno"  id="confirmacionNoGobierno"/>  
        <form:input path="confirmacionNoProhibido"  id="confirmacionNoProhibido"/>  
        <form:input path="confirmacionNoEmigracion"  id="confirmacionNoEmigracion"/>  
    </div>

    <table class="form-table"> 
        <tr>
            <td>
                <input id="declaracionRemitenteCheckbox" type="checkbox"> 
            </td> 
            <td colspan="19">
                I declare and state all information
                provided for this transaction is true and
                accurate to the best of my knowledge.
            </td> 
        </tr>
        <tr>
            <td>
                <input id="confirmacionFamiliaCheckbox" type="checkbox"> 
            </td> 
            <td colspan="19">
                I confirm that this transaction is being
                sent to a close relative.
            </td> 
        </tr>
        <tr>
            <td>
                <input id="confirmacionNoGobiernoCheckbox" type="checkbox"> 
            </td> 
            <td colspan="19">
                I confirm that the Beneficiary of this
                remittance is NOT a prohibited official of the
                Government of Cuba.
            </td> 
        </tr>
        <tr>
            <td>
                <input id="confirmacionNoProhibidoCheckbox" type="checkbox"> 
            </td> 
            <td colspan="19">
                I confirm that the Beneficiary of this
                transaction is NOT a prohibited member of
                the Cuban Communist Party.
            </td> 
        </tr>
        <tr>
            <td>
                <input id="confirmacionNoEmigracionCheckbox" type="checkbox"> 
            </td> 
            <td colspan="19">
                I confirm that this transaction is NOT
                for any emigration-related purposes.
            </td> 
        </tr>
        <tr>
            <td colspan="20">
                <input type="button" value="Continuar" class="button" onclick="javascript:next()"/>
            </td> 
        </tr>
    </table>

</form:form>
