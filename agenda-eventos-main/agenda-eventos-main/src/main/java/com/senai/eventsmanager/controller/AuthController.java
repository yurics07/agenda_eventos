package com.senai.eventsmanager.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.eventsmanager.dto.AuthDTO;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

     @PostMapping("/login")
     public void login(@RequestBody AuthDTO dto){

     }
     

}
