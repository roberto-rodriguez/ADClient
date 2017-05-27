/*
 @Autor: Roberto Rodriguez
 Email: robertoSoftwareEngineer@gmail.com

 @Copyright 2016 
 */
package common.persistence.model;

 
/**
 *
 * @author rrodriguez
 */
 
public class Estado extends Nomemclator{

    public Estado() {
    }

    public Estado(String nombre, String codigo) {
        super(nombre, codigo);
    }
     
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }
 
   
    public void setCodigo(String codigo) {
        super.setCodigo(codigo);
    }
}