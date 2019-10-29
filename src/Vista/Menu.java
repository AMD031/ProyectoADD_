/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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
        Submenu.add("6 Listar todos ");
        return Submenu;
    }

    private void imprimeMenu(List<String> opiones) {
        for (String op : opiones) {
            System.out.println(op);
        }
    }
    
    private void imprime(String txt){
        System.out.println(txt);
    }

    private void iniciaMenu(Scanner sc) {
        imprimeMenu(Principal);
        sc = new Scanner(System.in);
        try{
        int op = sc.nextInt();

        switch (op) {
            case 0:
              

                break;

            case 1:
                  imprimeMenu(creaSubmenu("sede"));
                
                
                break;

            case 2:

                break;

            case 3:

                break;

            case 4:

                break;

            case 5:

                break;

            case 6:

                break;

            case 7:

                break;

            case 8:

                break;

            case 9:
              imprimeMenu(creaSubmenu("Material"));
              
              
              break;
                
                
        }
        
        }catch(InputMismatchException e){
            imprime("Error de Formato"+e);
        }

    }

    
    
    
    
    
    
    
    
    
    
}
