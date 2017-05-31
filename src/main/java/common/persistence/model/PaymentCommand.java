package common.persistence.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date; 

/**
 * @author @Roberto Rodriguez :: <RobertoSoftwareEngineer@gmail.com>
 */
public class PaymentCommand implements Serializable {
    private static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    
    private String agenciaOrigen;
    //Tarifas
    private String pais;
    private String corresponsal;
    private String formaDeEntrega;
    private String montoAEnviar;
    private String tarifaIncluida;

    private String tarifa;
    private String tarifaTagId;
    private String tasaDeCambio;

    private String montoRealAEnviar;
    private String montoRealAPagar;
    private String totalAPagar;

    //Remitente
    private String remitenteNombre;
    private String remitenteTelefono;
    private String remitenteDireccion;
    private String remitenteZipcode;
    private String remitenteEstado;
    private String remitenteCiudad;

    //Destinatario
    private Long destinatarioId;
    private String destinatarioNombre;
    private String destinatarioTelefono;
    private String destinatarioDireccion;
    private String destinatarioPais;
    private String destinatarioEstado;
    private String destinatarioCiudad;
    private String numeroDeCuenta;

    //TODO include Agencia Origen
    public String toUrl() {
        StringBuilder sb = new StringBuilder();
        sb.append("&codCorresponsal=" + corresponsal);
        sb.append("&codCiudadRemite=" + remitenteCiudad);
        sb.append("&codCiudadDestinatario=" + destinatarioCiudad);
        sb.append("&dirRemite=" + remitenteDireccion);
        sb.append("&dirDestinatario=" + destinatarioDireccion);
        sb.append("&tipoCambio=" + tasaDeCambio);
        sb.append("&totalPagar=" + totalAPagar);
        sb.append("&dineroEntregado=" + montoRealAEnviar);
        sb.append("&montoEntregar=" + montoRealAPagar);
        sb.append("&nomRemite=" + remitenteNombre);
        sb.append("&nomDestinatario=" + destinatarioNombre);
        sb.append("&telRemite=" + remitenteTelefono);
        sb.append("&telDestinatario=" + destinatarioTelefono);
        sb.append("&zipRemite=" + remitenteZipcode);
        sb.append("&codEstadoRemite=" + remitenteEstado);
        sb.append("&codEstadoDestinatario=" + destinatarioEstado);
        sb.append("&codPaisDestinatario=" + destinatarioPais);
        sb.append("&nomCiudadRemite=" + remitenteCiudad);
        sb.append("&nomCiudadDestinatario=" + destinatarioCiudad);
        sb.append("&numeroCuenta=" + numeroDeCuenta);
        sb.append("&formaPago=" + formaDeEntrega);
        sb.append("&incluyeComision=" + tarifaIncluida);
        sb.append("&tarifaTagId=" + tarifaTagId); 
        sb.append("&fecha=" + dateFormat.format(new Date()));
         
        return sb.toString();
    }
     
    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
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
     * @return the montoAEnviar
     */
    public String getMontoAEnviar() {
        return montoAEnviar;
    }

    /**
     * @param montoAEnviar the montoAEnviar to set
     */
    public void setMontoAEnviar(String montoAEnviar) {
        this.montoAEnviar = montoAEnviar;
    }

    /**
     * @return the tarifa
     */
    public String getTarifa() {
        return tarifa;
    }

    /**
     * @param tarifa the tarifa to set
     */
    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
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
     * @return the totalAPagar
     */
    public String getTotalAPagar() {
        return totalAPagar;
    }

    /**
     * @param totalAPagar the totalAPagar to set
     */
    public void setTotalAPagar(String totalAPagar) {
        this.totalAPagar = totalAPagar;
    }

    /**
     * @return the remitenteNombre
     */
    public String getRemitenteNombre() {
        return remitenteNombre;
    }

    /**
     * @param remitenteNombre the remitenteNombre to set
     */
    public void setRemitenteNombre(String remitenteNombre) {
        this.remitenteNombre = remitenteNombre;
    }

    /**
     * @return the remitenteTelefono
     */
    public String getRemitenteTelefono() {
        return remitenteTelefono;
    }

    /**
     * @param remitenteTelefono the remitenteTelefono to set
     */
    public void setRemitenteTelefono(String remitenteTelefono) {
        this.remitenteTelefono = remitenteTelefono;
    }

    /**
     * @return the remitenteZipcode
     */
    public String getRemitenteZipcode() {
        return remitenteZipcode;
    }

    /**
     * @param remitenteZipcode the remitenteZipcode to set
     */
    public void setRemitenteZipcode(String remitenteZipcode) {
        this.remitenteZipcode = remitenteZipcode;
    }

    /**
     * @return the remitenteEstado
     */
    public String getRemitenteEstado() {
        return remitenteEstado;
    }

    /**
     * @param remitenteEstado the remitenteEstado to set
     */
    public void setRemitenteEstado(String remitenteEstado) {
        this.remitenteEstado = remitenteEstado;
    }

    /**
     * @return the remitenteCiudad
     */
    public String getRemitenteCiudad() {
        return remitenteCiudad;
    }

    /**
     * @param remitenteCiudad the remitenteCiudad to set
     */
    public void setRemitenteCiudad(String remitenteCiudad) {
        this.remitenteCiudad = remitenteCiudad;
    }

    /**
     * @return the destinatarioNombre
     */
    public String getDestinatarioNombre() {
        return destinatarioNombre;
    }

    /**
     * @param destinatarioNombre the destinatarioNombre to set
     */
    public void setDestinatarioNombre(String destinatarioNombre) {
        this.destinatarioNombre = destinatarioNombre;
    }

    /**
     * @return the destinatarioTelefono
     */
    public String getDestinatarioTelefono() {
        return destinatarioTelefono;
    }

    /**
     * @param destinatarioTelefono the destinatarioTelefono to set
     */
    public void setDestinatarioTelefono(String destinatarioTelefono) {
        this.destinatarioTelefono = destinatarioTelefono;
    }

    /**
     * @return the destinatarioEstado
     */
    public String getDestinatarioEstado() {
        return destinatarioEstado;
    }

    /**
     * @param destinatarioEstado the destinatarioEstado to set
     */
    public void setDestinatarioEstado(String destinatarioEstado) {
        this.destinatarioEstado = destinatarioEstado;
    }

    /**
     * @return the destinatarioCiudad
     */
    public String getDestinatarioCiudad() {
        return destinatarioCiudad;
    }

    /**
     * @param destinatarioCiudad the destinatarioCiudad to set
     */
    public void setDestinatarioCiudad(String destinatarioCiudad) {
        this.destinatarioCiudad = destinatarioCiudad;
    }

    /**
     * @return the numeroDeCuenta
     */
    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    /**
     * @param numeroDeCuenta the numeroDeCuenta to set
     */
    public void setNumeroDeCuenta(String numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

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
     * @return the corresponsal
     */
    public String getCorresponsal() {
        return corresponsal;
    }

    /**
     * @param corresponsal the corresponsal to set
     */
    public void setCorresponsal(String corresponsal) {
        this.corresponsal = corresponsal;
    }

    /**
     * @return the destinatarioPais
     */
    public String getDestinatarioPais() {
        return destinatarioPais;
    }

    /**
     * @param destinatarioPais the destinatarioPais to set
     */
    public void setDestinatarioPais(String destinatarioPais) {
        this.destinatarioPais = destinatarioPais;
    }

    /**
     * @return the tarifaIncluida
     */
    public String getTarifaIncluida() {
        return tarifaIncluida;
    }

    /**
     * @param tarifaIncluida the tarifaIncluida to set
     */
    public void setTarifaIncluida(String tarifaIncluida) {
        this.tarifaIncluida = tarifaIncluida;
    }

    /**
     * @return the remitenteDireccion
     */
    public String getRemitenteDireccion() {
        return remitenteDireccion;
    }

    /**
     * @param remitenteDireccion the remitenteDireccion to set
     */
    public void setRemitenteDireccion(String remitenteDireccion) {
        this.remitenteDireccion = remitenteDireccion;
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
     * @return the destinatarioDireccion
     */
    public String getDestinatarioDireccion() {
        return destinatarioDireccion;
    }

    /**
     * @param destinatarioDireccion the destinatarioDireccion to set
     */
    public void setDestinatarioDireccion(String destinatarioDireccion) {
        this.destinatarioDireccion = destinatarioDireccion;
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
}
