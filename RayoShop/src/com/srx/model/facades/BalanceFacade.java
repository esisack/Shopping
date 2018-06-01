package com.srx.model.facades;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.Balance;

@Stateless
@LocalBean
public class BalanceFacade extends AbstractFacade<Balance>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public BalanceFacade() {
        // TODO Auto-generated constructor stub
    	super(Balance.class);
    }

}