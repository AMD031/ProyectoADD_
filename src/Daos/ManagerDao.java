/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Modelo.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Your Name <Antonio Martinez Diaz>
 */
public class ManagerDao {

    public static AreaDao getAreadao() {
        if (areadao == null) {
            areadao = new AreaDao();
        }
        return areadao;
    }

    public static ComisarioDao getComisariodao() {
        if (comisariodao == null) {
            comisariodao = new ComisarioDao();
        }
        return comisariodao;
    }

    public static EventoDao getEventodao() {
        if (eventodao == null) {
            eventodao = new EventoDao();
        }
        return eventodao;
    }

    public static MaterialDao getMateraildao() {

        if (materialdao == null) {
            materialdao = new MaterialDao();
        }
        return materialdao;
    }

    public static PolideportivoDao getPolideportivo() {
        if (polideportivo == null) {
            polideportivo = new PolideportivoDao();
        }
        return polideportivo;
    }

    public static SedeDao getSededao() {
        if (sededao == null) {
            sededao = new SedeDao();
        }
        return sededao;
    }

    public static UnideportivoDao getUnideportivo() {
        if (unideportivo == null) {
            unideportivo = new UnideportivoDao();
        }
        return unideportivo;
    }

    private static AreaDao areadao;
    private static ComisarioDao comisariodao;
    private static EventoDao eventodao;
    private static MaterialDao materialdao;
    private static PolideportivoDao polideportivo;
    private static SedeDao sededao;
    private static UnideportivoDao unideportivo;

}
