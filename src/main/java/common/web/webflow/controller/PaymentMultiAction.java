package common.web.webflow.controller;

import common.persistence.model.PaymentCommand;
import java.io.Serializable; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.webflow.action.MultiAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

public class PaymentMultiAction extends MultiAction implements Serializable {

    @Autowired
    private Environment env;
    @Autowired
    private RestTemplate restTemplate;

    public Event inicializarFlujo(RequestContext context) {
        System.out.println("PaymentMultiAction -> inicializarFlujo");
        String agenciaOrigen = context.getExternalContext().getSessionMap().getString("agenciaOrigen");
        System.out.println("PaymentMultiAction -> inicializarFlujo :: agenciaOrigen = " + agenciaOrigen);

        PaymentCommand command = new PaymentCommand();
        command.setAgenciaOrigen(agenciaOrigen);

        context.getFlowScope().put("command", command);

        return success();
    }
  
    public Event enviar(RequestContext context) {
        System.out.println("PaymentMultiAction -> enviar");

        PaymentCommand command = (PaymentCommand) context.getFlowScope().get("command");
          
        String host = env.getProperty("adserver.url");

        System.out.println("Sending to HOST = " + host);

        String url = host + "alodiga/mobile/doTransaction2";

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(url, command, String.class);

            String str = response.getBody();

            System.out.println("response = " + str);
  
        } catch (Exception e) {
            e.printStackTrace();
        }

        return success();
    }
}
