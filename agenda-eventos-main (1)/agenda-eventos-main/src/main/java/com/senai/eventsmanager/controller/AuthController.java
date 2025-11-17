package com.senai.eventsmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @GetMapping
    public int index(){
        return 200;
    }

    @GetMapping("/ping")
    public String ping(){
        return "Pong";
    }

    @PostMapping("/nome")
    public String nome(){
        return "Samuel";
    }

}
