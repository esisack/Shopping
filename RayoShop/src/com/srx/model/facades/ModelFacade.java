package com.srx.model.facades;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.Model;

@Stateless
@LocalBean
public class ModelFacade extends AbstractFacade<Model>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public ModelFacade() {
        // TODO Auto-generated constructor stub
    	super(Model.class);
    }

}