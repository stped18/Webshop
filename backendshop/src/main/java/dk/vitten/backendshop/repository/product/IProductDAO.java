package dk.vitten.backendshop.data.product;



import dk.vitten.backendshop.models.product.Product;

import java.util.List;
import java.util.UUID;

public interface IProductDAO {

  int insertProduct(UUID id, Product product);

  default int addProduct(Product product){
    UUID uuid = UUID.randomUUID();
    return insertProduct(uuid, product);
  }

  List<Product> getAllProduct();


  int removeByID(UUID id);

  Product findProductById(UUID id);

  List<Product> findProductBySearch(String word);

  List<Product> findProductByType(String productType);

  List<Product> findProductByCatogry(String category);

  List<Product> findProductByName(String name);

  int updateProduct(Product product);
}
