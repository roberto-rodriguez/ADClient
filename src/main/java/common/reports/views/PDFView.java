package common.reports.views;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

public class PDFView extends JasperReportsPdfView {

    public PDFView() {
        super();
        //setContentType("application/pdf");
        //setExporterParameters(null);
    }

    @Override
    public void render(Map model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.render(model, request, response);
 
        String clientId = (String)request.getParameter("clientId");
         
        
        model.put("storeName", "It wirks!!");
        
        response.setHeader("Content-disposition", "attachment;filename=report_" + clientId +".pdf");
         
        response.setContentType("application/pdf");
    }

    
}
