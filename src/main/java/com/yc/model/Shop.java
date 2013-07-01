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

import com.yc.dto.ShopDTO;

@Entity
@Table(name="shops")
public class Shop {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="shop_moders",
		joinColumns = {@JoinColumn(name="shop_id", referencedColumnName="id")},
		inverseJoinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")}
	)
	private Set<User> moders;
	
	@OneToOne(mappedBy="shop", cascade=CascadeType.ALL)
	private ShopDetails shopDetails;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinTable(name="shop_owners",
		joinColumns = {@JoinColumn(name="shop_id", referencedColumnName="id")},
		inverseJoinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")}
	)
	private User shopOwner;
	
	/**
	 * Method updates already existed {@link Shop} object with values from the inputed argument.
	 * @param newShop - Object which contains new Shop values.
	 * @return {@link Shop} object to which this method applied.
	 */
	public Shop update(Shop newShop) {
		this.name = newShop.name;
		this.shopDetails = newShop.shopDetails;
		this.moders = newShop.moders;
		this.shopOwner = newShop.shopOwner;
		return this;
	}
	
	public Shop buildShopFromDTO(ShopDTO shopDTO) {
		//TODO
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
	public Set<User> getModers() {
		return moders;
	}

	public void setModers(Set<User> moders) {
		this.moders = moders;
	}

	public User getShopOwner() {
		return shopOwner;
	}

	public void setShopOwner(User shopOwner) {
		this.shopOwner = shopOwner;
	}
	
	
	
}
