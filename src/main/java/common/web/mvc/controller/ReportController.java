/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.web.mvc.controller;

import common.persistence.dto.Transferencia;
import common.persistence.manager.ReportManager;
import common.util.SessionData;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    private ReportManager reportManager;

    @Autowired
    private SessionData sessionData;

    @RequestMapping(value = "/goToSearch", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request) {
        System.out.println("goToSearch...");

        return new ModelAndView("reports/reports");
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, consumes = "application/json")
    public ModelAndView search(@RequestBody LinkedHashMap< String, String> request) {
        System.out.println("search... -> " + request);
        List<Transferencia> list = reportManager.search(request);

        sessionData.putAll(request);
        return new ModelAndView("reports/grid", "list", list);
    }

    @RequestMapping(value = "/excel", method = RequestMethod.GET)
    public ModelAndView excel() {
        System.out.println("receipt -> " + sessionData);
        
        LinkedHashMap request = sessionData;
        request.put("page", "0");
        List<Transferencia> list = reportManager.search(request);

        return new ModelAndView("txExcelView", "list", list);
    }
}
