/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facades;

import java.util.List;
import javax.ejb.Local;
import persistencia.Municipios;

/**
 *
 * @author Daniel
 */
@Local
public interface MunicipiosFacadeLocal {

    void create(Municipios municipios);

    void edit(Municipios municipios);

    void remove(Municipios municipios);

    Municipios find(Object id);

    List<Municipios> findAll();

    List<Municipios> findRange(int[] range);

    int count();
    
}
