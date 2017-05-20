package common.reports.views;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.jasperreports.JasperReportsXlsView;

public class XLSView extends JasperReportsXlsView {

    public XLSView() {
        super();
    }
    
        @Override
    public void render(Map model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.render(model, request, response);

        response.setHeader("Content-disposition", "attachment; filename=report.xls");
        response.setContentType("application/xls");
    }

}
