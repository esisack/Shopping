package com.srx.model.facades;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.Attribute;

@Stateless
@LocalBean
public class AttributeFacade extends AbstractFacade<Attribute>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public AttributeFacade() {
        // TODO Auto-generated constructor stub
    	super(Attribute.class);
    }

}