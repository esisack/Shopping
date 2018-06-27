package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.OfficialStore;
import com.srx.model.facades.OfficialStoreFacade;


@ManagedBean(name = "OfficialStoreController")
@RequestScoped()
public class OfficialStoreController  extends AbstractController<OfficialStore> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	OfficialStoreFacade ejbFacade;
	
	public OfficialStoreController() {
		super(OfficialStore.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	
	

}
