package dk.vitten.backendshop.api;

import dk.vitten.backendshop.models.shop.Shop;
import dk.vitten.backendshop.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin (origins = "*")
@RequestMapping ("/api/shop")
@RestController ()
public class ShopAPI {
  @Autowired
  private final ShopService shopService;

  public ShopAPI(ShopService shopService) {
    this.shopService = shopService;
  }

  @PostMapping
  public int addShop(@RequestBody Shop shop){
    return this.shopService.addShop(shop);
  }

  @GetMapping(path="/all")
  public List<Shop> getAllShops() {
    return this.shopService.getAllShops();
  }

}
