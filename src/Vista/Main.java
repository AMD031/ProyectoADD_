/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Daos.DaoExepcion;
import Modelo.Evento;
import Modelo.Polideportivo;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Antonio Martinez Diaz
 */
public class Main {
 
    
    public static void main(String[] args) throws ParseException, Exception {
        try {
            //Daos.ManagerDao.getUnideportivo().modificar(null);
            
           // Polideportivo a = new Polideportivo("Existe", "en algun lugar", "diablo",2);
 
          
          /*System.out.println( Daos.ManagerDao.getPolideportivo().obtener(1));
           
           for(Polideportivo a: Daos.ManagerDao.getPolideportivo().ObtenerTodos()){
                System.out.println(a);
                        
           }*/
          
        //  Comisario a = new Comisario("1000000T", "SeñorX");
          //Daos.ManagerDao.getComisariodao().insertar(a);
            
           //HashMap<Object, Object> dato = new HashMap<>();
            //dato.put("mr.information", "barrio peligroso");  
            
         //Daos.ManagerDao.getPolideportivo().modificar(dato,1); 
           // Sede a = new Sede("Madrid",  1500000);
           // Daos.ManagerDao.getSededao().insertar(a);
          
                                             //yyyy-MM-dd hh:mm:ss.SSS
            //Timestamp(int year, int month, int date, int hour, int minute, int second, int nano)                                 
            
         

        //MM.dd.yyyy hh:ss
            //Evento a = new Evento("tiro con arco", 1, Evento.stringToTimestamp("13.10.1999 10:90"), 1);
           // Daos.ManagerDao.getEventodao().insertar(a);
           HashMap<Object, Object> dato = new HashMap<>();
           dato.put("name", "pertiga");
           dato.put("date", Evento.stringToTimestamp("10.10.1999 20:40"));
           
          
           Daos.ManagerDao.getEventodao().modificar(dato, 2);
            for (Modelo.Evento e : Daos.ManagerDao.getEventodao().ObtenerTodos() ) {
                System.out.println(e);
            }
           
           
            
            
            
            
            
           /* Unideportivo u2  =Daos.ManagerDao.getUnideportivo().obtener(2);
            System.out.println(u2);
            System.out.println("-------------");
            
            for(Unideportivo u :Daos.ManagerDao.getUnideportivo().ObtenerTodos()){
                System.out.println(u);
            }*/
            
            
            
            //Unideportivo uni = new Unideportivo("tenis", "lluvia", "Sevilla", "maria", 1);
            //Daos.ManagerDao.getUnideportivo().insertar(uni);
            
            // Unideportivo a = new Unideportivo(114);
            // Daos.ManagerDao.getUnideportivo().eliminar(a);
            
            
            
            
            // Menu menu =  Menu.getInstance();
        } catch (DaoExepcion ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      
 
    }

}
