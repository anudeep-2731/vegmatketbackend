package com.vegmarket.vegmarketbackend.entity;

import javax.persistence.*;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="product_category")
@Getter
@Setter
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="category_name")
    private String category_name;

    @OneToMany(cascade=CascadeType.ALL,mappedBy="category")
    private Set<Product> products;
}
