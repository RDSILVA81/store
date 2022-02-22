package com.company.store.service;

import com.company.store.entity.StoreEntity;
import com.company.store.repository.StoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class StoreService {

    private final StoreRepository repository;

    public StoreEntity findStoreByStoreName(final String storeName){
        return repository.findByStoreName(storeName).orElseThrow(()-> new IllegalArgumentException(String.format("Store not found with name '%s'.",storeName)));
    }

    public List<StoreEntity> findStoreByProductID(final Integer productID){
        return repository.findStoreByProductID(productID);
    }


}
