package com.srx.model.facades;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.OfficialStore;

@Stateless
@LocalBean
public class OfficialStoreFacade extends AbstractFacade<OfficialStore>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public OfficialStoreFacade() {
        // TODO Auto-generated constructor stub
    	super(OfficialStore.class);
    }

}