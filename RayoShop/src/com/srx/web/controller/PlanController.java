package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.Plan;
import com.srx.model.facades.PlanFacade;


@ManagedBean(name = "PlanController")
@RequestScoped()
public class PlanController  extends AbstractController<Plan> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	PlanFacade ejbFacade;
	Plan defaultPlan;
	
	public PlanController() {
		super(Plan.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	public Plan getDefaultPlan() {
		return (Plan) ejbFacade.findAll().get(0);
		
	}
	
	

}
