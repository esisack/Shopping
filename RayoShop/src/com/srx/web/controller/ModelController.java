package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.Model;
import com.srx.model.facades.ModelFacade;


@ManagedBean(name = "modelController")
@RequestScoped()
public class ModelController  extends AbstractController<Model> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	ModelFacade ejbFacade;
	
	public ModelController() {
		super(Model.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	
	

}
