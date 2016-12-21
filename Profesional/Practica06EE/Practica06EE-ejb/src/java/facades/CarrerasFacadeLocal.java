/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facades;

import java.util.List;
import javax.ejb.Local;
import persistencia.Carreras;

/**
 *
 * @author Daniel
 */
@Local
public interface CarrerasFacadeLocal {

    void create(Carreras carreras);

    void edit(Carreras carreras);

    void remove(Carreras carreras);

    Carreras find(Object id);

    List<Carreras> findAll();

    List<Carreras> findRange(int[] range);

    int count();
    
}
