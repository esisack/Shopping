package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.Collection;
import com.srx.model.facades.CollectionFacade;


@ManagedBean(name = "collectionController")
@RequestScoped()
public class CollectionController  extends AbstractController<Collection> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	CollectionFacade ejbFacade;
	
	public CollectionController() {
		super(Collection.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	
	

}
