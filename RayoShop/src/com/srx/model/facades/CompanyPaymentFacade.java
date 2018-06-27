package com.srx.model.facades;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.CompanyPayment;

@Stateless
@LocalBean
public class CompanyPaymentFacade extends AbstractFacade<CompanyPayment>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public CompanyPaymentFacade() {
        // TODO Auto-generated constructor stub
    	super(CompanyPayment.class);
    }

}