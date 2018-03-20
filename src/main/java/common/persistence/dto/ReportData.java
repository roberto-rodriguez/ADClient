/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common.persistence.dto;

/**
 *
 * @author rrodriguez
 */
public class ReportData {

    private String moneda;  
    private String codEnvio;  //From response
    private String fecha;
    private String montoEnviado;
    private String clavePago;
    private String paisDestino ;
    private String puntoDePago;
    private String formaDeEntrega;
    private String tasaDeCambio;
    private String montoEntregar;
    
    private String senderName;
    private String senderAddress;
    private String senderPhone;
    
    private String receiverName;
    private String receiverPhone;
    private String receiverAddress;
    
    private String sentAmount;
    private String fee;
    private String totalPagar;

    
    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the montoEnviado
     */
    public String getMontoEnviado() {
        return montoEnviado;
    }

    /**
     * @param montoEnviado the montoEnviado to set
     */
    public void setMontoEnviado(String montoEnviado) {
        this.montoEnviado = montoEnviado;
    }

    /**
     * @return the clavePago
     */
    public String getClavePago() {
        return clavePago == null ? "" : clavePago;
    }

    /**
     * @param clavePago the clavePago to set
     */
    public void setClavePago(String clavePago) {
        this.clavePago = clavePago;
    }

    /**
     * @return the paisDestino
     */
    public String getPaisDestino() {
        return paisDestino;
    }

    /**
     * @param paisDestino the paisDestino to set
     */
    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    /**
     * @return the puntoDePago
     */
    public String getPuntoDePago() {
        return puntoDePago;
    }

    /**
     * @param puntoDePago the puntoDePago to set
     */
    public void setPuntoDePago(String puntoDePago) {
        this.puntoDePago = puntoDePago;
    }

    /**
     * @return the formaDeEntrega
     */
    public String getFormaDeEntrega() {
        return formaDeEntrega;
    }

    /**
     * @param formaDeEntrega the formaDeEntrega to set
     */
    public void setFormaDeEntrega(String formaDeEntrega) {
        this.formaDeEntrega = formaDeEntrega;
    }

    /**
     * @return the tasaDeCambio
     */
    public String getTasaDeCambio() {
        return tasaDeCambio;
    }

    /**
     * @param tasaDeCambio the tasaDeCambio to set
     */
    public void setTasaDeCambio(String tasaDeCambio) {
        this.tasaDeCambio = tasaDeCambio;
    }

    /**
     * @return the montoEntregar
     */
    public String getMontoEntregar() {
        return montoEntregar;
    }

    /**
     * @param montoEntregar the montoEntregar to set
     */
    public void setMontoEntregar(String montoEntregar) {
        this.montoEntregar = montoEntregar;
    }

    /**
     * @return the senderName
     */
    public String getSenderName() {
        return senderName;
    }

    /**
     * @param senderName the senderName to set
     */
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    /**
     * @return the senderAddress
     */
    public String getSenderAddress() {
        return senderAddress;
    }

    /**
     * @param senderAddress the senderAddress to set
     */
    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    /**
     * @return the senderPhone
     */
    public String getSenderPhone() {
        return senderPhone;
    }

    /**
     * @param senderPhone the senderPhone to set
     */
    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    /**
     * @return the receiverName
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * @param receiverName the receiverName to set
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    /**
     * @return the receiverPhone
     */
    public String getReceiverPhone() {
        return receiverPhone;
    }

    /**
     * @param receiverPhone the receiverPhone to set
     */
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    /**
     * @return the receiverAddress
     */
    public String getReceiverAddress() {
        return receiverAddress;
    }

    /**
     * @param receiverAddress the receiverAddress to set
     */
    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    /**
     * @return the sentAmount
     */
    public String getSentAmount() {
        return sentAmount;
    }

    /**
     * @param sentAmount the sentAmount to set
     */
    public void setSentAmount(String sentAmount) {
        this.sentAmount = sentAmount;
    }

    /**
     * @return the fee
     */
    public String getFee() {
        return fee;
    }

    /**
     * @param fee the fee to set
     */
    public void setFee(String fee) {
        this.fee = fee;
    }

    /**
     * @return the totalPagar
     */
    public String getTotalPagar() {
        return totalPagar;
    }

    /**
     * @param totalPagar the totalPagar to set
     */
    public void setTotalPagar(String totalPagar) {
        this.totalPagar = totalPagar;
    }

    /**
     * @return the codEnvio
     */
    public String getCodEnvio() {
        return codEnvio;
    }

    /**
     * @param codEnvio the codEnvio to set
     */
    public void setCodEnvio(String codEnvio) {
        this.codEnvio = codEnvio;
    }

    /**
     * @return the moneda
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     * @param moneda the moneda to set
     */
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
}
