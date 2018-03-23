package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.boot.model.Quote;
import com.boot.service.RandomService;

@RestController
@RequestMapping("/api/random")
public class RandomController {
  
  @Autowired
  RandomService randomService;
  
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<?> getQuote() {
      Quote quote = randomService.getQuote();

      if (quote == null) {
          return new ResponseEntity(null, new HttpHeaders(), HttpStatus.UNAUTHORIZED);
      }

    
      return ResponseEntity.ok(quote);
  }

}
