package common.display;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;

/**
 * @author @Roberto Rodriguez :: <RobertoSoftwareEngineer@gmail.com>
 */
public class ReportItem implements Serializable {

    public static final DecimalFormat twoPlaces = new DecimalFormat("0.00");
    public static final DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm");
    public static final DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
    private Long facturaId;

    private String product;
    private Integer quantity;
    private Double sales;
    private Double commission;
    private Double net2pay; 
    private Double freeDollar;

    private Date reportDate;
    private String reportNumber;

    private String name;
    private String lastName;
    private String storeAddress;

    private Integer totalQuantity;
    private Double totalSalesPromotion;
    private Double totalSales;
    private Double totalNet2Pay;
    private Double totalCommission;

    private Date startDate;
    private Date endDate;

    private String startDateStr;
    private String endDateStr;

    private String loginId;

    private Integer quantityPurchaseBalance;
    private Double purchaseBalance;

    public ReportItem() {
    }

    public ReportItem(OriginRow originRow) {
        this.product = originRow.getTransactionType();
        this.quantity = originRow.getQuantity();

        this.sales = originRow.getTotalSales();
        this.freeDollar = originRow.getTotalPromotion();
    }

    private String getDoubleString(Double d) {
        String str = "0.00";
        if (d != null) {
            str = twoPlaces.format(d);
        }

        return str;
    }

//    private String getToday() {
//        Date d = new Date();
//        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
//        return df.format(d);
//    }
//    public ReportItem(Integer quantity, String product, Double sales, Double freeDollar, Double salesPayment) {
//        this.quantity = quantity;
//        this.product = product;
//        this.sales = sales;
//        this.freeDollar = freeDollar;
//        this.salesPayment = salesPayment;
//    }
    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber;
    }

    /**
     * @return the reportDate
     */
    public Date getReportDate() {
        return reportDate;
    }

    public String getFecha() {
        if (reportDate != null) {
            return dateFormat.format(reportDate);
        } else {
            return "";
        }
    }

    /**
     * @param reportDate the reportDate to set
     */
    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    /**
     * @return the reportNumber
     */
    public String getReportNumber() {
        return reportNumber;
    }

    /**
     * @return the storeAddress
     */
    public String getStoreAddress() {
        return storeAddress;
    }

    /**
     * @param storeAddress the storeAddress to set
     */
    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    /**
     * @return the commission
     */
    public Double getCommission() {
        return commission;
    }

    /**
     * @param commission the commission to set
     */
    public void setCommission(Double commission) {
        this.commission = commission;
    }

    /**
     * @return the sales
     */
    public Double getSales() {
        return sales;
    }

    /**
     * @param sales the sales to set
     */
    public void setSales(Double sales) {
        this.sales = sales;
    }

    /**
     * @return the freeDollar
     */
    public Double getFreeDollar() {
        return freeDollar;
    }

    /**
     * @param freeDollar the freeDollar to set
     */
    public void setFreeDollar(Double freeDollar) {
        this.freeDollar = freeDollar;
    }

    /**
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the product
     */
    public String getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(String product) {
        this.product = product;
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

    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the loginId
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * @param loginId the loginId to set
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * @return the totalSalesPromotion
     */
    public Double getTotalSalesPromotion() {
        return totalSalesPromotion;
    }

    /**
     * @param totalSalesPromotion the totalSalesPromotion to set
     */
    public void setTotalSalesPromotion(Double totalSalesPromotion) {
        this.totalSalesPromotion = totalSalesPromotion;
    }

    /**
     * @return the totalCommission
     */
    public Double getTotalCommission() {
        return totalCommission;
    }

    /**
     * @param totalCommission the totalCommission to set
     */
    public void setTotalCommission(Double totalCommission) {
        this.totalCommission = totalCommission;
    }

    /**
     * @return the net2pay
     */
    public Double getNet2pay() {
        return net2pay;
    }
    
    public String getNet2payStr() {
        if(net2pay < 0){
           return "(" + net2pay + ")"; 
        }else{
            return net2pay + "";
        }
        
    }

    /**
     * @param net2pay the net2pay to set
     */
    public void setNet2pay(Double net2pay) {
        this.net2pay = net2pay;
    }

    /**
     * @return the totalNet2Pay
     */
    public Double getTotalNet2Pay() {
        return totalNet2Pay;
    }

    /**
     * @param totalNet2Pay the totalNet2Pay to set
     */
    public void setTotalNet2Pay(Double totalNet2Pay) {
        this.totalNet2Pay = totalNet2Pay;
    }

    /**
     * @return the totalSales
     */
    public Double getTotalSales() {
        return totalSales;
    }

    /**
     * @param totalSales the totalSales to set
     */
    public void setTotalSales(Double totalSales) {
        this.totalSales = totalSales;
    }

    /**
     * @return the totalQuantity
     */
    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    /**
     * @param totalQuantity the totalQuantity to set
     */
    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
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
        this.setStartDateStr(df.format(startDate));
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
        this.setEndDateStr(df.format(endDate));
    }

    /**
     * @return the startDateStr
     */
    public String getStartDateStr() {
        return startDateStr;
    }

    /**
     * @param startDateStr the startDateStr to set
     */
    public void setStartDateStr(String startDateStr) {
        this.startDateStr = startDateStr;
    }

    /**
     * @return the endDateStr
     */
    public String getEndDateStr() {
        return endDateStr;
    }

    /**
     * @param endDateStr the endDateStr to set
     */
    public void setEndDateStr(String endDateStr) {
        this.endDateStr = endDateStr;
    }

    /**
     * @return the totalNet2PayStr
     */
    public String getTotalNet2PayStr() {
        return getDoubleString(totalNet2Pay);
    }

    /**
     * @return the totalCommissionStr
     */
    public String getTotalCommissionStr() {
        return getDoubleString(totalCommission);
    }

    /**
     * @return the quantityPurchaseBalance
     */
    public Integer getQuantityPurchaseBalance() {
        return quantityPurchaseBalance;
    }

    /**
     * @param quantityPurchaseBalance the quantityPurchaseBalance to set
     */
    public void setQuantityPurchaseBalance(Integer quantityPurchaseBalance) {
        this.quantityPurchaseBalance = quantityPurchaseBalance;
    }

    /**
     * @return the purchaseBalance
     */
    public Double getPurchaseBalance() {
        return purchaseBalance;
    }
    
     public String getPurchaseBalanceStr() {
        return "(" + purchaseBalance + ")";
    }

    /**
     * @param purchaseBalance the purchaseBalance to set
     */
    public void setPurchaseBalance(Double purchaseBalance) {
        this.purchaseBalance = purchaseBalance;
    }

}
