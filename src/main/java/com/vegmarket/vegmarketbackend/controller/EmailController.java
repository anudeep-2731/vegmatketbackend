package com.vegmarket.vegmarketbackend.controller;

import com.vegmarket.vegmarketbackend.entity.EmailDetails;
import com.vegmarket.vegmarketbackend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emailservice")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendMail")
    public boolean sendEmail(@RequestBody EmailDetails emailDetails){
          this.emailService.sendSimpleMail(emailDetails);
          return true;
    }
}
