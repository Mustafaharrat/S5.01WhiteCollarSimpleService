package com.WhiteCollarShop.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WhiteCollarShop.entity.Picture;


@Repository
@Transactional
public interface PictureDao extends JpaRepository<Picture,Integer> {
	
	
		List<Picture> findAllByShopid(int shopid);
		void deleteAllByShopid(int shopid);

}
