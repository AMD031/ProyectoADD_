package Modelo;



import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/**
 *
 * @author Antonio Martinez Diaz
 */

public class Conexion {
    
   private static String host;
   private static String bbdd; 
   private static String login;
   private static String password;

    
    
    
    private Conexion(String host, String bbdd, String login, String password) 
	{
		this.host=host;
		this.bbdd=bbdd;
		this.login=login;
                if(password ==null || password.equals(" ")){
                    this.password ="";
                }else{
                    this.password=password;	
                }
 
	}
    
    
    
    

   private static Connection cnx = null;
   public static Connection obtener() throws SQLException{
        leeXml();
         if (cnx == null || cnx.isClosed()) {
     
           try {
               Class.forName("com.mysql.jdbc.Driver");
      
            cnx =  DriverManager.getConnection("jdbc:mysql://"+ Conexion.host+"/"+ Conexion.bbdd+
            "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Madrid&user="+
            Conexion.login+"&password="+ Conexion.password);
      
                 } catch (ClassNotFoundException ex) {
               Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SQLException ex) {
               Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
           }
            
        
           
      }
      return cnx;
   }
   
   public static void cerrar() {
       
      if (cnx != null) {
          try {
              cnx.close();
          } catch (SQLException ex) {
              Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
   }
   
   
   
    public static void leeXml(){
       ArrayList<String>datos=null;
   
       try {
           if(new File("DatosCnx.xml").exists()){
           datos = new ArrayList<>();
           NodeList nodelist = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("DatosCnx.xml"))
                   .getDocumentElement().getChildNodes();
           
           for (int i = 0; i < nodelist.getLength(); i++) {
               Node node = nodelist.item(i);
               if (node.getNodeType() == 1) {
                   Element element = (Element) node;
                    datos.add( element.getTextContent()); 
               }   
           } 
         }
         
       } catch (org.xml.sax.SAXException ex) {
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ParserConfigurationException ex) {
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
       }
       if(datos!=null){
           Conexion c = new Conexion(datos.get(0), datos.get(1), datos.get(2), datos.get(3));
       }

    }
 
    
    
    
    
    
    
    public static void crearDDBB() throws SQLException {
		try {
                 leeXml();
                 
                Conexion.cnx= DriverManager.getConnection("jdbc:mysql://"+Conexion.host+"/"+""
                + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Madrid&user="
                +Conexion.login+"&password="+Conexion.password);
                Statement  statement = cnx.createStatement();
		String sql = "CREATE DATABASE IF NOT EXISTS "+Conexion.bbdd+" CHARACTER SET utf8 COLLATE utf8_general_ci";
		boolean existe = statement.execute(sql);
                cnx =null;
                if(!existe){
                   Basededatos.CrearTablas();
                }
                
		} catch (SQLException e) {
			throw new SQLException("Error sql, el servidor puede no estar disponible.");
		}
	
	}
    
    
    
    
    
}//fin clase




    
    
    
    
