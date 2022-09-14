package com.vegmarket.vegmarketbackend.service;

import com.vegmarket.vegmarketbackend.dao.PackRepository;
import com.vegmarket.vegmarketbackend.dto.AddPackRequest;
import com.vegmarket.vegmarketbackend.dto.PackResponse;
import com.vegmarket.vegmarketbackend.entity.Pack;
import com.vegmarket.vegmarketbackend.entity.PackItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PackService {
    @Autowired
    private PackRepository packRepository;

    public PackResponse addPack(AddPackRequest addPackRequest){
        Pack pack=new Pack();
        pack.setImageUrl(addPackRequest.getImageUrl());
        pack.setPackName(addPackRequest.getPackName());
        pack.setTotalPrice(addPackRequest.getTotalPrice());
        pack.setTotalQuantity(addPackRequest.getTotalQuantity());
        pack.setTotalItems(addPackRequest.getTotalItems());

        Set<PackItem> packItems=addPackRequest.getPackItems();

        packItems.forEach(item->pack.add(item));

        packRepository.save(pack);

        return new PackResponse(pack.getPackName());
    }
}
