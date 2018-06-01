package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.srx.model.entities.Branch;
import com.srx.model.facades.BranchFacade;


@ManagedBean(name = "branchController")
@RequestScoped()
public class BranchController  extends AbstractController<Branch> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	BranchFacade ejbFacade;
	CompanyController companyController;
	
	public BranchController() {
		super(Branch.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
		FacesContext context = FacesContext.getCurrentInstance();
		companyController = context.getApplication().evaluateExpressionGet(context, "#{companyController}",
				CompanyController.class);				
	}
	
    public void resetParents() {
        companyController.setSelected(null);
    }
     
    public void prepareCompany(ActionEvent event) {
        if (this.getSelected() != null && companyController.getSelected() == null) {
            companyController.setSelected(this.getSelected().getCompany());
        }
    }	
	
	
}
