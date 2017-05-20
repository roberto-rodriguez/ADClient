package common.web.webflow.controller;

import java.io.Serializable;
import org.springframework.webflow.action.MultiAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

public class PaymentMultiAction extends MultiAction implements Serializable {

    public Event echo( RequestContext ctx) {
        System.out.println("PaymentMultiAction -> echo");
        return success();
    }

}
