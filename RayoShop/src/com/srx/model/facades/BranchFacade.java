package com.srx.model.facades;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.Branch;

@Stateless
@LocalBean
public class BranchFacade extends AbstractFacade<Branch>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public BranchFacade() {
        // TODO Auto-generated constructor stub
    	super(Branch.class);
    }

}