package com.srx.model.facades;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.ShopCart;

@Stateless
@LocalBean
public class ShopCartFacade extends AbstractFacade<ShopCart>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public ShopCartFacade() {
        // TODO Auto-generated constructor stub
    	super(ShopCart.class);
    }

	@SuppressWarnings("unchecked")
	public List<ShopCart> shopCartByUser(int id) {
		return (List<ShopCart>) em.createNamedQuery("ShopCart.findByUser").setParameter("userId", id).getResultList();
	}
}