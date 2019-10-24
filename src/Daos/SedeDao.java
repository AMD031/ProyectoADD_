package Daos;

import DaosInterfaces.IDaosSede;
import Modelo.Conexion;
import Modelo.Sede;
import java.io.IOException;
import java.sql.PreparedStatement;
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
                try {
                    n.cerrar();
                } catch (SQLException ex) {
                    Logger.getLogger(SedeDao.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

     return Correcto; 
                
    }

    @Override
    public void modificar(Sede a) {
        
    }

    @Override
    public void eliminar(Sede a) {
       
    }

    @Override
    public List<Sede> ObtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sede obtener(Sede cod) {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
