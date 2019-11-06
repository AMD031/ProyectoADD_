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
  
    }
    
    
    







    
}
