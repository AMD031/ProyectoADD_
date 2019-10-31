/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import DaosInterfaces.IDaoArea;
import Modelo.Area;
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
public class AreaDao implements IDaoArea{
    private Connection n;

    public AreaDao(Connection n) {
        this.n = n;
    }

    @Override
    public boolean insertar(Area a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Area a) throws DaoExepcion {
        String sentencia = "UPDATE area set id_multisportcenter = ?"
                + " and location set = ?"
                + " and set sport = ? "
                + "where id = ?  ";
 
        try {
            PreparedStatement ps =  n.prepareStatement(sentencia);
            ps.setInt(1, a.getCod_poli());
            ps.setString(2, a.getLocalizacion());
            ps.setString(3, a.getDeporte());
            ps.setInt(4, a.getCod());
            
            if(ps.executeUpdate()<0){
                throw new DaoExepcion("Ha fallado la insercion");
            }
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AreaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    @Override
    public int eliminar(Area a) throws DaoExepcion {
        int cantidad = 0;
        String Sentencia =   "DELETE FROM area WHERE id =?";
        try {
            PreparedStatement ps =  n.prepareStatement(Sentencia);
            ps.setInt(1,a.getCod());
            cantidad =  ps.executeUpdate();
        } catch (SQLException ex) {
              throw new DaoExepcion(ex);
        }
        return cantidad;
    }

    @Override
    public List<Area> ObtenerTodos() throws DaoExepcion {
       
       ArrayList<Area> areas = null;
       Area area = null;
       String consulta ="SELECT * FROM area";
        try {
            PreparedStatement ps = n.prepareStatement(consulta);
            ResultSet rs  = ps.executeQuery();
              int id;
              int id_poli;
              String loc;
              String deporte;
              areas = new ArrayList<>();
              
            while(rs.next()){
              id =rs.getInt("id");
              id_poli = rs.getInt("id_multisportcenter");
              loc = rs.getString("location");
              deporte = rs.getString("sport");
              area = new Area(id, id_poli,loc,deporte);
              if(area!=null){
                  areas.add(area);
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
        return areas;

        
    }

    

    @Override
    public Area obtener(Integer cod) {
              int id;
              int id_poli;
              String loc;
              String deporte;
              Area area = null;
       String consulta ="SELECT * FROM area where id = ?";
        try {
           
            PreparedStatement ps =   n.prepareStatement(consulta);
            ps.setInt(1, cod);
            ResultSet rs  = ps.executeQuery();
            while(rs.next()){
              id =rs.getInt("id");
              id_poli = rs.getInt("id_multisportcenter");
              loc = rs.getString("location");
              deporte = rs.getString("sport");
              area = new Area(id, id_poli,loc,deporte);
            } 
        } catch (SQLException ex) {
            System.out.println(ex);
        }finally{
           try {
              n.close();
           } catch (SQLException ex) {
              new DaoExepcion(ex);
           }
        }
        return area;
    }
    
}
