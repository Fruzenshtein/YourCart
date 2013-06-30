package com.yc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.dao.ShopRepository;
import com.yc.exception.ShopNotFoundException;
import com.yc.model.Shop;
import com.yc.model.ShopDetails;

@Service
@Transactional(rollbackFor=ShopNotFoundException.class)
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopRepository shopRepository;

	@Override
	public Shop get(int id) {
		return shopRepository.findOne(id);
	}

	@Override
	public Shop save(Shop shop) {
		ShopDetails shopDetails = new ShopDetails();
		shop.setShopDetails(shopDetails);
		shopDetails.setShop(shop);
		
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
	public Shop update(Shop shop) throws ShopNotFoundException {
		Shop shopToUpdate = get(shop.getId());
		if (shopToUpdate == null)
			throw new ShopNotFoundException();
		
		shopToUpdate.update(shop);
		
		return shopToUpdate;
	}

}
