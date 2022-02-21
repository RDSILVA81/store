package com.company.store.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product")
@Getter
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer id;
    @Column(name = "product_name")
    private String name;
    @Column(name="quantity")
    private int quantity;
    @Column(name = "price")
    private Double price;

    @ManyToMany
    @JoinTable(
            name = "store_products",
            joinColumns = @JoinColumn(name = "products_id"),
            inverseJoinColumns = @JoinColumn(name = "store_id"))
    @JsonIgnore
    private Set<StoreEntity> store;
}
