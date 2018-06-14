package com.srx.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.srx.model.entities.Category;
import com.srx.model.facades.CategoryFacade;


@ManagedBean(name = "categoryController")
@SessionScoped()
public class CategoryController  extends AbstractController<Category> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	CategoryFacade ejbFacade;
	
	private int id;
	
	public CategoryController() {
		super(Category.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Category> getItemsByCategory() {
		return this.ejbFacade.itemsByCategory(id);
		
	}
	

}
