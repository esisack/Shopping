package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.Version;
import com.srx.model.facades.VersionFacade;

@ManagedBean(name = "versionController")
@RequestScoped
public class VersionController extends AbstractController<Version> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB 
	VersionFacade ejbFacade;
	
	public VersionController() {
		super(Version.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	

}
