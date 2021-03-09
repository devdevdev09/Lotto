package com.heo.lotto.controller;

import java.net.URI;

import com.heo.lotto.domain.Numbers;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/numbers")
public class NumberController {
    
    @GetMapping("/")
    public ResponseEntity<Numbers> getNumbers(){
        return null;
    }

    @PostMapping("/")
    public ResponseEntity<Void> postNumbers(){
        URI location = UriComponentsBuilder.fromPath("/numbers/{id}").buildAndExpand("10").toUri();
        
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/")
    public ResponseEntity<Void> putNumbers(){
        return null;
    }

    @PatchMapping("/")
    public ResponseEntity<Void> patchNumbers(){
        return null;
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteNumbers(){
        return null;
    }
}
