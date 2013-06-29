package com.yc.dto;

import com.yc.model.Shop;
import com.yc.model.ShopDetails;

/**
 * Class represents combined entities: {@link Shop}, {@link ShopDetails} 
 * @author Fruzenshtein
 *
 */
public class ShopDTO {
	
	private Integer id;
	private String name;
	private String category;
	private String type;
	
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

}
