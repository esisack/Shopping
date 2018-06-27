package com.srx.model.facades;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.OrderDetail;

@Stateless
@LocalBean
public class OrderDetailFacade extends AbstractFacade<OrderDetail>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;


    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public OrderDetailFacade() {
        // TODO Auto-generated constructor stub
    	super(OrderDetail.class);
    }

    @SuppressWarnings("unchecked")
	public List<OrderDetail> orderDetailByCompany(Integer id) {
		return (List<OrderDetail>) em.createNamedQuery("OrderDetail.findByCompany").setParameter("companyId", id).getResultList();
    	
    }

}