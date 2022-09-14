package com.vegmarket.vegmarketbackend.controller;

import com.vegmarket.vegmarketbackend.dto.AddPackRequest;
import com.vegmarket.vegmarketbackend.dto.PackResponse;
import com.vegmarket.vegmarketbackend.entity.Pack;
import com.vegmarket.vegmarketbackend.service.PackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("https://localhost:4201")
@RestController
@RequestMapping("/api/packmanagement")
public class PackController {

    @Autowired
    private PackService packService;

    @PostMapping("/addpack")
    public PackResponse addPack(@RequestBody AddPackRequest addPackRequest){

        return  packService.addPack(addPackRequest);
    }

}
