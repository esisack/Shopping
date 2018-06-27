package com.srx.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.srx.model.entities.Plan;
import com.srx.model.facades.PlanFacade;


@ManagedBean(name = "planController")
@SessionScoped()
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
		return (Plan) this.getItems().get(0);
		
	}
	
	public List<Plan> getPlans() {
		List<Plan> plans = this.getItems();
		return plans ;
			
	}

}
