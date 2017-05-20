package common.display;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import org.codehaus.jackson.annotate.JsonIgnore;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author @Roberto Rodriguez :: <RobertoSoftwareEngineer@gmail.com>
 */
public class Report implements Serializable {

    public static final DecimalFormat twoPlaces = new DecimalFormat("0.00");
    public static final DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

    private String clientId;
    private Long facturaId;
    private Double salesPromotion;
    private Double net2pay;
    private Double commission;
    private Double sales;
    private Date startDate;
    private Date endDate;

    private Date reportFecha;
    private String reportClient;
    private Date reportStartDate;
    private Date reportEndDate;
    private Double reportTotalSales;
    private Double reportTotalCommission;
    private Double reportTotalNet2Pay;
    private Double reportTotalSalesPromotion;

    private List<ReportItem> items = new ArrayList<>();

    public Report() {
    }

    public void complete(String clientId, Double salesPromotion, Double net2pay, Double commission) {
        this.clientId = clientId;
        this.salesPromotion = salesPromotion;
        this.setNet2pay(net2pay);
        this.commission = commission;
    }

    public String getPeriod() {
        return df.format(startDate) + " - " + df.format(endDate);
    }

    public String getReportPeriod() {
        return getReportStartDate() + " - " + getReportEndDate();
    }

    /**
     * @return the clientId
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * @param clientId the clientId to set
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return getFacturaId() + "";
    }

    @JsonIgnore
    public List<ReportItem> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<ReportItem> items) {
        this.items = items;
    }

    /**
     * @return the salesPromotion
     */
    public Double getSalesPromotion() {
        return salesPromotion != null ? salesPromotion : 0D;   
    }

    /**
     * @param salesPromotion the salesPromotion to set
     */
    public void setSalesPromotion(Double salesPromotion) {
        this.salesPromotion = salesPromotion;
    }

    /**
     * @return the commission
     */
    public Double getCommission() {
         return commission != null ? commission : 0D;  
    }

    public String getCommissionStr() {
        return twoPlaces.format(commission);
    }

    /**
     * @param commission the commission to set
     */
    public void setCommission(Double commission) {
        this.commission = commission;
    }

    /**
     * @return the facturaId
     */
    public Long getFacturaId() {
        return facturaId;
    }

    /**
     * @param facturaId the facturaId to set
     */
    public void setFacturaId(Long facturaId) {
        this.facturaId = facturaId;
    }

    /**
     * @return the sales
     */
    public Double getSales() {
        return sales != null ? sales : 0D;
    }

    /**
     * @param sales the sales to set
     */
    public void setSales(Double sales) {
        this.sales = sales;
    }

    /**
     * @return the net2pay
     */
    public Double getNet2pay() {
         return net2pay != null ? net2pay : 0D; 
    }

    public String getNet2payStr() {
        return twoPlaces.format(net2pay);
    }

    /**
     * @param net2pay the net2pay to set
     */
    public void setNet2pay(Double net2pay) {
        this.net2pay = net2pay;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the reportFecha
     */
    public String getReportFecha() {
        if (reportFecha != null) {
            return df.format(reportFecha);
        } else {
            return "";
        }

    }

    /**
     * @param reportFecha the reportFecha to set
     */
    public void setReportFecha(Date reportFecha) {
        this.reportFecha = reportFecha;
    }

    /**
     * @return the reportClient
     */
    public String getReportClient() {
        return reportClient;
    }

    /**
     * @param reportClient the reportClient to set
     */
    public void setReportClient(String reportClient) {
        this.reportClient = reportClient;
    }

    /**
     * @return the reportStartDate
     */
    public String getReportStartDate() {
        if (reportStartDate != null) {
            return df.format(reportStartDate);
        } else {
            return "-";
        }
    }

    /**
     * @param reportStartDate the reportStartDate to set
     */
    public void setReportStartDate(Date reportStartDate) {
        this.reportStartDate = reportStartDate;
    }

    /**
     * @return the reportEndDate
     */
    public String getReportEndDate() {
        if (reportEndDate != null) {
            return df.format(reportEndDate);
        } else {
            return "-";
        }
    }

    /**
     * @param reportEndDate the reportEndDate to set
     */
    public void setReportEndDate(Date reportEndDate) {
        this.reportEndDate = reportEndDate;
    }

    /**
     * @return the reportTotalSales
     */
    public String getReportTotalSales() {
        return  twoPlaces.format(reportTotalSales);
    }

    /**
     * @param reportTotalSales the reportTotalSales to set
     */
    public void setReportTotalSales(Double reportTotalSales) {
        this.reportTotalSales = reportTotalSales;
    }

    /**
     * @return the reportTotalCommission
     */
    public String getReportTotalCommission() {
        return  twoPlaces.format(reportTotalCommission);
    }

    /**
     * @param reportTotalCommission the reportTotalCommission to set
     */
    public void setReportTotalCommission(Double reportTotalCommission) {
        this.reportTotalCommission = reportTotalCommission;
    }

    /**
     * @return the reportTotalNet2Pay
     */
    public String getReportTotalNet2Pay() {
        return  twoPlaces.format(reportTotalNet2Pay);
    }

    /**
     * @param reportTotalNet2Pay the reportTotalNet2Pay to set
     */
    public void setReportTotalNet2Pay(Double reportTotalNet2Pay) {
        this.reportTotalNet2Pay = reportTotalNet2Pay;
    }

    /**
     * @return the reportTotalSalesPromotion
     */
    public String getReportTotalSalesPromotion() {
        return  twoPlaces.format(reportTotalSalesPromotion);
    }

    /**
     * @param reportTotalSalesPromotion the reportTotalSalesPromotion to set
     */
    public void setReportTotalSalesPromotion(Double reportTotalSalesPromotion) {
        this.reportTotalSalesPromotion = reportTotalSalesPromotion;
    }

}
