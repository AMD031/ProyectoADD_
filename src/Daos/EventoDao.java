/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import DaosInterfaces.IDaoEvento;
import Modelo.Conexion;
import Modelo.Evento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public int eliminar(Integer  a) throws DaoExepcion {
        
        int cantidad = 0;
        String Sentencia =   "DELETE FROM event WHERE id =?";
        try {
            PreparedStatement ps =  Conexion.obtener().prepareStatement(Sentencia);
            ps.setInt(1,a);
            cantidad =  ps.executeUpdate();
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
                
                id= rs.getInt("id");
                nombre = rs.getString("name");
                cod_complejo = rs.getInt("id_sportcomplex");
                cod_area = rs.getInt("id_area");
                fecha = rs.getTimestamp("date");
                //(int cod, String nombre, int cod_complejo, Timestamp fecha, int cod_area)
                evento = new Evento(id,nombre,cod_complejo,fecha,cod_area);
         
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
        String consulta = "SELECT * FROM event";
        
   
        try {
            PreparedStatement ps = Conexion.obtener().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            int id;
            String nombre;
            int cod_complejo;
            Timestamp fecha;
            int cod_area;
        
            while (rs.next()) {
                
                id= rs.getInt("id");
                nombre = rs.getString("name");
                fecha = rs.getTimestamp("date");
                cod_complejo = rs.getInt("id_sportcomplex");
                cod_area = rs.getInt("id_area");
                evento = new Evento(nombre,cod_complejo,fecha,cod_area);
 
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
            
            ps.setInt(p,id);
            
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
    
   
    
    
    
}
