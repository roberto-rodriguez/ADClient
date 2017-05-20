package common.persistence.manager;

import common.display.OriginRow;
import common.display.Report;
import common.display.ReportItem;
import common.persistence.dao.FacturaDAO;
import common.persistence.dao.FacturaItemDAO;
import common.persistence.domain.Factura;
import common.persistence.domain.FacturaItem;
import common.persistence.domain.Store;
import common.util.GridData;
import common.util.email.GoogleMail;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author @Roberto Rodriguez :: <RobertoSoftwareEngineer@gmail.com>
 */
@Service
public class FacturaManager {

    public static Integer index = null;
    public static final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    @Autowired
    private StoreManager storeManager;

    @Autowired
    private FacturaDAO facturaDAO;

    @Autowired
    private FacturaItemDAO facturaItemDAO;

    public GridData<Report> list(Integer rows, Integer page, String clientId, Date startDate, Date endDate) {
        return facturaDAO.list(rows, page, clientId, startDate, endDate);
    }

    public List<ReportItem> getReport(String facturaId) {
        System.out.println("ReportManager -> getReport " + facturaId);
        Long idFactura = Long.parseLong(facturaId);

        List<ReportItem> reportItems = facturaItemDAO.list(idFactura);

        if (reportItems != null && !reportItems.isEmpty()) {
            ReportItem first = reportItems.get(0);
            ReportItem factura = facturaDAO.getById(idFactura);

            first.setReportDate(factura.getReportDate());
            first.setReportNumber(factura.getReportNumber());
            first.setName(factura.getName());
            first.setLastName(factura.getLastName());
            first.setStoreAddress(factura.getStoreAddress());
            first.setTotalSales(factura.getTotalSales());
            first.setTotalSalesPromotion(factura.getTotalSalesPromotion());
            first.setTotalNet2Pay(factura.getTotalNet2Pay());
            first.setTotalCommission(factura.getTotalCommission());
            first.setTotalQuantity(factura.getTotalQuantity());
            first.setStartDate(factura.getStartDate());
            first.setEndDate(factura.getEndDate());
            first.setPurchaseBalance(factura.getPurchaseBalance());

            ReportItem last = reportItems.get(reportItems.size() - 1);
            last.setTotalSales(factura.getTotalSales());
            last.setTotalSalesPromotion(factura.getTotalSalesPromotion());
            last.setTotalNet2Pay(factura.getTotalNet2Pay());
            last.setTotalCommission(factura.getTotalCommission());
            last.setTotalQuantity(factura.getTotalQuantity());
            last.setPurchaseBalance(factura.getPurchaseBalance());
            last.setQuantityPurchaseBalance(factura.getQuantityPurchaseBalance());
        }

        return reportItems;

    }

    public void fillRepo(List<OriginRow> list, String dateStart, String dateEnd) throws ParseException, Exception {
        System.out.println("Filling out Repo...");
        index = 1;
        final Date startDate = dateFormat.parse(dateStart);
        final Date endDate = dateFormat.parse(dateEnd);

        facturaDAO.deleteByRange(startDate, endDate);

        Map<String, List<OriginRow>> groupByRows
                = list.stream()
                .collect(Collectors.groupingBy(OriginRow::getLogin));

        List<String> notPresentClients = new ArrayList<>();

        List<Factura> facturas = groupByRows.entrySet()
                .stream().map(e -> {
                    Factura factura = new Factura();
                    factura.setCreationDate(new Date());

                    List<FacturaItem> facturaItems = new ArrayList();

                    List<OriginRow> originList = e.getValue();

                    Integer quantityPurchaseBalance = 0;
                    Double purchaseBalance = 0D;

                    for (OriginRow originRow : originList) {
                        if (originRow.getTransactionType() != null && originRow.getTransactionType().equalsIgnoreCase("PURCHASE_BALANCE")) {
                            quantityPurchaseBalance += originRow.getQuantity();
                            purchaseBalance += originRow.getNet2pay();
                        } else {
                            facturaItems.add(new FacturaItem(originRow));
                        }
                    }

                    factura.setPurchaseBalance(purchaseBalance);
                    factura.setQuantityPurchaseBalance(quantityPurchaseBalance);

                    Integer totalQuantity = facturaItems.stream().mapToInt(FacturaItem::getQuantity).sum();
                    Double totalSalesPromotion = facturaItems.stream().mapToDouble(FacturaItem::getFreeDollar).sum();
                    Double totalCommission = facturaItems.stream().mapToDouble(FacturaItem::getCommission).sum();
                    Double totalSales = facturaItems.stream().mapToDouble(FacturaItem::getSales).sum();
                    Double totalNet2pay = facturaItems.stream().mapToDouble(FacturaItem::getNet2pay).sum();

                    factura.setSalesPromotion(totalSalesPromotion);
                    factura.setCommission(totalCommission);
                    factura.setSales(totalSales);
                    factura.setNet2pay(totalNet2pay);
                    factura.setQuantity(totalQuantity);

                    factura.createReportNumber(index++);
                    String clientId = e.getKey();
                    System.out.println("storeId >" + clientId + "<");
                    Store store = storeManager.getStoreByLoginId(clientId);
                    if (store != null) {
                        factura.setStore(store);
                        factura.setStartDate(startDate);
                        factura.setEndDate(endDate);
                        // facturaDAO.saveOrUpdate(factura);

                        for (FacturaItem facturaItem : facturaItems) {
                            facturaItem.setFactura(factura);
                            //  facturaItemDAO.saveOrUpdate(facturaItem);
                        }

                        factura.setItems(facturaItems);
                    } else {
                        notPresentClients.add(clientId);
                    }

                    return factura;
                }).collect(Collectors.toList());

        if (notPresentClients.isEmpty()) {
            for (Factura factura : facturas) {
                facturaDAO.saveOrUpdate(factura);

                for (FacturaItem facturaItem : factura.getItems()) {
                    facturaItemDAO.saveOrUpdate(facturaItem);
                }

                GoogleMail.sendReportEmail(factura.getStore().getEmail(), factura);
            }

            new Thread(() -> {
                for (Factura factura : facturas) {
                    try {
                        GoogleMail.sendReportEmail(factura.getStore().getEmail(), factura);
                    } catch (MessagingException ex) {
                        Logger.getLogger(FacturaManager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }).start();
        } else {
            StringBuilder sb = new StringBuilder("The following clients were not found in the database: <br><ul>");
            for (String npc : notPresentClients) {
                sb.append("<li>" + npc + "</li><br>");
            }
            sb.append("</ul>");
            throw new Exception(sb.toString());
        }

    }

    public Date getMaxDate() {
        return facturaDAO.getMaxDate();
    }

    public List<Report> resumen(String clientId, Date startDate, Date endDate) {
        List<Report> list = facturaDAO.resumen(clientId, startDate, endDate);

        if (list != null && !list.isEmpty()) {
            list.get(0).setReportFecha(new Date());
            list.get(0).setReportStartDate(startDate);
            list.get(0).setReportEndDate(endDate);
            list.get(0).setReportClient(clientId);

            Double reportTotalSales = 0D;
            Double reportTotalCommission = 0D;
            Double reportTotalNet2Pay = 0D;
            Double reportTotalSalesPromotion = 0D;

            for (Report r : list) {
                reportTotalSales += r.getSales();
                reportTotalCommission += r.getCommission();
                reportTotalNet2Pay += r.getNet2pay();
                reportTotalSalesPromotion += r.getSalesPromotion();
            }

            Integer lastPos = list.size() - 1;
            list.get(lastPos).setReportTotalSales(reportTotalSales);
            list.get(lastPos).setReportTotalCommission(reportTotalCommission);
            list.get(lastPos).setReportTotalNet2Pay(reportTotalNet2Pay);
            list.get(lastPos).setReportTotalSalesPromotion(reportTotalSalesPromotion);
        }

        return list;
    }
}
