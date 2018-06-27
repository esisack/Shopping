package com.srx.model.facades;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.Version;

@Stateless
@LocalBean
public class VersionFacade extends AbstractFacade<Version> {

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public VersionFacade() {
        // TODO Auto-generated constructor stub
    	super(Version.class);
    }
}
