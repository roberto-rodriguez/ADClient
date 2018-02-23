/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.web.mvc.controller;

import common.persistence.dto.ReportData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.webflow.context.servlet.HttpSessionMap;

/**
 *
 * @author Roberto
 */
@Controller
@RequestMapping(value = "/reports", method = RequestMethod.GET)
public class ReportController {

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
