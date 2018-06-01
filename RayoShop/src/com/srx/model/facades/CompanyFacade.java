package com.srx.model.facades;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.Company;

@Stateless
@LocalBean
public class CompanyFacade extends AbstractFacade<Company>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public CompanyFacade() {
        // TODO Auto-generated constructor stub
    	super(Company.class);
    }
    
    public Company companyByUser(Long id) {
    	Company companyByUser= null;
    	try {
    		companyByUser = (Company) em.createNamedQuery("Company.findByUser").setParameter("userId", id).getSingleResult();
		} catch (Exception e) {
			companyByUser= null;
		}
  		return companyByUser;
      	
      	
      }
}