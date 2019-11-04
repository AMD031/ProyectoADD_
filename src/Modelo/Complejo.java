/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Antonio Martinez Diaz
 */
public class Complejo {

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getJefe() {
        return jefe;
    }

    public void setJefe(String jefe) {
        this.jefe = jefe;
    }

    public int getCod_sede() {
        return cod_sede;
    }

    public void setCod_sede(int cod_sede) {
        this.cod_sede = cod_sede;
    }

 
    private int cod;
    private String localizacion;
    private String jefe;
    private int cod_sede;
    
    public Complejo(int cod, String localizacion, String jefe, int cod_sede) {
     this.cod = cod;
     this.localizacion = localizacion;
     this.jefe = jefe;
     this.cod_sede = cod_sede;
    }

    public Complejo(String localizacion, String jefe, int cod_sede) {
        this.localizacion = localizacion;
        this.jefe = jefe;
        this.cod_sede = cod_sede;
    
    }

    public Complejo(int cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return "Complejo{" + "cod=" + cod + ", localizacion=" + localizacion + ", jefe=" + jefe + ", cod_sede=" + cod_sede + '}';
    }
    
    
    
    
    
    
    
    
    
    
}
