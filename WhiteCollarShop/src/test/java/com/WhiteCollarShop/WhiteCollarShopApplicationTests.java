package com.WhiteCollarShop;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.WhiteCollarShop.dao.PictureDao;
import com.WhiteCollarShop.dao.ShopDao;
import com.WhiteCollarShop.entity.Picture;
import com.WhiteCollarShop.entity.Shop;

@SpringBootTest
class WhiteCollarShopApplicationTests {

	@Autowired
	private ShopDao shopDAO;
	
	@Autowired
	private PictureDao pictureDAO;
	
	//1)Crear botiga: li direm el nom i la capacitat (POST /shops/).
	@Test
	public void testCreate() {
		
		Shop blackShop= new Shop("BlackShop",2);
		
		shopDAO.save(blackShop);
		
		assertNotNull(shopDAO.findById(1).get());
		
		
	}
	//2)Llistar botigues: retorna la llista de botigues amb el seu nom i la capacitat (GET /shops/). 
	@Test
	public void testReadShops() {
		
		List<Shop> ShopsList= shopDAO.findAll();
		assertNotNull(ShopsList);
	}
	
	//3)Afegir quadre: li donarem el nom del quadre i el del autor (POST /shops/{ID}/pictures)
	@Test
	public void testAddPicture() {
		
		
		
		Shop redShop= new Shop("RedShop",2);
		
		shopDAO.save(redShop);
		
		ArrayList <Picture> pictures= new ArrayList<Picture>();
		
		Picture picture=new Picture("Despertar","William",2200);
			
		picture.setShopid(2);
		
		picture.setDate_at(Calendar.getInstance());
		
		pictures.add(picture);
		
		redShop.setPictureList(pictures);
		Picture newPicture = pictureDAO.save(picture);
		assertNotNull(redShop.getPictureList());

	}
	//4)Llistar els quadres de la botiga (GET /shops/{ID}/pictures). 
	@Test
	public void getPicturesShop() {
		
		Optional<Shop> optionalShop= shopDAO.findById(2);
		
		List<Picture> picturesShop=pictureDAO.findAllByShopid(2);
		assertNotNull(picturesShop);
	}
	
	//5) Incendiar quadres: per si ve la policia, es poden eliminar tots els quadres de la botiga sense deixar rastre (DELETE /shops/{ID}/pictures). 
	@Test
	public void firePictures() {
		Optional<Shop> optionalShop= shopDAO.findById(1);
		
		Shop shop1= optionalShop.get();
		shop1.setPictureList(null);
		assertNull(shop1.getPictureList());
	
	}

}
