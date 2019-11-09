/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import DaosInterfaces.IDaoArea;
import Modelo.Area;
import Modelo.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Antonio Martinez Diaz
 */
public class AreaDao implements IDaoArea {

    @Override
    public boolean insertar(Area a) throws DaoExepcion {
        boolean correcto = false;
        String sentencia = "INSERT INTO area(id_multisportcenter,location,sport  )"
                + "VALUES (?,?,?)";

        try {
            PreparedStatement ps = Conexion.obtener().prepareStatement(sentencia, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, a.getCod_poli());
            ps.setString(2, a.getLocalizacion());
            ps.setString(3, a.getDeporte());
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
        String Sentencia = "DELETE FROM area WHERE id =?";
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
    public List<Area> ObtenerTodos() throws DaoExepcion {

        ArrayList<Area> areas = null;
        Area area = null;
        String consulta = "SELECT * FROM area";
        try {
            PreparedStatement ps = Conexion.obtener().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            int id;
            int id_poli;
            String loc;
            String deporte;
            areas = new ArrayList<>();

            while (rs.next()) {
                id = rs.getInt("id");
                id_poli = rs.getInt("id_multisportcenter");
                loc = rs.getString("location");
                deporte = rs.getString("sport");
                area = new Area(id, id_poli, loc, deporte);
                if (area != null) {
                    areas.add(area);
                }

            }
        } catch (SQLException ex) {
            throw new DaoExepcion(ex);
        } finally {
            Conexion.cerrar();
        }
        return areas;

    }

    @Override
    public Area obtener(Integer cod) throws DaoExepcion {
        int id;
        int id_poli;
        String loc;
        String deporte;
        Area area = null;
        String consulta = "SELECT * FROM area where id = ?";
        try {
            
            PreparedStatement ps = Conexion.obtener().prepareStatement(consulta);
            ps.setInt(1, cod);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                id_poli = rs.getInt("id_multisportcenter");
                loc = rs.getString("location");
                deporte = rs.getString("sport");
                area = new Area(id, id_poli, loc, deporte);
            }
        } catch (SQLException ex) {
            throw new DaoExepcion(ex);
        } finally {
            Conexion.cerrar();
        }
        return area;
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
            
            String consulta = String.format("UPDATE area SET %s WHERE id=?",
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
    public List<Area> buscar(HashMap<Object, Object> a) throws DaoExepcion {
         ArrayList<Area> eventos = new ArrayList<>();
         LinkedList<Integer> ids = new LinkedList<>();
         
        String columna = "";
        int p = 1;
        try {
            for (Object key : a.keySet()) {
                columna = String.format("%s", key);
            }

            String consulta = String.format("SELECT DISTINCT id FROM area WHERE %s LIKE ?",
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
           throw new DaoExepcion(ex);
        }
        return eventos;
    }

  

}
