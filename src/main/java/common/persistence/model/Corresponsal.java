/*
 @Autor: Roberto Rodriguez
 Email: robertoSoftwareEngineer@gmail.com

 @Copyright 2016 
 */
package common.persistence.model;
 
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.xml.bind.annotation.XmlElement; 

/**
 *
 * @author rrodriguez
 */
 
public class Corresponsal { 
    private Double tipoCambio;
    private Double tarifa;
    private String nombre;
    private String codigo;
    private String moneda; 
    @JsonIgnore
    private List<FormaEntrega> formaEntregaList;

    public Corresponsal() {
    }

    public Corresponsal(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }
 
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
