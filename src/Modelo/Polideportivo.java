/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;

/**
 *
 * @author Antonio Martinez Diaz
 */
public class Polideportivo {

    public int getCod_complejo() {
        return cod_complejo;
    }

    public void setCod_complejo(int cod_complejo) {
        this.cod_complejo = cod_complejo;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
   private int cod_complejo;
   private String info;
   private List<Area>areas;

    public Polideportivo(int cod_complejo, String info) {
        this.cod_complejo = cod_complejo;
        this.info = info;
    }
   
    
    
    
    
   

}
