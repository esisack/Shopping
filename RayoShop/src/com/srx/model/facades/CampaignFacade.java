package com.srx.model.facades;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.Campaign;

@Stateless
@LocalBean
public class CampaignFacade extends AbstractFacade<Campaign>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public CampaignFacade() {
        // TODO Auto-generated constructor stub
    	super(Campaign.class);
    }

}