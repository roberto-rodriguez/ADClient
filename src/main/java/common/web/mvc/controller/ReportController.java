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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
    public ModelAndView index(HttpServletRequest request, @RequestParam(required = false) Integer type) {
        System.out.println("goToSearch...");
        
        return new ModelAndView("reports/reports");
    }
    
  
    
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView search(HttpServletRequest request, @RequestParam(required = false) Integer type) {
        System.out.println("search...");
        
        String host = env.getProperty("adserver.url");
        
        String url = host + "alodiga/mobile/buscar?agenciaOrigen=11502223&page=1&limit=5&fechaDel=&fechaAl=&nombreR=&nombreD=";
        
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        
        String str = response.getBody();
        
        System.out.println("str = " + str);
        
        Gson gson = new Gson(); // Or use new GsonBuilder().create();
        
        
        ResultList resultList = gson.fromJson(str, ResultList.class);
        
        System.out.println("resultList = " + (resultList != null));
        
        List<Transferencia> list = resultList == null ? new ArrayList<>() : resultList.getList();
 
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
}
