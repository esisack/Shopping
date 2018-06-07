package com.srx.model.facades;

import java.math.BigDecimal;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.srx.model.entities.User;

@Stateless
@LocalBean
public class UserFacade extends AbstractFacade<User> {

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public UserFacade() {
        // TODO Auto-generated constructor stub
    	super(User.class);
    }


	public User userByMail(String mail) {	
		User userByMail = null;
		try {
			TypedQuery<User> query = em.createNamedQuery("User.findByMail", User.class);			
			userByMail = query.setParameter("mail", mail).getSingleResult();
			
		} catch (NoResultException e) {
			userByMail = null;
		}
		return userByMail;

	}

	public User userByDocument(long document) {	
		User userByDocument = null;
		try {
			TypedQuery<User> query = em.createNamedQuery("User.findByMail", User.class);
			userByDocument = query.setParameter("document", document).getSingleResult();			
		} catch (Exception e) {
			userByDocument = null;
		}
		return userByDocument;

	}


}