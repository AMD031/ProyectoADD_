/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Modelo.Conexion;
import Modelo.Material;

/**
 *
 * @author Your Name <Antonio Martinez Diaz>
 */
public class ManagerDao {

    public AreaDao getAreadao() {
       if(areadao==null){
           areadao = new AreaDao(Conexion.obtener());
       }
        return areadao;
    }

    public ComisarioDao getComisariodao() {
        if(comisariodao==null){
         comisariodao = new ComisarioDao(Conexion.obtener());
        }
        return comisariodao;
    }

    public ComplejoDao getComplejodao() {
         if(complejodao ==null){
           complejodao = new ComplejoDao(Conexion.obtener());
       }
        return complejodao;
    }

    public EventoDao getEventodao() {
       if(eventodao ==null){
         eventodao =new EventoDao(Conexion.obtener());
       }
        return eventodao;
    }

    public static MaterialDao getMateraildao() {
        
       if(materialdao ==null){
          materialdao = new MaterialDao(Conexion.obtener());
       }
       
        return materialdao;
    }

    public PolideportivoDao getPolideportivo() {
        
      if(polideportivo ==null){
          polideportivo = new PolideportivoDao(Conexion.obtener());
      }
      return polideportivo;
    }

    public SedeDao getSededao() {
      if(sededao ==null){
           sededao = new SedeDao(Conexion.obtener());
       }
        return sededao;
    }

    public  UnideportivoDao getUnideportivo() {
       if(unideportivo==null){
           unideportivo = new UnideportivoDao(Conexion.obtener());
       }
       return unideportivo;
    }
    
    private AreaDao areadao;
    private ComisarioDao comisariodao;
    private ComplejoDao complejodao;
    private EventoDao eventodao;
    private static MaterialDao materialdao;
    private PolideportivoDao polideportivo;
    private SedeDao sededao;
    private UnideportivoDao unideportivo;
 
    
  
    
}

