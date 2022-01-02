package com.WhiteCollarShop.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WhiteCollarShop.entity.Shop;

@Repository
@Transactional
public interface ShopDao extends JpaRepository <Shop,Integer> {

}
