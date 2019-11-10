/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import DaosInterfaces.IDaoComisario;
import Modelo.Comisario;
import Modelo.Conexion;
import Modelo.Evento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Antonio Martinez Diaz
 */
public class ComisarioDao implements IDaoComisario {

    @Override
    public boolean insertar(Comisario a) throws DaoExepcion {

        boolean correcto = false;
        String sentencia = "INSERT commissioner( name,dni)"
                + "VALUES (?,?)";

        try {
            PreparedStatement ps = Conexion.obtener().prepareStatement(sentencia, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getDNI());
            if (ps.executeUpdate() > 0) {
                correcto = true;
            }
            ResultSet rs = ps.getGeneratedKeys();
            if (!rs.next()) {
                throw new DaoExepcion("No se ha podido asignar clave.");
            }

        } catch (SQLException ex) {
            throw new DaoExepcion(ex);
        } finally {
            Conexion.cerrar();
        }
        return correcto;

    }

    @Override
    public int eliminar(Integer a) throws DaoExepcion {

        int cantidad = 0;
        String Sentencia = "DELETE FROM commissioner WHERE id =?";
        try {
            PreparedStatement ps = Conexion.obtener().prepareStatement(Sentencia);
            ps.setInt(1, a);
            cantidad = ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoExepcion(ex);
        } finally {
            Conexion.cerrar();
        }
        return cantidad;

    }

    @Override
    public List<Comisario> ObtenerTodos() throws DaoExepcion {
        List<Comisario> comisarios = null;
        Comisario comisario = null;
        String consulta = "SELECT * FROM commissioner";
        try {
            PreparedStatement ps = Conexion.obtener().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            int id;
            String nombre;
            String dni;

            comisarios = new ArrayList<>();
            while (rs.next()) {
                id = rs.getInt("id");
                nombre = rs.getString("name");
                dni = rs.getString("dni");
                comisario = new Comisario(id, dni, nombre);

                if (comisario != null) {
                    comisarios.add(comisario);
                }

            }
        } catch (SQLException ex) {
            throw new DaoExepcion(ex);
        } finally {
            Conexion.cerrar();
        }
        return comisarios;
    }

    @Override
    public Comisario obtener(Integer cod) throws DaoExepcion {

        Comisario comisario = null;
        String consulta = "SELECT * FROM commissioner where id =?";
        try {
            PreparedStatement ps = Conexion.obtener().prepareStatement(consulta);
            ps.setInt(1, cod);
            ResultSet rs = ps.executeQuery();
            int id;
            String nombre;
            String dni;

            while (rs.next()) {
                id = rs.getInt("id");
                nombre = rs.getString("name");
                dni = rs.getString("dni");
                comisario = new Comisario(id, dni, nombre);
            }
        } catch (SQLException ex) {
            throw new DaoExepcion(ex);
        } finally {
            Conexion.cerrar();
        }
        return comisario;
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
            
            String consulta = String.format("UPDATE commissioner SET %s WHERE id=?",
                     StringUtils.join(clausulas, ","));

            PreparedStatement ps = Conexion.obtener().prepareStatement(consulta);
            for (Object key : a.keySet()) {

                if (a.get(key) instanceof String) {
                    ps.setString(p++, (String) a.get(key));
                }

                if (a.get(key) instanceof Integer) {
                  
                    ps.setInt(p++, (Integer) a.get(key));
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

    @Override
    public List<Comisario> buscar(HashMap<Object, Object> a) throws DaoExepcion {
        ArrayList<Comisario> comisarios = new ArrayList<>();
        ArrayList<Integer> ids = new ArrayList<>();

        String columna = "";
        int p = 1;
        try {
            for (Object key : a.keySet()) {
                columna = String.format("%s", key);
            }
            
            String consulta = String.format("SELECT DISTINCT id FROM commissioner WHERE %s LIKE ?",
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
                comisarios.add(obtener(id));
            }

         
        } catch (SQLException ex) {
            Logger.getLogger(MaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comisarios;
    }

    public void agregarComisarioEvento(int codC, String rol, int codE ) throws DaoExepcion{
    
            Comisario c =  obtener(codC);
            Evento e =  Daos.ManagerDao.getEventodao().obtener(codE);
            String sql = "INSERT INTO comissioner_event (id, id_event, id_comissioner, rol) VALUES (NULL, ?, ?, ?)";
            if(e!=null && c!=null){
                try {
                  PreparedStatement ps = Conexion.obtener().prepareStatement(sql);
                  ps.setInt(1, e.getCod());
                  ps.setInt(2, c.getCod());
                  ps.setString(3,rol);
                 if( ps.executeUpdate()<1){      
                       throw new DaoExepcion("no se ha insertado");
                 }  
                 
               } catch (SQLException ex) { 
               
                 throw new DaoExepcion(ex);
                }finally{
                  Conexion.cerrar();
                }
             }else{
                Conexion.cerrar();
                throw new DaoExepcion("No existe en la base de datos algunos elementos.");
            }
            
     
    }
    
 
      
      
      
    
}
