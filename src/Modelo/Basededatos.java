/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.font.CreatedFontTracker;

/**
 *
 * @author Your Name <Antonio Martinez Diaz>
 */
public class Basededatos {

    public static void CrearTablas() throws SQLException {
        //tabla area
        
        try{
        Conexion.obtener().setAutoCommit(false);
        Statement statement = Conexion.obtener().createStatement();
        String sql = " CREATE TABLE IF NOT EXISTS area ("
                + "  id int(11) NOT NULL AUTO_INCREMENT,"
                + "  id_multisportcenter int(11) NOT NULL,"
                + "  location varchar(50) NOT NULL,"
                + "  sport varchar(50) NOT NULL,"
                + "  PRIMARY KEY (id),"
                + "  KEY id_sportcomlex (id_multisportcenter)"
                + ") ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 ";
        statement.executeUpdate(sql);

        statement = Conexion.obtener().createStatement();
        sql = "        INSERT INTO area (id, id_multisportcenter, location, sport) VALUES"
                + "(1, 1, 'Pistas', 'Atletismo'),"
                + "(2, 1, 'Campo', 'Rugbi'),"
                + "(3, 3, 'Pista', 'Atletismo'),"
                + "(4, 3, 'Campo', 'Fútbol'); ";
        statement.executeUpdate(sql);
  

        //tabla comisario-evento
        statement = Conexion.obtener().createStatement();
        sql = "CREATE TABLE IF NOT EXISTS comissioner_event ("
                + "  id int(11) NOT NULL AUTO_INCREMENT,"
                + "  id_event int(11) NOT NULL,"
                + "  id_comissioner int(11) NOT NULL,"
                + "  rol varchar(50) NOT NULL,"
                + "  PRIMARY KEY (id),"
                + "  KEY evento (id_event),"
                + "  KEY comisario (id_comissioner)"
                + ") ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 ";
        statement.executeUpdate(sql);
  

        statement = Conexion.obtener().createStatement();
        sql = "INSERT INTO comissioner_event (id, id_event, id_comissioner, rol) VALUES"
                + "(1, 7, 1, 'JUEZ'),"
                + "(2, 7, 2, 'OBSERVADOR');";
        statement.executeUpdate(sql);
 

        //tabla comisario
        statement = Conexion.obtener().createStatement();
        sql = "CREATE TABLE IF NOT EXISTS commissioner ("
                + "  id int(11) NOT NULL AUTO_INCREMENT,"
                + "  dni varchar(10) NOT NULL,"
                + "  name varchar(50) NOT NULL,"
                + "  PRIMARY KEY (id)"
                + ") ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;";
        statement.executeUpdate(sql);
    

        statement = Conexion.obtener().createStatement();
        sql = "INSERT INTO commissioner (id, dni, name) VALUES"
                + "(1, '00000000-T', 'Felipe'),"
                + "(2, '00000001-R', 'María');";
        statement.executeUpdate(sql);
    

        //equipamiento
        statement = Conexion.obtener().createStatement();
        sql = "CREATE TABLE IF NOT EXISTS equipment ("
                + "  id int(11) NOT NULL AUTO_INCREMENT,"
                + "  name varchar(50) NOT NULL,"
                + "  PRIMARY KEY (id)"
                + ") ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;";
        statement.executeUpdate(sql);
 

        statement = Conexion.obtener().createStatement();
        sql = "INSERT INTO equipment (id, name) VALUES"
                + "(1, 'CortaCesped'),"
                + "(2, 'Balón');";
        statement.executeUpdate(sql);


        //equipamiento-evento
        statement = Conexion.obtener().createStatement();
        sql = "CREATE TABLE IF NOT EXISTS equipment_event ("
                + "  id int(11) NOT NULL AUTO_INCREMENT,"
                + "  id_equipment int(11) NOT NULL,"
                + "  id_event int(11) NOT NULL,"
                + "  PRIMARY KEY (id),"
                + "  KEY equipamiento (id_equipment),"
                + "  KEY enero (id_event)"
                + ") ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;";
        statement.executeUpdate(sql);
  

        statement = Conexion.obtener().createStatement();
        sql = "INSERT INTO equipment_event (id, id_equipment, id_event) VALUES"
                + "(1, 2, 1),"
                + "(2, 2, 7);";
        statement.executeUpdate(sql);
    
        //evento
        statement = Conexion.obtener().createStatement();
        sql = "CREATE TABLE IF NOT EXISTS event ("
                + "  id int(11) NOT NULL AUTO_INCREMENT,"
                + "  name varchar(50) NOT NULL,"
                + "  date timestamp NOT NULL DEFAULT current_timestamp(),"
                + "  id_sportcomplex int(11) NOT NULL,"
                + "  id_area int(11) DEFAULT NULL,"
                + "  PRIMARY KEY (id),"
                + "  KEY id_sportcomplex (id_sportcomplex)"
                + ") ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;";
        statement.executeUpdate(sql);
  

        statement = Conexion.obtener().createStatement();
        sql = "INSERT INTO event (id, name, date, id_sportcomplex, id_area) VALUES"
                + "(1, 'España-Italia', '2019-10-22 22:00:00', 1, 2),"
                + "(2, '100 metros liso', '2019-10-23 22:00:00', 1, 1),"
                + "(4, 'CAJASUR-BADALONA', '2019-10-04 22:00:00', 2, 0),"
                + "(5, 'ITALIA-BELGICA', '2019-10-29 23:00:00', 3, 1),"
                + "(6, '200M VALLAS', '2019-10-30 23:00:00', 3, 2),"
                + "(7, 'BETIS-SEVILLA', '2019-10-18 22:00:00', 4, NULL);";
        statement.executeUpdate(sql);
  

        //sede
        statement = Conexion.obtener().createStatement();
        sql = "CREATE TABLE IF NOT EXISTS headquarter ("
                + "  id int(11) NOT NULL AUTO_INCREMENT,"
                + "  name varchar(50) NOT NULL,"
                + "  budget float(9,2) NOT NULL,"
                + "  PRIMARY KEY (id)"
                + ") ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;";
        statement.executeUpdate(sql);
  

        statement = Conexion.obtener().createStatement();
        sql = "INSERT INTO headquarter (id, name, budget) VALUES"
                + "(1, 'Córdoba', 1000000.00),"
                + "(2, 'Sevilla', 2000000.00);";
        statement.executeUpdate(sql);
   

        //polideportivo
        statement = Conexion.obtener().createStatement();
        sql = "CREATE TABLE IF NOT EXISTS multisportcenter ("
                + "  id_sportcomplex int(11) NOT NULL,"
                + "  information varchar(50) NOT NULL,"
                + "  PRIMARY KEY (id_sportcomplex)"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
        statement.executeUpdate(sql);
    

        statement = Conexion.obtener().createStatement();
        sql = "INSERT INTO multisportcenter (id_sportcomplex, information) VALUES"
                + "(1, 'Lejos de la ciudad'),"
                + "(3, 'Bien comunicado');";
        statement.executeUpdate(sql);
     

        //unideportivo
        statement = Conexion.obtener().createStatement();
        sql = "CREATE TABLE IF NOT EXISTS sportcenter ("
                + "  id_sportcomplex int(11) NOT NULL,"
                + "  sport varchar(50) NOT NULL,"
                + "  information varchar(50) NOT NULL,"
                + "  PRIMARY KEY (id_sportcomplex)"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
        statement.executeUpdate(sql);
   

        statement = Conexion.obtener().createStatement();
        sql = "INSERT INTO sportcenter (id_sportcomplex, sport, information) VALUES"
                + "(2, 'Basket', 'Nada reseñable'),"
                + "(4, 'Fútbol', 'Musho Betis!');";
        statement.executeUpdate(sql);
     

        //complejo
        statement = Conexion.obtener().createStatement();
        sql = "CREATE TABLE IF NOT EXISTS sportcomplex ("
                + "  id int(11) NOT NULL AUTO_INCREMENT,"
                + "  location varchar(50) NOT NULL,"
                + "  boss varchar(50) NOT NULL,"
                + "  id_headquarter int(11) NOT NULL,"
                + "  PRIMARY KEY (id),"
                + "  KEY sede (id_headquarter)"
                + ") ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;";
        statement.executeUpdate(sql);
 

        statement = Conexion.obtener().createStatement();
        sql = "INSERT INTO sportcomplex (id, location, boss, id_headquarter) VALUES"
                + "(1, 'Rabanales', 'Carlos', 1),"
                + "(2, 'Vistaalegre', 'Eva', 1),"
                + "(3, 'Estadio Olímpico', 'Pepe', 2),"
                + "(4, 'Estadio del Betis', 'Juan', 2);";
        statement.executeUpdate(sql);
  

        //Filtros para la tabla `area`
        statement = Conexion.obtener().createStatement();
        sql = "ALTER TABLE `area`\n"
                + "  ADD CONSTRAINT `id_sportcomlex` FOREIGN KEY (`id_multisportcenter`) REFERENCES `multisportcenter` (`id_sportcomplex`) ON UPDATE CASCADE";
        statement.executeUpdate(sql);
  
       
        // Filtros para la tabla comisario-evento
        statement = Conexion.obtener().createStatement();
        sql = "ALTER TABLE `comissioner_event`\n"
                + "  ADD CONSTRAINT `comisario` FOREIGN KEY (`id_comissioner`) REFERENCES `commissioner` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,\n"
                + "  ADD CONSTRAINT `evento` FOREIGN KEY (`id_event`) REFERENCES `event` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;";
      
        statement.executeUpdate(sql);

        
        //Filtros para la tabla `equipment_event`
        statement = Conexion.obtener().createStatement();
        sql = "ALTER TABLE `equipment_event`\n"
                + "  ADD CONSTRAINT `enero` FOREIGN KEY (`id_event`) REFERENCES `event` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,\n"
                + "  ADD CONSTRAINT `equipamiento` FOREIGN KEY (`id_equipment`) REFERENCES `equipment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;";
        statement.executeUpdate(sql);
  

        //Filtros para la tabla `event`
        statement = Conexion.obtener().createStatement();
        sql = "ALTER TABLE `event`\n"
                + "  ADD CONSTRAINT `id_sportcomplex` FOREIGN KEY (`id_sportcomplex`) REFERENCES `sportcomplex` (`id`);";
        statement.executeUpdate(sql);
   

        //Filtros para la tabla `multisportcenter`
        statement = Conexion.obtener().createStatement();
        sql = "ALTER TABLE `multisportcenter`\n" +
        "  ADD CONSTRAINT `complex` FOREIGN KEY (`id_sportcomplex`) REFERENCES `sportcomplex` (`id`);";
        statement.executeUpdate(sql);
    

        //Filtros para la tabla `sportcenter`
        statement = Conexion.obtener().createStatement();
        sql = "ALTER TABLE `sportcenter`\n" +
        "  ADD CONSTRAINT `sededemono` FOREIGN KEY (`id_sportcomplex`) REFERENCES `sportcomplex` (`id`);";
        statement.executeUpdate(sql);
    
        
        //Filtros para la tabla `sportcomplex`
        statement = Conexion.obtener().createStatement();
        sql = "ALTER TABLE `sportcomplex`\n" +
        "  ADD CONSTRAINT `sede` FOREIGN KEY (`id_headquarter`) REFERENCES `headquarter` (`id`);";
        statement.executeUpdate(sql);
        
        
        }catch(SQLException e){ 
            try {
                Conexion.obtener().rollback();
            } catch (SQLException ex) {
                Logger.getLogger(Basededatos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }finally{
           Conexion.obtener().setAutoCommit(true);
           Conexion.cerrar(); 
        }
   
   

    }

}
