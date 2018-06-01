package com.srx.model.facades;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.Order;

@Stateless
@LocalBean
public class OrderFacade extends AbstractFacade<Order>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public OrderFacade() {
        // TODO Auto-generated constructor stub
    	super(Order.class);
    	
    }
    
    @SuppressWarnings("unchecked")
	public List<Order> ordersByUser(int id) {
    	return (List<Order>) em.createNamedQuery("Order.findByUser").setParameter("userId", id ).getResultList();   	
    }

    
}