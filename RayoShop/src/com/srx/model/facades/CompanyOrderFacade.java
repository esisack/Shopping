package com.srx.model.facades;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.CompanyOrder;

@Stateless
@LocalBean
public class CompanyOrderFacade extends AbstractFacade<CompanyOrder>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public CompanyOrderFacade() {
        // TODO Auto-generated constructor stub
    	super(CompanyOrder.class);
    }

}