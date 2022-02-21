package com.company.store.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "store")
public class StoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id", nullable = false)
    private Integer id;

    @Column(name = "store_name")
    private String storeName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id",nullable = false)
    @JsonManagedReference
    private Set<ProductEntity> products;
}
