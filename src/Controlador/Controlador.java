/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Daos.DaoExepcion;


/**
 *
 * @author Antonio Martinez Diaz
 */
public class Controlador {
    
    //sede 
    public static void mostrar(String str) throws DaoExepcion {
        
        
        if(str.equals("sede")){
            Vista.Menu.imprimeContenido(Daos.ManagerDao.getSededao().ObtenerTodos());
        }
        
        if(str.equals("unideportivo")){
             Vista.Menu.imprimeContenido(Daos.ManagerDao.getUnideportivo().ObtenerTodos());
        }
        
        
           
        if(str.equals("polideportivo")){
             Vista.Menu.imprimeContenido(Daos.ManagerDao.getPolideportivo().ObtenerTodos());
        }
 
        if(str.equals("area")){
             Vista.Menu.imprimeContenido(Daos.ManagerDao.getAreadao().ObtenerTodos());
        }
        
        if(str.equals("evento")){
             Vista.Menu.imprimeContenido(Daos.ManagerDao.getAreadao().ObtenerTodos());
        }
        
         if(str.equals("comisario")){
             Vista.Menu.imprimeContenido(Daos.ManagerDao.getComisariodao().ObtenerTodos());
        }
        
         
         
         
        
        
        
        
  
    }
    
    
    







    
}
