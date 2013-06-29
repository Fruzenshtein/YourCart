package com.yc.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="shops")
public class Shop {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_shops",
		joinColumns = {@JoinColumn(name="shop_id", referencedColumnName="id")},
		inverseJoinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")}
	)
	private Set<User> users;
	
	@OneToOne(mappedBy="shop", cascade=CascadeType.ALL)
	private ShopDetails shopDetails;
	
	/**
	 * Method updates already existed {@link Shop} object with values from the inputed argument.
	 * @param newShop - Object which contains new Shop values.
	 * @return {@link Shop} object to which this method applied.
	 */
	public Shop update(Shop newShop) {
		this.name = newShop.name;
		this.shopDetails = newShop.shopDetails;
		return this;
	}
	
	public ShopDetails getShopDetails() {
		return shopDetails;
	}
	public void setShopDetails(ShopDetails shopDetails) {
		this.shopDetails = shopDetails;
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
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}
