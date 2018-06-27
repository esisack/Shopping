package com.srx.model.facades;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.CampaignPrice;

@Stateless
@LocalBean
public class CampaignPriceFacade extends AbstractFacade<CampaignPrice>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public CampaignPriceFacade() {
        // TODO Auto-generated constructor stub
    	super(CampaignPrice.class);
    }

}