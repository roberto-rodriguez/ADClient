package common.conf.spring;

import common.web.webflow.controller.PaymentMultiAction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({ "classpath:blitz-webflow.xml" }) 
public class WebFlowConfig {

    public WebFlowConfig() {
        super();
    }
    
    @Bean
    public PaymentMultiAction paymentMultiAction(){
        return new PaymentMultiAction();
    }
}
