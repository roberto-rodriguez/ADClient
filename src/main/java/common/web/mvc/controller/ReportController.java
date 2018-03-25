/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.web.mvc.controller;

import com.google.gson.Gson;
import common.persistence.dto.ReportData;
import common.persistence.dto.ResultList;
import common.persistence.dto.Transferencia;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Roberto
 */
@Controller
@RequestMapping(value = "/reports", method = RequestMethod.GET)
public class ReportController {
    
    @Autowired
    private Environment env;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @RequestMapping(value = "/goToSearch", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request ) {
        System.out.println("goToSearch...");
        
        return new ModelAndView("reports/reports");
    }
    
  
    
    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = "application/json")
    public ModelAndView search( @RequestBody LinkedHashMap< String, String> request) {
        System.out.println("search... -> " + request);
        
         List<Transferencia> list = new ArrayList<>();
        
        String host = env.getProperty("adserver.url");
        
        String params = request.entrySet().stream().map(entry -> entry.getKey() + "=" + entry.getValue()).collect(Collectors.joining("&"));
        System.out.println("params... -> " + params);
        
        String url = host + "alodiga/mobile/buscar?agenciaOrigen=11502223&";
        url += params;
        
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        
        String str = response.getBody();
        
        System.out.println("str = " + str);
        
        Gson gson = new Gson(); // Or use new GsonBuilder().create();
         
        ResultList resultList = gson.fromJson(str, ResultList.class);
        
        System.out.println("resultList = " + (resultList != null));
        
        if(resultList != null){
            list = resultList.getList();
        } 
        return new ModelAndView("reports/grid", "list", list);
    }
    
      @RequestMapping(value = "/searchByCode", method = RequestMethod.POST, consumes = "application/json")
    public ModelAndView searchByCode( @RequestBody LinkedHashMap< String, String> request) {
        System.out.println("searchByCode... -> " + request);
        
         List<Transferencia> list = new ArrayList<>();
        
        String host = env.getProperty("adserver.url");
         
        String url = host + "alodiga/mobile/buscarPorCodigo?codEnvio=" + request.get("codEnvio");
       
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        
        String str = response.getBody();
        
        System.out.println("str = " + str);
        
        Gson gson = new Gson(); // Or use new GsonBuilder().create();
         
        Transferencia transferencia = gson.fromJson(str, Transferencia.class);
         
        
        if(transferencia != null){
            list.add(transferencia);
        } 
        return new ModelAndView("reports/grid", "list", list);
    }
    
    
    @RequestMapping(value = "/receipt", method = RequestMethod.GET)
    public ModelAndView receipt(HttpServletRequest request) {
        System.out.println("receiptReport ");
        
        Map<String, Object> parameterMap = new HashMap<>();
        
        ReportData reportData = (ReportData) request.getSession().getAttribute("reportData");
        
        System.out.println("ReportController -> reportData = " + (reportData != null));
        
        if (reportData == null) {
            reportData = new ReportData();
        }
        
        List<ReportData> list = Arrays.asList(new ReportData[]{reportData});
        
        parameterMap.put("datasource", new JRBeanCollectionDataSource(list));
        //     parameterMap.put("datasource", new JREmptyDataSource( ));
        return new ModelAndView("reportPDFView", parameterMap);
    }
    
    
//    @RequestMapping(value = "/excel", method = RequestMethod.POST)
//    public ModelAndView excel(HttpServletRequest request, HttpServletResponse response) { 
//        System.out.println("excel -> "); 
//        String clientIdStr = request.getParameter("clientId");
//        String fromStr = request.getParameter("from");
//        String toStr = request.getParameter("to"); 
//        System.out.println("clientIdStr = " + clientIdStr);
//        System.out.println("fromStr = " + fromStr);
//        System.out.println("toStr = " + toStr);
//         
//        Date startDate = getDateFromString(fromStr, true);
//        Date endDate = getDateFromString(toStr, false); 
//  
//        List<FacturaDTO> facturas = facturaManager.facturasExcelReport(  clientIdStr,   startDate,   endDate);
//         
//        return new ModelAndView("facturasExcelView", "facturas", facturas);
//    }
}
