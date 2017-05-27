/*
 @Autor: Roberto Rodriguez
 Email: robertoSoftwareEngineer@gmail.com

 @Copyright 2016 
 */
package common.persistence.model;
 
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

/**
 *
 * @author rrodriguez
 */
 
public class Corresponsal  extends Nomemclator { 
    private Double tipoCambio;
    private Double tarifa; 
    private String moneda; 
    @JsonIgnore
    private List<FormaEntrega> formaEntregaList;

    public Corresponsal() {
    }

    public Corresponsal(String nombre, String codigo) {
       super(nombre, codigo);
    }

    public Corresponsal(Double tipoCambio, Double tarifa, String nombre, String codigo) {
        this(nombre, codigo);
        this.tipoCambio = tipoCambio;
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
     * @return the tipoCambio
     */
    public Double getTipoCambio() {
        return tipoCambio;
    }
 
    public void setTipoCambio(Double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    /**
     * @return the tarifa
     */
    public Double getTarifa() {
        return tarifa;
    }
 
    public void setTarifa(Double tarifa) {
        this.tarifa = tarifa;
    }
  
    /**
     * @return the formaEntregaList
     */
    public List<FormaEntrega> getFormaEntregaList() {
        return formaEntregaList;
    }

    /**
     * @param formaEntregaList the formaEntregaList to set
     */
    public void setFormaEntregaList(List<FormaEntrega> formaEntregaList) {
        this.formaEntregaList = formaEntregaList;
    }
 
}
