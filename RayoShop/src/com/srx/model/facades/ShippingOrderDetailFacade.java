package com.srx.model.facades;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.ShippingOrderDetail;

@Stateless
@LocalBean
public class ShippingOrderDetailFacade extends AbstractFacade<ShippingOrderDetail>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public ShippingOrderDetailFacade() {
        // TODO Auto-generated constructor stub
    	super(ShippingOrderDetail.class);
    }

}
