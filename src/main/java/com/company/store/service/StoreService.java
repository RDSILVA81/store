package com.company.store.service;

import com.company.store.entity.StoreEntity;
import com.company.store.exception.StoreException;
import com.company.store.repository.StoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;


@Service
@AllArgsConstructor
public class StoreService {

    private final StoreRepository repository;

    public StoreEntity findStoreByStoreName(final String storeName){
        return repository.findByStoreName(storeName).orElseThrow(()-> new StoreException(String.format("Store not found with name '%s'.",storeName)));
    }

    public List<StoreEntity> findStoreByProductID(final Integer productID){
        var response = repository.findStoreByProductID(productID);
        if(CollectionUtils.isEmpty(response)){
            throw new StoreException(String.format("Product not found with id '%s'.", productID));
        }
        return response ;
    }


}
