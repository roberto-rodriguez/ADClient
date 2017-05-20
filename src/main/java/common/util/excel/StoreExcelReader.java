package common.util.excel;

import common.persistence.domain.Store;
import static common.util.excel.ExcelReader.getPosition;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class StoreExcelReader extends ExcelReader {

    private static final DecimalFormat twoPlaces = new DecimalFormat("0.00");

    public static List<Store> read(InputStream is) throws Exception {
        List<Store> results = new ArrayList<>();

        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(0);

        Point p = getPosition(sheet, "Login ID");
        System.out.println(p);

        int lastRowNum = sheet.getLastRowNum();

        for (int i = p.getRow() + 1; i <= lastRowNum; i++) {
            try {
                Row row = sheet.getRow(i);

                Store store = new Store();
                String loginId = getCellValue(row.getCell(p.getColl()));
                if (loginId == null || loginId.isEmpty()) {
                    continue;
                }
                store.setLoginId(loginId);
                store.setName(getCellValue(row.getCell(p.getColl() + 1)));
                store.setLastName(getCellValue(row.getCell(p.getColl() + 2)));
                store.setAddress(getCellValue(row.getCell(p.getColl() + 3)));
                store.setPhone(getCellValue(row.getCell(p.getColl() + 4)));
                store.setEmail(getCellValue(row.getCell(p.getColl() + 5)));

                String dateStr = getCellValue(row.getCell(p.getColl() + 6));
                store.setCreationDate(getDateFromString(dateStr));

                results.add(store);
            } catch (Exception e) {
                throw new Exception("Error reading the line #" + (i + 1));
            }
        }

        return results;
    }
}
