/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.web.mvc.controller;

import com.google.gson.Gson;
import common.persistence.dto.LoginCommand;
import common.persistence.model.Pais;
import common.persistence.repo.Repo;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@PropertySource({"classpath:env.properties"})
@RequestMapping(value = "/", method = RequestMethod.GET)
public class GeneralController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Repo repo;

    @Autowired
    private Environment env;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, @RequestParam(required = false) Integer type) {
        System.out.println("index...");

        return new ModelAndView("login", "loginCommand", new LoginCommand());
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, @ModelAttribute("loginCommand") LoginCommand loginCommand) {
        System.out.println("login...");
        System.out.println("loginCommand.getUsername() = " + loginCommand.getUsername());
        System.out.println("loginCommand.getPassword() = " + loginCommand.getPassword());
        String host = env.getProperty("adserver.url");
        System.out.println("host = " + host);

        if (!doLogin(loginCommand)) {
            loginCommand.setInvalidCredentials(Boolean.TRUE);
            return new ModelAndView("login", "loginCommand", loginCommand);
        }

        String agenciaOrigen = loginCommand.getUsername();

// String agenciaOrigen = "11502223";
        ResponseEntity<String> response = restTemplate.getForEntity(host + "alodiga/mobile/config", String.class);

        String str = response.getBody();
        Gson gson = new Gson(); // Or use new GsonBuilder().create();
        Pais[] paisesArray = gson.fromJson(str, Pais[].class);

        List<Pais> paises = Arrays.asList(paisesArray);

        repo.setConfig(paises);

        request.getSession().setAttribute("agenciaOrigen", agenciaOrigen);

        System.out.println("agenciaOrigen = " + agenciaOrigen);

        return new ModelAndView("index");
    }

    private boolean doLogin(LoginCommand loginCommand) {
        String url = "http://sales.alodiga.us:8080/ESPServlet/ESPServlet?method=login&login=" + loginCommand.getUsername() + "&password=" + loginCommand.getPassword();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        String str = response.getBody();

        System.out.println("Login Result = " + str);

        return str != null && !str.isEmpty() && str.charAt(0) == '0';
    }

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://sales.alodiga.us:8080/ESPServlet/ESPServlet?method=login&login=11502223&password=5074";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        String str = response.getBody();

        System.out.println("str = " + str);

    }
}
