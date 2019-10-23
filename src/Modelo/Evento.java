
package Modelo;

import java.util.List;

/**
 *
 * @author Antonio Martinez Diaz
 */
public class Evento {

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

    public int getCod_complejo() {
        return cod_complejo;
    }

    public void setCod_complejo(int cod_complejo) {
        this.cod_complejo = cod_complejo;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public int getCod_area() {
        return cod_area;
    }

    public void setCod_area(int cod_area) {
        this.cod_area = cod_area;
    }

    public List<Comisario> getComisarios() {
        return comisarios;
    }

    public void setComisarios(List<Comisario> comisarios) {
        this.comisarios = comisarios;
    }

    public List<Material> getMateriales() {
        return Materiales;
    }

    public void setMateriales(List<Material> Materiales) {
        this.Materiales = Materiales;
    }

    public Evento(int cod, String nombre, int cod_complejo, String Fecha, int cod_area, List<Comisario> comisarios, List<Material> Materiales) {
        this.cod = cod;
        this.nombre = nombre;
        this.cod_complejo = cod_complejo;
        this.Fecha = Fecha;
        this.cod_area = cod_area;
        this.comisarios = comisarios;
        this.Materiales = Materiales;
    }
    
    private int cod;
    private String nombre;
    private int cod_complejo;
    private String Fecha;
    private int cod_area;
    List<Comisario>comisarios;
    List<Material>Materiales;

    public Evento(int cod, String nombre, int cod_complejo, String Fecha, int cod_area, List<Comisario> comisarios) {
        this.cod = cod;
        this.nombre = nombre;
        this.cod_complejo = cod_complejo;
        this.Fecha = Fecha;
        this.cod_area = cod_area;
        this.comisarios = comisarios;
    }
    
    
    
    
    
    
    
    
    
}
