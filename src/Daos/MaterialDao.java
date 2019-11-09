/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import DaosInterfaces.IDaoMaterial;
import Modelo.Conexion;
import Modelo.Material;
import Modelo.Sede;
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
public class MaterialDao implements IDaoMaterial {

    @Override
    public boolean insertar(Material a) throws DaoExepcion {
        boolean correcto = false;
        String sentencia = "INSERT INTO equipment( name)"
                + "VALUES (?)";

        try {
            PreparedStatement ps = Conexion.obtener().prepareStatement(sentencia, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, a.getNombre());
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
        String Sentencia = "DELETE FROM equipment WHERE id =?";
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
    public List<Material> ObtenerTodos() throws DaoExepcion {
        ArrayList<Material> materiales = null;
        Material material = null;
        String consulta = "SELECT * FROM equipment";
        try {
            PreparedStatement ps = Conexion.obtener().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            int id;
            String nombre;
            materiales = new ArrayList<>();
            while (rs.next()) {
                id = rs.getInt("id");
                nombre = rs.getString("name");
                material = new Material(id, nombre);

                if (material != null) {
                    materiales.add(material);
                }
            }
        } catch (SQLException ex) {
            throw new DaoExepcion(ex);
        } finally {
            Conexion.cerrar();
        }
        return materiales;
    }

    @Override
    public Material obtener(Integer cod) throws DaoExepcion {
        Material material = null;
        String consulta = "SELECT * FROM equipment where id = ?";
        try {

            PreparedStatement ps = Conexion.obtener().prepareStatement(consulta);
            ps.setInt(1, cod);
            ResultSet rs = ps.executeQuery();
            int id;
            String nombre;
            while (rs.next()) {
                id = rs.getInt("id");
                nombre = rs.getString("name");
                material = new Material(id, nombre);
            }
        } catch (SQLException ex) {
            throw new DaoExepcion(ex);
        } finally {
            Conexion.cerrar();
        }
        return material;
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

            String consulta = String.format("UPDATE equipment SET %s WHERE id=?",
                    StringUtils.join(clausulas, ","));

            PreparedStatement ps = Conexion.obtener().prepareStatement(consulta);
            for (Object key : a.keySet()) {

                if (a.get(key) instanceof String) {
                    ps.setString(p++, (String) a.get(key));
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
    public List<Material> buscar(HashMap<Object, Object> a) throws DaoExepcion {

        ArrayList<Material> materiales = new ArrayList<>();
        ArrayList<Integer> ids = new ArrayList<>();

        String columna = "";
        int p = 1;
        try {
            for (Object key : a.keySet()) {
                columna = String.format("%s", key);
            }

            String consulta = String.format("SELECT DISTINCT eqt.id FROM equipment eqt WHERE %s LIKE ?",
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
                materiales.add(obtener(id));
            }

         
        } catch (SQLException ex) {
            throw new DaoExepcion(ex);
        }
        return materiales;

    }

   

}
