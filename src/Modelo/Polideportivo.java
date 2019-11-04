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
public class Polideportivo extends Complejo{

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

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

   private int cod_complejo;
   private String info;
   private List<Area>areas;

    public Polideportivo(int cod_complejo, String info, int cod, String localizacion, String jefe, int cod_sede) {
        super(cod, localizacion, jefe, cod_sede);
        this.cod_complejo = cod_complejo;
        this.info = info;
    }

    public Polideportivo(int cod_complejo, String info, List<Area> areas, int cod, String localizacion, String jefe, int cod_sede) {
        super(cod, localizacion, jefe, cod_sede);
        this.cod_complejo = cod_complejo;
        this.info = info;
        this.areas = areas;
    }

  
    
    
    
  
    @Override
    public String toString() {
        return "Polideportivo{" + "cod_complejo=" + cod_complejo + ", info=" + info + '}';
    }
    
}
