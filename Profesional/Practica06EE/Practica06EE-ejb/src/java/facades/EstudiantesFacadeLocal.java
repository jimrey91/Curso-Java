/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facades;

import java.util.List;
import javax.ejb.Local;
import persistencia.Estudiantes;

/**
 *
 * @author Daniel
 */
@Local
public interface EstudiantesFacadeLocal {

    void create(Estudiantes estudiantes);

    void edit(Estudiantes estudiantes);

    void remove(Estudiantes estudiantes);

    Estudiantes find(Object id);

    List<Estudiantes> findAll();

    List<Estudiantes> findRange(int[] range);

    int count();
    
}
