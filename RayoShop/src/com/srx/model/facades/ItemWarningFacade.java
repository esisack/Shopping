package com.srx.model.facades;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.ItemWarning;

@Stateless
@LocalBean
public class ItemWarningFacade extends AbstractFacade<ItemWarning>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public ItemWarningFacade() {
        // TODO Auto-generated constructor stub
    	super(ItemWarning.class);
    }

}