package com.srx.model.facades;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.Country;

@Stateless
@LocalBean
public class CountryFacade extends AbstractFacade<Country>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public CountryFacade() {
        // TODO Auto-generated constructor stub
    	super(Country.class);
    }

}
