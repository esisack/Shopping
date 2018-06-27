package com.srx.web.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.srx.model.entities.Category;
import com.srx.model.facades.CategoryFacade;


@ManagedBean(name = "categoryController")
@RequestScoped()
public class CategoryController  extends AbstractController<Category> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	CategoryFacade ejbFacade;
	
	public CategoryController() {
		super(Category.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	
	

}
