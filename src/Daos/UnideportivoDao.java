/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import DaosInterfaces.IDaoUnideportivo;
import Modelo.Conexion;
import Modelo.Polideportivo;
import Modelo.Unideportivo;
import Vista.Main;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Antonio Martinez Diaz
 */
public class UnideportivoDao implements IDaoUnideportivo {
    @Override
    public boolean insertar(Unideportivo a) throws DaoExepcion {
        boolean correcto = false;
        int id = 0;
        try {
            Conexion.obtener().setAutoCommit(false);
            String sentenciaComplejo = "INSERT INTO sportcomplex (location ,boss, id_headquarter )"
                    + "VALUES (?,?,?)";

            String sentenciaUnideportivo = "INSERT INTO sportcenter (id_sportcomplex, sport , information )"
                    + "VALUES (?,?,?)";

            PreparedStatement psUni, psCom;
            psCom = Conexion.obtener().prepareStatement(sentenciaComplejo, PreparedStatement.RETURN_GENERATED_KEYS);
            psCom.setString(1, a.getLocalizacion());
            psCom.setString(2, a.getJefe());
            psCom.setInt(3, a.getCod_sede());
            psCom.executeUpdate();
            ResultSet rs = psCom.getGeneratedKeys();
            while (rs.next()) {
                id = rs.getInt(1);
            }

            psUni = Conexion.obtener().prepareStatement(sentenciaUnideportivo, PreparedStatement.RETURN_GENERATED_KEYS);
            psUni.setInt(1, id);
            psUni.setString(2, a.getDeporte());
            psUni.setString(3, a.getInfo());
            psUni.executeUpdate();
            Conexion.obtener().commit();

        } catch (SQLException ex) {
            try {
                Conexion.obtener().rollback();
                throw new DaoExepcion("Error sql" + ex);
            } catch (SQLException e) {
                throw new DaoExepcion("Error sql" + e);
            }
        } finally {

            try {
                Conexion.obtener().setAutoCommit(true);
                Conexion.obtener().close();
            } catch (SQLException ex) {
                throw new DaoExepcion("Error sql", ex);
            }
        }
        return correcto;
    }


    @Override
    public int eliminar(Integer  a) throws DaoExepcion {
        int cantidad = 0;
        String sentenciaComplejo = "DELETE FROM sportcomplex WHERE id = ?";
        String sentenciaUnideportivo = "DELETE FROM sportcenter WHERE id_sportcomplex = ?";
        PreparedStatement psUni, psCom;

        try {
            Conexion.obtener().setAutoCommit(false);
            psUni = Conexion.obtener().prepareStatement(sentenciaUnideportivo);
            psUni.setInt(1, a);
            if (psUni.executeUpdate() > 0) {
                cantidad++;
            }

            psCom = Conexion.obtener().prepareStatement(sentenciaComplejo);
            psCom.setInt(1, a);
            if (psCom.executeUpdate() > 0) {
                cantidad++;
            }

            Conexion.obtener().commit();
        } catch (SQLException ex) {
            try {
                Conexion.obtener().rollback();
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                throw new DaoExepcion(ex1);
            }
        } finally {
            try {
                Conexion.obtener().setAutoCommit(true);
                Conexion.obtener().close();
            } catch (SQLException ex) {
                throw new DaoExepcion(ex);
            }
        }
        return cantidad;
    }

    @Override
    public List<Unideportivo> ObtenerTodos() throws DaoExepcion {
        ArrayList<Unideportivo> unideportivos = null;
        Unideportivo unideportivo = null;
        String consulta = "SELECT * FROM sportcomplex sx INNER JOIN sportcenter sr on sx.id = sr.id_sportcomplex";
        try {
            PreparedStatement ps = Conexion.obtener().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();

            unideportivos = new ArrayList<>();
            String deporte;
            String info;
            int id;
            String localizacion;
            String jefe;
            int cod_sede;
            int idC; 
            
            while (rs.next()) {
                idC = rs.getInt("id_sportcomplex");
                id = rs.getInt("id");
                info = rs.getString("information");
                deporte = rs.getString("sport");
                jefe = rs.getString("boss");
                cod_sede = rs.getInt("id_headquarter");
                localizacion = rs.getString("location");
                unideportivo = new Unideportivo(id,deporte, info,idC, localizacion, jefe, cod_sede);
                if (unideportivo != null) {
                    unideportivos.add(unideportivo);
                }
            }
        } catch (SQLException ex) {
            throw new DaoExepcion(ex);
        } finally {
           Conexion.cerrar();
        }
        return unideportivos;
    }
    
    @Override
    public Unideportivo obtener(Integer cod) throws DaoExepcion {
        Unideportivo unideportivo = null;
        String consulta = "SELECT * FROM sportcomplex sx INNER JOIN sportcenter sr on sx.id = sr.id_sportcomplex where id_sportcomplex =?";
        
        try {
            PreparedStatement ps = Conexion.obtener().prepareStatement(consulta);
            ps.setInt(1,cod);
            ResultSet rs = ps.executeQuery();
            String deporte;
            String info;
            int id;
            String localizacion;
            String jefe;
            int cod_sede;
            int idC;

            while (rs.next()) {
                id = rs.getInt("id_sportcomplex");
                idC = rs.getInt("id");
                info = rs.getString("information");
                deporte = rs.getString("sport");
                jefe = rs.getString("boss");
                cod_sede = rs.getInt("id_headquarter");
                localizacion = rs.getString("location");
                unideportivo = new Unideportivo(idC,deporte, info,id, localizacion, jefe, cod_sede);
               
            }
        } catch (SQLException ex) {
            throw new DaoExepcion(ex);
        } finally {
                Conexion.cerrar();
        }
        return unideportivo; 
    }
    /**
     *sportcomplex sx
     *sportcenter sr 
    */
    
    @Override
    public boolean modificar(HashMap<Object, Object> a, Integer id) throws DaoExepcion {
         
        boolean correcto = false;
        int p = 1;
        try {
            List<String> clausulas = new ArrayList<>();
            for (Object key : a.keySet()) {
                clausulas.add(String.format("%s=?", key));
            }
            String consulta = String.format("UPDATE sportcomplex sx INNER JOIN sportcenter sr on sx.id = sr.id_sportcomplex"
                    + " SET %s  WHERE sx.id = ?;",
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
    public List<Unideportivo> buscar(HashMap<Object, Object> a) throws DaoExepcion {
           ArrayList<Unideportivo>   unideportivos = new ArrayList<>();
         LinkedList<Integer> ids = new LinkedList<>();

        String columna = "";
        int p = 1;
        try {
            for (Object key : a.keySet()) {
                columna = String.format("%s", key);
            }

            String consulta = String.format("SELECT DISTINCT sr.id_sportcomplex FROM sportcomplex sx INNER JOIN sportcenter sr on " +
            "sx.id = sr.id_sportcomplex where %s like ? ",
                    StringUtils.join(columna));
            
            
         
            PreparedStatement ps = Conexion.obtener().prepareStatement(consulta);
            for (Object key : a.keySet()) {
                if (a.get(key) instanceof String) {
                    ps.setString(p++, (String) a.get(key));
                }
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ids.add(rs.getInt("id_sportcomplex"));
            }

            for (Integer id : ids) {
                unideportivos.add(obtener(id));
            }

        } catch (SQLException ex) {
            Logger.getLogger(MaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unideportivos;

        
        
    }

   

}
