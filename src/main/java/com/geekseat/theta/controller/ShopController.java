package com.geekseat.theta.controller;

import com.geekseat.theta.model.Shop;
import com.geekseat.theta.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {

    private final ShopRepository shopRepository;

    @GetMapping("/list")
    public ResponseEntity<?> list() {
        return new ResponseEntity<>(shopRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody @Valid Shop shop) {
        Shop save = shopRepository.save(shop);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

}
