package com.srx.model.facades;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.ItemType;

@Stateless
@LocalBean
public class ItemTypeFacade extends AbstractFacade<ItemType>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public ItemTypeFacade() {
        // TODO Auto-generated constructor stub
    	super(ItemType.class);
    }

}