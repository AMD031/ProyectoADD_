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
public class Material {

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
    private int cod;
    private String nombre;

    public Material(int cod, String nombre) {
        this.cod = cod;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Material{" + "cod=" + cod + ", nombre=" + nombre + '}';
    }
      
}
