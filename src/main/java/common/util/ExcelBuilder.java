package common.util;

/**
 * @author @Roberto Rodriguez :: <RobertoSoftwareEngineer@gmail.com>
 */
import common.persistence.dto.Transferencia;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

/**
 * This class builds an Excel spreadsheet document using Apache POI library.
 *
 * @author www.codejava.net
 *
 */
public class ExcelBuilder extends AbstractExcelView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model,
            HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // get data model which is passed by the Spring container
        List<Transferencia> list = (List<Transferencia>) model.get("list");

        // create a new Excel sheet
        HSSFSheet sheet = workbook.createSheet("Transferencias");
        sheet.setDefaultColumnWidth(30);

        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);

        // create header row
        HSSFRow header = sheet.createRow(0);

        header.createCell(0).setCellValue("Fecha");
        header.getCell(0).setCellStyle(style);

        header.createCell(1).setCellValue("Estatus");
        header.getCell(1).setCellStyle(style);

        header.createCell(2).setCellValue("Remitente");
        header.getCell(2).setCellStyle(style);

        header.createCell(3).setCellValue("Destinatario");
        header.getCell(3).setCellStyle(style);

        header.createCell(4).setCellValue("Código");
        header.getCell(4).setCellStyle(style);

        header.createCell(5).setCellValue("Pais");
        header.getCell(5).setCellStyle(style);

        header.createCell(6).setCellValue("Monto Entregado");
        header.getCell(6).setCellStyle(style);

        header.createCell(7).setCellValue("Commision");
        header.getCell(7).setCellStyle(style);

        header.createCell(8).setCellValue("Total a pagar");
        header.getCell(8).setCellStyle(style);

        header.createCell(9).setCellValue("Monto a Entregar");
        header.getCell(9).setCellStyle(style);

        header.createCell(10).setCellValue("Tarifa");
        header.getCell(10).setCellStyle(style);

        header.createCell(11).setCellValue("Comisión Alo Diga");
        header.getCell(11).setCellStyle(style);

        // create data rows
        int rowCount = 1;

        for (Transferencia t : list) {
            HSSFRow aRow = sheet.createRow(rowCount++);
            aRow.createCell(0).setCellValue(t.getFecha());
            aRow.createCell(1).setCellValue(t.getEstatus());
            aRow.createCell(2).setCellValue(t.getNomRemite());
            aRow.createCell(3).setCellValue(t.getNomDestinatario());
            aRow.createCell(4).setCellValue(t.getCodEnvio());
            aRow.createCell(5).setCellValue(t.getCodPaisDestinatario());
            aRow.createCell(6).setCellValue(t.getDineroEntregado());
            aRow.createCell(7).setCellValue(t.getComision());
            aRow.createCell(8).setCellValue(t.getTotalPagar());
            aRow.createCell(9).setCellValue(t.getMontoEntregar());
            aRow.createCell(10).setCellValue(t.getTarifa());
            aRow.createCell(11).setCellValue(t.getComisionAD());

        }
    }

}
