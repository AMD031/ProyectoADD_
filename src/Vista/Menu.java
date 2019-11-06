/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import Daos.DaoExepcion;
import Modelo.Sede;
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
        creaPrinciapal();
        iniciaMenu(sc);
    }

    private ArrayList<String> Principal;
    private Scanner sc;

    private void creaPrinciapal() {
        Principal = new ArrayList<>();
        Principal.add("1 Menu sede");
        Principal.add("2 Menu complejos");
        Principal.add("3 Menu polideportivo");
        Principal.add("4 Menu unidiportivo");
        Principal.add("6 Menu area");
        Principal.add("7 Menu evento");
        Principal.add("8 Menu comisario");
        Principal.add("9 Menu material");
        Principal.add("0 salir");
    }

    private List<String> creaSubmenu(String txt) {
        ArrayList<String> Submenu = new ArrayList<>();
        Submenu.add("1 Crear " + txt);
        Submenu.add("2 Actualizar " + txt);
        Submenu.add("3 Borrar " + txt);
        Submenu.add("4 Listar " + txt);
        Submenu.add("5 Listar todos ");
        return Submenu;
    }

    private void imprimeMenu(List<String> opiones) {
        for (String op : opiones) {
            System.out.println(op);
        }
    }
    

    public static void imprimeContenido(List<? extends Object> contenedor){
        
        for (Object contenido : contenedor) {
            System.out.println(contenido);
           
        }
    }
    
    
    
    
    
    private void imprime(String txt){
        System.out.println(txt);
    }

    private void iniciaMenu(Scanner sc) {
         int op  =0;
        imprimeMenu(Principal);
        sc = new Scanner(System.in);
        try{
        op = sc.nextInt();

        switch (op) {
            case 0:
              

                break;

            case 1:
                 MenuSede(sc);
                break;
            case 2:
                  imprimeMenu(creaSubmenu("Complejos"));
                

                break;

            case 3:
                imprimeMenu(creaSubmenu("Polideportivo"));
                
                
                break;

            case 4:
                imprimeMenu(creaSubmenu("uniderpotivo"));
                
                

                break;

            case 5:
                imprimeMenu(creaSubmenu("Area"));
                

                break;

            case 6:
                imprimeMenu(creaSubmenu("Evento"));
                
                
                
                

                break;

            case 7: 
                imprimeMenu(creaSubmenu("Comisario"));

                
                
                break;

            case 8:
                imprimeMenu(creaSubmenu("Comisario"));

                
                
                
                break;

            case 9:
              imprimeMenu(creaSubmenu("Material"));
              
              
              break;
                
                
        }
        
        }catch(InputMismatchException e){
            imprime("Error de Formato"+e);
        } 

    }

    
    
    
    
     private void MenuSede(Scanner sc){
       
        int op =0;
        try {
            do{
                
       
            imprimeMenu(creaSubmenu("sede"));
            op = sc.nextInt();
            switch(op){
                
                case 4: 
                    Controlador.mostrar("sede");
                break;   
                
            }
          }while(op !=0);
            
            
        } catch (DaoExepcion ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }catch(InputMismatchException ex){
            imprime("No se permite letras.");
        }
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
