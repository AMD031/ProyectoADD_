/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import DaosInterfaces.IDaoEvento;
import Modelo.Comisario;
import Modelo.Conexion;
import Modelo.Evento;
import Modelo.Material;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Antonio Martinez Diaz
 */
public class EventoDao implements IDaoEvento {

    @Override
    public boolean insertar(Evento a) throws DaoExepcion {
        boolean correcto = false;

        String sentencia = "INSERT INTO Event(date,name,id_sportcomplex, id_area )"
                + "VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = Conexion.obtener().prepareStatement(sentencia, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setTimestamp(1, a.getFecha());
            ps.setString(2, a.getNombre());
            ps.setInt(3, a.getCod_complejo());
            ps.setInt(4, a.getCod_area());

            if (ps.executeUpdate() > 0) {
                correcto = true;
            }
            ResultSet rs = ps.getGeneratedKeys();
            if (!rs.next()) {
                throw new DaoExepcion("No se ha podido asignar clave.");
            }

        } catch (SQLException ex) {
            throw new DaoExepcion(ex);
        }
        return correcto;

    }

    @Override
    public int eliminar(Integer a) throws DaoExepcion {

        int cantidad = 0;
        String Sentencia = "DELETE FROM event WHERE id =?";
        try {
            PreparedStatement ps = Conexion.obtener().prepareStatement(Sentencia);
            ps.setInt(1, a);
            cantidad = ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoExepcion(ex);
        }
        return cantidad;

    }

    @Override
    public List<Evento> ObtenerTodos() throws DaoExepcion {
        ArrayList<Evento> eventos = null;
        Evento evento = null;
        String consulta = "SELECT * FROM event";

        try {
            PreparedStatement ps = Conexion.obtener().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            int id;
            String nombre;
            int cod_complejo;
            Timestamp fecha;
            int cod_area;
            eventos = new ArrayList<>();
            while (rs.next()) {

                id = rs.getInt("id");
                nombre = rs.getString("name");
                cod_complejo = rs.getInt("id_sportcomplex");
                cod_area = rs.getInt("id_area");
                fecha = rs.getTimestamp("date");
                //(int cod, String nombre, int cod_complejo, Timestamp fecha, int cod_area)
                evento = new Evento(id, nombre, cod_complejo, fecha, cod_area);

                if (evento != null) {
                    eventos.add(evento);
                }

            }
        } catch (SQLException ex) {
            throw new DaoExepcion(ex);
        } finally {
            Conexion.cerrar();
        }
        return eventos;

    }

    @Override
    public Evento obtener(Integer cod) throws DaoExepcion {
        Evento evento = null;
        String consulta = "SELECT * FROM event where id =?";

        try {
            PreparedStatement ps = Conexion.obtener().prepareStatement(consulta);
            ps.setInt(1,cod );
            ResultSet rs = ps.executeQuery();
            int id;
            String nombre;
            int cod_complejo;
            Timestamp fecha;
            int cod_area;

           while (rs.next()) {

                id = rs.getInt("id");
                nombre = rs.getString("name");
                fecha = rs.getTimestamp("date");
                cod_complejo = rs.getInt("id_sportcomplex");
                cod_area = rs.getInt("id_area");

                evento = new Evento(id, nombre,  cod_complejo,  fecha, cod_area);

            }
        } catch (SQLException ex) {
            throw new DaoExepcion(ex);
        } finally {
            Conexion.cerrar();
        }
        return evento;
    }

    @Override
    public boolean modificar(HashMap<Object, Object> a, Integer id) throws DaoExepcion {

        boolean correcto = false;
        int p = 1;
        try {
            List<String> clausulas = new ArrayList<>();
            for (Object key : a.keySet()) {
                clausulas.add(String.format("%s=?", key));
            }

            String consulta = String.format("UPDATE event SET %s WHERE id=?",
                    StringUtils.join(clausulas, ","));

            PreparedStatement ps = Conexion.obtener().prepareStatement(consulta);
            for (Object key : a.keySet()) {

                if (a.get(key) instanceof String) {
                    ps.setString(p++, (String) a.get(key));
                }

                if (a.get(key) instanceof Integer) {
                    ps.setInt(p++, (Integer) a.get(key));
                }

                if (a.get(key) instanceof Timestamp) {
                    ps.setTimestamp(p++, (Timestamp) a.get(key));
                }

            }

            ps.setInt(p, id);

            if (ps.executeUpdate() == 0) {
                throw new DaoExepcion("No se ha podido modificar el registro");
            } else {
                correcto = true;
            }

        } catch (Exception ex) {
            throw new DaoExepcion(ex);
        } finally {
            Conexion.cerrar();
        }

        return correcto;
    }

    @Override
    public List<Evento> buscar(HashMap<Object, Object> a) throws DaoExepcion {
        ArrayList<Evento> eventos = new ArrayList<>();
         LinkedList<Integer> ids = new LinkedList<>();

        String columna = "";
        int p = 1;
        try {
            for (Object key : a.keySet()) {
                columna = String.format("%s", key);
            }

            String consulta = String.format("SELECT DISTINCT id FROM event WHERE %s LIKE ?",
                    StringUtils.join(columna));

            PreparedStatement ps = Conexion.obtener().prepareStatement(consulta);
            for (Object key : a.keySet()) {
                if (a.get(key) instanceof String) {
                    ps.setString(p++, (String) a.get(key));
                }
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                    ids.add(rs.getInt("id"));   
            }

            for (Integer id : ids) {
                eventos.add(obtener(id));
            }

        } catch (SQLException ex) {
            Logger.getLogger(MaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eventos;
    }
    
    
    public Evento obtenerEventoConAgregados(int CodE) throws DaoExepcion{
             Evento evento =null;
            //variables evento
               int codEvento= 0;
               String nombreEvento=""; 
               int cod_complejo =0; 
               Timestamp fecha=null; 
               int cod_area =0; 
               HashMap<Comisario, String> comisarios = null;
               List<Material> Materiales;
            //variables comisario
             int idComisario =0;
             String dni ="";
             String nombreComisario="";
             String rol ="";
             //variables material
             String idmaterial ="";
             String nombreMaterial ="";
        
        
        try {
            comisarios = new HashMap<>(); 
            Materiales = new ArrayList<>();
  
            String sql ="SELECT c.id,c.dni,c.name,cv.id,cv.id_event, cv.id_comissioner,cv.rol, evt.id,evt.name,"
                    + " evt.date,evt.id_sportcomplex, evt.id_area FROM commissioner c INNER JOIN comissioner_event cv on c.id "
                    + "INNER JOIN event evt on cv.id_event = evt.id WHERE evt.id = ? GROUP by c.id ";
            
            String sqlmaterial = "SELECT eqt.id, eqt.name FROM equipment eqt "
                    + "INNER JOIN equipment_event eqev on eqt.id = eqev.id_equipment "
                    + "INNER JOIN event evt on eqev.id_event = ? GROUP by eqt.id";
          
            PreparedStatement ps =  Conexion.obtener().prepareStatement(sql);
            ps.setInt(1,CodE);
            ResultSet rs =ps.executeQuery();
            while(rs.next()){
               
               //datos comisario
               idComisario = rs.getInt(1);
               dni = rs.getString(2);
               nombreComisario = rs.getString(3);
               rol = rs.getString(7);
               //---------------
               
               comisarios.put(new Comisario(idComisario,dni, nombreComisario), rol);     
               codEvento =  rs.getInt(8);
               nombreEvento = rs.getString(9);
               fecha = rs.getTimestamp(10);
               cod_complejo = rs.getInt(11);
               cod_area = rs.getInt(12);
             }
            
            PreparedStatement ps2 = Conexion.obtener().prepareStatement(sqlmaterial);
            ps2.setInt(1, CodE);
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()){ 
                Materiales.add(new Material(rs2.getInt(1),rs2.getString(2)));
            }
            evento = new Evento(codEvento,nombreEvento, cod_complejo, fecha, cod_area, comisarios, Materiales);
        } catch (SQLException ex) {
           throw new DaoExepcion(ex);
        }finally{
            Conexion.cerrar();
        }
       return evento;
    }
    
    
 
    
    

}
