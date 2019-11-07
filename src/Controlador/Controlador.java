/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Daos.DaoExepcion;
import Modelo.Area;
import Modelo.Comisario;
import Modelo.Evento;
import Modelo.Material;
import Modelo.Polideportivo;
import Modelo.Sede;
import Modelo.Unideportivo;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antonio Martinez Diaz
 */
public class Controlador {

    //sede 
    public static void mostrar(String str) throws DaoExepcion {

        if (str.equals("sede")) {
            Vista.Menu.imprimeContenido(Daos.ManagerDao.getSededao().ObtenerTodos());
        }

        if (str.equals("unideportivo")) {
            Vista.Menu.imprimeContenido(Daos.ManagerDao.getUnideportivo().ObtenerTodos());
        }

        if (str.equals("polideportivo")) {
            Vista.Menu.imprimeContenido(Daos.ManagerDao.getPolideportivo().ObtenerTodos());
        }

        if (str.equals("area")) {
            Vista.Menu.imprimeContenido(Daos.ManagerDao.getAreadao().ObtenerTodos());
        }

        if (str.equals("evento")) {
            Vista.Menu.imprimeContenido(Daos.ManagerDao.getAreadao().ObtenerTodos());
        }

        if (str.equals("comisario")) {
            Vista.Menu.imprimeContenido(Daos.ManagerDao.getComisariodao().ObtenerTodos());
        }

        if (str.equals("material")) {
            Vista.Menu.imprimeContenido(Daos.ManagerDao.getMateraildao().ObtenerTodos());
        }

    }

    public static void insertar(String str, Object a) {
        if (str.equals("sede")) {
            try {
                Daos.ManagerDao.getSededao().insertar((Sede) a);
            } catch (DaoExepcion ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (str.equals("unideportivo")) {
            try {
                Daos.ManagerDao.getUnideportivo().insertar((Unideportivo) a);
            } catch (DaoExepcion ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (str.equals("polideportivo")) {
            try {
                Daos.ManagerDao.getPolideportivo().insertar((Polideportivo) a);
            } catch (DaoExepcion ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (str.equals("polideportivo")) {
            try {
                Daos.ManagerDao.getPolideportivo().insertar((Polideportivo) a);
            } catch (DaoExepcion ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (str.equals("area")) {
            try {
                Daos.ManagerDao.getAreadao().insertar((Area) a);
            } catch (DaoExepcion ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (str.equals("evento")) {
            try {
                Daos.ManagerDao.getEventodao().insertar((Evento) a);
            } catch (DaoExepcion ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (str.equals("evento")) {
            try {
                Daos.ManagerDao.getEventodao().insertar((Evento) a);
            } catch (DaoExepcion ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (str.equals("material")) {
            try {
                Daos.ManagerDao.getMateraildao().insertar((Material) a);
            } catch (DaoExepcion ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
               
    } //fin metodo 

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
