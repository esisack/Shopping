package com.srx.web.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import com.srx.model.entities.Order;
import com.srx.model.entities.OrderDetail;
import com.srx.model.entities.ShopCart;
import com.srx.model.facades.OrderFacade;

@ManagedBean(name = "orderController")
@RequestScoped()
public class OrderController extends AbstractController<Order> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	OrderFacade ejbFacade;

	@ManagedProperty(value = "#{userController}")
	private UserController userController;

	@ManagedProperty(value = "#{shopCartController}")
	private ShopCartController shopCartController;

	public OrderController() {
		super(Order.class);
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

	public ShopCartController getShopCartController() {
		return shopCartController;
	}

	public void setShopCartController(ShopCartController shopCartController) {
		this.shopCartController = shopCartController;
	}

	public List<Order> getOrdersByUser() {
		return ejbFacade.ordersByUser(this.userController.getUserLoggedIn().getUserId());
	}

	public void processOrder(ActionEvent event) {
		Integer quantity = 0;
		BigDecimal amount = BigDecimal.ZERO;
		BigDecimal shippingCost = BigDecimal.ZERO;
		Order order = new Order();
		order.setDescription("Descripcion nuevo pedido");
		order.setOrderDate(new Date());
		order.setUser(userController.getUserLoggedIn());
		order.setOrdersDetails(new ArrayList());
		OrderDetail orderDetail = new OrderDetail();
		for (ShopCart shopList : shopCartController.getShopList()) {
			orderDetail = new OrderDetail();
			orderDetail.setOrder(order);
			orderDetail.setItem(shopList.getItem());
			orderDetail.setQuantity(shopList.getQuantity());
			orderDetail.setUnitPrice(shopList.getChannelPrice());
			shopList.getFinalPrice();
			order.getOrdersDetails().add(orderDetail);
			quantity = quantity + shopList.getQuantity();
			amount = amount.add(shopList.getChannelPrice());
		}
		order.setItems(quantity);
		order.setAmount(amount);
		order.setStatus("I");
		order.setShippingCost(shippingCost);
		this.ejbFacade.create(order);
		shopCartController.removeShopList(event);
	}
	

}
