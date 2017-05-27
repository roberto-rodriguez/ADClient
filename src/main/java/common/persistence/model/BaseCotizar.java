/*
 @Autor: Roberto Rodriguez
 Email: robertoSoftwareEngineer@gmail.com

 @Copyright 2016 
 */
package common.persistence.model;

import java.io.Serializable;
import java.io.StringReader;
import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author rrodriguez
 */ 
public class BaseCotizar  implements Serializable{
    private Double tarifa;
    private Double tasaDeCambio;
    private Double montoEntregar;
    private Double dineroEntregado;
    private Double totalPagar;
    private Integer tarifaTagId;
   
    
    public BaseCotizar() {
    }

    public BaseCotizar(Double tarifa, Double tasaDeCambio) {
        this.tarifa = tarifa;
        this.tasaDeCambio = tasaDeCambio;
    }

    public String getNombre() {
        return tarifa + "";
    }
 

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return tasaDeCambio + "";
    }
    /**
     * @return the tarifa
     */
    public Double getTarifa() {
        return tarifa;
    }

     @XmlElement( name = "TARIFA" ) 
    public void setTarifa(Double tarifa) {
        this.tarifa = tarifa;
    }

    /**
     * @return the tasaDeCambio
     */
    public Double getTasaDeCambio() {
        return tasaDeCambio;
    }

     @XmlElement( name = "TIPO_CAMBIO" )
    public void setTasaDeCambio(Double tasaDeCambio) {
        this.tasaDeCambio = tasaDeCambio;
    }

    /**
     * @return the montoEntregar
     */
    public Double getMontoEntregar() {
        return montoEntregar;
    }
 
    /**
     * @param montoEntregar the montoEntregar to set
     */
      @XmlElement( name = "MONTO_ENTREGAR" )
    public void setMontoEntregar(Double montoEntregar) {
        this.montoEntregar = montoEntregar;
    }

    /**
     * @return the dineroEntregado
     */
    public Double getDineroEntregado() {
        return dineroEntregado;
    }

     @XmlElement( name = "DINERO_ENTREGADO" )
    public void setDineroEntregado(Double dineroEntregado) {
        this.dineroEntregado = dineroEntregado;
    }

    /**
     * @return the totalPagar
     */
    public Double getTotalPagar() {
        return totalPagar;
    }

    @XmlElement( name = "TOTAL_PAGAR" )
    public void setTotalPagar(Double totalPagar) {
        this.totalPagar = totalPagar;
    }

    /**
     * @return the tarifaTagId
     */
    public Integer getTarifaTagId() {
        return tarifaTagId;
    }

    /**
     * @param tarifaTagId the tarifaTagId to set
     */
    public void setTarifaTagId(Integer tarifaTagId) {
        this.tarifaTagId = tarifaTagId;
    }
 
}
