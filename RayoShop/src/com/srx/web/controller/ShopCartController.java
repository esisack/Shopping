package com.srx.web.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.srx.model.entities.ShopCart;
import com.srx.model.facades.ShopCartFacade;

@ManagedBean(name = "shopCartController")
@SessionScoped()
public class ShopCartController extends AbstractController<ShopCart> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	ShopCartFacade ejbFacade;
	private List<ShopCart> shopList;

	@ManagedProperty(value = "#{userController}")
	private UserController userController;

	@ManagedProperty(value = "#{itemController}")
	private ItemController itemController;

	private Integer quantity = 0;
	private BigDecimal amount = BigDecimal.ZERO;

	public ShopCartController() {
		super(ShopCart.class);
	}

	@PostConstruct
	public void init() {
		super.setFacade(ejbFacade);
	}

	public List<ShopCart> getShopList() {
		if (shopList == null) {
			shopList = this.getShopCartByUser();
			for (ShopCart cart : shopList) {
				quantity = quantity + cart.getQuantity();
				amount = amount.add(cart.getChannelPrice());
			}
		}
		return shopList;
	}

	public void setShopList(List<ShopCart> shopList) {
		this.shopList = shopList;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void createNewLine(ActionEvent event) {
		ShopCart shopCart = new ShopCart();
		shopCart.setItem(this.getItemController().getSelected());
		shopCart.setUser(this.getUserController().getUserLoggedIn());
		shopCart.setRetailPrice(this.getItemController().getSelected().getRetailPrice());
		shopCart.setChannelPrice(this.getItemController().getSelected().getChannelPrice());
		shopCart.setQuantity(1);
		quantity = quantity + 1;
		amount = amount.add(this.getItemController().getSelected().getChannelPrice());
		this.ejbFacade.create(shopCart);
		shopList.add(shopCart);
	}

	public void removeLine(ActionEvent event) {
		this.ejbFacade.remove(this.getSelected());		
	}
	
	public void removeShopList(ActionEvent event) {
		for (ShopCart list : this.getShopList()) {
			this.ejbFacade.remove(list);
		}
	}

	private List<ShopCart> getShopCartByUser() {
		return (List<ShopCart>) ejbFacade.shopCartByUser(userController.getUserLoggedIn().getUserId());
	}

}
