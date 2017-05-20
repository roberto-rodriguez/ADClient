package common.persistence.domain;

import common.display.OriginRow;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

/**
 * @author @Roberto Rodriguez :: <RobertoSoftwareEngineer@gmail.com>
 */
@Entity
@Table(name = "factura_item")
@XmlRootElement
public class FacturaItem {

    @Id
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
    @SequenceGenerator(name = "pk_sequence", sequenceName = "factura_item_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @Generated(GenerationTime.INSERT)
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "product")
    private String product;
    @Column(name = "sales")
    private Double sales;
    @Column(name = "commission")
    private Double commission;
    @Column(name = "net2pay")
    private Double net2pay;
    @Column(name = "free_dollar")
    private Double freeDollar;

    @ManyToOne
    @JoinColumn(name = "factura")
    private Factura factura;

    public FacturaItem() {
    }

    public FacturaItem(OriginRow originRow) {
        this.product = originRow.getTransactionType();
        this.quantity = originRow.getQuantity();
        this.sales = originRow.getTotalSales();
        this.freeDollar = originRow.getTotalPromotion();
        this.net2pay = originRow.getNet2pay();
        this.setCommission(originRow.getCommission());
    }

    public String getNet2payStr() {
        if (net2pay < 0) {
            return "(" + net2pay + ")";
        } else {
            return net2pay + "";
        }

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
     * @return the factura
     */
    public Factura getFactura() {
        return factura;
    }

    /**
     * @param factura the factura to set
     */
    public void setFactura(Factura factura) {
        this.factura = factura;
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

}
