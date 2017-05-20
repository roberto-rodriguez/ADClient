package common.persistence.domain;

import static common.display.ReportItem.dateFormat;
import static common.display.ReportItem.df;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

/**
 * @author @Roberto Rodriguez :: <RobertoSoftwareEngineer@gmail.com>
 */
@Entity
@Table(name = "factura")
@XmlRootElement
public class Factura { 
    @Id
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
    @SequenceGenerator(name = "pk_sequence", sequenceName = "factura_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @Generated(GenerationTime.INSERT)
    private Long id;

    @Column(name = "number")
    private String number;
    
    @Column(name = "creation_date")
    private Date creationDate;
    
    @Column(name = "start_date")
    private Date startDate;
    
    @Column(name = "end_date")
    private Date endDate;
  
    @Column(name = "sales")
    private Double sales;
    @Column(name = "net2pay")
    private Double net2pay;
    @Column(name = "commission")
    private Double commission; 
    @Column(name = "sales_promotion")
    private Double salesPromotion; 
    @Column(name = "quantity")
    private Integer quantity; 
    @Column(name = "quantity_purchase_balance")
    private Integer quantityPurchaseBalance;
    @Column(name = "purchase_balance")
    private Double purchaseBalance;

    @ManyToOne
    @JoinColumn(name = "store")
    private Store store;
     
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "factura", cascade=CascadeType.REMOVE)
    private List<FacturaItem> items;
    
    public void createReportNumber(Integer index) {
        DateFormat df = new SimpleDateFormat("MMdd");
        this.number = "ALO-" + df.format(new Date()) + String.format("%03d", index);
    }
    
    public String getStartDateStr(){
        return df.format(startDate);
    }
    
      public String getFecha() {
        if (creationDate != null) {
            return dateFormat.format(creationDate);
        } else {
            return "";
        }
    }
    
    public String getEndDateStr(){
        return df.format(endDate);
    }
    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @return the creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
 

    /**
     * @return the store
     */
    public Store getStore() {
        return store;
    }

    /**
     * @param store the store to set
     */
    public void setStore(Store store) {
        this.store = store;
    }

    /**
     * @return the items
     */
    public List<FacturaItem> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<FacturaItem> items) {
        this.items = items;
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
     * @return the salesPromotion
     */
    public Double getSalesPromotion() {
        return salesPromotion;
    }

    /**
     * @param salesPromotion the salesPromotion to set
     */
    public void setSalesPromotion(Double salesPromotion) {
        this.salesPromotion = salesPromotion;
    }

    /**
     * @return the net2pay
     */
    public Double getNet2pay() {
        return net2pay;
    }

    /**
     * @param net2pay the net2pay to set
     */
    public void setNet2pay(Double net2pay) {
        this.net2pay = net2pay;
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

    /**
     * @param purchaseBalance the purchaseBalance to set
     */
    public void setPurchaseBalance(Double purchaseBalance) {
        this.purchaseBalance = purchaseBalance;
    }
 
 
}
