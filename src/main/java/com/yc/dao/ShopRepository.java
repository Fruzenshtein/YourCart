package com.yc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yc.model.Shop;

public interface ShopRepository extends JpaRepository<Shop, Integer> {

}
