package dk.vitten.backendshop.repository.shop;

import dk.vitten.backendshop.models.shop.Shop;

import java.util.List;
import java.util.UUID;

public interface IShopDao {
  int insertShop(UUID id, Shop shop);

  default int addShop(Shop shop){
    UUID uuid = UUID.randomUUID();
    return insertShop(uuid, shop);
  }

  List<Shop> getAllShop();

  int removeByShop(UUID id);

  Shop findShopById(UUID id);

  List<Shop> findShopBySearch(String word);

  List<Shop> findShopByName(String name);

  int updateShop(Shop shop);
}
