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
public class Sede {

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public List<Complejo> getComplejos() {
        return complejos;
    }

    public void setComplejos(List<Complejo> complejos) {
        this.complejos = complejos;
    }
    private int cod;
    private String nombre;
    private double presupuesto;
    List<Complejo> complejos;

    public Sede(int cod, String nombre, double presupuesto, List<Complejo> complejos) {
        this.cod = cod;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.complejos = complejos;
    }
   

    
}
