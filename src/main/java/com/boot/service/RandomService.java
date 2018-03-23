package com.boot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.boot.model.Quote;

@Service
public class RandomService {
  
  
  private RestTemplate restTemplate = new RestTemplate();
  
  @Value(value = "${url.gturnquist-quoters.cfapps.io}")
  private String url;
  
  
  public Quote getQuote () {
    HttpHeaders header = new HttpHeaders();
    header.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<?> entity = new HttpEntity(header);

    try {
      ResponseEntity<Quote> response = restTemplate.exchange(url, HttpMethod.GET, entity, Quote.class);

      return response.getBody();
    } catch (Exception e) {
      
        return null;
    }
  }

}
