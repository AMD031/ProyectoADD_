/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import DaosInterfaces.IDaoPolideportivo;
import Modelo.Polideportivo;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Antonio Martinez Diaz
 */
public class PolideportivoDao implements IDaoPolideportivo{

    private Connection n;

    public PolideportivoDao(Connection n) {
        this.n = n;
    }
    
    
    @Override
    public boolean insertar(Polideportivo a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificar(Polideportivo a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(Polideportivo a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Polideportivo> ObtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Polideportivo obtener(Integer cod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
