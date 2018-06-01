package com.srx.model.facades;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.DisplayAd;

@Stateless
@LocalBean
public class DisplayAdFacade extends AbstractFacade<DisplayAd>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public DisplayAdFacade() {
        // TODO Auto-generated constructor stub
    	super(DisplayAd.class);
    }

}