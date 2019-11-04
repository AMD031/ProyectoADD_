/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import DaosInterfaces.IDaoPolideportivo;
import Modelo.Conexion;
import Modelo.Polideportivo;
import Vista.Main;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Antonio Martinez Diaz
 */
public class PolideportivoDao implements IDaoPolideportivo {

    @Override
    public boolean insertar(Polideportivo a) throws DaoExepcion {
        boolean correcto = false;
        int id = 0;
        try {
            Conexion.obtener().setAutoCommit(false);
            String sentenciaComplejo = "INSERT INTO sportcomplex (location ,boss, id_headquarter )"
                    + "VALUES (?,?,?)";

            String sentenciaPolideportivo = "INSERT INTO multisportcenter(id_sportcomplex,information )"
                    + "VALUES (?,?)";

            PreparedStatement psPoli, psCom;
            psCom = Conexion.obtener().prepareStatement(sentenciaComplejo, PreparedStatement.RETURN_GENERATED_KEYS);
            psCom.setString(1, a.getLocalizacion());
            psCom.setString(2, a.getJefe());
            psCom.setInt(3, a.getCod_sede());
            psCom.executeUpdate();
            ResultSet rs = psCom.getGeneratedKeys();
            while (rs.next()) {
                id = rs.getInt(1);
            }

            psPoli = Conexion.obtener().prepareStatement(sentenciaPolideportivo, PreparedStatement.RETURN_GENERATED_KEYS);
            psPoli.setInt(1, id);
            psPoli.setString(2, a.getInfo());
            psPoli.executeUpdate();
            Conexion.obtener().commit();

        } catch (SQLException ex) {
            try {

                Conexion.obtener().rollback();
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
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

 
    public boolean modificar(Polideportivo a) {
        
      
        
      return false;
    }

    @Override
    public int eliminar(Integer a) throws DaoExepcion {
        int cantidad = 0;
        String sentenciaComplejo = "DELETE FROM sportcomplex WHERE id = ?";
        String sentenciaPolideportivo = "DELETE FROM  multisportcenter WHERE id_sportcomplex = ?";
        PreparedStatement psPoli, psCom;

        try {
            Conexion.obtener().setAutoCommit(false);
            psPoli = Conexion.obtener().prepareStatement(sentenciaPolideportivo);
            psPoli.setInt(1, a);
            if (psPoli.executeUpdate() > 0) {
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
    public List<Polideportivo> ObtenerTodos() throws DaoExepcion {
        ArrayList<Polideportivo> polideportivos = null;
        Polideportivo polideportivo = null;
        String consulta = "SELECT * FROM sportcomplex sx INNER JOIN multisportcenter mr on sx.id = mr.id_sportcomplex ";
        try {
            PreparedStatement ps = Conexion.obtener().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();

            polideportivos = new ArrayList<>();
            String info;
            int id;
            String localizacion;
            String jefe;
            int cod_sede;
            int idC;

            while (rs.next()) {
                idC= rs.getInt("id_sportcomplex");
                id = rs.getInt("id");
                info = rs.getString("information");
                jefe = rs.getString("boss");
                cod_sede = rs.getInt("id_headquarter");
                localizacion = rs.getString("location");
                polideportivo = new Polideportivo(id, info, idC, localizacion, jefe, cod_sede);

                if (polideportivo != null) {
                    polideportivos.add(polideportivo);
                }
            }
        } catch (SQLException ex) {
            throw new DaoExepcion(ex);
        } finally {
            Conexion.cerrar();
        }
        return polideportivos;
    }

    @Override
    public Polideportivo obtener(Integer cod) throws DaoExepcion {
        Polideportivo polideportivo = null;
        String consulta = "SELECT * FROM sportcomplex sx INNER JOIN multisportcenter mr on sx.id = mr.id_sportcomplex ";
        try {
            PreparedStatement ps = Conexion.obtener().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            String info;
            int id;
            String localizacion;
            String jefe;
            int cod_sede;
            int idC;

            while (rs.next()) {
                idC= rs.getInt("id_sportcomplex");
                id = rs.getInt("id");
                info = rs.getString("information");
                jefe = rs.getString("boss");
                cod_sede = rs.getInt("id_headquarter");
                localizacion = rs.getString("location");
                polideportivo = new Polideportivo(id, info, idC, localizacion, jefe, cod_sede);
            }
        } catch (SQLException ex) {
            throw new DaoExepcion(ex);
        } finally {
            Conexion.cerrar();
        }
        return polideportivo;
    }

    @Override
    public boolean modificar(HashMap<Object, Object> a, Integer id) throws DaoExepcion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
