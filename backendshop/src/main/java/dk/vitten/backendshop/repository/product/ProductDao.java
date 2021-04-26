package dk.vitten.backendshop.repository.product;


import dk.vitten.backendshop.models.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import dk.vitten.backendshop.data.product.IProductDAO;


import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
@Repository ("ProductDao")
public class ProductDao implements IProductDAO {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public ProductDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public int insertProduct(UUID id, Product product) {
    final String sql = "INSERT INTO Product(ID, ShopID, Name, Description, Buy_price, Price, Quantity, Catagory, Type, Brand, Timestamp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    this.jdbcTemplate.update(
            sql, id, product.getShopID(), product.getName(), product.getDescription(), product.getBuy_price(), product.getPrice()
            ,product.getQuantity(), product.getCatagory(), product.getType(), product.getBrand(), new Timestamp(System.currentTimeMillis()));
      return 200;
  }

  @Override
  public List<Product> getAllProduct() {
    final String sql = "SELECT ID, ShopID, Name, Description, Buy_price, Price, Quantity, Catagory, Type, Brand FROM Product;";
    return (List<Product>) this.jdbcTemplate.query(sql, (resultSet , i)->{
      return new Product(UUID.fromString(resultSet.getString("ID")),UUID.fromString(resultSet.getString("ShopID")),
              resultSet.getString("Name"),
              resultSet.getString("Description"),
              resultSet.getFloat("Buy_price"),
              resultSet.getFloat("Price"),
              resultSet.getInt("Quantity"),
              resultSet.getString("Catagory"),
              resultSet.getString("Type"),
              resultSet.getString("Brand"));
    });

  }

  @Override
  public int removeByID(UUID id) {
    return 0;
  }

  @Override
  public Product findProductById(UUID id) {
    return null;
  }

  @Override
  public List<Product> findProductBySearch(String word) {
    return null;
  }

  @Override
  public List<Product> findProductByType(String productType) {
    return null;
  }

  @Override
  public List<Product> findProductByCatogry(String category) {
    return null;
  }

  @Override
  public List<Product> findProductByName(String name) {
    return null;
  }

  @Override
  public int updateProduct(Product product) {
    return 0;
  }
}
