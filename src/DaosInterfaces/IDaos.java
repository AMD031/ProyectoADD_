/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaosInterfaces;
import Daos.DaoExepcion;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Your Name <Antonio Martinez Diaz>
 */
public interface IDaos<T, K> {
    public boolean insertar(T a) throws DaoExepcion;
    public boolean modificar(HashMap<Object,Object> a, K id)throws DaoExepcion;
    public int eliminar(K a)throws DaoExepcion;
    public List<T>ObtenerTodos()throws DaoExepcion;
    public T obtener(K cod)throws DaoExepcion;

    
}
