/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import DaosInterfaces.IDaoPolideportivo;
import Modelo.Conexion;
import Modelo.Evento;
import Modelo.Material;
import Modelo.Polideportivo;
import Vista.Main;
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
        String consulta = "SELECT * FROM sportcomplex sx INNER JOIN multisportcenter mr on sx.id = mr.id_sportcomplex where sx.id = ?";
        try {
            PreparedStatement ps = Conexion.obtener().prepareStatement(consulta);
            ps.setInt(1, cod);
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

       /**
     *sportcomplex sx
     *multisportcenter mr 
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
            String consulta = String.format("UPDATE sportcomplex sx INNER JOIN multisportcenter mr on sx.id = mr.id_sportcomplex"
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
    public List<Polideportivo> buscar(HashMap<Object, Object> a) throws DaoExepcion {
         ArrayList<Polideportivo> polideportivos = new ArrayList<>();
         LinkedList<Integer> ids = new LinkedList<>();

        String columna = "";
        int p = 1;
        try {
            for (Object key : a.keySet()) {
                columna = String.format("%s", key);
            }

            String consulta = String.format("SELECT DISTINCT mr.id_sportcomplex  FROM sportcomplex sx INNER JOIN"
                    + " multisportcenter mr on sx.id = mr.id_sportcomplex where %s like ?",
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
                polideportivos.add(obtener(id));
            }

        } catch (SQLException ex) {
            Logger.getLogger(MaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return polideportivos;

    }

   public List<Evento>obtenerEventosPolideportivo(int codEV) throws DaoExepcion{
        String sql = "SELECT DISTINCT ev.id, ev.name, ev.date,ev.id_sportcomplex,ev.id_area FROM event ev INNER JOIN sportcomplex sx on ev.id_sportcomplex =? where ev.id_area !=0 GROUP BY ev.id";
            int id;
            String nombre;
            int cod_complejo;
            Timestamp fecha;
            int cod_area;
            Evento evento =null;
        
        List<Evento>eventos = new ArrayList<>();
        try {
          PreparedStatement ps =  Conexion.obtener().prepareStatement(sql);
          ps.setInt(1,codEV);
          ResultSet rs =  ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
                nombre = rs.getString(2);
                fecha = rs.getTimestamp(3);
                cod_complejo = rs.getInt(4);
                cod_area = rs.getInt(5);
                evento = new Evento(id, nombre,  cod_complejo,  fecha, cod_area); 
                
                
            if(evento !=null){
               eventos.add(evento);
            }
           }
        } catch (SQLException ex) {
         throw new DaoExepcion(ex); 
        }finally{
            Conexion.cerrar();
        }  
        return eventos;
       }
 
    
}
