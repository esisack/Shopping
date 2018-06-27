package com.srx.model.facades;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.CampaignType;

@Stateless
@LocalBean
public class CampaignTypeFacade extends AbstractFacade<CampaignType>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public CampaignTypeFacade() {
        // TODO Auto-generated constructor stub
    	super(CampaignType.class);
    }

}