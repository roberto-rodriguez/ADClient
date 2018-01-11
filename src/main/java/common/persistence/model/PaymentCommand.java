package common.persistence.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat; 

/**
 * @author @Roberto Rodriguez :: <RobertoSoftwareEngineer@gmail.com>
 */
public class PaymentCommand implements Serializable {
    private static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

    /**
     * @return the dateFormat
     */
    public static DateFormat getDateFormat() {
        return dateFormat;
    }

    /**
     * @param aDateFormat the dateFormat to set
     */
    public static void setDateFormat(DateFormat aDateFormat) {
        dateFormat = aDateFormat;
    }
    
    private String agenciaOrigen;
    //Tarifas 
    private String codCorresponsal;
    private String codCorresponsalLabel;
    private String formaPago;
    private String formaPagoLabel;
    private String dineroEntregado;
    private String incluyeComision;

   // private String tarifa;
    private String tarifaTagId;
    private String tipoCambio;
    private String tasaDeCambio;

    private String montoEntregar;
    private String montoRealAEnviar;
    private String montoRealAPagar;
    private String totalPagar;

    //Remitente
    private String nomRemite;
    private String telRemite;
    private String dirRemite;
    private String zipRemite;
    private String dirPostalRemite;
    private String codEstadoRemite;
    private String nomCiudadRemite;

    //Destinatario
    private Long destinatarioId;
    private String nomDestinatario;
    private String telDestinatario;
    private String dirDestinatario;
    private String codPaisDestinatario;
    private String codEstadoDestinatario;
    private String nomCiudadDestinatario;
    private String numeroCuenta;

    public void complete(){
        this.zipRemite = dirPostalRemite;
    }
    
    //TODO include Agencia Origen
//    public String toUrl() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("&codCorresponsal=" + corresponsal);
//        sb.append("&codCiudadRemite=" + remitenteCiudad);
//        sb.append("&codCiudadDestinatario=" + destinatarioCiudad);
//        sb.append("&dirRemite=" + remitenteDireccion);
//        sb.append("&dirDestinatario=" + destinatarioDireccion);
//        sb.append("&tipoCambio=" + tasaDeCambio);
//        sb.append("&totalPagar=" + totalPagar);
//        sb.append("&dineroEntregado=" + montoRealAEnviar);
//        sb.append("&montoEntregar=" + montoRealAPagar);
//        sb.append("&nomRemite=" + remitenteNombre);
//        sb.append("&nomDestinatario=" + destinatarioNombre);
//        sb.append("&telRemite=" + remitenteTelefono);
//        sb.append("&telDestinatario=" + destinatarioTelefono);
//        sb.append("&zipRemite=" + remitenteZipcode);
//        sb.append("&codEstadoRemite=" + remitenteEstado);
//        sb.append("&codEstadoDestinatario=" + destinatarioEstado);
//        sb.append("&codPaisDestinatario=" + destinatarioPais);
//        sb.append("&nomCiudadRemite=" + remitenteCiudad);
//        sb.append("&nomCiudadDestinatario=" + destinatarioCiudad);
//        sb.append("&numeroCuenta=" + numeroDeCuenta);
//        sb.append("&formaPago=" + formaPago);
//        sb.append("&incluyeComision=" + incluyeComision);
//        sb.append("&tarifaTagId=" + tarifaTagId); 
//        sb.append("&fecha=" + dateFormat.format(new Date()));
//         
//        return sb.toString();
//    }

    /**
     * @return the agenciaOrigen
     */
    public String getAgenciaOrigen() {
        return agenciaOrigen;
    }

    /**
     * @param agenciaOrigen the agenciaOrigen to set
     */
    public void setAgenciaOrigen(String agenciaOrigen) {
        this.agenciaOrigen = agenciaOrigen;
    }

    /**
     * @return the codCorresponsal
     */
    public String getCodCorresponsal() {
        return codCorresponsal;
    }

    /**
     * @param codCorresponsal the codCorresponsal to set
     */
    public void setCodCorresponsal(String codCorresponsal) {
        this.codCorresponsal = codCorresponsal;
    }

    /**
     * @return the formaPago
     */
    public String getFormaPago() {
        return formaPago;
    }

    /**
     * @param formaPago the formaPago to set
     */
    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    /**
     * @return the dineroEntregado
     */
    public String getDineroEntregado() {
        return dineroEntregado;
    }

    /**
     * @param dineroEntregado the dineroEntregado to set
     */
    public void setDineroEntregado(String dineroEntregado) {
        this.dineroEntregado = dineroEntregado;
    }

    /**
     * @return the incluyeComision
     */
    public String getIncluyeComision() {
        return incluyeComision;
    }

    /**
     * @param incluyeComision the incluyeComision to set
     */
    public void setIncluyeComision(String incluyeComision) {
        this.incluyeComision = incluyeComision;
    }

    /**
     * @return the tarifaTagId
     */
    public String getTarifaTagId() {
        return tarifaTagId;
    }

    /**
     * @param tarifaTagId the tarifaTagId to set
     */
    public void setTarifaTagId(String tarifaTagId) {
        this.tarifaTagId = tarifaTagId;
    }

    /**
     * @return the tipoCambio
     */
    public String getTipoCambio() {
        return tipoCambio;
    }

    /**
     * @param tipoCambio the tipoCambio to set
     */
    public void setTipoCambio(String tipoCambio) {
        this.tipoCambio = tipoCambio;
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
     * @return the montoRealAEnviar
     */
    public String getMontoRealAEnviar() {
        return montoRealAEnviar;
    }

    /**
     * @param montoRealAEnviar the montoRealAEnviar to set
     */
    public void setMontoRealAEnviar(String montoRealAEnviar) {
        this.montoRealAEnviar = montoRealAEnviar;
    }

    /**
     * @return the montoRealAPagar
     */
    public String getMontoRealAPagar() {
        return montoRealAPagar;
    }

    /**
     * @param montoRealAPagar the montoRealAPagar to set
     */
    public void setMontoRealAPagar(String montoRealAPagar) {
        this.montoRealAPagar = montoRealAPagar;
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
     * @return the nomRemite
     */
    public String getNomRemite() {
        return nomRemite;
    }

    /**
     * @param nomRemite the nomRemite to set
     */
    public void setNomRemite(String nomRemite) {
        this.nomRemite = nomRemite;
    }

    /**
     * @return the telRemite
     */
    public String getTelRemite() {
        return telRemite;
    }

    /**
     * @param telRemite the telRemite to set
     */
    public void setTelRemite(String telRemite) {
        this.telRemite = telRemite;
    }
 
    /**
     * @return the zipRemite
     */
    public String getZipRemite() {
        return zipRemite;
    }

    /**
     * @param zipRemite the zipRemite to set
     */
    public void setZipRemite(String zipRemite) {
        this.zipRemite = zipRemite;
    }

    /**
     * @return the dirPostalRemite
     */
    public String getDirPostalRemite() {
        return dirPostalRemite;
    }

    /**
     * @param dirPostalRemite the dirPostalRemite to set
     */
    public void setDirPostalRemite(String dirPostalRemite) {
        this.dirPostalRemite = dirPostalRemite;
    }

    /**
     * @return the codEstadoRemite
     */
    public String getCodEstadoRemite() {
        return codEstadoRemite;
    }

    /**
     * @param codEstadoRemite the codEstadoRemite to set
     */
    public void setCodEstadoRemite(String codEstadoRemite) {
        this.codEstadoRemite = codEstadoRemite;
    }

    /**
     * @return the nomCiudadRemite
     */
    public String getNomCiudadRemite() {
        return nomCiudadRemite;
    }

    /**
     * @param nomCiudadRemite the nomCiudadRemite to set
     */
    public void setNomCiudadRemite(String nomCiudadRemite) {
        this.nomCiudadRemite = nomCiudadRemite;
    }

    /**
     * @return the destinatarioId
     */
    public Long getDestinatarioId() {
        return destinatarioId;
    }

    /**
     * @param destinatarioId the destinatarioId to set
     */
    public void setDestinatarioId(Long destinatarioId) {
        this.destinatarioId = destinatarioId;
    }

    /**
     * @return the nomDestinatario
     */
    public String getNomDestinatario() {
        return nomDestinatario;
    }

    /**
     * @param nomDestinatario the nomDestinatario to set
     */
    public void setNomDestinatario(String nomDestinatario) {
        this.nomDestinatario = nomDestinatario;
    }

    /**
     * @return the telDestinatario
     */
    public String getTelDestinatario() {
        return telDestinatario;
    }

    /**
     * @param telDestinatario the telDestinatario to set
     */
    public void setTelDestinatario(String telDestinatario) {
        this.telDestinatario = telDestinatario;
    }

    /**
     * @return the dirDestinatario
     */
    public String getDirDestinatario() {
        return dirDestinatario;
    }

    /**
     * @param dirDestinatario the dirDestinatario to set
     */
    public void setDirDestinatario(String dirDestinatario) {
        this.dirDestinatario = dirDestinatario;
    }

     

    /**
     * @return the codEstadoDestinatario
     */
    public String getCodEstadoDestinatario() {
        return codEstadoDestinatario;
    }

    /**
     * @param codEstadoDestinatario the codEstadoDestinatario to set
     */
    public void setCodEstadoDestinatario(String codEstadoDestinatario) {
        this.codEstadoDestinatario = codEstadoDestinatario;
    }

    /**
     * @return the nomCiudadDestinatario
     */
    public String getNomCiudadDestinatario() {
        return nomCiudadDestinatario;
    }

    /**
     * @param nomCiudadDestinatario the nomCiudadDestinatario to set
     */
    public void setNomCiudadDestinatario(String nomCiudadDestinatario) {
        this.nomCiudadDestinatario = nomCiudadDestinatario;
    }

   

    /**
     * @return the codPaisDestinatario
     */
    public String getCodPaisDestinatario() {
        return codPaisDestinatario;
    }

    /**
     * @param codPaisDestinatario the codPaisDestinatario to set
     */
    public void setCodPaisDestinatario(String codPaisDestinatario) {
        this.codPaisDestinatario = codPaisDestinatario;
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
     * @return the codCorresponsalLabel
     */
    public String getCodCorresponsalLabel() {
        return codCorresponsalLabel;
    }

    /**
     * @param codCorresponsalLabel the codCorresponsalLabel to set
     */
    public void setCodCorresponsalLabel(String codCorresponsalLabel) {
        this.codCorresponsalLabel = codCorresponsalLabel;
    }

    /**
     * @return the formaPagoLabel
     */
    public String getFormaPagoLabel() {
        return formaPagoLabel;
    }

    /**
     * @param formaPagoLabel the formaPagoLabel to set
     */
    public void setFormaPagoLabel(String formaPagoLabel) {
        this.formaPagoLabel = formaPagoLabel;
    }

    /**
     * @return the dirRemite
     */
    public String getDirRemite() {
        return dirRemite;
    }

    /**
     * @param dirRemite the dirRemite to set
     */
    public void setDirRemite(String dirRemite) {
        this.dirRemite = dirRemite;
    }

    /**
     * @return the numeroCuenta
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * @param numeroCuenta the numeroCuenta to set
     */
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    
    
      }
