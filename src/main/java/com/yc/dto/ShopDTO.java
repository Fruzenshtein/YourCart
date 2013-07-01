package com.yc.dto;

import com.yc.model.Shop;
import com.yc.model.ShopDetails;

/**
 * Class represents combined entities: {@link Shop}, {@link ShopDetails} 
 * @author Fruzenshtein
 *
 */
public class ShopDTO {
	
	//Shop object fields
	private Integer id;
	private String name;
	
	//ShopDetails object fields
	private String category;
	private String type;
	private boolean activatedStatus;
	
	/**
	 * Method builds {@link Shop} object based on the current {@link ShopDTO} object.
	 * @return New {@link Shop} object.
	 */
	public Shop buildShop() {
		Shop shop = new Shop();
		shop.setId(id);
		shop.setName(name);
		return shop;
	}
	
	/**
	 * Method builds {@link ShopDetails} object based on the current {@link ShopDTO} object.
	 * @return New {@link ShopDetails} object.
	 */	
	public ShopDetails buildShopDetails() {
		ShopDetails details = new ShopDetails();
		details.setCategory(category);
		details.setType(type);
		details.setActivatedStatus(activatedStatus);
		return details;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isActivatedStatus() {
		return activatedStatus;
	}
	public void setActivatedStatus(boolean activatedStatus) {
		this.activatedStatus = activatedStatus;
	}

}
