package dk.vitten.backendshop.repository.shop;

import dk.vitten.backendshop.models.shop.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository ("ShopDao")
public class ShopDao implements IShopDao {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public ShopDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }


  @Override
  public int insertShop(UUID id, Shop shop) {
    final String sql = "INSERT INTO Shop(ID, Name, Description, Adress, City, Contact_nr, Mail, Website) VALUES (?, ?, ?, ?, ?, ?, ?, ?);\n";
    this.jdbcTemplate.update(
            sql, id, shop.getName(), shop.getDescription(), shop.getAdress(), shop.getCity(), shop.getContact_nr(), shop.getMail(), shop.getWebsite());
    return 200;
  }

  @Override
  public List<Shop> getAllShop() {
    final String sql = "SELECT ID, Name, Description, Adress, City, Contact_nr, Mail, Website FROM Shop;\n";
    return (List<Shop>) this.jdbcTemplate.query(sql, (resultSet , i)->{
      return new Shop(UUID.fromString(resultSet.getString("ID")),
              resultSet.getString("Name"),
              resultSet.getString("Description"),
              resultSet.getString("Adress"),
              resultSet.getString("City"),
              resultSet.getInt("Contact_nr"),
              resultSet.getString("Mail"),
              resultSet.getString("Website")
              );
    });
  }

  @Override
  public int removeByShop(UUID id) {
    return 0;
  }

  @Override
  public Shop findShopById(UUID id) {
    return null;
  }

  @Override
  public List<Shop> findShopBySearch(String word) {
    return null;
  }

  @Override
  public List<Shop> findShopByName(String name) {
    return null;
  }

  @Override
  public int updateShop(Shop shop) {
    return 0;
  }
}
