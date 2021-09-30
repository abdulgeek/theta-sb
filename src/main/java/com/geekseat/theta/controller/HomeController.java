package com.geekseat.theta.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ObjectMapper mapper;

    @GetMapping("/home")
    public void home(Authentication authentication, Principal principal) throws JsonProcessingException {
        log.info("\n");
        log.info("Principal -> {}", principal);
        log.info("Jenis Class authentication -> {}", authentication.getClass().getSimpleName());
        log.info("User yang sedang login -> {}", mapper.writeValueAsString(authentication.getPrincipal()));
    }
}
