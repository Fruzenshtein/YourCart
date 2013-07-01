package com.yc.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.dao.ShopRepository;
import com.yc.dto.ShopDTO;
import com.yc.exception.ShopNotFoundException;
import com.yc.helper.security.UserContext;
import com.yc.model.Shop;
import com.yc.model.ShopDetails;
import com.yc.model.User;

@Service
@Transactional(rollbackFor=ShopNotFoundException.class)
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopRepository shopRepository;
	
	@Autowired
	private UserContext userContext;
	
	@Autowired
	private UserService userService;

	@Override
	public Shop get(int id) {
		return shopRepository.findOne(id);
	}

	@Override
	public Shop save(ShopDTO shopDTO) {
		Shop shop = shopDTO.buildShop();
		ShopDetails shopDetails = shopDTO.buildShopDetails();
		
		//Persisted user
		User shopOwner = userService.get(userContext.getCurrentUser().getId());
		
		shop.setShopDetails(shopDetails);
		shopDetails.setShop(shop);
		
		shop.setShopOwner(shopOwner);
		
		shopRepository.save(shop);
		
		return shop;
	}

	@Override
	public Shop delete(int id) throws ShopNotFoundException {
		Shop shopToDelete = get(id);
		if (shopToDelete == null)
			throw new ShopNotFoundException();
		shopRepository.delete(shopToDelete);
		return shopToDelete;
	}

	@Override
	public Shop update(ShopDTO shopDTO) throws ShopNotFoundException {
		Shop shopToUpdate = get(shopDTO.getId());
		if (shopToUpdate == null)
			throw new ShopNotFoundException();
		
		//TODO: Update logic need to be implemented
		//shopToUpdate.update(shop);
		
		return shopToUpdate;
	}

}
