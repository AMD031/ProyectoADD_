/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import Daos.DaoExepcion;
import Modelo.Area;
import Modelo.Comisario;
import Modelo.Evento;
import Modelo.Material;
import Modelo.Polideportivo;
import Modelo.Sede;
import Modelo.Unideportivo;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antonio Martinez Diaz
 */
public class Menu {

    private static Menu instance;

    public static Menu getInstance() {

        if (instance == null) {
            Menu.instance = new Menu();
        }
        return Menu.instance;
    }

    private Menu() {
        this.creaPrinciapal();
        this.sc = new Scanner(System.in);
        this.datos = new ArrayList<>();
        Menu.err = false;
        Menu.iniciaMenu(sc);
    }

    private static boolean err;
    private static ArrayList<String> Principal;
    private static Scanner sc;
    ArrayList datos;
    private static int opn;

    private void creaPrinciapal() {
        Principal = new ArrayList<>();
        Principal.add("1 Menu sede");
        Principal.add("2 Menu unidiportivo");
        Principal.add("3 Menu polideportivo");
        Principal.add("4 Menu area");
        Principal.add("5 Menu evento");
        Principal.add("6 Menu comisario");
        Principal.add("7 Menu material");
        Principal.add("0 salir");
    }

    private static List<String> creaSubmenu(String txt) {
        ArrayList<String> Submenu = new ArrayList<>();
        Submenu.add("---" + txt.toUpperCase() + "---");
        Submenu.add("1 Crear " + txt);
        Submenu.add("2 Actualizar " + txt);
        Submenu.add("3 Borrar " + txt);
        Submenu.add("4 Listar todos ");
        Submenu.add("5 Listar un elemento por codigo" + txt);
        Submenu.add("0 Salir");

        return Submenu;
    }

    private static void imprimeMenu(List<String> opiones) {
        for (String op : opiones) {
            System.out.println(op);
        }
    }

    public static void imprimeContenido(List<? extends Object> contenedor) {

        for (Object contenido : contenedor) {
            System.out.println(contenido);
        }
    }

    private static void imprime(String txt) {
        System.out.println(txt);
    }

    private static void iniciaMenu(Scanner sc) {

        int op = 0;

        imprimeMenu(Principal);
        try {

            if (!err) {
                op = sc.nextInt();
            } else {
                op = Menu.opn;
            }

            switch (op) {
                case 1:
                    err = false;
                    MenuSede(sc);
                    break;
                case 2:
                      err = false;
                    MenuUnideportivo(sc);
                    break;
                case 3:
                    err = false;
                    MenuPolideportivo(sc);
                    break;
                case 4:
                     err = false;
                    MenuArea(sc);
                    break;
                case 5:
                     err = false; 
                    MenuEvento(sc);
                    break;
                case 6:
                    err = false;
                    MenuComisario(sc);
                    break;
                case 7:
                     err = false;
                    MenuMaterial(sc);
                    break;
            }

        } catch (InputMismatchException e) {
            imprime("Error de Formato " + e);
            Menu.sc = new Scanner(System.in);

        }

    }

    private static void MenuSede(Scanner sc) {

        int op = 0;
        try {
            do {

                imprimeMenu(creaSubmenu("sede"));
                op = sc.nextInt();
                String nombre;
                Float presupuesto;
                int codE =0;

                switch (op) {

                    case 1:
                        imprime("Introduce nombre sede");
                        nombre = sc.next();
                        sc.nextLine();

                        imprime("Introduce presupuesto");
                        presupuesto = sc.nextFloat();
                        sc.nextLine();

                        Sede a = new Sede(nombre, presupuesto);
                        Controlador.insertar("sede", a);
                        a = null;
                        break;

                    case 2:

                        break;
     
                    case 3:
                      imprime("introduce codigo");
                      codE  = sc.nextInt();                      
                      Controlador.borrar("sede", codE);

                        break;

                    case 4:
                        Controlador.mostrar("sede");
                        break;
                }

            } while (op != 0);
        } catch (InputMismatchException e) {
            System.out.println("Error: no se permite letras");
            Menu.sc = new Scanner(System.in);
            Menu.opn =1;
            Menu.err = true;

        } catch (DaoExepcion ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
           iniciaMenu(Menu.sc);
        }

     

    }
    


    private static void MenuUnideportivo(Scanner sc) {

        String deporte;
        String info;
        String localizacion;
        String jefe;
        int cod_sede;
        int codE =0;
        
        
        int op = 0;
        try {
            do {

                imprimeMenu(creaSubmenu("Unideportivo"));
                op = sc.nextInt();
                switch (op) {
                    case 1:
                     
                        Menu.imprime("Introduce deporte");
                        deporte = sc.next();
                        Menu.imprime("Introduce informacion");
                        info = sc.next();
                        Menu.imprime("Introduce localizacion");
                        localizacion = sc.next();
                        sc.nextLine();
                        Menu.imprime("Introduce jefe");
                        jefe = sc.next();
                        Menu.imprime("Introduce codigo sede");
                        cod_sede = sc.nextInt();
                        
                        Unideportivo a = new Unideportivo(deporte, info, localizacion, jefe, cod_sede);
                        Controlador.insertar("unideportivo", a);
                        break;
        
                       case 3:
                      imprime("introduce codigo");
                      codE  = sc.nextInt();                      
                      Controlador.borrar("unideportivo", codE);

                        break; 
                        
                        
                    case 4:
                        Controlador.mostrar("unideportivo");
                        break;

                }
            } while (op != 0);

        }catch (InputMismatchException e) {
            System.out.println("Error: no se permite letras");
            Menu.sc = new Scanner(System.in);
            Menu.opn =2;
            Menu.err = true;

        } catch (DaoExepcion ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
           iniciaMenu(Menu.sc);
        }
        
    } 

    private static void MenuPolideportivo(Scanner sc) {

        int op = 0;
        String info;
        String localizacion;
        String jefe;
        int cod_sede;
        int codE =0;
        try {
            do {

                imprimeMenu(creaSubmenu("Polideportivo"));
                op = sc.nextInt();
                switch (op) {
                    
                     case 1:
                        Menu.imprime("Introduce informacion");
                        info = sc.next();
                        Menu.imprime("Introduce localizacion");
                        localizacion = sc.next();
                        sc.nextLine();
                        Menu.imprime("Introduce jefe");
                        jefe = sc.next();
                        Menu.imprime("Introduce codigo sede");
                        cod_sede = sc.nextInt();
                        
                        Polideportivo a = new Polideportivo(info, localizacion, jefe, cod_sede);
                        Controlador.insertar("polideportivo", a);
                      break;
                      
                               case 3:
                      imprime("introduce codigo");
                      codE  = sc.nextInt();                      
                      Controlador.borrar("polideportivo", codE);

                        break;
                      
                    case 4:
                        Controlador.mostrar("polideportivo");
                        break;
                }
            } while (op != 0);
        }catch (InputMismatchException e) {
            System.out.println("Error: no se permite letras");
            Menu.sc = new Scanner(System.in);
            Menu.opn =3;
            Menu.err = true;

        } catch (DaoExepcion ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
           iniciaMenu(Menu.sc);
        }

    }

    private static void MenuArea(Scanner sc) {

        int op = 0;
        int cod_poli; 
        String localizacion;
        String deporte;
        int codE =0;
        try {
            do {
                imprimeMenu(creaSubmenu("Area"));
                op = sc.nextInt();
                switch (op) {
                    case 1:
                    Menu.imprime("Introduce codigo polideportivo");
                    cod_poli = sc.nextInt(); 
                    Menu.imprime("Introduce localizacion");
                    sc.nextLine();
                    localizacion = sc.nextLine();
                    Menu.imprime("Introduce deporte");
                    deporte = sc.next();   
    
                    Area a = new Area(cod_poli, localizacion, deporte);
                    Controlador.insertar("area", a);
                    break;
                    
                                  case 3:
                      imprime("introduce codigo");
                      codE  = sc.nextInt();                      
                      Controlador.borrar("area", codE);

                        break;
                    

                    case 4:
                        Controlador.mostrar("area");
                        break;

                }
            } while (op != 0);
        } catch (InputMismatchException e) {
            System.out.println("Error: no se permite letras");
            Menu.sc = new Scanner(System.in);
            Menu.opn =4;
            Menu.err = true;

        } catch (DaoExepcion ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
           iniciaMenu(Menu.sc);
        }

    }

    private static void MenuEvento(Scanner sc) {
        int op = 0;
        String nombre;
        int cod_complejo; 
        String fecha;
        int cod_area;
        int codE =0;
        
        
        try {
            do {
                imprimeMenu(creaSubmenu("Evento"));
                op = sc.nextInt();
                switch (op) {
                    case 1:
                        Menu.imprime("Introduce nombre");
                        nombre = sc.next();
                        Menu.imprime("Introduce codigo del complejo");
                        cod_complejo = sc.nextInt();
                        Menu.imprime("Introduce fecha");
                        fecha = sc.next();
                        Menu.imprime("Intoduce codigo area");
                        cod_area = sc.nextInt();
     
                        Evento a = new Evento(nombre, cod_complejo,  Evento.stringToTimestamp(fecha), cod_area);
                        Controlador.insertar("evento", a);
                        
                        break;
                    
                     case 3:
                      imprime("introduce codigo");
                      codE  = sc.nextInt();                      
                      Controlador.borrar("evento", codE);
                     break;     
                        
                    
                    
                    case 4:
                        Controlador.mostrar("evento");
                        break;

                }
            } while (op != 0);
        }catch (InputMismatchException e) {
            System.out.println("Error: no se permite letras");
            Menu.sc = new Scanner(System.in);
            Menu.opn =5;
            Menu.err = true;

        } catch (DaoExepcion ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
           iniciaMenu(Menu.sc);
        }

    }

    private static void MenuComisario(Scanner sc) {
        int op = 0;
         String DNI;
         String Nombre;
         int codE =0;
        try {
            do {
                imprimeMenu(creaSubmenu("Comisario"));
                op = sc.nextInt();
                switch (op) {
                    case 1:
                     Menu.imprime("Introduce Dni");
                     DNI = sc.next();
                     Menu.imprime("Introduce nombre");
                     Nombre = sc.next();
                     
                     Comisario a = new Comisario(DNI, Nombre);
                     Controlador.insertar("comisario", a);
                    break;
                    
                            case 3:
                      imprime("introduce codigo");
                      codE  = sc.nextInt();                      
                      Controlador.borrar("comisario", codE);
                     break;     
                    
                    case 4:
                        Controlador.mostrar("comisario");
                        break;
                }
            } while (op != 0);
        }catch (InputMismatchException e) {
            System.out.println("Error: no se permite letras");
            Menu.sc = new Scanner(System.in);
            Menu.opn =6;
            Menu.err = true;

        } catch (DaoExepcion ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
           iniciaMenu(Menu.sc);
        } 
    }

    private static void MenuMaterial(Scanner sc) {
        int op = 0;
        int codE =0;
        String nombre;
        try {
            do {
                imprimeMenu(creaSubmenu("Material"));
                op = sc.nextInt();
                switch (op) {
                    
                    case 1:
                        Menu.imprime("Introduce nomber");
                        nombre = sc.next();
                        Material a = new Material(nombre);
                        Controlador.insertar("material", a);
                      break;
       
                    case 3:
                        imprime("introduce codigo");
                        codE = sc.nextInt();
                        Controlador.borrar("material", codE);
                        break;


                    case 4:
                        Controlador.mostrar("material");
                        break;
                }
            } while (op != 0);
        } catch (InputMismatchException e) {
            System.out.println("Error: no se permite letras");
            Menu.sc = new Scanner(System.in);
            Menu.opn =7;
            Menu.err = true;

        } catch (DaoExepcion ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
           iniciaMenu(Menu.sc);
        }
    }

}
