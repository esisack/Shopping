package com.srx.model.facades;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.TextAd;

@Stateless
@LocalBean
public class TextAdFacade extends AbstractFacade<TextAd>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public TextAdFacade() {
        // TODO Auto-generated constructor stub
    	super(TextAd.class);
    }

}