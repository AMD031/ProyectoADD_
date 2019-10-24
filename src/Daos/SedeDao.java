package Daos;

import DaosInterfaces.IDaosSede;
import Modelo.Conexion;
import Modelo.Sede;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Your Name <Antonio Martinez Diaz>
 */
public class SedeDao implements IDaosSede{

    Conexion n;

    public SedeDao(Conexion n) {
        this.n = n;
    }
    
    
    @Override
    public boolean insertar(Sede a) {
     boolean Correcto = false;
            String sentencia ="";
            PreparedStatement ps =null;
            
        try {
           ps =  n.obtener().prepareStatement(sentencia);
           ps.setInt(1, 0);
           
           
           if( ps.executeUpdate()>0){
               Correcto = true;
           }
            
            
          
            
        } catch (SQLException ex) {
            Logger.getLogger(SedeDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
             
            n.cerrar();
              
        }

     return Correcto;               
    }

    @Override
    public void modificar(Sede a) {
        
    }

    @Override
    public int eliminar(Sede a) {
       int cantidad =0;
       String sentencia ="DELETE FROM sede WHERE = ?;";
        try {
          PreparedStatement ps = Conexion.obtener().prepareStatement(sentencia);
          cantidad = ps.executeUpdate();

         } catch (SQLException ex) {
            Logger.getLogger(SedeDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
             Conexion.cerrar();
        }
   
       return cantidad;
        
    }

    @Override
    public List<Sede> ObtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sede obtener(Sede cod) {
       Sede sede =null;
        String sentencia ="Select * from sede where cod = ?;";
        try {
          PreparedStatement ps = Conexion.obtener().prepareStatement(sentencia);
          ResultSet rs =  ps.executeQuery();
           
            while (rs.next()) {
              rs.getInt("cod");
              
              
            }
   
           } catch (SQLException ex) {
            Logger.getLogger(SedeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sede;
    }
    
    
    
}
