package com.yc.service;

import com.yc.exception.ShopNotFoundException;
import com.yc.model.ShopDetails;

public interface ShopDetailsService {
	
	public ShopDetails get(int id);
	public ShopDetails save(ShopDetails shopDetails);
	public ShopDetails update(ShopDetails shopDetails) throws ShopNotFoundException;

}
