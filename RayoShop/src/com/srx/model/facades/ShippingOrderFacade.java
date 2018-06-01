package com.srx.model.facades;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.ShippingOrder;

@Stateless
@LocalBean
public class ShippingOrderFacade extends AbstractFacade<ShippingOrder>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public ShippingOrderFacade() {
        // TODO Auto-generated constructor stub
    	super(ShippingOrder.class);
    }

}