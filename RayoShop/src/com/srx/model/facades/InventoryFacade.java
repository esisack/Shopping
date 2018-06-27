package com.srx.model.facades;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.Inventory;

@Stateless
@LocalBean
public class InventoryFacade extends AbstractFacade<Inventory>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public InventoryFacade() {
        // TODO Auto-generated constructor stub
    	super(Inventory.class);
    }

}