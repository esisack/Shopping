package com.srx.model.facades;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.Item;

@Stateless
@LocalBean
public class ItemFacade extends AbstractFacade<Item> {

	@PersistenceContext(unitName = "SRX-Marketplace")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	/**
	 * Default constructor.
	 */
	public ItemFacade() {
		// TODO Auto-generated constructor stub
		super(Item.class);
	}

	@SuppressWarnings("unchecked")
	public List<Item> itemsByCompany(Integer id) {
		return (List<Item>) em.createNamedQuery("Item.findByCompany").setParameter("companyId", id).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Item> itemsByCategory(Integer id) {
		return (List<Item>) em.createNamedQuery("Item.findByCategory").setParameter("categoryId", id).getResultList();

	}
}