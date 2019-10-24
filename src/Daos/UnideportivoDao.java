/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import DaosInterfaces.IDaoUnideportivo;
import Modelo.Unideportivo;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Antonio Martinez Diaz
 */
public class UnideportivoDao implements IDaoUnideportivo{
   private Connection n;

    public UnideportivoDao(Connection n) {
        this.n = n;
    }
    
    
    
    @Override
    public boolean insertar(Unideportivo a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Unideportivo a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(Unideportivo a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Unideportivo> ObtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Unideportivo obtener(Integer cod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
