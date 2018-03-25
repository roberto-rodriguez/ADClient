package common.persistence.model;

import common.persistence.dto.ReportData;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    private String moneda;
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
    private String codEstadoRemiteLabel;
    private String nomCiudadRemite;
    private String codCiudadRemite;

    //Destinatario
    private Long destinatarioId;
    private String nomDestinatario;
    private String telDestinatario;
    private String dirDestinatario;
    private String codPaisDestinatario;
    private String codPaisDestinatarioLabel;
    private String codEstadoDestinatario;
    private String codEstadoDestinatarioLabel;
    private String nomCiudadDestinatario;
    private String codCiudadDestinatario;
    private String numeroCuenta;

    //Para envios a Cuba
    private String fechaNacRemite;
    private String apellidoMaterno;
    private String numId;
    private String fechaExpiracion;
    private String tipoId;
    private String tipoIdIndex;
    private Boolean remitentePresente;
    private String relacionDestinatario;
    private String relacionDestinatarioIndex;
    private String declaracionRemitente;
    private String confirmacionFamilia;
    private String confirmacionNoGobierno;
    private String confirmacionNoProhibido;
    private String confirmacionNoEmigracion;

    private String formatAmount(String amount) {
        if (amount != null) {
            try {
                return String.format("%.2f", Double.parseDouble(amount));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return "";

    }

    public void complete() {
        this.zipRemite = dirPostalRemite;
        this.codCiudadRemite = trim(nomCiudadRemite);
        this.codCiudadDestinatario = trim(nomCiudadDestinatario);
    }

    private static String trim(String val) {
        if (val != null && val.length() > 5) {
            return val.substring(0, 5);
        }
        return val;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<PaymentCommand>");
        sb.append("    <montoEntregar>" + montoEntregar + "<montoEntregar>");
        sb.append("    <montoRealAEnviar>" + montoRealAEnviar + "<montoRealAEnviar>");
        sb.append("    <montoRealAPagar>" + montoRealAPagar + "<montoRealAPagar>");
        sb.append("    <totalPagar>" + totalPagar + "<totalPagar>");
        sb.append("    <dineroEntregado>" + dineroEntregado + "<dineroEntregado>");
        sb.append("    <tipoCambio>" + tipoCambio + "<tipoCambio>");
        sb.append("    <tasaDeCambio>" + tasaDeCambio + "<tasaDeCambio>");
        sb.append("    <tarifaTagId>" + tarifaTagId + "<tarifaTagId>");
        sb.append("</PaymentCommand>");

        return sb.toString();
    }

    public ReportData toReportData(String clavePago) {
        ReportData reportData = new ReportData();

        reportData.setFecha(dateFormat.format(new Date()));
        reportData.setMontoEnviado(getMontoRealAEnviarStr());
        reportData.setMoneda(moneda);
        reportData.setClavePago(clavePago);
        reportData.setPaisDestino(codPaisDestinatarioLabel);
        reportData.setPuntoDePago(codCorresponsalLabel);
        reportData.setFormaDeEntrega(formaPagoLabel);
        reportData.setTasaDeCambio(getTasaDeCambioStr());
        reportData.setMontoEntregar(getDineroEntregadoStr());

        reportData.setSenderName(nomRemite);
        reportData.setSenderAddress(dirRemite + " " + nomCiudadRemite + " " + codEstadoRemiteLabel + " " + dirPostalRemite);
        reportData.setSenderPhone(telRemite);

        reportData.setReceiverName(nomDestinatario);
        reportData.setReceiverPhone(telDestinatario);
        reportData.setReceiverAddress(dirDestinatario + " " + getNomCiudadDestinatario() + " " + codEstadoDestinatarioLabel + " " + codPaisDestinatarioLabel);

        reportData.setSentAmount(getMontoEntregarStr());
        reportData.setFee(getTipoCambioStr());
        reportData.setTotalPagar(getTotalPagarStr());

        return reportData;
    }

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
    public String getDineroEntregadoStr() {
        return formatAmount(dineroEntregado);
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
    public String getTipoCambioStr() {
        return formatAmount(tipoCambio);
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
    public String getMontoEntregarStr() { 
        return formatAmount(montoEntregar);
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

    public String getMontoRealAEnviarStr() { 
         return formatAmount(montoRealAEnviar);
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
    public String getMontoRealAPagarStr() {
        return formatAmount(montoRealAPagar);
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
    public String getTotalPagarStr() {
        return formatAmount(totalPagar);
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
    public String getTasaDeCambioStr() {
        return formatAmount(tasaDeCambio);
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

    /**
     * @return the apellidoMaterno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * @param apellidoMaterno the apellidoMaterno to set
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * @return the numId
     */
    public String getNumId() {
        return numId;
    }

    /**
     * @param numId the numId to set
     */
    public void setNumId(String numId) {
        this.numId = numId;
    }

    /**
     * @return the fechaExpiracion
     */
    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    /**
     * @param fechaExpiracion the fechaExpiracion to set
     */
    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    /**
     * @return the tipoId
     */
    public String getTipoId() {
        return tipoId;
    }

    /**
     * @param tipoId the tipoId to set
     */
    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    /**
     * @return the relacionDestinatario
     */
    public String getRelacionDestinatario() {
        return relacionDestinatario;
    }

    /**
     * @param relacionDestinatario the relacionDestinatario to set
     */
    public void setRelacionDestinatario(String relacionDestinatario) {
        this.relacionDestinatario = relacionDestinatario;
    }

    /**
     * @return the declaracionRemitente
     */
    public String getDeclaracionRemitente() {
        return declaracionRemitente;
    }

    /**
     * @param declaracionRemitente the declaracionRemitente to set
     */
    public void setDeclaracionRemitente(String declaracionRemitente) {
        this.declaracionRemitente = declaracionRemitente;
    }

    /**
     * @return the confirmacionFamilia
     */
    public String getConfirmacionFamilia() {
        return confirmacionFamilia;
    }

    /**
     * @param confirmacionFamilia the confirmacionFamilia to set
     */
    public void setConfirmacionFamilia(String confirmacionFamilia) {
        this.confirmacionFamilia = confirmacionFamilia;
    }

    /**
     * @return the confirmacionNoGobierno
     */
    public String getConfirmacionNoGobierno() {
        return confirmacionNoGobierno;
    }

    /**
     * @param confirmacionNoGobierno the confirmacionNoGobierno to set
     */
    public void setConfirmacionNoGobierno(String confirmacionNoGobierno) {
        this.confirmacionNoGobierno = confirmacionNoGobierno;
    }

    /**
     * @return the confirmacionNoProhibido
     */
    public String getConfirmacionNoProhibido() {
        return confirmacionNoProhibido;
    }

    /**
     * @param confirmacionNoProhibido the confirmacionNoProhibido to set
     */
    public void setConfirmacionNoProhibido(String confirmacionNoProhibido) {
        this.confirmacionNoProhibido = confirmacionNoProhibido;
    }

    /**
     * @return the confirmacionNoEmigracion
     */
    public String getConfirmacionNoEmigracion() {
        return confirmacionNoEmigracion;
    }

    /**
     * @param confirmacionNoEmigracion the confirmacionNoEmigracion to set
     */
    public void setConfirmacionNoEmigracion(String confirmacionNoEmigracion) {
        this.confirmacionNoEmigracion = confirmacionNoEmigracion;
    }

    /**
     * @return the fechaNacRemite
     */
    public String getFechaNacRemite() {
        return fechaNacRemite;
    }

    /**
     * @param fechaNacRemite the fechaNacRemite to set
     */
    public void setFechaNacRemite(String fechaNacRemite) {
        this.fechaNacRemite = fechaNacRemite;
    }

    /**
     * @return the remitentePresente
     */
    public Boolean getRemitentePresente() {
        return remitentePresente;
    }

    /**
     * @param remitentePresente the remitentePresente to set
     */
    public void setRemitentePresente(Boolean remitentePresente) {
        this.remitentePresente = remitentePresente;
    }

    /**
     * @return the tipoIdIndex
     */
    public String getTipoIdIndex() {
        return tipoIdIndex;
    }

    /**
     * @param tipoIdIndex the tipoIdIndex to set
     */
    public void setTipoIdIndex(String tipoIdIndex) {
        this.tipoIdIndex = tipoIdIndex;
    }

    /**
     * @return the relacionDestinatarioIndex
     */
    public String getRelacionDestinatarioIndex() {
        return relacionDestinatarioIndex;
    }

    /**
     * @param relacionDestinatarioIndex the relacionDestinatarioIndex to set
     */
    public void setRelacionDestinatarioIndex(String relacionDestinatarioIndex) {
        this.relacionDestinatarioIndex = relacionDestinatarioIndex;
    }

    /**
     * @return the codEstadoRemiteLabel
     */
    public String getCodEstadoRemiteLabel() {
        return codEstadoRemiteLabel;
    }

    /**
     * @param codEstadoRemiteLabel the codEstadoRemiteLabel to set
     */
    public void setCodEstadoRemiteLabel(String codEstadoRemiteLabel) {
        this.codEstadoRemiteLabel = codEstadoRemiteLabel;
    }

    /**
     * @return the codEstadoDestinatarioLabel
     */
    public String getCodEstadoDestinatarioLabel() {
        return codEstadoDestinatarioLabel;
    }

    /**
     * @param codEstadoDestinatarioLabel the codEstadoDestinatarioLabel to set
     */
    public void setCodEstadoDestinatarioLabel(String codEstadoDestinatarioLabel) {
        this.codEstadoDestinatarioLabel = codEstadoDestinatarioLabel;
    }

    /**
     * @return the codPaisDestinatarioLabel
     */
    public String getCodPaisDestinatarioLabel() {
        return codPaisDestinatarioLabel;
    }

    /**
     * @param codPaisDestinatarioLabel the codPaisDestinatarioLabel to set
     */
    public void setCodPaisDestinatarioLabel(String codPaisDestinatarioLabel) {
        this.codPaisDestinatarioLabel = codPaisDestinatarioLabel;
    }

    /**
     * @return the codCiudadRemite
     */
    public String getCodCiudadRemite() {
        return codCiudadRemite;
    }

    /**
     * @param codCiudadRemite the codCiudadRemite to set
     */
    public void setCodCiudadRemite(String codCiudadRemite) {
        this.codCiudadRemite = codCiudadRemite;
    }

    /**
     * @return the codCiudadDestinatario
     */
    public String getCodCiudadDestinatario() {
        return codCiudadDestinatario;
    }

    /**
     * @param codCiudadDestinatario the codCiudadDestinatario to set
     */
    public void setCodCiudadDestinatario(String codCiudadDestinatario) {
        this.codCiudadDestinatario = codCiudadDestinatario;
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
