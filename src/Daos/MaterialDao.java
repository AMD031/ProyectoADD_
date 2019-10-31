/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import DaosInterfaces.IDaoMaterial;
import Modelo.Material;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author Antonio Martinez Diaz
 */
public class MaterialDao implements IDaoMaterial{
    
    private Connection n;
    
    public MaterialDao(Connection n) {
        this.n = n;
    }
    
    @Override
    public boolean insertar(Material a) {
        boolean correcto = false;
         String sentencia = "INSERT INTO equipment(id, name)" +
         "VALUES (?,?);";
         a = new Material(3,"raqueta");
         
        try {
            PreparedStatement ps =  n.prepareStatement(sentencia);
        
            ps.setString(2, a.getNombre());
            ResultSet rs =  ps.getGeneratedKeys();
            while(rs.next()){
                ps.setInt(1, rs.getInt(1));
            }
           
            if( ps.executeUpdate()>0){
               correcto = true;
           }
  
        } catch (SQLException ex) {
           new DaoExepcion(ex);
        }
       return correcto;
    }

    @Override
    public void modificar(Material a) {
        String sentencia = "UPDATE equipment set name = ? where id = ?  ";
        a = new Material(3,"arco");
        try {
            PreparedStatement ps =  n.prepareStatement(sentencia);
            ps.setString(1, a.getNombre());
            ps.setInt(2, a.getCod());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(MaterialDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @Override
    public int eliminar(Material a) throws DaoExepcion {
        int cantidad = 0;
        String Sentencia =   "DELETE FROM equipment WHERE id =?";
        try {
            PreparedStatement ps =  n.prepareStatement(Sentencia);
            ps.setInt(1,a.getCod());
            cantidad =  ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
            throw new DaoExepcion(ex);
        }
        return cantidad;
    }

    @Override
    public List<Material> ObtenerTodos() throws DaoExepcion {
       ArrayList<Material> materiales = null;
       Material material = null;
       String consulta ="SELECT * FROM equipment";
        try {
            PreparedStatement ps =   n.prepareStatement(consulta);
            ResultSet rs  = ps.executeQuery();
              int id;
              String nombre;
              materiales = new ArrayList<>();
            while(rs.next()){
              id =rs.getInt("id");
              nombre = rs.getString("name");
              material = new Material(id, nombre);
            
              if(material!=null){
                  materiales.add(material);
              }
              
            } 
        } catch (SQLException ex) {
                throw new DaoExepcion(ex);
        }finally{
           try {
               n.close();
           } catch (SQLException ex) {
                throw new DaoExepcion(ex);
           }
        }
        return materiales;
    }

    @Override
    public Material obtener(Integer cod) throws DaoExepcion {
       Material material = null;
       String consulta ="SELECT * FROM equipment where id = ?";
        try {
           
            PreparedStatement ps =   n.prepareStatement(consulta);
            ps.setInt(1, cod);
            ResultSet rs  = ps.executeQuery();
              int id;
              String nombre;
            while(rs.next()){
              id =rs.getInt("id");
              nombre = rs.getString("name");
              material = new Material(id, nombre);
            } 
        } catch (SQLException ex) {
            System.out.println(ex);
        }finally{
           try {
               n.close();
           } catch (SQLException ex) {
              throw new DaoExepcion(ex);
           }
        }
        return material;
    }

   
    
}
