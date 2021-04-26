package dk.vitten.backendshop.models.shop;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Shop {
  @JsonProperty ("ID")
  private UUID ID;
  @JsonProperty ("name")
  private String name;
  @JsonProperty ("description")
  private String description;
  @JsonProperty ("adress")
  private String adress;
  @JsonProperty ("city")
  private String city;
  @JsonProperty ("contact_nr")
  private int contact_nr;
  @JsonProperty ("mail")
  private String mail;
  @JsonProperty ("website")
  private String website;

  public Shop(UUID ID, String name, String description, String adress, String city, int contact_nr, String mail, String website) {
    this.ID = ID;
    this.name = name;
    this.description = description;
    this.adress = adress;
    this.city = city;
    this.contact_nr = contact_nr;
    this.mail = mail;
    this.website = website;
  }

  public UUID getID() {
    return ID;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getAdress() {
    return adress;
  }

  public String getCity() {
    return city;
  }

  public int getContact_nr() {
    return contact_nr;
  }

  public String getMail() {
    return mail;
  }

  public String getWebsite() {
    return website;
  }
}
