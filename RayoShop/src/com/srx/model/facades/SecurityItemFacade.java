package com.srx.model.facades;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.SecurityItem;

@Stateless
@LocalBean
public class SecurityItemFacade extends AbstractFacade<SecurityItem>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public SecurityItemFacade() {
        // TODO Auto-generated constructor stub
    	super(SecurityItem.class);
    }

}