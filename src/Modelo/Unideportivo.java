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
public class Unideportivo extends Complejo{

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
    
    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
    
    
    
    public Unideportivo(Evento evento,    int cod_complejo,
                        String deporte,   String info, 
                        int cod, String   localizacion,
                        String jefe,      int cod_sede) {
        super(cod, localizacion, jefe, cod_sede);
        this.evento = evento;
        this.cod_complejo = cod_complejo;
        this.deporte = deporte;
        this.info = info;
    }

    public Unideportivo(int cod_complejo, String deporte, String info, int cod, String localizacion, String jefe, int cod_sede) {
        super(cod, localizacion, jefe, cod_sede);
        this.cod_complejo = cod_complejo;
        this.deporte = deporte;
        this.info = info;
    }

    

    public Unideportivo(int cod_complejo, String deporte, String info, String localizacion, String jefe, int cod_sede) {
        super(localizacion, jefe, cod_sede);
        this.cod_complejo = cod_complejo;
        this.deporte = deporte;
        this.info = info;
    }

    public Unideportivo(String deporte, String info, String localizacion, String jefe, int cod_sede) {
        super(localizacion, jefe, cod_sede);
        this.deporte = deporte;
        this.info = info;
    }
    
    

    public Unideportivo(int cod) {
        super(cod);
        this.cod_complejo = cod;
    }
 
    private Evento evento; 
    private int cod_complejo;
    private String deporte;
    private String info;

    @Override
    public String toString() {
        return "Unideportivo{" + "cod_complejo=" + cod_complejo + ", deporte=" + deporte + ", info=" + info + '}' ;
    }



  
    
    
}
