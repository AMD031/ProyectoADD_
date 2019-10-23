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
public class Comisario {

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Comisario(int cod, String DNI, String Nombre) {
        this.cod = cod;
        this.DNI = DNI;
        this.Nombre = Nombre;
    }
     
    private int cod;
    private String DNI;
    private String Nombre;
    
    
    
    
    
    
    
    
}
