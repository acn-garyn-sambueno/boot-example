package com.boot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import org.springframework.web.util.UriComponentsBuilder;
import com.boot.model.Country;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;


@Service

public class CountryService   {
  
private RestTemplate restTemplate = new RestTemplate();
  
  @Value(value = "${url.services.groupkt.com}")
  private String url;
  
 
  public List<Country> searchByCountryCode(String code) throws JsonProcessingException {
    HttpHeaders header = new HttpHeaders();
    header.setContentType(MediaType.APPLICATION_JSON);
  
    HttpEntity<ObjectNode> httpEntity = new HttpEntity<>(new HttpHeaders());
    //HttpEntity<JsonNode> entity = new HttpEntity(header);
    UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url).pathSegment("get").pathSegment(code).pathSegment("all");

   ResponseEntity<ObjectNode> response = restTemplate.exchange(uriBuilder.build().toUriString(),HttpMethod.GET, httpEntity, ObjectNode.class);
   
   List <JsonNode> nodes = new ArrayList<>();
   response.getBody().findValue("result").forEach(res -> nodes.add(res) );
   List<Country> result = nodes.stream().map(country -> 
   {    
     ObjectMapper mapper = new ObjectMapper();
     Country cntry = new Country();
    try {
      cntry =  mapper.treeToValue(country, Country.class);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return cntry;}
   ).collect(Collectors.toList());
   
   return result;
  }
  

}
