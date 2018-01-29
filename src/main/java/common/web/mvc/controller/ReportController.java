/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.web.mvc.controller;
  
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Roberto
 */
@Controller
@RequestMapping(value = "/reports", method = RequestMethod.GET)
public class ReportController {
 
       @RequestMapping(value = "/receipt", method = RequestMethod.GET)
    public ModelAndView receipt() {
        System.out.println("receiptReport " );
 
        Map<String, Object> parameterMap = new HashMap<>();
//        parameterMap.put("datasource", new JRBeanCollectionDataSource(new ArrayList<>()));
          parameterMap.put("datasource", new JREmptyDataSource( ));
        return new ModelAndView("reportPDFView", parameterMap);
    }
}
