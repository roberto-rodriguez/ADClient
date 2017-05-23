package common.web.webflow.controller;

import common.persistence.model.PaymentCommand;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import org.springframework.webflow.action.MultiAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

public class PaymentMultiAction extends MultiAction implements Serializable {

    public Event inicializarFlujo(RequestContext context) {
        System.out.println("PaymentMultiAction -> inicializarFlujo");
        String agenciaOrigen = context.getExternalContext().getSessionMap().getString("agenciaOrigen");
        System.out.println("PaymentMultiAction -> inicializarFlujo :: agenciaOrigen = " + agenciaOrigen);

        PaymentCommand command = new PaymentCommand();
        command.setAgenciaOrigen(agenciaOrigen);

        context.getFlowScope().put("command", command);

        return success();
    }

    public Event bind(RequestContext context) {
        System.out.println("PaymentMultiAction -> bind");

        Map<String, Object> map = context.getRequestParameters().asMap();

        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }

//        PaymentCommand command = (PaymentCommand) context.getFlowScope().get("command");
//        command.build(map);
//        context.getFlowScope().put("command", command);

        return success();
    }

    public Event enviar(RequestContext context) {
        System.out.println("PaymentMultiAction -> enviar");

        PaymentCommand command = (PaymentCommand) context.getFlowScope().get("command");
 
            System.out.println( "Remitente: " + command.getRemitenteNombre());
            System.out.println( "Destinatario: " + command.getDestinatarioNombre());
       
 

        return success();
    }
}
