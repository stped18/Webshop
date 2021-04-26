package dk.vitten.backendshop.services;

import dk.vitten.backendshop.repository.shop.IShopDao;
import dk.vitten.backendshop.models.shop.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

  private IShopDao shopDao;

  @Autowired
  public ShopService(@Qualifier ("ShopDao")IShopDao shopDao) {
    this.shopDao = shopDao;
  }

  public int addShop(Shop shop){
    return this.shopDao.addShop(shop);
  }

  public List<Shop> getAllShops(){
    return this.shopDao.getAllShop();
  }

}
