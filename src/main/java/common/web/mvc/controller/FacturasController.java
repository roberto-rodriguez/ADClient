package common.web.mvc.controller;

import common.display.OriginRow;
import common.util.excel.FacturasExcelReader;
import common.display.Report;
import common.display.ReportItem;
import common.persistence.manager.FacturaManager;
import common.persistence.model.ExcelFile;
import common.persistence.model.FacturaExcelFile;
import common.util.GridData;
import common.util.ResponseUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import common.util.exceptionResolver.MyException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/facturas", method = RequestMethod.GET)
public class FacturasController extends MultiActionController {

    private static DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
 
    @Autowired
    private FacturaManager facturaManager;

    @RequestMapping("/facturasView.htm")
    public ModelAndView mvcManageCampaign(HttpServletRequest request, HttpServletResponse response) throws MyException {
        System.out.println("/facturasView");
        return new ModelAndView("mvc/view/facturasGridView");

    }

    @RequestMapping(value = "/facturasReport/{clientId}", method = RequestMethod.GET)
    public ModelAndView generateCampaignReportPDF(@PathVariable("clientId") String clientId) {
        System.out.println("viewReport " + clientId);

        List<ReportItem> list = facturaManager.getReport(clientId);

        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("datasource", new JRBeanCollectionDataSource(list));
        return new ModelAndView("reportPDFView", parameterMap);
    }

    @RequestMapping("/listFacturas.htm")
    public void listFacturas(HttpServletRequest request, HttpServletResponse response) throws MyException, IOException {
        System.out.println("listReports -> ");
        String rowsStr = request.getParameter("rows");
        String pageStr = request.getParameter("page");
        String clientIdStr = request.getParameter("clientId");
        String fromStr = request.getParameter("from");
        String toStr = request.getParameter("to");
        System.out.println("rows = " + rowsStr);
        System.out.println("page = " + pageStr);
        System.out.println("clientIdStr = " + clientIdStr);
        System.out.println("fromStr = " + fromStr);
        System.out.println("toStr = " + toStr);

        Integer rows = Integer.parseInt(rowsStr);
        Integer page = Integer.parseInt(pageStr);
        Date startDate = getDateFromString(fromStr, true);
        Date endDate = getDateFromString(toStr, false); 
        
        GridData<Report> data = facturaManager.list(rows, page,clientIdStr, startDate,endDate);

        ResponseUtil.escribirDatosEnElResponse(response, data.getJsonString());
    }

    @RequestMapping(value = "/readFacturasExcel", method = RequestMethod.POST)
    public ModelAndView readFacturasExcel(
            @ModelAttribute("facturasExcelFile") FacturaExcelFile excelFile, Model model) {
        System.out.println("CampaignMultiActionController -> readExcel");
        System.out.println("excelFile.getDateStart() = " + excelFile.getDateStart());
        System.out.println("excelFile.getDateEnd() = " + excelFile.getDateEnd());

        MultipartFile file = excelFile.getFile();
        Integer total = 0;
        try {
            if (!file.isEmpty()) {
                String suffix = null;
                int index = file.getOriginalFilename().lastIndexOf(".");
                if (index != -1
                        && index != file.getOriginalFilename().length() - 1) {
                    suffix = file.getOriginalFilename().substring(index + 1);
                    if (suffix == null || "xls|xlsx".indexOf(suffix) == -1) {
                        System.out.println("Wrong format");
                    } else {

                        InputStream is = file.getInputStream();

                        System.out.println("Printing Results");
                        List<OriginRow> results = FacturasExcelReader.read(is);
                        total = results.size();
                        facturaManager.fillRepo(results, excelFile.getDateStart(), excelFile.getDateEnd());
                    }
                }

            } else {
                System.out.println("File is empty");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("index", "facturaErrorMessage", e.getMessage());
        }
        
        System.out.println("Answering to client...");
        return new ModelAndView("mvc/view/facturasGridView", "total", total);

    }
    
     @RequestMapping(value = "/resumenReport", method = RequestMethod.GET)
    public ModelAndView resumenReport(HttpServletRequest request, HttpServletResponse response) { 
        System.out.println("resumenReport -> "); 
        String clientIdStr = request.getParameter("clientId");
        String fromStr = request.getParameter("from");
        String toStr = request.getParameter("to"); 
        System.out.println("clientIdStr = " + clientIdStr);
        System.out.println("fromStr = " + fromStr);
        System.out.println("toStr = " + toStr);
 
        Date startDate = getDateFromString(fromStr, true);
        Date endDate = getDateFromString(toStr, false); 
        
        List<Report> list = facturaManager.resumen(clientIdStr, startDate, endDate);

        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("datasource", new JRBeanCollectionDataSource(list));
        return new ModelAndView("resumenPDFView", parameterMap);
    }

    private static Date getDateFromString(String str, boolean start) {
        if (str != null && !str.isEmpty()) {
            try {
                Date date = df.parse(str);

                if (start) {
                    date.setHours(0);
                    date.setMinutes(0);
                    date.setSeconds(0);
                } else {
                    date.setHours(23);
                    date.setMinutes(59);
                    date.setSeconds(59);
                }
                return date;
            } catch (Exception e) {
            }
        }
        return null;
    }
 
}
