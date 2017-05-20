package common.display;

/**
 * @author @Roberto Rodriguez :: <RobertoSoftwareEngineer@gmail.com>
 */
public class OriginRow {

    private String name;
    private String login;
    private Integer quantity;
    private String transactionType;
    private Double totalTransaction;
    private Double totalPromotion;
    private Double totalSales;
    private Double net2pay;
    private Double commission;

    public OriginRow(String name, String login, String quantity, String transactionType, String totalTransaction, String totalPromotion, String totalSales, String commission) {
        this.name = name;
        this.login = login;
        this.quantity = getInteger(quantity);
        this.transactionType = transactionType;
        this.totalTransaction = getDouble(totalTransaction);
        this.totalPromotion = getDouble(totalPromotion);
        this.totalSales = getDouble(totalSales);
        this.commission = getDouble(commission);
    }

    @Override
    public String toString() {
        return "[ name: " + name + ", login: " + login + ", quantity: " + quantity + ", transactionType: " + transactionType + ", totalTransaction: " + totalTransaction + ", totalPromotion: " + totalPromotion + ", totalSales: " + totalSales + ", commission: " + commission + "]";
    }

    private Double getDouble(String str) {
        Double d = 0.0;
        if (str != null && !str.isEmpty()) {
            d = Double.parseDouble(str);
        }
        return d;
    }

    private Integer getInteger(String str) {
        Integer d = 0;
        if (str != null && !str.isEmpty()) {
            d = Integer.parseInt(str);
        }
        return d;
    }

    public OriginRow() {
    }

    /**
     * @return the name
     */
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
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the transactionType
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * @param transactionType the transactionType to set
     */
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * @return the totalTransaction
     */
    public Double getTotalTransaction() {
        return totalTransaction;
    }

    /**
     * @param totalTransaction the totalTransaction to set
     */
    public void setTotalTransaction(String totalTransaction) {
        this.totalTransaction = getDouble(totalTransaction);
    }

    /**
     * @return the totalPromotion
     */
    public Double getTotalPromotion() {
        return totalPromotion;
    }

    /**
     * @param totalPromotion the totalPromotion to set
     */
    public void setTotalPromotion(String totalPromotion) {
        this.totalPromotion = getDouble(totalPromotion);
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
    public void setTotalSales(String totalSales) {
        this.totalSales = getDouble(totalSales);
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
    public void setCommission(String commission) {
        this.commission = getDouble(commission);
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
    public void setQuantity(String quantity) {
        this.quantity = getInteger(quantity);
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
    public void setNet2pay(String net2pay) {
        this.net2pay = getDouble(net2pay);
    }
}
