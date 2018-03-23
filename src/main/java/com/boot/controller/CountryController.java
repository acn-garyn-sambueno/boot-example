package com.boot.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.boot.model.Country;
import com.boot.service.CountryService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("country/")
public class CountryController {
  
  @Autowired
  private CountryService countryService;
  
  @RequestMapping(path = "{country}/all", method = RequestMethod.GET)
  public ResponseEntity<List<Country>> searchByCountryCode(@PathVariable String country) {
    List<Country> cntryList = null;
    
    try {
      cntryList = countryService.searchByCountryCode(country);
    } catch (JsonProcessingException e) {
      return ResponseEntity.unprocessableEntity().build();    
    }
    
    if (cntryList == null) {
      return new ResponseEntity(null, new HttpHeaders(), HttpStatus.UNAUTHORIZED);
    }
    
    return ResponseEntity.ok(cntryList);
  }

  

}
