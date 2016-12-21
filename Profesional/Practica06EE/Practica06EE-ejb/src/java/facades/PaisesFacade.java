/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import persistencia.Paises;

/**
 *
 * @author Daniel
 */
@Stateless
public class PaisesFacade extends AbstractFacade<Paises> implements PaisesFacadeLocal {
    @PersistenceContext(unitName = "Practica06EE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaisesFacade() {
        super(Paises.class);
    }
    
}
