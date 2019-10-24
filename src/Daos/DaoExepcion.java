/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

/**
 *
 * @author Your Name <Antonio Martinez Diaz>
 */
public class DaoExepcion extends Exception{

    public DaoExepcion(String message) {
        super(message);
    }

    public DaoExepcion(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoExepcion(Throwable cause) {
        super(cause);
    }
    
    
    
}
