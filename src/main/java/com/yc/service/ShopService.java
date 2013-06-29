package com.yc.service;

import com.yc.exception.ShopNotFoundException;
import com.yc.model.Shop;

public interface ShopService {
	
	public Shop get(int id);
	public Shop save(Shop shop);
	public Shop delete(int id) throws ShopNotFoundException;
	public Shop update(Shop shop) throws ShopNotFoundException;

}
