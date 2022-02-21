package com.company.store.controller;

import com.company.store.entity.StoreEntity;
import com.company.store.service.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/store")
@AllArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping
    public HttpEntity<StoreEntity> finsStoreByName(@RequestParam final String storeName){
        return new HttpEntity<>(storeService.findStoreByStoreName(storeName));
    }

}
