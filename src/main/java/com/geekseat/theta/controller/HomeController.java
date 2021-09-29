package com.geekseat.theta.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @PreAuthorize(value = "hasAuthority('EDIT_TRANSAKSI')")
    @GetMapping("/home")
    public void home() {

    }
}
