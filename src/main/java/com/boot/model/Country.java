package com.boot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country {

  private Long id;
  private String country;
  private String name;
  private String abbr;
  private String area;
  @JsonProperty("largest_city")
  private String largestCity;
  private String capital;
  
  public String getCountry() {
    return country;
  }
  public void setCountry(String country) {
    this.country = country;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getAbbr() {
    return abbr;
  }
  public void setAbbr(String abbr) {
    this.abbr = abbr;
  }
  public String getArea() {
    return area;
  }
  public void setArea(String area) {
    this.area = area;
  }
 
  public String getCapital() {
    return capital;
  }
  public void setCapital(String capital) {
    this.capital = capital;
  }
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getLargestCity() {
    return largestCity;
  }
  public void setLargestCity(String largestCity) {
    this.largestCity = largestCity;
  }
}
