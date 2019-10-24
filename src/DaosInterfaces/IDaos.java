/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaosInterfaces;

import Modelo.Sede;
import java.util.List;

/**
 *
 * @author Your Name <Antonio Martinez Diaz>
 */
public interface IDaos<T, K> {
    public boolean insertar(T a);
    public void modificar(T a);
    void eliminar(T a);
    List<T>ObtenerTodos();
    T obtener(T cod);
    
    
    
}
