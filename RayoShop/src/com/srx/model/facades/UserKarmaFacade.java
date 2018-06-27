package com.srx.model.facades;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.UserKarma;

@Stateless
@LocalBean
public class UserKarmaFacade extends AbstractFacade<UserKarma>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public UserKarmaFacade() {
        // TODO Auto-generated constructor stub
    	super(UserKarma.class);
    }

}