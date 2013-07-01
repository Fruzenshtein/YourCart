package com.yc.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import javax.persistence.Entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="shop_details")
public class ShopDetails {
	
	@Id
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen", strategy="foreign",
	parameters=@Parameter(name="property", value="shop"))
	@Column(name="shop_id")
	private Integer shopId;
	
	private String category;
	
	private String type;
	
	@Column(name="activated_status")
	private boolean activatedStatus;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Shop shop;
	
	public ShopDetails() {
		this.activatedStatus = false;
	}
	
	/**
	 * Method updates already existed {@link ShopDetails} object with values from the inputed argument.
	 * @param newDetails - Object which contains new ShopDetails values.
	 * @return {@link ShopDetails} object to which this method applied.
	 */
	public ShopDetails update(ShopDetails newDetails) {
		this.category = newDetails.category;
		this.type = newDetails.type;
		this.activatedStatus = newDetails.activatedStatus;
		return this;
	}
	
	public boolean isActivatedStatus() {
		return activatedStatus;
	}
	public void setActivatedStatus(boolean activatedStatus) {
		this.activatedStatus = activatedStatus;
	}
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
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
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}

}
