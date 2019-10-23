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
public class Area {

    public Area(int cod, int cod_poli, String localizacion) {
        this.cod = cod;
        this.cod_poli = cod_poli;
        this.localizacion = localizacion;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getCod_poli() {
        return cod_poli;
    }

    public void setCod_poli(int cod_poli) {
        this.cod_poli = cod_poli;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }
    private int cod;
    private int cod_poli;
    private String localizacion;
    private String deporte;
    
    
}
