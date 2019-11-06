package Daos;

import DaosInterfaces.IDaosSede;
import Modelo.Conexion;
import Modelo.Sede;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Your Name <Antonio Martinez Diaz>
 */
public class SedeDao implements IDaosSede {


    @Override
    public boolean insertar(Sede a) throws DaoExepcion {

        boolean Correcto = false;
        String insertar = "INSERT INTO headquarter (name, budget) VALUES (?,?)";
        PreparedStatement ps = null;
        try {
            ps = Conexion.obtener().prepareStatement(insertar, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, a.getNombre());
            ps.setFloat(2, a.getPresupuesto());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (!rs.next()) {
                throw new DaoExepcion("Ha fallado la asignacion de la clave.");
            }

        } catch (SQLException e) {
            throw new DaoExepcion(e);
        }finally{
            Conexion.cerrar();
        }
        return Correcto;
    }




    @Override
    public int eliminar(Integer  a) throws DaoExepcion {

        int cantidad = 0;
        String Sentencia = "DELETE FROM headquarter WHERE id =?";
        try {
            PreparedStatement ps = Conexion.obtener().prepareStatement(Sentencia);
            ps.setInt(1,a);
            cantidad = ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DaoExepcion(ex);
        }finally{
            Conexion.cerrar();
        }
        return cantidad;
    }

    @Override
    public List<Sede> ObtenerTodos() throws DaoExepcion {
        ArrayList<Sede> sedes = null;
        Sede sede = null;
        String consulta = "SELECT * FROM headquarter";
        try {
            PreparedStatement ps = Conexion.obtener().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            int id = 0;
            String nombre = "";
            float presupuesto = 0;
            sedes = new ArrayList<>();
            while (rs.next()) {
                id = rs.getInt("id");
                nombre = rs.getString("name");
                presupuesto = rs.getFloat("budget");
                sede = new Sede(id, nombre, presupuesto);

                if (sede != null) {
                    sedes.add(sede);
                }

            }
        } catch (SQLException ex) {
            throw new DaoExepcion(ex);
        } finally {
          Conexion.cerrar();
        }
        return sedes;

    }

    @Override
    public Sede obtener(Integer cod) throws DaoExepcion {
        Sede sede = null;
        String consulta = "SELECT * FROM equipment";
        try {
            PreparedStatement ps = Conexion.obtener().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            int id = 0;
            String nombre = "";
            float presupuesto = 0;

            while (rs.next()) {
                id = rs.getInt("id");
                nombre = rs.getString("name");
                presupuesto = rs.getFloat("budget");
                sede = new Sede(id, nombre, presupuesto);

            }
        } catch (SQLException ex) {
            throw new DaoExepcion(ex);
        } finally {
         Conexion.cerrar();
        }
        return sede;

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
            
            String consulta = String.format("UPDATE headquarter SET %s WHERE id=?",
                     StringUtils.join(clausulas, ","));

            PreparedStatement ps = Conexion.obtener().prepareStatement(consulta);
            for (Object key : a.keySet()) {
                if (a.get(key) instanceof String) {
                    ps.setString(p++, (String) a.get(key));
                }
                
                 if (a.get(key) instanceof Integer) {
                    ps.setDouble(p++, (Integer) a.get(key));
                }
         
                if (a.get(key) instanceof Double) {
                    ps.setDouble(p++, (Double) a.get(key));
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
