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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Antonio Martinez Diaz
 */
public class EventoDao implements IDaoEvento {
    

    

    @Override
    public boolean insertar(Evento a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public boolean modificar(Evento a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
        return null;
        
        
    }


    @Override
    public Evento obtener(Integer cod) throws DaoExepcion {
        return null;
        
    }

    @Override
    public boolean modificar(HashMap<Object, Object> a, Integer id) throws DaoExepcion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
