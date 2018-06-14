package com.srx.model.facades;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.Category;

@Stateless
@LocalBean
public class CategoryFacade extends AbstractFacade<Category>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public CategoryFacade() {
        // TODO Auto-generated constructor stub
    	super(Category.class);
    }
    
    @SuppressWarnings("unchecked")
	public List<Category> itemsByCategory(int id) {
		return (List<Category>) this.em.createNamedQuery("Category.findByCategory").setParameter("categoryId", id).getResultList();
    	
    }

}