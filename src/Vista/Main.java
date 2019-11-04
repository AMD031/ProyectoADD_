/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Daos.DaoExepcion;
import Modelo.Comisario;
import Modelo.Polideportivo;
import Modelo.Unideportivo;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Antonio Martinez Diaz
 */
public class Main {
 
    
    public static void main(String[] args) {
 

           
        try {
            //Daos.ManagerDao.getUnideportivo().modificar(null);
            
           // Polideportivo a = new Polideportivo("Existe", "en algun lugar", "diablo",2);
 
          
          /*System.out.println( Daos.ManagerDao.getPolideportivo().obtener(1));
           
           for(Polideportivo a: Daos.ManagerDao.getPolideportivo().ObtenerTodos()){
                System.out.println(a);
                        
           }*/
          
        //  Comisario a = new Comisario("1000000T", "SeñorX");
          //Daos.ManagerDao.getComisariodao().insertar(a);
            
            HashMap<Object, Object> dato = new HashMap<>();
            dato.put("budget", 1000000.00);
            Daos.ManagerDao.getSededao().modificar(dato, 1);
            
            
            
            
            
            
            
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
