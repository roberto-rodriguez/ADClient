package common.web.webflow.controller;

import com.google.gson.Gson;
import common.persistence.dto.ReportData;
import common.persistence.dto.Transferencia;
import common.persistence.model.Pais;
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

        if (command != null) {
            command.complete();
        }

        String host = env.getProperty("adserver.url");

        System.out.println("Sending to HOST = " + host);

        String url = host + "alodiga/mobile/doTransaction2";

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(url, command, String.class);

            String str = response.getBody();

            System.out.println("response ----> " + str);

            Gson gson = new Gson(); // Or use new GsonBuilder().create();
            Transferencia transferencia = gson.fromJson(str, Transferencia.class);

            System.out.println("*** transferencia = " + (transferencia != null));

            if (transferencia == null) {
                transferencia = new Transferencia();
            }

            context.getFlowScope().put("transferencia", transferencia);
            
            String clavePago = transferencia == null ? "" : transferencia.getClavePago();

            ReportData reportData = command.toReportData(clavePago);

            if (transferencia != null) {
                reportData.setCodEnvio(transferencia.getCodEnvio());
            }

            System.out.println("-------------- PaymentCommand ------------");
            System.out.println(command.toString());

            System.out.println("PaymentMultiAction ->  context.getExternalContext().getSessionMap().put(reportData , reportData)");
            context.getExternalContext().getSessionMap().put("reportData", reportData);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return success();
    }

    public Boolean isCuba(RequestContext context) {
        System.out.println("context = " + (context != null));

        PaymentCommand command = (PaymentCommand) context.getFlowScope().get("command");
        return command != null && command.getCodPaisDestinatario() != null && command.getCodPaisDestinatario().equalsIgnoreCase("CUB");
    }
}
