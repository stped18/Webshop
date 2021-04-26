package dk.vitten.backendshop.models.costumer;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Customer {
  @JsonProperty ("ID")
  private UUID ID;
  @JsonProperty ("first_name")
  private String first_name;
  @JsonProperty ("last_name")
  private String last_name;
  @JsonProperty ("contact_nr")
  private int contact_nr;

  public Customer(UUID ID, String first_name, String last_name, int contact_nr) {
    this.ID = ID;
    this.first_name = first_name;
    this.last_name = last_name;
    this.contact_nr = contact_nr;
  }

  public UUID getID() {
    return ID;
  }

  public String getFirst_name() {
    return first_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public int getContact_nr() {
    return contact_nr;
  }
}
