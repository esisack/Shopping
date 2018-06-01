package com.srx.model.facades;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.ItemAd;

@Stateless
@LocalBean
public class ItemAdFacade extends AbstractFacade<ItemAd>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public ItemAdFacade() {
        // TODO Auto-generated constructor stub
    	super(ItemAd.class);
    }

}