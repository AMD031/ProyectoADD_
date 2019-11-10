/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Daos.DaoExepcion;
import Modelo.Area;
import Modelo.Comisario;
import Modelo.Conexion;
import Modelo.Evento;
import Modelo.Material;
import Modelo.Polideportivo;
import Modelo.Sede;
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
     Conexion.crearDDBB();
     Menu menu =  Menu.getInstance();          
   }

}
