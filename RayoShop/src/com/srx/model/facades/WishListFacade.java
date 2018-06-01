package com.srx.model.facades;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.WishList;

@Stateless
@LocalBean
public class WishListFacade extends AbstractFacade<WishList>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public WishListFacade() {
        // TODO Auto-generated constructor stub
    	super(WishList.class);
    }

}