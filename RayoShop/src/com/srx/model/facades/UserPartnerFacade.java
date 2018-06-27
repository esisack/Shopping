package com.srx.model.facades;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.UserPartner;

@Stateless
@LocalBean
public class UserPartnerFacade extends AbstractFacade<UserPartner>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public UserPartnerFacade() {
        // TODO Auto-generated constructor stub
    	super(UserPartner.class);
    }

}