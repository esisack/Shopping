package com.srx.model.facades;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.Vendor;

@Stateless
@LocalBean
public class VendorFacade extends AbstractFacade<Vendor>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public VendorFacade() {
        // TODO Auto-generated constructor stub
    	super(Vendor.class);
    }

}