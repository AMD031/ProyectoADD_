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
public class Unideportivo {

    public int getCod_complejo() {
        return cod_complejo;
    }

    public void setCod_complejo(int cod_complejo) {
        this.cod_complejo = cod_complejo;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Unideportivo(int cod_complejo, String deporte, String info) {
        this.cod_complejo = cod_complejo;
        this.deporte = deporte;
        this.info = info;
    }
    
    private int cod_complejo;
    private String deporte;
    private String info;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
