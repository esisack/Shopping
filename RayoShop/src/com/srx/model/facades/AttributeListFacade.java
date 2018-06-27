package com.srx.model.facades;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.AttributeList;

@Stateless
@LocalBean
public class AttributeListFacade extends AbstractFacade<AttributeList>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public AttributeListFacade() {
        // TODO Auto-generated constructor stub
    	super(AttributeList.class);
    }

}