/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistencia.Estudiantes;

/**
 *
 * @author Daniel
 */
@Stateless
public class EstudiantesFacade extends AbstractFacade<Estudiantes> implements EstudiantesFacadeLocal {
    @PersistenceContext(unitName = "Practica06EE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudiantesFacade() {
        super(Estudiantes.class);
    }
    
}
