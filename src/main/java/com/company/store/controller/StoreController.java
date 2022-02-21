package com.company.store.controller;

import com.company.store.entity.StoreEntity;
import com.company.store.service.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/store")
@AllArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping
    public StoreEntity findStoreByName(@RequestParam final String storeName){
        return storeService.findStoreByStoreName(storeName);
    }

    @GetMapping("/product")
    public List<StoreEntity> findStoreByProduct(@RequestParam final Integer id){
        return storeService.findStoreByProductID(id);
    }

}
