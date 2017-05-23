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
public class Pais extends Nomemclator {
    @JsonIgnore
    private List<Corresponsal> corresponsales;

    public Pais() {
    }

    public Pais(String nombre, String codigo, String moneda) {
        this(nombre, codigo); 
    }

    public Pais(String nombre, String codigo) {
        super(nombre, codigo);
    }

//    public String getName() {
//       return super.getNombre();
//    }
//
//    /**
//     * @param codigo the codigo to set
//     */
//    public String getValue(String codigo) {
//        return super.getCodigo();
//    }

    /**
     * @return the corresponsales
     */
    public List<Corresponsal> getCorresponsales() {
        return corresponsales;
    }

    /**
     * @param corresponsales the corresponsales to set
     */
    public void setCorresponsales(List<Corresponsal> corresponsales) {
        this.corresponsales = corresponsales;
    }

}
