package com.srx.model.facades;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.srx.model.entities.Picture;

@Stateless
@LocalBean
public class PictureFacade extends AbstractFacade<Picture>{

	@PersistenceContext(unitName = "SRX-Marketplace")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    } 

    /**
     * Default constructor. 
     */
    public PictureFacade() {
        // TODO Auto-generated constructor stub
    	super(Picture.class);
    }

}