package Modelo;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;



/**
 *
 * @author Antonio Martinez Diaz
 */
public class Evento {


    private int cod;
    private String nombre;
    private int cod_complejo;
    private Timestamp fecha;
    private int cod_area;
    HashMap<Comisario, String>comisarios;
    List<Material> Materiales;

    
    public Evento(int cod, String nombre, int cod_complejo, Timestamp fecha, int cod_area, HashMap<Comisario, String> comisarios, List<Material> Materiales) {
        this.cod = cod;
        this.nombre = nombre;
        this.cod_complejo = cod_complejo;
        this.fecha = fecha;
        this.cod_area = cod_area;
        this.comisarios = comisarios;
        this.Materiales = Materiales;
    }

  

    public Evento(int cod, String nombre, int cod_complejo, Timestamp fecha, int cod_area) {
        this.cod = cod;
        this.nombre = nombre;
        this.cod_complejo = cod_complejo;
        this.fecha = fecha;
        this.cod_area = cod_area;
    }


    public Evento(String nombre, int cod_complejo, Timestamp fecha, int cod_area) {
        this.nombre = nombre;
        this.cod_complejo = cod_complejo;
        this.fecha = fecha;
        this.cod_area = cod_area;
    }
 
    
    public static Timestamp stringToTimestamp(String str) throws Exception{
         java.util.Date f =null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy hh:ss");
             f =   sdf.parse(str);
        } catch (ParseException ex) {
          throw  new Exception("Error de conversion: ");
        }
        
        return new Timestamp(f.getTime());
    }

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

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public int getCod_area() {
        return cod_area;
    }

    public void setCod_area(int cod_area) {
        this.cod_area = cod_area;
    }

    public List<Material> getMateriales() {
        return Materiales;
    }

    public void setMateriales(List<Material> Materiales) {
        this.Materiales = Materiales;
    }

    
    @Override
    public String toString() {
        return "Evento{" + "cod=" + cod + ", nombre=" + nombre + ", cod_complejo=" + cod_complejo + ", fecha=" + fecha + ", cod_area=" + cod_area + '}';
    }
    


 



}
