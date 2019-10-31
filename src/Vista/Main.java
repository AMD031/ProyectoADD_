/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Daos.DaoExepcion;
import Daos.ManagerDao;
import Modelo.Material;


/**
 *
 * @author Antonio Martinez Diaz
 */
public class Main {
 
    
    public static void main(String[] args) throws DaoExepcion {
       boolean b = ManagerDao.getMateraildao().insertar(null);
       ManagerDao.getMateraildao().modificar(null);
       Material z = new Material(3, "arco");
      // ManagerDao.getMateraildao().eliminar(z);
       
        for (Material m : ManagerDao.getMateraildao().ObtenerTodos()){
           System.out.println(m); 
        }
      
      
        
        
     // Menu menu =  Menu.getInstance();
      
 
    }

}
