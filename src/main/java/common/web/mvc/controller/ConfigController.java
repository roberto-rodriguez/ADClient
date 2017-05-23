/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.web.mvc.controller;

import common.persistence.model.Corresponsal;
import common.persistence.model.FormaEntrega;
import common.persistence.model.Pais;
import common.persistence.repo.Repo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Roberto Rodriguez
 */
@RestController
@RequestMapping(value = "/config", method = RequestMethod.GET)
public class ConfigController { 
    @Autowired
    private Repo repo;

    @RequestMapping(value = "/paises", method = RequestMethod.GET)
    public  @ResponseBody List<Pais>  index() {
        System.out.println("paises..."); 
        return repo.getConfig();
    }

    @RequestMapping(value = "/corresponsales/{pais}", method = RequestMethod.GET)
    public  @ResponseBody List<Corresponsal>  corresponsales(@PathVariable("pais") String pais) {
        System.out.println("corresponsales... pais = " + pais); 
        return repo.getConfig().stream().filter(p -> p.getCodigo().equalsIgnoreCase(pais)).findAny().get().getCorresponsales();
     }

    @RequestMapping(value = "/formasEntrega/{pais}/{corresponsal}", method = RequestMethod.GET)
    public  @ResponseBody List<FormaEntrega>  formasEntrega(@PathVariable("pais") String pais,@PathVariable("corresponsal") String corresponsal) {
        System.out.println("corresponsales... corresponsal = " + corresponsal); 
        return repo.getConfig()
                .stream().filter(p -> p.getCodigo().equalsIgnoreCase(pais))
                    .findAny().get().getCorresponsales()
                .stream().filter(c -> c.getCodigo().equalsIgnoreCase(corresponsal))
                    .findAny().get().getFormaEntregaList();
     }
    
    

}
