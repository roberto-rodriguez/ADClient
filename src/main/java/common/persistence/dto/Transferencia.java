/*
 @Autor: Roberto Rodriguez
 Email: robertoSoftwareEngineer@gmail.com

 @Copyright 2016 
 */
package common.persistence.dto;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * <TRANSFERENCIA>
 * <COD_CORRESPONSAL>HUE-51</COD_CORRESPONSAL>
 * <CUENTA_BANCO></CUENTA_BANCO>
 * <COD_CIUDAD_REMITE>HUE-1142</COD_CIUDAD_REMITE>
 * <COD_CIUDAD_DESTINATARIO>HUE-932</COD_CIUDAD_DESTINATARIO>
 * <TIPOVENTA>TR01</TIPOVENTA>
 * <DIR_REMITE>TEST</DIR_REMITE>
 * <DIR_DESTINATARIO>GUATEMALA</DIR_DESTINATARIO>
 * <FECHA>08/12/2016</FECHA>
 * <COMENTARIO></COMENTARIO>
 * <TIPO_CAMBIO>7.83</TIPO_CAMBIO>
 * <TOTAL_PAGAR>19</TOTAL_PAGAR>
 * <AGENCIA_ORIGEN>MIA-1</AGENCIA_ORIGEN>
 * <BI_CREA>MIA-2</BI_CREA>
 * <DINERO_ENTREGADO>783</DINERO_ENTREGADO>
 * <MONTO_ENTREGAR>100</MONTO_ENTREGAR>
 * <NOM_REMITE>PABLO ESCOBAR GAVIRIA</NOM_REMITE>
 * <NOM_DESTINATARIO>TEST2</NOM_DESTINATARIO>
 * <TEL_REMITE>123-4</TEL_REMITE>
 * <TEL_DESTINATARIO></TEL_DESTINATARIO>
 * <ZIP_REMITE></ZIP_REMITE>
 * <COD_ESTADO_REMITE>HUE-22</COD_ESTADO_REMITE>
 * <NOMBRE_ESTADO_REMITE>FLORIDA</NOMBRE_ESTADO_REMITE>
 * <COD_ESTADO_DESTINATARIO>HUE-3</COD_ESTADO_DESTINATARIO>
 * <NOMBRE_ESTADO_DESTINATARIO>GUATEMALA</NOMBRE_ESTADO_DESTINATARIO>
 * <NOMBRE_PAIS_REMITE>USA</NOMBRE_PAIS_REMITE>
 * <COD_PAIS_DESTINATARIO>GT</COD_PAIS_DESTINATARIO>
 * <NOMBRE_PAIS_DESTINATARIO>GUATEMALA</NOMBRE_PAIS_DESTINATARIO>
 * <ESTATUS>1</ESTATUS>
 * <CLAVE_PAGO>70456373</CLAVE_PAGO>
 * </TRANSFERENCIA>
 *
 *
 * @author rrodriguez
 */ 
public class Transferencia {

    private String codEnvio;
    private String codCorresponsal;
    private String codCiudadRemite;
    private String codCiudadDestinatario;
    private String tipoVenta;
    private String dirRemite;
    private String dirDestinatario;
    private String fecha;
    private String comentario;

    private String agenciaOrigen;
    private String biCrea;

    private String nomRemite;
    private String nomDestinatario;
    private String telRemite;
    private String telDestinatario;
    private String zipRemite;
    private String codEstadoRemite;
    private String codEstadoDestinatario;
    private String codPaisDestinatario;
    private String dirPostalRemite;
    
    private String fechaNacDestinatario;
    private String nomCiudadRemite;
    private String nomCiudadDestinatario;
    private String estatus;
    private String clavePago;//no

    private Double totalPagar; //ok
    private Double tipoCambio; //ok
    private Double dineroEntregado; //ok
    private Double montoEntregar;  //OK

    private Double comision;  //no

    private Double eRemite;//no
    private Double eDestino;//no

    private String respuesta;

    private String numeroCuenta;

    //nuevos campos
    private String nombreEstadoRemite;
    private String nombreEstadoDestinatario;
    private String nombrePaisRemite;
    private String nombrePaisDestinatario;
    private String incluyeComision;
    private String tarifa; //no

    private String moneda;//Solo para la vista
    private String nombreAgencia;//no
    private String direccionAgencia;//
    private String telefonoAgencia;//
    private String puntoPago; //no
    private String formaPago;
    private String comisionAD;//no
    private String tarifaTagId;

    //Para envios a Cuba
    private String fechaNacRemite;
    private String apellidoMaterno;
    private String numId;
    private String fechaExpiracion;
    private String tipoId;
    private String remitentePresente;
    private String relacionDestinatario;
    private String declaracionRemitente;
    private String confirmacionFamilia;
    private String confirmacionNoGobierno;
    private String confirmacionNoProhibido;
    private String confirmacionNoEmigracion;

    public Transferencia() {
    }

    public Transferencia(String codEnvio) {
        this.codEnvio = codEnvio;
    }
 

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
 

    public String getCodEnvio() {
        return codEnvio;
    }
 
    public void setCodEnvio(String codEnvio) {
        this.codEnvio = codEnvio;
    }

    /**
     * @return the codCorresponsal
     */
    public String getCodCorresponsal() {
        return codCorresponsal;
    }
 
    public void setCodCorresponsal(String codCorresponsal) {
        this.codCorresponsal = codCorresponsal;
    }

    /**
     * @return the codCiudadDestinatario
     */
    public String getCodCiudadDestinatario() {
        return codCiudadDestinatario;
    }

    public String getCodCiudadRemite() {
        return codCiudadRemite;
    }
 
    public void setCodCiudadRemite(String codCiudadRemite) {
        this.codCiudadRemite = codCiudadRemite;
    }
 
    public void setCodCiudadDestinatario(String codCiudadDestinatario) {
        this.codCiudadDestinatario = codCiudadDestinatario;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }
 
    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public String getDirRemite() {
        return dirRemite;
    }
 
    public void setDirRemite(String dirRemite) {
        this.dirRemite = dirRemite;
    }

    /**
     * @return the dirDestinatario
     */
    public String getDirDestinatario() {
        return dirDestinatario;
    }
 
    public void setDirDestinatario(String dirDestinatario) {
        this.dirDestinatario = dirDestinatario;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }
 
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }
 
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * @return the tipoCambio
     */
    public Double getTipoCambio() {
        return tipoCambio;
    }
 
    public void setTipoCambio(Double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public Double getTotalPagar() {
        return totalPagar;
    }

  
    public void setTotalPagar(Double totalPagar) {
        this.totalPagar = totalPagar;
    }

    /**
     * @return the agenciaOrigen
     */
    public String getAgenciaOrigen() {
        return agenciaOrigen;
    }

     
    public void setAgenciaOrigen(String agenciaOrigen) {
        this.agenciaOrigen = agenciaOrigen;
    }

    /**
     * @return the biCrea
     */
    public String getBiCrea() {
        return biCrea;
    }
 
    public void setBiCrea(String biCrea) {
        this.biCrea = biCrea;
    }

    public Double getDineroEntregado() {
        return dineroEntregado;
    }
 
    public void setDineroEntregado(Double dineroEntregado) {
        this.dineroEntregado = dineroEntregado;
    }

    public Double getMontoEntregar() {
        return montoEntregar;
    }
 
    public void setMontoEntregar(Double montoEntregar) {
        this.montoEntregar = montoEntregar;
    }

    /**
     * @return the nomRemite
     */
    public String getNomRemite() {
        return nomRemite;
    }

    
    public void setNomRemite(String nomRemite) {
        this.nomRemite = nomRemite;
    }

    /**
     * @return the nomDestinatario
     */
    public String getNomDestinatario() {
        return nomDestinatario;
    }

  
    public void setNomDestinatario(String nomDestinatario) {
        this.nomDestinatario = nomDestinatario;
    }

    /**
     * @return the telRemite
     */
    public String getTelRemite() {
        return telRemite;
    }
 
    public void setTelRemite(String telRemite) {
        this.telRemite = telRemite;
    }

    /**
     * @return the telDestinatario
     */
    public String getTelDestinatario() {
        return telDestinatario;
    }
 
    public void setTelDestinatario(String telDestinatario) {
        this.telDestinatario = telDestinatario;
    }

    /**
     * @return the zipRemite
     */
    public String getZipRemite() {
        return zipRemite;
    }
 
    public void setZipRemite(String zipRemite) {
        this.zipRemite = zipRemite;
    }

    /**
     * @return the codEstadoRemite
     */
    public String getCodEstadoRemite() {
        return codEstadoRemite;
    }
 
    public void setCodEstadoRemite(String codEstadoRemite) {
        this.codEstadoRemite = codEstadoRemite;
    }

    /**
     * @return the codEstadoDestinatario
     */
    public String getCodEstadoDestinatario() {
        return codEstadoDestinatario;
    }
 
    public void setCodEstadoDestinatario(String codEstadoDestinatario) {
        this.codEstadoDestinatario = codEstadoDestinatario;
    }

    public String getCodPaisDestinatario() {
        return codPaisDestinatario;
    }

 
    public void setCodPaisDestinatario(String codPaisDestinatario) {
        this.codPaisDestinatario = codPaisDestinatario;
    }

    public String getDirPostalRemite() {
        return dirPostalRemite;
    }
 
    public void setDirPostalRemite(String dirPostalRemite) {
        this.dirPostalRemite = dirPostalRemite;
    }

    public String getFechaNacRemite() {
        return fechaNacRemite;
    }
 
    public void setFechaNacRemite(String fechaNacRemite) {
        this.fechaNacRemite = fechaNacRemite;
    }

    public String getFechaNacDestinatario() {
        return fechaNacDestinatario;
    }
 
    public void setFechaNacDestinatario(String fechaNacDestinatario) {
        this.fechaNacDestinatario = fechaNacDestinatario;
    }

    public String getNomCiudadRemite() {
        return nomCiudadRemite;
    }
 
    public void setNomCiudadRemite(String nomCiudadRemite) {
        this.nomCiudadRemite = nomCiudadRemite;
    }

    public String getNomCiudadDestinatario() {
        return nomCiudadDestinatario;
    }
 
    public void setNomCiudadDestinatario(String nomCiudadDestinatario) {
        this.nomCiudadDestinatario = nomCiudadDestinatario;
    }

    public String getEstatus() {
        return estatus;
    }
 
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getClavePago() {
        return clavePago;
    }
 
    public void setClavePago(String clavePago) {
        this.clavePago = clavePago;
    }

    /**
     * @return the eRemite
     */
    public Double geteRemite() {
        return eRemite;
    }
 
    public void seteRemite(Double eRemite) {
        this.eRemite = eRemite;
    }

    public Double geteDestino() {
        return eDestino;
    }
 
    public void seteDestino(Double eDestino) {
        this.eDestino = eDestino;
    }

    /**
     * @return the respuesta
     */
    public String getRespuesta() {
        return respuesta;
    }
 
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    /**
     * @return the numeroCuenta
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

   
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * @return the nombreEstadoRemite
     */
    public String getNombreEstadoRemite() {
        return nombreEstadoRemite;
    }
 
    public void setNombreEstadoRemite(String nombreEstadoRemite) {
        this.nombreEstadoRemite = nombreEstadoRemite;
    }

    /**
     * @return the nombreEstadoDestinatario
     */
    public String getNombreEstadoDestinatario() {
        return nombreEstadoDestinatario;
    }
 
    public void setNombreEstadoDestinatario(String nombreEstadoDestinatario) {
        this.nombreEstadoDestinatario = nombreEstadoDestinatario;
    }

    /**
     * @return the nombrePaisRemite
     */
    public String getNombrePaisRemite() {
        return nombrePaisRemite;
    }
 
    public void setNombrePaisRemite(String nombrePaisRemite) {
        this.nombrePaisRemite = nombrePaisRemite;
    }

    /**
     * @return the nombrePaisDestinatario
     */
    public String getNombrePaisDestinatario() {
        return nombrePaisDestinatario;
    }
 
    public void setNombrePaisDestinatario(String nombrePaisDestinatario) {
        this.nombrePaisDestinatario = nombrePaisDestinatario;
    }

    /**
     * @return the comision
     */
    public Double getComision() {
        return comision;
    }

   
    public void setComision(Double comision) {
        this.comision = comision;
    }

    /**
     * @return the formaPago
     */
    public String getFormaPago() {
        return formaPago;
    }

 
    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    /**
     * @return the incluyeComision
     */
    public String getIncluyeComision() {
        return incluyeComision;
    }
 
    public void setIncluyeComision(String incluyeComision) {
        this.incluyeComision = incluyeComision;
    }

    /**
     * @return the tarifa
     */
    public String getTarifa() {
        return tarifa;
    }
 
    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    /**
     * @return the moneda
     */
    public String getMoneda() {
        return moneda;
    }
 
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    /**
     * @return the nombreAgencia
     */
    public String getNombreAgencia() {
        return nombreAgencia;
    }

     
    public void setNombreAgencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
    }

    /**
     * @return the direccionAgencia
     */
    public String getDireccionAgencia() {
        return direccionAgencia;
    }
 
    public void setDireccionAgencia(String direccionAgencia) {
        this.direccionAgencia = direccionAgencia;
    }

    /**
     * @return the telefonoAgencia
     */
    public String getTelefonoAgencia() {
        return telefonoAgencia;
    }
 
    public void setTelefonoAgencia(String telefonoAgencia) {
        this.telefonoAgencia = telefonoAgencia;
    }

    /**
     * @return the puntoPago
     */
    public String getPuntoPago() {
        return puntoPago;
    }

 
    public void setPuntoPago(String puntoPago) {
        this.puntoPago = puntoPago;
    }

    /**
     * @return the comisionAD
     */
    public String getComisionAD() {
        return comisionAD;
    }

 
    public void setComisionAD(String comisionAD) {
        this.comisionAD = comisionAD;
    }

    /**
     * @return the tarigaTagId
     */
    public String getTarifaTagId() {
        return tarifaTagId;
    }
 
    public void setTarifaTagId(String tarifaTagId) {
        this.tarifaTagId = tarifaTagId;
    }

    /**
     * @return the apellidoMaterno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }
 
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * @return the numId
     */
    public String getNumId() {
        return numId;
    }
 
    public void setNumId(String numId) {
        this.numId = numId;
    }

    /**
     * @return the fechaExpiracion
     */
    public String getFechaExpiracion() {
        return fechaExpiracion;
    }
 
    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    /**
     * @return the tipoId
     */
    public String getTipoId() {
        return tipoId;
    }
 
    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    /**
     * @return the remitentePresente
     */
    public String getRemitentePresente() {
        return remitentePresente;
    }
 
    public void setRemitentePresente(String remitentePresente) {
        this.remitentePresente = remitentePresente;
    }

    public String getRelacionDestinatario() {
        return relacionDestinatario;
    }
 
    public void setRelacionDestinatario(String relacionDestinatario) {
        this.relacionDestinatario = relacionDestinatario;
    }

    /**
     * @return the declaracionRemitente
     */
    public String getDeclaracionRemitente() {
        return declaracionRemitente;
    }
 
    public void setDeclaracionRemitente(String declaracionRemitente) {
        this.declaracionRemitente = declaracionRemitente;
    }

    /**
     * @return the confirmacionFamilia
     */
    public String getConfirmacionFamilia() {
        return confirmacionFamilia;
    }
 
    public void setConfirmacionFamilia(String confirmacionFamilia) {
        this.confirmacionFamilia = confirmacionFamilia;
    }

    /**
     * @return the confirmacionNoGobierno
     */
    public String getConfirmacionNoGobierno() {
        return confirmacionNoGobierno;
    }
 
    public void setConfirmacionNoGobierno(String confirmacionNoGobierno) {
        this.confirmacionNoGobierno = confirmacionNoGobierno;
    }

    /**
     * @return the confirmacionNoProhibido
     */
    public String getConfirmacionNoProhibido() {
        return confirmacionNoProhibido;
    }
 
    public void setConfirmacionNoProhibido(String confirmacionNoProhibido) {
        this.confirmacionNoProhibido = confirmacionNoProhibido;
    }

    /**
     * @return the confirmacionNoEmigracion
     */
    public String getConfirmacionNoEmigracion() {
        return confirmacionNoEmigracion;
    }
 
    public void setConfirmacionNoEmigracion(String confirmacionNoEmigracion) {
        this.confirmacionNoEmigracion = confirmacionNoEmigracion;
    }

}
