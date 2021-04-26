package dk.vitten.backendshop.services;


import dk.vitten.backendshop.models.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import dk.vitten.backendshop.data.product.IProductDAO;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

  private final IProductDAO productDao;
  @Autowired
  public ProductService(@Qualifier ("ProductDao") IProductDAO productDao) {
    this.productDao = productDao;
  }

  public int addProduct(Product product){
    return this.productDao.addProduct(product);
  }



  public List<Product> getAllProduct(){
    return this.productDao.getAllProduct();
  }


  public int removeByID(UUID id){
    return this.productDao.removeByID(id);
  }

  public Product findProductById(UUID id){
    return this.productDao.findProductById(id);
  }

  public List<Product> findProductBySearch(String word){
    return this.productDao.findProductBySearch(word);
  }

  public List<Product> findProductByType(String productType){
    return this.productDao.findProductByType(productType);
  }

  public List<Product> findProductByCatogry(String category){
    return this.productDao.findProductByCatogry(category);
  }

  public List<Product> findProductByName(String name){
    return this.productDao.findProductByName(name);
  }

  public int updateProduct(Product product){
    return this.productDao.updateProduct(product);
  }
}
