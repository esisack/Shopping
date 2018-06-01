package com.srx.web.controller;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import com.srx.model.entities.WishList;
import com.srx.model.facades.WishListFacade;


@ManagedBean(name = "wishListController")
@RequestScoped()
public class WishListController  extends AbstractController<WishList> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB 
	WishListFacade ejbFacade;
	
	@ManagedProperty(value = "#{userController}")
	private UserController userController;
	
	@ManagedProperty(value = "#{itemController}")
	private ItemController itemController;
	
	@ManagedProperty(value = "#{navigationController}")
	private NavigationController navigationController;
	
	public WishListController() {
		super(WishList.class);
	}
	
	@PostConstruct
	public void init() {
        super.setFacade(ejbFacade);
	}
	
	
	public UserController getUserController() {
		return userController;
	}

	public void setUserController(UserController userController) {
		this.userController = userController;
	}

	public ItemController getItemController() {
		return itemController;
	}

	public void setItemController(ItemController itemController) {
		this.itemController = itemController;
	}
	
	

	public NavigationController getNavigationController() {
		return navigationController;
	}

	public void setNavigationController(NavigationController navigationController) {
		this.navigationController = navigationController;
	}

	public void createNewLine(ActionEvent event) {
		WishList wish = new WishList();
		wish.setItem(itemController.getSelected());
		wish.setUser(userController.getUserLoggedIn());
		wish.setStartDate(new Date());
		wish.setEndDate(new Date());
		this.ejbFacade.create(wish);
	}

	public String canIAddWish() {
		if (userController.getLoggedIn()) {
			WishList wish = new WishList();
			wish.setItem(itemController.getSelected());
			wish.setUser(userController.getUserLoggedIn());
			wish.setStartDate(new Date());
			wish.setEndDate(new Date());
			this.ejbFacade.create(wish);
		} else {
			return "/login.xhtml?=faces-redirect=true";
		}
		return "/pages/items/index.xhtml?faces-redirect=true";
	}
	
}
