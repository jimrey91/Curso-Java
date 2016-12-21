/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistencia.Carreras;

/**
 *
 * @author Daniel
 */
@Stateless
public class CarrerasFacade extends AbstractFacade<Carreras> implements CarrerasFacadeLocal {
    @PersistenceContext(unitName = "Practica06EE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarrerasFacade() {
        super(Carreras.class);
    }
    
}
