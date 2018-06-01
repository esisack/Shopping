package com.srx.model.facades;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.Offer;

@Stateless
@LocalBean
public class OfferFacade extends AbstractFacade<Offer>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public OfferFacade() {
        // TODO Auto-generated constructor stub
    	super(Offer.class);
    }

}