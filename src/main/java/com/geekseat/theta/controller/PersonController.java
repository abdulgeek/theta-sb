package com.geekseat.theta.controller;

import com.geekseat.theta.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @GetMapping("/list")
    public ResponseEntity<?> list() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
}
