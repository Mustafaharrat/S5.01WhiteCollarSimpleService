package com.WhiteCollarShop.controllers;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.WhiteCollarShop.dao.PictureDao;
import com.WhiteCollarShop.dao.ShopDao;
import com.WhiteCollarShop.entity.Picture;
import com.WhiteCollarShop.entity.Shop;



@RestController
@RequestMapping("/")
public class Controller {
	
	@Autowired
	private PictureDao pictureDAO;
	@Autowired
	private ShopDao shopDAO;
	
	
	

	//1)Crear botiga: li direm el nom i la capacitat (POST /shops/).
	@PostMapping("createShop")
	public ResponseEntity<Shop> createShop(@RequestBody Shop shop){
		
		Shop newShop= shopDAO.save(shop);
		
		return ResponseEntity.ok(newShop);
	}
	
	//2)Llistar botigues: retorna la llista de botigues amb el seu nom i la capacitat (GET /shops/). 
	@GetMapping("readShops")
	public ResponseEntity<List<Shop>> readShops(){
		
		List<Shop> shops=shopDAO.findAll();
		return ResponseEntity.ok(shops);
	}
	
	//3)Afegir quadre: li donarem el nom del quadre i el del autor (POST /shops/{ID}/pictures)
	@PostMapping("addPicture/{shopId}/createpictures")
	public ResponseEntity<String> addPicture(@RequestBody Picture picture,
												@PathVariable("shopId") Integer shopId){
		
		Optional<Shop> optionalShop= shopDAO.findById(shopId);
		
		if(optionalShop.isPresent()) {
		
		Shop shop1= optionalShop.get();
		
		if(shop1.getPictureList().size()<shop1.getCapacity()) {
		
		picture.setShopid(shopId);
		
		picture.setDate_at(Calendar.getInstance());
		
		shop1.getPictureList().add(picture);
		
		Picture newPicture = pictureDAO.save(picture);
		return ResponseEntity.ok("Picture incorporated : "+newPicture);
		
		}
		return ResponseEntity.ok("Capacity of shop is FULL");
		
		}else {
			
			return ResponseEntity.ok("No Shop Found with shop id= "+shopId);
			
			
		}
		
	}
	

	//4)Llistar els quadres de la botiga (GET /shops/{ID}/pictures). 
	@GetMapping("getPicturesShop/{shopId}/pictures")
	public ResponseEntity<String> getPicturesShop(@PathVariable("shopId") Integer shopId ){
		
		Optional<Shop> optionalShop= shopDAO.findById(shopId);
		
		if(optionalShop.isPresent()) {
		
		
		
		List<Picture> picturesShop=pictureDAO.findAllByShopid(shopId);
		
		return ResponseEntity.ok("Pictures of ShopId:"+shopId+" "+picturesShop);
		
		}else {
			
			return ResponseEntity.ok("No Shop Found with shop id= "+shopId);
			
			
		}
	}

	//5) Incendiar quadres: per si ve la policia, es poden eliminar tots els 
		//quadres de la botiga sense deixar rastre (DELETE /shops/{ID}/pictures). 
			
	@DeleteMapping("deletePictures/{shopId}/pictures")
	public ResponseEntity<String> deletePictures(@PathVariable ("shopId")Integer shopId){
		
		Optional<Shop> optionalShop= shopDAO.findById(shopId);
		
		if(optionalShop.isPresent()) {
			
		pictureDAO.deleteAllByShopid(shopId);
		
		return ResponseEntity.ok("Pictures Fired in shop id= "+shopId);
		
		}else {
			
			return ResponseEntity.ok("No Shop Found with shop id= "+shopId);
			
		}
	}
	
	@GetMapping("getShops/{shopId}")
	public ResponseEntity<String> getShopsById(@PathVariable("shopId")Integer shopId){
		
		Optional<Shop> optionalShop= shopDAO.findById(shopId);
		
		if(optionalShop.isPresent()) {
			
			Shop shop1= optionalShop.get();
			
			return ResponseEntity.ok("id:"+shopId+" is "+shop1);
			
		}else {
			return ResponseEntity.noContent().build();
		}
		
	}
		
	@DeleteMapping("deleteShop/{shopId}")
	public ResponseEntity<String> deleteShopById(@PathVariable("shopId")Integer shopId){
		Optional<Shop> optionalShop= shopDAO.findById(shopId);
		
		
		if(optionalShop.isPresent()) {
			
			Shop shop1= optionalShop.get();
			
			shopDAO.delete(shop1);
			
			return ResponseEntity.ok("deleted shop id= "+shopId);
			
		}else {
			
			return ResponseEntity.ok("No Shop Found with shop id= "+shopId);
		}
	}
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

