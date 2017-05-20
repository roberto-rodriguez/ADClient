package common.util.excel;

import common.display.OriginRow;
import common.util.excel.ExcelReader;
import static common.util.excel.ExcelReader.getPosition;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FacturasExcelReader extends ExcelReader {

    private static final DecimalFormat twoPlaces = new DecimalFormat("0.00");

    public static List<OriginRow> read(InputStream is) throws Exception {
        List<OriginRow> results = new ArrayList();

        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);

        Point p = getPosition(sheet, "name");
        System.out.println(p);

        int lastRowNum = sheet.getLastRowNum();

        for (int i = p.getRow() + 1; i <= lastRowNum; i++) {
            try{
            Row row = sheet.getRow(i);

            String loginId = getCellValue(row.getCell(p.getColl() + 1));
            System.out.println("reading login:: " + loginId);
            if (loginId == null || loginId.isEmpty()) {
                continue;
            }

            OriginRow originRow = new OriginRow();
            originRow.setName(getCellValue(row.getCell(p.getColl())));
            originRow.setLogin(loginId);
           
            
            String transactionType = getCellValue(row.getCell(p.getColl() + 3));
            originRow.setTransactionType(transactionType); 
            
            String prefix = transactionType != null && transactionType.equalsIgnoreCase("REVERSE_TRANSACTION") ? "-" : "";
            
            originRow.setQuantity(prefix + getCellValue(row.getCell(p.getColl() + 2)));
            originRow.setTotalTransaction(prefix + getCellValue(row.getCell(p.getColl() + 4)));
            originRow.setTotalPromotion(prefix + getCellValue(row.getCell(p.getColl() + 5)));
            originRow.setTotalSales(prefix + getCellValue(row.getCell(p.getColl() + 6)));
            originRow.setNet2pay(prefix + getCellValue(row.getCell(p.getColl() + 7)));
            originRow.setCommission(prefix + getCellValue(row.getCell(p.getColl() + 8)));

           // Double salesPayment = originRow.getTotalSales() - originRow.getTotalPromotion() - originRow.getCommission();

           // originRow.setSalesPayment(twoPlaces.format(salesPayment));
            System.out.println(originRow.toString());
            results.add(originRow);
            }catch(Exception e){
                throw new Exception("Error reading the line #" + (i + 1));
            }
        }

        return results;
    }
}
