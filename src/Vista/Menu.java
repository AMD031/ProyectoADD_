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
import java.util.ArrayList;
import java.util.HashMap;
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
        Menu.err = false;
        ACsede = creaActualizaSede();
        ACpolideportivo = creaActualizaPolideportivo();
        ACunideportivo = creaActualizaUnideportivo();
        ACevento = creaActualizaEvento();
        ACmaterial = creaActualizaMatarial();
        ACcomisario = creaActualizaComisario();
        ACarea = creaActualizaArea();
        //----------------
        Bsede = creaBuscaSede();
        Bpolideportivo = creaBuscaPolideportivo();
        Bunideportivo = creaBuscaUnideportivo();
        Barea = creaBuscaArea();
        Bcomisario = creaBuscaComisario();
        Bmaterial = creaBuscaMaterial();
        Bevento = creaBuscaEvento();

        Menu.iniciaMenu(sc);
    }
    //lista de opciones
    private static List<String> ACsede;
    private static List<String> ACpolideportivo;
    private static List<String> ACunideportivo;
    private static List<String> ACarea;
    private static List<String> ACcomisario;
    private static List<String> ACmaterial;
    private static List<String> ACevento;
    //lista buscar
    private static List<String> Bsede;
    private static List<String> Bpolideportivo;
    private static List<String> Bunideportivo;
    private static List<String> Barea;
    private static List<String> Bcomisario;
    private static List<String> Bmaterial;
    private static List<String> Bevento;

    private static boolean err;
    private static ArrayList<String> Principal;
    private static Scanner sc;
    private static int opn;
    // opciones de actualizar

    private List<String> creaActualizaSede() {
        ArrayList datos = new ArrayList<>();
        datos.add("1 Actualiza nombre");
        datos.add("2 Actualiza presupuesto");
        datos.add("0 salir");
        return datos;
    }

    private List<String> creaActualizaUnideportivo() {
        ArrayList datos = new ArrayList<>();
        datos.add("1 Actualiza info");
        datos.add("2 Actualiza localizacion");
        datos.add("3 Actualiza nombre del jefe");
        datos.add("4 Actualiza deporte");
        datos.add("0 salir");
        return datos;
    }

    private List<String> creaActualizaPolideportivo() {
        ArrayList datos = new ArrayList<>();
        datos.add("1 Actualiza info");
        datos.add("2 Actualiza localizacion");
        datos.add("3 Actualiza nombre del jefe");
        datos.add("0 salir");
        return datos;
    }

    private List<String> creaActualizaArea() {
        ArrayList datos = new ArrayList<>();
        datos.add("1 Actualiza localizacion");
        datos.add("2 Actualiza deporte");
        datos.add("0 salir");
        return datos;
    }

    private List<String> creaActualizaEvento() {
        ArrayList datos = new ArrayList<>();
        datos.add("1 Actualiza nombre");
        datos.add("2 Actualiza fecha");
        datos.add("0 salir");
        return datos;
    }

    private List<String> creaActualizaComisario() {
        ArrayList datos = new ArrayList<>();
        datos.add("1 Actualiza dni");
        datos.add("2 Actualiza nombre");
        datos.add("0 salir");
        return datos;
    }

    private List<String> creaActualizaMatarial() {
        ArrayList datos = new ArrayList<>();
        datos.add("1 Actualiza nombre");
        datos.add("0 salir");
        return datos;
    }

    //opciones de buscar
    private List<String> creaBuscaSede() {
        ArrayList datos = new ArrayList<>();
        datos.add("1 Busca por nombre");
        datos.add("2 busca por presupuesto");
        datos.add("0 salir");
        return datos;

    }

    private List<String> creaBuscaPolideportivo() {
        ArrayList datos = new ArrayList<>();
        datos.add("1 busca por info");
        datos.add("2 busca por localizacion");
        datos.add("3 busca por nombre del jefe");
        datos.add("0 salir");   
        return datos;

    }

    private List<String> creaBuscaUnideportivo() {
        ArrayList datos = new ArrayList<>();
        datos.add("1 busca por info");
        datos.add("2 busca por localizacion");
        datos.add("3 busca por nombre del jefe");
        datos.add("4 busca por deporte");
        datos.add("0 salir");
        return datos;
    }

    private List<String> creaBuscaArea() {
        ArrayList datos = new ArrayList<>();
        datos.add("1 Busca localizacion");
        datos.add("2 Busca deporte");
        datos.add("0 salir");
        return datos;
    }

    private List<String> creaBuscaEvento() {
        ArrayList datos = new ArrayList<>();

        datos.add("1 busca por nombre");
        datos.add("2 busca por fecha");
        datos.add("0 salir");

        return datos;
    }

    private List<String> creaBuscaMaterial() {
        ArrayList datos = new ArrayList<>();
        datos.add("1 buca por  nombre");
        datos.add("0 salir");
        return datos;
    }

    private List<String> creaBuscaComisario() {
        ArrayList datos = new ArrayList<>();
        datos.add("1 busca por dni");
        datos.add("2 busca por nombre");
        datos.add("0 salir");
        return datos;
    }

    //-------------------------------------------
    private static void creaPrinciapal() {
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
        Submenu.add("0 Salir");
        Submenu.add("1 Crear " + txt);
        Submenu.add("2 Actualizar " + txt);
        Submenu.add("3 Borrar " + txt);
        Submenu.add("4 Listar todos ");
        Submenu.add("5 Buscar elemento " + txt);

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

   

   // menus pricipales
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
                int codE = 0;

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
                        MenuActualizaSede(sc);
                        break;

                    case 3:
                        imprime("introduce codigo");
                        codE = sc.nextInt();
                        Controlador.borrar("sede", codE);
                        break;

                    case 4:
                        Controlador.mostrar("sede");
                        break;
                    case 5:
                        MenuBucarsede(sc);
                        break;

                }

            } while (op != 0);
        } catch (InputMismatchException e) {
            System.out.println("Error: no se permite letras");
            Menu.sc = new Scanner(System.in);
            Menu.opn = 1;
            Menu.err = true;

        } catch (DaoExepcion ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            iniciaMenu(Menu.sc);
        }

    }

    private static void MenuUnideportivo(Scanner sc) {

        String deporte;
        String info;
        String localizacion;
        String jefe;
        int cod_sede;
        int codE = 0;

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

                    case 2:
                        MenuActualizaUnideportivo(sc);
                        break;

                    case 3:
                        imprime("introduce codigo");
                        codE = sc.nextInt();
                        Controlador.borrar("unideportivo", codE);

                        break;

                    case 4:
                        Controlador.mostrar("unideportivo");
                        break;

                    case 5:
                        MenuBucarUnideportivo(sc);
                        break;

                }
            } while (op != 0);

        } catch (InputMismatchException e) {
            System.out.println("Error: no se permite letras");
            Menu.sc = new Scanner(System.in);
            Menu.opn = 2;
            Menu.err = true;

        } catch (DaoExepcion ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            iniciaMenu(Menu.sc);
        }

    }

    private static void MenuPolideportivo(Scanner sc) {

        int op = 0;
        String info;
        String localizacion;
        String jefe;
        int cod_sede;
        int codE = 0;
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

                    case 2:
                        MenuActualizaPolideportivo(sc);
                        break;

                    case 3:
                        imprime("introduce codigo");
                        codE = sc.nextInt();
                        Controlador.borrar("polideportivo", codE);

                        break;

                    case 4:
                        Controlador.mostrar("polideportivo");
                        break;
                    case 5:
                        MenuBucarPolideportivo(sc);
                        break;

                }
            } while (op != 0);
        } catch (InputMismatchException e) {
            System.out.println("Error: no se permite letras");
            Menu.sc = new Scanner(System.in);
            Menu.opn = 3;
            Menu.err = true;

        } catch (DaoExepcion ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            iniciaMenu(Menu.sc);
        }

    }

    private static void MenuArea(Scanner sc) {

        int op = 0;
        int cod_poli;
        String localizacion;
        String deporte;
        int codE = 0;
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
                    case 2:
                        MenuActualizaArea(sc);
                        break;

                    case 3:
                        imprime("introduce codigo");
                        codE = sc.nextInt();
                        Controlador.borrar("area", codE);

                        break;

                    case 4:
                        Controlador.mostrar("area");
                        break;
                    case 5:
                           MenuBucarArea(sc);
                        break;

                }
            } while (op != 0);
        } catch (InputMismatchException e) {
            System.out.println("Error: no se permite letras");
            Menu.sc = new Scanner(System.in);
            Menu.opn = 4;
            Menu.err = true;

        } catch (DaoExepcion ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            iniciaMenu(Menu.sc);
        }

    }

    private static void MenuEvento(Scanner sc) {
        int op = 0;
        String nombre;
        int cod_complejo;
        String fecha;
        int cod_area;
        int codE = 0;

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

                        Evento a = new Evento(nombre, cod_complejo, Evento.stringToTimestamp(fecha), cod_area);
                        Controlador.insertar("evento", a);

                        break;

                    case 2:
                        MenuActualizaEvento(sc);
                        break;

                    case 3:
                        imprime("introduce codigo");
                        codE = sc.nextInt();
                        Controlador.borrar("evento", codE);
                        break;

                    case 4:
                        Controlador.mostrar("evento");
                        break;

                    case 5:
                        MenuBucarEvento(sc);
                        break;

                }
            } while (op != 0);
        } catch (InputMismatchException e) {
            System.out.println("Error: no se permite letras");
            Menu.sc = new Scanner(System.in);
            Menu.opn = 5;
            Menu.err = true;

        } catch (DaoExepcion ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            iniciaMenu(Menu.sc);
        }

    }

    private static void MenuComisario(Scanner sc) {
        int op = 0;
        String DNI;
        String Nombre;
        int codE = 0;
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

                    case 2:

                        MenuActualizaComisario(sc);

                        break;
                    case 3:
                        imprime("introduce codigo");
                        codE = sc.nextInt();
                        Controlador.borrar("comisario", codE);
                        break;

                    case 4:
                        Controlador.mostrar("comisario");
                        break;
                    case 5:
                            MenuBucarComisario(sc);
                        break;

                }
            } while (op != 0);
        } catch (InputMismatchException e) {
            System.out.println("Error: no se permite letras");
            Menu.sc = new Scanner(System.in);
            Menu.opn = 6;
            Menu.err = true;

        } catch (DaoExepcion ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            iniciaMenu(Menu.sc);
        }
    }

    private static void MenuMaterial(Scanner sc) {
        int op = 0;
        int codE = 0;
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

                    case 2:

                        imprimeMenu(ACmaterial);
                        Menu.imprime("introduce codigo del elemento");
                        int codigo = sc.nextInt();
                        Menu.imprime("introduce nuevo nombre");
                        String nMaterial = sc.next();
                        HashMap<Object, Object> datos = new HashMap<>();
                        datos.put("name", nMaterial);
                        Controlador.actualizar("material", datos, codigo);
                        break;

                    case 3:
                        imprime("introduce codigo");
                        codE = sc.nextInt();
                        Controlador.borrar("material", codE);
                        break;

                    case 4:
                        Controlador.mostrar("material");
                        break;

                    case 5:
                          MenuBuscarMaterial(sc);
                        break;
                }
            } while (op != 0);
        } catch (InputMismatchException e) {
            System.out.println("Error: no se permite letras");
            Menu.sc = new Scanner(System.in);
            Menu.opn = 7;
            Menu.err = true;

        } catch (DaoExepcion ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            iniciaMenu(Menu.sc);
        }
    }
   
    //menu actualiazar
    private static void MenuActualizaComisario(Scanner sc) {
        int op = 0;
        HashMap<Object, Object> datos = new HashMap<>();
        int codigo = 0;
        String dni = "";
        
        try {

            do {
                imprimeMenu(ACcomisario);
                op = sc.nextInt();
                switch (op) {

                    case 1:
                        Menu.imprime("introduce codigo del elemento");
                        codigo = sc.nextInt();
                        Menu.imprime("introduce nuevo dni");
                        dni = sc.next();
                        datos = new HashMap<>();
                        datos.put("dni", dni);
                        Controlador.actualizar("comisario", datos, codigo);
                        break;

                    case 2:
                        Menu.imprime("introduce codigo del elemento");
                        codigo = sc.nextInt();
                        Menu.imprime("introduce nuevo nombre");
                        String nComisario = sc.next();
                        datos = new HashMap<>();
                        datos.put("name", nComisario);
                        Controlador.actualizar("comisario", datos, codigo);
                        break;
                }
            } while (op != 0);

        } catch (InputMismatchException e) {
            Menu.imprime("Error: no se permite letras");
        }

    }
    private static void MenuActualizaSede(Scanner sc) {
        int op = 0;
        HashMap<Object, Object> datos = new HashMap<>();
        int codigo = 0;
        String nombre = "";
        float presupuesto = 0f;
        try {

            do {
                imprimeMenu(ACsede);
                op = sc.nextInt();
                switch (op) {

                    case 1:
                        Menu.imprime("introduce codigo del elemento");
                        codigo = sc.nextInt();
                        Menu.imprime("introduce nuevo nombre");
                        nombre = sc.next();
                        datos = new HashMap<>();
                        datos.put("name", nombre);
                        Controlador.actualizar("sede", datos, codigo);
                        break;

                    case 2:
                        Menu.imprime("introduce codigo del elemento");
                        codigo = sc.nextInt();
                        Menu.imprime("introduce nuevo presupuesto");
                        presupuesto = sc.nextFloat();
                        datos = new HashMap<>();
                        datos.put("budget", presupuesto);
                        Controlador.actualizar("sede", datos, codigo);
                        break;
                }
            } while (op != 0);

        } catch (InputMismatchException e) {
            Menu.imprime("Error: no se permite letras");
        }

    }
    private static void MenuActualizaArea(Scanner sc) {
        int op = 0;
        HashMap<Object, Object> datos = new HashMap<>();
        int codigo = 0;
        String localizacion = "";
        String deporte = "";
        try {

            do {
                imprimeMenu(ACarea);
                op = sc.nextInt();
                switch (op) {

                    case 1:
                        Menu.imprime("introduce codigo del elemento");
                        codigo = sc.nextInt();
                        Menu.imprime("introduce nueva localizacion");
                        localizacion = sc.next();
                        datos = new HashMap<>();
                        datos.put("location", localizacion);
                        Controlador.actualizar("area", datos, codigo);
                        break;

                    case 2:
                        Menu.imprime("introduce codigo del elemento");
                        codigo = sc.nextInt();
                        Menu.imprime("introduce nuevo deporte");
                        deporte = sc.next();
                        datos = new HashMap<>();
                        datos.put("sport", deporte);
                        Controlador.actualizar("area", datos, codigo);
                        break;
                }
            } while (op != 0);
        } catch (InputMismatchException e) {
            Menu.imprime("Error: no se permite letras");
        }

    }
    private static void MenuActualizaPolideportivo(Scanner sc) {
        int op = 0;
        HashMap<Object, Object> datos = new HashMap<>();
        int codigo = 0;
        String info;
        String localizacion;
        String jefe;
        try {

            do {
                imprimeMenu(ACpolideportivo);
                op = sc.nextInt();
                switch (op) {

                    case 1:
                        Menu.imprime("introduce codigo del elemento");
                        codigo = sc.nextInt();
                        Menu.imprime("introduce nueva informacion");
                        sc.nextLine();
                        info = sc.nextLine();
                        datos = new HashMap<>();
                        datos.put("information", info);
                        Controlador.actualizar("polideportivo", datos, codigo);
                        break;

                    case 2:
                        Menu.imprime("introduce codigo del elemento");
                        codigo = sc.nextInt();
                        Menu.imprime("introduce nueva localizacion");
                        sc.nextLine();
                        localizacion = sc.nextLine();
                        datos = new HashMap<>();
                        datos.put("location", localizacion);
                        Controlador.actualizar("polideportivo", datos, codigo);
                        break;

                    case 3:
                        Menu.imprime("introduce codigo del elemento");
                        codigo = sc.nextInt();
                        Menu.imprime("introduce nuevo jefe");
                        sc.nextLine();
                        jefe = sc.nextLine();
                        datos = new HashMap<>();
                        datos.put("boss", jefe);
                        Controlador.actualizar("polideportivo", datos, codigo);
                        break;

                }
            } while (op != 0);
        } catch (InputMismatchException e) {
            Menu.imprime("Error: no se permite letras");
        }

    }
    private static void MenuActualizaUnideportivo(Scanner sc) {
        int op = 0;
        HashMap<Object, Object> datos = new HashMap<>();
        int codigo = 0;
        String info;
        String localizacion;
        String deporte;
        String jefe;
        try {

            do {
                imprimeMenu(ACunideportivo);
                op = sc.nextInt();
                switch (op) {

                    case 1:
                        Menu.imprime("introduce codigo del elemento");
                        codigo = sc.nextInt();
                        Menu.imprime("introduce nueva informacion");
                        sc.nextLine();
                        info = sc.nextLine();
                        datos = new HashMap<>();
                        datos.put("information", info);
                        Controlador.actualizar("unideportivo", datos, codigo);
                        break;

                    case 2:
                        Menu.imprime("introduce codigo del elemento");
                        codigo = sc.nextInt();
                        Menu.imprime("introduce nueva localizacion");
                        sc.nextLine();
                        localizacion = sc.nextLine();
                        datos = new HashMap<>();
                        datos.put("location", localizacion);
                        Controlador.actualizar("unideportivo", datos, codigo);
                        break;

                    case 3:
                        Menu.imprime("introduce codigo del elemento");
                        codigo = sc.nextInt();
                        Menu.imprime("introduce nuevo jefe");
                        sc.nextLine();
                        jefe = sc.nextLine();
                        datos = new HashMap<>();
                        datos.put("boss", jefe);
                        Controlador.actualizar("unideportivo", datos, codigo);
                        break;

                    case 4:

                        Menu.imprime("introduce codigo del elemento");
                        codigo = sc.nextInt();
                        Menu.imprime("introduce nuevo deporte");
                        sc.nextLine();
                        deporte = sc.nextLine();
                        datos = new HashMap<>();
                        datos.put("sport", deporte);
                        Controlador.actualizar("unideportivo", datos, codigo);

                        break;

                }
            } while (op != 0);
        } catch (InputMismatchException e) {
            Menu.imprime("Error: no se permite letras");
        }

    }
    private static void MenuActualizaEvento(Scanner sc) {
        int op = 0;
        HashMap<Object, Object> datos = new HashMap<>();
        int codigo = 0;
        String nombre = "";
        String fecha = null;
        try {

            do {
                imprimeMenu(ACevento);
                op = sc.nextInt();
                switch (op) {

                    case 1:
                        Menu.imprime("introduce codigo del elemento");
                        codigo = sc.nextInt();
                        Menu.imprime("introduce nuevo nombre");
                        sc.nextLine();
                        nombre = sc.nextLine();
                        datos = new HashMap<>();
                        datos.put("name", nombre);
                        Controlador.actualizar("evento", datos, codigo);
                        break;

                    case 2:
                        Menu.imprime("introduce codigo del elemento");
                        codigo = sc.nextInt();
                        Menu.imprime("introduce nueva fecha con formato MM.dd.yyyy hh:ss");
                        sc.nextLine();
                        fecha = sc.nextLine();
                        datos = new HashMap<>();
                        datos.put("date", Evento.stringToTimestamp(fecha));
                        Controlador.actualizar("evento", datos, codigo);
                        break;

                }
            } while (op != 0);
        } catch (InputMismatchException e) {
            Menu.imprime("Error: no se permite letras");
        } catch (Exception ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    //menu buscar
    private static void MenuBucarsede(Scanner sc) {

        HashMap<Object, Object> datos = new HashMap<>();
        int op = 0;
        String nombre = "";
        float presupuesto = 0f;
        try {

            do {
                imprimeMenu(Bsede);
                op = sc.nextInt();
                switch (op) {

                    case 1:        
                        Menu.imprime("introduce nombre");
                        nombre = sc.next();
                        datos = new HashMap<>();
                        datos.put("name", "%"+nombre+"%");
                        Controlador.buscar("sede", datos);
                        break;

                    case 2:
                        Menu.imprime("introduce presupuesto");
                        presupuesto = sc.nextFloat();
                        datos = new HashMap<>();
                        datos.put("budget","%"+presupuesto+"%");
                        Controlador.buscar("sede", datos);
                        break;
                }
            } while (op != 0);

        } catch (InputMismatchException e) {
            Menu.imprime("Error: no se permite letras");
        }
    }
    private static void MenuBucarUnideportivo(Scanner sc){
        
        int op = 0;
        HashMap<Object, Object> datos = new HashMap<>();
        int codigo = 0;
        String info;
        String localizacion;
        String deporte;
        String jefe;
        try {

            do {
                imprimeMenu(Bunideportivo);
                op = sc.nextInt();
                switch (op) {

                    case 1:
              
                        Menu.imprime("introduce informacion");
                        sc.nextLine();
                        info = sc.nextLine();
                        datos = new HashMap<>();
                        datos.put("sr.information", "%"+info+"%");
                        Controlador.buscar("unideportivo", datos);
                        break;

                    case 2:
                        Menu.imprime("introduce localizacion");
                        sc.nextLine();
                        localizacion = sc.nextLine();
                        datos = new HashMap<>();
                        datos.put("sr.location", "%"+ localizacion+ "%");
                      Controlador.buscar("unideportivo", datos);
                        break;

                    case 3:
                        Menu.imprime("introduce jefe");
                        sc.nextLine();
                        jefe = sc.nextLine();
                        datos = new HashMap<>();
                        datos.put("sx.boss","%"+ jefe+ "%");
                        Controlador.buscar("unideportivo", datos);
                        break;

                    case 4:
                        Menu.imprime("introduce deporte");
                        sc.nextLine();
                        deporte = sc.nextLine();
                        datos = new HashMap<>();
                        datos.put("sr.sport",  "%"+deporte+"%");
                        Controlador.buscar("unideportivo", datos);

                        break;

                }
            } while (op != 0);
        } catch (InputMismatchException e) {
            Menu.imprime("Error: no se permite letras");
        }
        
        
        
    }
    private static void MenuBucarPolideportivo(Scanner sc){
 
          int op = 0;
        HashMap<Object, Object> datos = new HashMap<>();
        String info;
        String localizacion;
        String jefe;
        try {

            do {
                imprimeMenu(Bpolideportivo);
                op = sc.nextInt();
                switch (op) {

                    case 1:
                        Menu.imprime("introduce informacion");
                        sc.nextLine();
                        info = sc.nextLine();
                        datos = new HashMap<>();
                        datos.put("information", "%"+info+"%");
                        Controlador.buscar("polideportivo", datos);
                        break;

                    case 2:
                        Menu.imprime("introduce localizacion");
                        sc.nextLine();
                        localizacion = sc.nextLine();
                        datos = new HashMap<>();
                        datos.put("location", "%"+localizacion+"%");
                        Controlador.buscar("polideportivo", datos);
                        break;

                    case 3:
                        Menu.imprime("introduce jefe");
                        sc.nextLine();
                        jefe = sc.nextLine();
                        datos = new HashMap<>();
                        datos.put("boss", "%"+jefe+"%");
                        Controlador.buscar("polideportivo", datos);
                        break;

                }
            } while (op != 0);
        } catch (InputMismatchException e) {
            Menu.imprime("Error: no se permite letras");
        }

        
        
        
        
        
        
        
        
    }
    private static void MenuBucarArea(Scanner sc){
        int op = 0;
        HashMap<Object, Object> datos = new HashMap<>();
        String localizacion = "";
        String deporte = "";
        try {

            do {
                imprimeMenu(Barea);
                op = sc.nextInt();
                switch (op) {
                    case 1:
                        Menu.imprime("introduce localizacion");
                        localizacion = sc.next();
                        datos = new HashMap<>();
                        datos.put("location","%"+ localizacion+"%");
                        Controlador.buscar("area", datos);
                        break;

                    case 2:
                        Menu.imprime("introduce deporte");
                        deporte = sc.next();
                        datos = new HashMap<>();
                        datos.put("sport", "%"+deporte+"%");
                        Controlador.buscar("area", datos);
                        break;
                }
            } while (op != 0);
        } catch (InputMismatchException e) {
            Menu.imprime("Error: no se permite letras");
        }
    }
    private static void MenuBucarComisario(Scanner sc){
        int op = 0;
        HashMap<Object, Object> datos = new HashMap<>();
        String dni = "";
        try {
            do {
                imprimeMenu(Bcomisario);
                op = sc.nextInt();
                switch (op) {

                    case 1:
                        Menu.imprime("introduce  dni");
                        dni = sc.next();
                        datos = new HashMap<>();
                        datos.put("dni", "%"+dni+"%");
                        Controlador.buscar("comisario", datos);
                        break;

                    case 2:
                        Menu.imprime("introduce nombre");
                        String nComisario = sc.next();
                        datos = new HashMap<>();
                        datos.put("name", "%"+nComisario+"%");
                        Controlador.buscar("comisario", datos);
                        break;
                }
            } while (op != 0);

        } catch (InputMismatchException e) {
            Menu.imprime("Error: no se permite letras");
        }
        
        
        
    } 
    private static void MenuBucarEvento(Scanner sc){  
           int op = 0;
        HashMap<Object, Object> datos = new HashMap<>();
         String nombre = "";
        String fecha = null;
        try {

            do {
                imprimeMenu(Bevento);
                op = sc.nextInt();
                switch (op) {

                    case 1:
                 
                        Menu.imprime("introduce nombre");
                        sc.nextLine();
                        nombre = sc.nextLine();
                        datos = new HashMap<>();
                        datos.put("name", "%"+nombre+"%");
                        Controlador.buscar("evento", datos);
                        break;

                    case 2:
                 
                        Menu.imprime("introduce  fecha con ");
                        sc.nextLine();
                        fecha = sc.nextLine();
                        datos = new HashMap<>();
                        datos.put("date",  "%"+fecha+"%");
                        Controlador.buscar("evento", datos);
                        break;
                }
            } while (op != 0);
        } catch (InputMismatchException e) {
            Menu.imprime("Error: no se permite letras");
        } catch (Exception ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private static void MenuBuscarMaterial(Scanner sc){
        int op = 0;
        HashMap<Object, Object> datos = new HashMap<>();
        try {

            do {
                imprimeMenu(Bmaterial);
                op = sc.nextInt();
                switch (op) {

                    case 1:
     
                        Menu.imprime("introduce nombre");
                        String nMaterial = sc.next();
                        datos = new HashMap<>();
                        datos.put("name","%"+nMaterial+"%");
                        Controlador.buscar("material", datos);
                        break;
    
                }
            } while (op != 0);
        } catch (InputMismatchException e) {
            Menu.imprime("Error: no se permite letras");
        } catch (Exception ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
   
    
    
    
    
    

}
