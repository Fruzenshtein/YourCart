package com.yc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yc.model.Shop;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
	
	@Query("from Shop shop where shop.shopOwner.id = :id")
	public List<Shop> findShopsByOwner(@Param(value = "id") int id);

}
