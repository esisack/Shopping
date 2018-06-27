package com.srx.model.facades;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.FiscalPosition;

@Stateless
@LocalBean
public class FiscalPositionFacade extends AbstractFacade<FiscalPosition>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public FiscalPositionFacade() {
        // TODO Auto-generated constructor stub
    	super(FiscalPosition.class);
    }

}