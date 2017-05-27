/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.web.mvc.controller;

import com.google.gson.Gson;
import common.persistence.model.Pais;
import common.persistence.repo.Repo;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Roberto Rodriguez
 */
@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public class GeneralController { 
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Repo repo;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, @RequestParam(required = false) Integer type) {
        System.out.println("index..."); 
        
        String host = request.getRequestURL().toString();
        if(host.contains("/ADClient/")){
            host = host.split("/ADClient/")[0];
        }
        
        ResponseEntity<String> response = restTemplate.getForEntity(host + "/ADServer/alodiga/mobile/config", String.class);

        String str = response.getBody();
        Gson gson = new Gson(); // Or use new GsonBuilder().create();
        Pais[] paisesArray = gson.fromJson(str, Pais[].class);
        
        List<Pais> paises = Arrays.asList(paisesArray);
        
        repo.setConfig(paises);
        
        String agenciaOrigen = (String) request.getParameter("agenciaOrigen");

        request.getSession().setAttribute("agenciaOrigen", agenciaOrigen);

        System.out.println("agenciaOrigen = " + agenciaOrigen);

//        return "redirect:payment-flow.htm";
        return new ModelAndView("index");
    }

}
