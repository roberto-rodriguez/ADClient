package common.util.excel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 * @author @Roberto Rodriguez :: <RobertoSoftwareEngineer@gmail.com>
 */
public class ExcelReader {

    public static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    protected static Point getPosition(Sheet sheet, String label) throws Exception {
        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            Iterator<Cell> cells = row.cellIterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                String val = getCellValue(cell);

                if (val.equalsIgnoreCase(label)) {
                    return new Point(cell.getRowIndex(), cell.getColumnIndex());
                }
            }
        }
        return null;
    }

    protected static String getCellValue(Cell cell) {
        String ret;
        switch (cell.getCellType()) { 
            default:
                cell.setCellType(Cell.CELL_TYPE_STRING);
            case Cell.CELL_TYPE_STRING:
                ret = cell.getStringCellValue();
                break; 
        }
        return ret;
    }

    protected static Date getDateFromString(String dateStr) {
        if (dateStr != null) {
            try {
                return df.parse(dateStr);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return null;
    }
}
