package com.yc.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.yc.dto.ShopDTO;
import com.yc.exception.ShopNotFoundException;
import com.yc.model.Shop;

public interface ShopService {
	
	@PreAuthorize("isAuthenticated()")
	public Shop get(int id);
	
	@PreAuthorize("isAuthenticated()")
	public Shop save(ShopDTO shopDTO);
	
	
	public Shop delete(int id) throws ShopNotFoundException;
	
	@PreAuthorize("#shopDTO.ownerId == principal.id")
	public Shop update(ShopDTO shopDTO) throws ShopNotFoundException;
	
	/**
	 * Method searches all shops associated with logged in user.
	 * @return List of {@link Shop}
	 */
	@PreAuthorize("isAuthenticated()")
	public List<Shop> findOwnerShops();

}
