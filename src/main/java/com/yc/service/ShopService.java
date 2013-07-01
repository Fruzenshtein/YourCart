package com.yc.service;

import com.yc.dto.ShopDTO;
import com.yc.exception.ShopNotFoundException;
import com.yc.model.Shop;

public interface ShopService {
	
	public Shop get(int id);
	public Shop save(ShopDTO shopDTO);
	public Shop delete(int id) throws ShopNotFoundException;
	public Shop update(ShopDTO shopDTO) throws ShopNotFoundException;

}
