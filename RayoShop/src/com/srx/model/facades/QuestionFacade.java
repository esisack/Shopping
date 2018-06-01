package com.srx.model.facades;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.Question;

@Stateless
@LocalBean
public class QuestionFacade extends AbstractFacade<Question>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public QuestionFacade() {
        // TODO Auto-generated constructor stub
    	super(Question.class);
    }
    
    @SuppressWarnings("unchecked")
	public List<Question> questionsByItem(int id) {
		return (List<Question>)  em.createNamedQuery("Question.findByItem").setParameter("itemId", id).getResultList();

    }
    
	@SuppressWarnings("unchecked")
	public List<Question> questionsByUser(int id) {
		return (List<Question>) em.createNamedQuery("Question.findByUser").setParameter("userId", id).getResultList();

	}


}