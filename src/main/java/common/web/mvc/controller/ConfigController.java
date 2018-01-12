/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.web.mvc.controller;

import com.google.gson.Gson;
import common.persistence.dto.Nom;
import common.persistence.model.BaseCotizar;
import common.persistence.model.Corresponsal;
import common.persistence.model.Destinatario;
import common.persistence.model.Estado;
import common.persistence.model.FormaEntrega;
import common.persistence.model.Nomemclator;
import common.persistence.model.Pais;
import common.persistence.model.Remitente;
import common.persistence.repo.Repo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Roberto Rodriguez
 */
@RestController
@PropertySource({"classpath:env.properties"})
@RequestMapping(value = "/config", method = RequestMethod.GET)
public class ConfigController {
   @Autowired
    private Environment env;

    @Autowired
    private Repo repo;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/paises", method = RequestMethod.GET)
    public @ResponseBody
    List<Pais> index() {
        System.out.println("paises...");
        return repo.getConfig();
    }

    @RequestMapping(value = "/corresponsales/{pais}", method = RequestMethod.GET)
    public @ResponseBody
    List<Corresponsal> corresponsales(@PathVariable("pais") String pais) {
        System.out.println("corresponsales... pais = " + pais);
        return repo.getConfig().stream().filter(p -> p.getCodigo().equalsIgnoreCase(pais)).findAny().get().getCorresponsales();
    }

    @RequestMapping(value = "/formasEntrega/{pais}/{corresponsal}", method = RequestMethod.GET)
    public @ResponseBody
    List<FormaEntrega> formasEntrega(@PathVariable("pais") String pais, @PathVariable("corresponsal") String corresponsal) {
        System.out.println("corresponsales... corresponsal = " + corresponsal);
        return repo.getConfig()
                .stream().filter(p -> p.getCodigo().equalsIgnoreCase(pais))
                .findAny().get().getCorresponsales()
                .stream().filter(c -> c.getCodigo().equalsIgnoreCase(corresponsal))
                .findAny().get().getFormaEntregaList();
    }

    @RequestMapping(value = "cotizar")
    public @ResponseBody
    List<BaseCotizar> cotizar(HttpServletRequest request) {

        String monto = request.getParameter("monto");
        String corresponsal = request.getParameter("corresponsal");
        String formaEntrega = request.getParameter("formaEntrega");
        String incluyeComision = request.getParameter("incluyeComision");

        System.out.println("cotizar: monto = " + monto);

        String host = env.getProperty("adserver.url");

        String params = "?monto=" + monto + "&corresponsal=" + corresponsal + "&formaEntrega=" + formaEntrega + "&incluyeComision=" + incluyeComision + "&agenciaOrigen=MIA-1";

        String url = host + "alodiga/mobile/cotizar2" + params;

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

            String str = response.getBody();

            System.out.println("str = " + str);

            Gson gson = new Gson(); // Or use new GsonBuilder().create();
            BaseCotizar[] list = gson.fromJson(str, BaseCotizar[].class);

            return Arrays.asList(list).stream().filter(b -> b != null).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "state/{pais}")
    public @ResponseBody
    Estado[] state(HttpServletRequest request, @PathVariable("pais") String pais) {
        System.out.println("state");

        String host =  env.getProperty("adserver.url");

        String url = host + "alodiga/mobile/listarEstados?pais=" + pais;

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

            String str = response.getBody();

            System.out.println("str = " + str);

            Gson gson = new Gson(); // Or use new GsonBuilder().create();
            return gson.fromJson(str, Estado[].class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "city/{state}")
    public @ResponseBody
    List<Nomemclator> city(HttpServletRequest request, @PathVariable("state") String state) {
        System.out.println("state");

        String host = env.getProperty("adserver.url");

        String url = host + "/alodiga/mobile/listCities?state=" + state;

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

            String str = response.getBody();

            System.out.println("str = " + str);

            Gson gson = new Gson(); // Or use new GsonBuilder().create();
            List<String> list = Arrays.asList(gson.fromJson(str, String[].class));

            return list.stream().map(s -> new Nomemclator(s, s)).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/remitente/{telefono}", method = RequestMethod.GET/*, produces = MediaType.APPLICATION_JSON_VALUE*/)
    public @ResponseBody
    Remitente remitente(HttpServletRequest request, @PathVariable("telefono") String telefono) {
        System.out.println("remitente");
        String host = env.getProperty("adserver.url");

        String url = host + "alodiga/mobile/remitente?agenciaOrigen=MIA-1&telefono=" + telefono;

        try {
            ResponseEntity<Remitente> response = restTemplate.getForEntity(url, Remitente.class);

            Remitente remitente = response.getBody();

            return remitente;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/destinatario/{telefono}", method = RequestMethod.GET/*, produces = MediaType.APPLICATION_JSON_VALUE*/)
    public @ResponseBody
    List<Destinatario> destinatario(HttpServletRequest request, @PathVariable("telefono") String telefono) {
  
       Remitente remitente = remitente( request,telefono);
       
       if(remitente != null){
           List<Destinatario> list = remitente.getDestinatarios();
           if(list != null && !list.isEmpty()){
               list.add(0, new Destinatario(0L, "Nuevo Destinatario."));
           }
           return list;
       } 
       return null;
    }
 

    static String urlEncodeUTF8(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException(e);
        }
    }
}
