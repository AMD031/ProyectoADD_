/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import DaosInterfaces.IDaoComplejo;
import Modelo.Complejo;
import Modelo.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Antonio Martinez Diaz
 */
public class ComplejoDao implements IDaoComplejo{
    

    

    @Override
    public boolean insertar(Complejo a) throws DaoExepcion {
        boolean correcto = false;
         String sentencia = "INSERT INTO sportcomplex (location ,boss, id_headquarter )" +
         "VALUES (?,?,?)";
       
           try {
            PreparedStatement ps =  Conexion.obtener().prepareStatement(sentencia, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,a.getLocalizacion());
            ps.setString(2,a.getJefe());
            ps.setInt(3,a.getCod_sede());
            if( ps.executeUpdate()>0){
               correcto = true;
           }
            ResultSet rs =  ps.getGeneratedKeys();
            if(!rs.next()){
                throw  new DaoExepcion("No se ha podido asignar clave.");
            }
            
        } catch (SQLException ex) {
          throw new DaoExepcion(ex);
        }
       return correcto;
        
        
        
    }


    public  boolean modificar(Complejo a) throws DaoExepcion {
       
           boolean correcto = false;
        String sentencia = "UPDATE area set id_multisportcenter = ?"
                + " and location set = ?"
                + " and set sport = ? "
                + "where id = ?  ";
 
        try {
            
            PreparedStatement ps = Conexion.obtener().prepareStatement(sentencia);
            ps.setString(1,a.getLocalizacion());
            ps.setString(2,a.getJefe());
            ps.setInt(3,a.getCod_sede());
            ps.setInt(4, a.getCod());
            
            if(ps.executeUpdate()==0){
                throw new DaoExepcion("Ha fallado la modificacion");
            }else{
                correcto = true;
            }
            
        } catch (SQLException ex) {
            throw new DaoExepcion(ex);
        }finally{
            Conexion.cerrar();
        }
        
        return correcto;
    }

    @Override
    public int eliminar(Integer  a) throws DaoExepcion {
     
        int cantidad = 0;
        String Sentencia =   "DELETE FROM sportcomplex WHERE id =?";
        try {
            PreparedStatement ps =  Conexion.obtener().prepareStatement(Sentencia);
            ps.setInt(1,a);
            cantidad =  ps.executeUpdate();
            
        } catch (SQLException ex) {
              throw new DaoExepcion(ex);
        }finally{
            Conexion.cerrar();
        }
        return cantidad;  
        
        
        
    }

    @Override
    public List<Complejo> ObtenerTodos() throws DaoExepcion {
         ArrayList<Complejo> complejos = null;
       Complejo complejo = null;
       
       String consulta ="SELECT * FROM complejo";
        try {
            PreparedStatement ps = Conexion.obtener().prepareStatement(consulta);
            ResultSet rs  = ps.executeQuery();
              int id;
              String loc;
              String jefe;
              int id_sede;
              complejos = new ArrayList<>();
              
            while(rs.next()){
              id =rs.getInt("id");
              loc = rs.getString("location"); 
              jefe = rs.getString("boss");
              id_sede = rs.getInt("id_headquarter");
              complejo = new Complejo(id, loc, jefe,id_sede);
              if(complejo!=null){
                  complejos.add(complejo);
              }
              
            } 
        } catch (SQLException ex) {
               throw new DaoExepcion(ex);
        }finally{
             Conexion.cerrar();
        }
        return complejos;
    }

  

    @Override
    public Complejo obtener(Integer cod) throws DaoExepcion {
       
          ArrayList<Complejo> complejos = null;
       Complejo complejo = null;
       
       String consulta ="SELECT * FROM complejo";
        try {
              PreparedStatement ps = Conexion.obtener().prepareStatement(consulta);
              ResultSet rs  = ps.executeQuery();
              int id;
              String loc;
              String jefe;
              int id_sede;             
              
            while(rs.next()){
              id =rs.getInt("id");
              loc = rs.getString("location"); 
              jefe = rs.getString("boss");
              id_sede = rs.getInt("id_headquarter");
              
              
              //Complejo(int cod, String localizacion, String jefe, int cod_sede) 
              complejo = new Complejo(id, loc, jefe,id_sede);
            
              
            } 
        } catch (SQLException ex) {
               throw new DaoExepcion(ex);
        }finally{
             Conexion.cerrar();
        }
        return complejo;
        
        
        
        
    }

    @Override
    public boolean modificar(HashMap<Object, Object> a, Integer id) throws DaoExepcion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
