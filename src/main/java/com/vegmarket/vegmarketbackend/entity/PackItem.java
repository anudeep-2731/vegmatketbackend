package com.vegmarket.vegmarketbackend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="pack_item")
@Getter
@Setter
public class PackItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="image_url")
    private  String imageUrl;
    @Column(name="unit_price")
    private BigDecimal unitPrice;
    @Column(name = "quantity")
    private BigDecimal quantity;
    @Column(name = "product_id")
    private  Long productId;
    @ManyToOne
    @JoinColumn(name = "pack_id")
    private Pack pack;
}
