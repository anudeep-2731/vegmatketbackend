package com.vegmarket.vegmarketbackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="packs")
@Data
public class Pack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="pack_name")
    private String packName;
    @Column(name="total_quantity")
    private  BigDecimal totalQuantity;
    @Column(name="total_price")
    private BigDecimal totalPrice;
    @Column(name="total_items")
    private  int totalItems;
    @Column(name="image_url")
    private String imageUrl;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "pack")
    private Set<PackItem> packItems=new HashSet<>();

    public void add(PackItem item){
        if(packItems == null){
            packItems=new HashSet<>();
        }
        packItems.add(item);
        item.setPack(this);
    }
}
