package dk.vitten.backendshop.api;


import dk.vitten.backendshop.models.product.Product;
import dk.vitten.backendshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin (origins = "*")
@RequestMapping ("/api/product")
@RestController ()
public class ProductAPI {


  private final ProductService productService;

  @Autowired
  public ProductAPI(ProductService productService) {
    this.productService = productService;
  }
  @PostMapping
  public int addItem(@RequestBody Product product){
    return this.productService.addProduct(product);
  }

  @GetMapping(path="/all")
  public List<Product> getAllItems() {
    return this.productService.getAllProduct();
  }
}
