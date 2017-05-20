/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.web.mvc.controller;
 
import common.persistence.manager.FacturaManager;
import common.persistence.model.FacturaExcelFile;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Roberto Rodriguez
 */
@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public class GeneralController {
    @Autowired
    private FacturaManager facturaManager;
  
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, @RequestParam(required = false) Integer type){
        System.out.println("index..."); 
        Date lastFacturaDate = facturaManager.getMaxDate();
        FacturaExcelFile model = new FacturaExcelFile();
        
        if(lastFacturaDate != null){
            Calendar c = Calendar.getInstance();
            c.setTime(lastFacturaDate);
            c.add(Calendar.DAY_OF_MONTH, 1);
            lastFacturaDate = c.getTime();
            String lastFacturaDateStr = FacturaManager.dateFormat.format(lastFacturaDate);
            model.setLastFacturaDate(lastFacturaDateStr);
        }
        
        System.out.println("lastFacturaDate = " + lastFacturaDate);
        
        return new ModelAndView("index", "facturasExcelFile", model);
//         return new ModelAndView("login");
    }
 
    
    @RequestMapping(value = "portal",method = RequestMethod.GET)
    public String login(HttpServletRequest request, @RequestParam(required = false) Integer type){
        System.out.println("login...");

         return "index";
    }
    
//    @RequestMapping(value = "/portal",method = RequestMethod.GET)
//    private ModelAndView dashboard(HttpServletRequest request, @RequestParam(required = false) Integer type){
//        System.out.println("dashboard...");
//
//         return new ModelAndView("index");
//    }
}
