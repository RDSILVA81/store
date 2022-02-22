package com.company.store.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "store")
@Getter
@Setter
public class StoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id", nullable = false)
    private Integer id;

    @Column(name = "store_name")
    private String storeName;

    @ManyToMany
    @JoinTable(
            name = "store_products",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name = "products_id"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<ProductEntity> products;
}
