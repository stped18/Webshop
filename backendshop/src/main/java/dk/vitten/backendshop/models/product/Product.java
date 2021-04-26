package dk.vitten.backendshop.models.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Entity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;
@JsonIgnoreProperties (ignoreUnknown = true)
public class Product {
  @JsonProperty ("ID")
  private UUID ID;
  @JsonProperty ("shopID")
  private UUID shopID;
  @JsonProperty("name")
  private String name;
  @JsonProperty("description")
  private String description;
  @JsonProperty("buy_price")
  private float buy_price;
  @JsonProperty("price")
  private float price;
  @JsonProperty("quantity")
  private int quantity;
  @JsonProperty("catagory")
  private String catagory;
  @JsonProperty("type")
  private String type;
  @JsonProperty("brand")
  private String brand;



  public Product(UUID ID, UUID shopID, String name, String description, float buy_price, float price, int quantity, String catagory, String type, String brand) {
    this.ID = ID;
    this.shopID = shopID;
    this.name = name;
    this.description = description;
    this.buy_price = buy_price;
    this.price = price;
    this.quantity = quantity;
    this.catagory = catagory;
    this.type = type;
    this.brand = brand;
  }


  public UUID getID() {
    return ID;
  }

  public UUID getShopID() {
    return shopID;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public float getBuy_price() {
    return buy_price;
  }

  public float getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }

  public String getCatagory() {
    return catagory;
  }

  public String getType() {
    return type;
  }

  public String getBrand() {
    return brand;
  }

  @Override
  public String toString() {
    return "Product{" +
            "ID=" + ID +
            ", shopID=" + shopID +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", buy_price=" + buy_price +
            ", price=" + price +
            ", quantity=" + quantity +
            ", catagory='" + catagory + '\'' +
            ", type='" + type + '\'' +
            ", brand='" + brand + '\'' +
            '}';
  }
}
