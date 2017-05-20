package common.web.mvc.controller;

import common.display.StoreDTO;
import common.persistence.domain.Store;
import common.persistence.manager.StoreManager;
import common.persistence.model.ExcelFile;
import common.util.GridData;
import common.util.ResponseUtil;
import common.util.excel.StoreExcelReader; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController; 
import common.util.exceptionResolver.MyException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/stores", method = RequestMethod.GET)
public class StoresController extends MultiActionController {
    
    @Autowired
    private StoreManager storeManager;
    
    @RequestMapping("/storesView.htm")
    public ModelAndView mvcManageCampaign(HttpServletRequest request, HttpServletResponse response) throws MyException {
        System.out.println("/stores"); 
        return new ModelAndView("mvc/view/storesGridView");
        
    }
    
    @RequestMapping("/listStores.htm")
    public void mvcLoadCampaignList(HttpServletRequest request, HttpServletResponse response) throws MyException, IOException {
        System.out.println("listStores -> ");
        String rowsStr = request.getParameter("rows");
        String pageStr = request.getParameter("page");
        System.out.println("rows = " + rowsStr);
        System.out.println("page = " + pageStr);
        
        Integer rows = Integer.parseInt(rowsStr);
        Integer page = Integer.parseInt(pageStr);
        
        GridData<StoreDTO> data = storeManager.list(rows, page);
        
        ResponseUtil.escribirDatosEnElResponse(response, data.getJsonString());
    }
    
    @RequestMapping(value = "/readStoresExcel", method = RequestMethod.POST)
    public ModelAndView readFacturasExcel(
            @ModelAttribute("storesExcelFile") ExcelFile excelFile, Model model) {
        System.out.println("StoresController -> readExcel");
        Integer total = 0;
        try {
        MultipartFile file = excelFile.getFile();
        
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
                        List<Store> results = StoreExcelReader.read(is);
                        total = results.size();
                        storeManager.saveBatch(results);
                    }
                }
                
            } else {
                System.out.println("File is empty");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ModelAndView("index", "storeErrorMessage", e.getMessage());
        }        
        return new ModelAndView("mvc/view/storesGridView", "total", total);
        
    }
    
//    @RequestMapping(value = "/edit/{storeId}", method = RequestMethod.POST)
//    public void readFacturasExcel(
//            @PathVariable("storeId") Long storeId, HttpServletRequest request) {
//        String sendReportStr = request.getParameter("sendReport");
//        String email = request.getParameter("email");
//}
}
