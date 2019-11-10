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
import Vista.Menu;
import java.util.HashMap;

/**
 *
 * @author Antonio Martinez Diaz
 */
public class Controlador {

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
            Vista.Menu.imprimeContenido(Daos.ManagerDao.getEventodao().ObtenerTodos());
        }

        if (str.equals("comisario")) {
            Vista.Menu.imprimeContenido(Daos.ManagerDao.getComisariodao().ObtenerTodos());
        }

        if (str.equals("material")) {
            Vista.Menu.imprimeContenido(Daos.ManagerDao.getMateraildao().ObtenerTodos());
        }

    }

    public static void insertar(String str, Object a) throws DaoExepcion {
       
        if (str.equals("sede")) {
            Daos.ManagerDao.getSededao().insertar((Sede) a);
        }

        if (str.equals("unideportivo")) {
            Daos.ManagerDao.getUnideportivo().insertar((Unideportivo) a);
        }

        if (str.equals("polideportivo")) {
            Daos.ManagerDao.getPolideportivo().insertar((Polideportivo) a);
        }

        if (str.equals("area")) {
            Daos.ManagerDao.getAreadao().insertar((Area) a);
        }

        if (str.equals("evento")) {
            Daos.ManagerDao.getEventodao().insertar((Evento) a);
        }
        if (str.equals("comisario")) {
            Daos.ManagerDao.getComisariodao().insertar((Comisario) a);

        }

        if (str.equals("material")) {
            Daos.ManagerDao.getMateraildao().insertar((Material) a);
        }

    } //fin metodo 

    public static void borrar(String str, int cod) throws DaoExepcion {

        if (str.equals("sede")) {
            Daos.ManagerDao.getSededao().eliminar(cod);
        }

        if (str.equals("unideportivo")) {
            Daos.ManagerDao.getUnideportivo().eliminar(cod);
        }

        if (str.equals("polideportivo")) {
            Daos.ManagerDao.getPolideportivo().eliminar(cod);
        }

        if (str.equals("area")) {
            Daos.ManagerDao.getAreadao().eliminar(cod);
        }

        if (str.equals("evento")) {
                Daos.ManagerDao.getEventodao().eliminar(cod);
          }

        if (str.equals("comisario")) {
            Daos.ManagerDao.getComisariodao().eliminar(cod);
        }

        if (str.equals("material")) {
            Daos.ManagerDao.getMateraildao().eliminar(cod);
        }
    }

    public static void actualizar(String str, HashMap<Object, Object> datos, int cod) throws DaoExepcion {

        if (str.equals("sede")) {
                Daos.ManagerDao.getSededao().modificar(datos, cod);
        }

        if (str.equals("unideportivo")) {
          Daos.ManagerDao.getUnideportivo().modificar(datos, cod);
        }

        if (str.equals("polideportivo")) {
           Daos.ManagerDao.getPolideportivo().modificar(datos, cod);
        }

        if (str.equals("area")) {
           Daos.ManagerDao.getAreadao().modificar(datos, cod);
        }

        if (str.equals("evento")) {
           Daos.ManagerDao.getEventodao().modificar(datos, cod);
        }

        if (str.equals("comisario")) {
           Daos.ManagerDao.getComisariodao().modificar(datos, cod);
        }

        if (str.equals("material")) {
           Daos.ManagerDao.getMateraildao().modificar(datos, cod);
        }

    }

    public static void buscar(String str, HashMap<Object, Object> datos) throws DaoExepcion {
        if (str.equals("sede")) {
             Menu.imprimeContenido(Daos.ManagerDao.getSededao().buscar(datos));
        }
        
        if (str.equals("unideportivo")) {
          Menu.imprimeContenido(Daos.ManagerDao.getUnideportivo().buscar(datos));
        }

        if (str.equals("polideportivo")) {
           Menu.imprimeContenido(Daos.ManagerDao.getPolideportivo().buscar(datos));
        }

        if (str.equals("area")) {
           Menu.imprimeContenido(Daos.ManagerDao.getAreadao().buscar(datos));
        }

        if (str.equals("evento")) {
          Menu.imprimeContenido(Daos.ManagerDao.getEventodao().buscar(datos));
        }
        if (str.equals("comisario")) {
          Menu.imprimeContenido(Daos.ManagerDao.getComisariodao().buscar(datos));
        }

        if (str.equals("material")) {
           Menu.imprimeContenido(Daos.ManagerDao.getMateraildao().buscar(datos));
        }

    }

    public static void agregarComisarioEvento(int codC, String rol, int codE) throws DaoExepcion {
        Daos.ManagerDao.getComisariodao().agregarComisarioEvento(codC, rol, codE);
    }
    
    public static void agregarMaterialEvento(int codE, int codM) throws DaoExepcion {
       Daos.ManagerDao.getMateraildao().AgregarMaterialEvento(codE, codM); 
    }
    
    public static void obtenerComisariosEvento(int codEvento) throws DaoExepcion{
       Menu.imprimeHashmap(Daos.ManagerDao.getEventodao().obtenerEventoConAgregados(codEvento).getComisarios());
    }
    
    public static void obtenerMaterialesEvento(int codEvento) throws DaoExepcion{
      Menu.imprimeContenido(Daos.ManagerDao.getEventodao().obtenerEventoConAgregados(codEvento).getMateriales());
    }
    
    public static void obtenerEventosPolideportivo(int codUni) throws DaoExepcion{
       Menu.imprimeContenido(Daos.ManagerDao.getPolideportivo().obtenerEventosPolideportivo(codUni));
    }
    
     public static void obtenerEventosUnideportivo(int codPoli) throws DaoExepcion{
      Menu.imprimeContenido(Daos.ManagerDao.getUnideportivo().obtenerEventosUnideportivo(codPoli));
    }
    
    
    
    
    

}
