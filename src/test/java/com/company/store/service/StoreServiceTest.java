package com.company.store.service;

import com.company.store.entity.StoreEntity;
import com.company.store.repository.StoreRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

public class StoreServiceTest {

    private static StoreService storeService;
    private static StoreRepository storeRepositoryMock;

    @BeforeAll
    @SneakyThrows
    static void setUp(){
        storeRepositoryMock = mock(StoreRepository.class);
        storeService = new StoreService(storeRepositoryMock);
    }

    @Test
    void findStoreByNameSuccess(){
        //Arrange
        var storeMock = new StoreEntity();
        storeMock.setStoreName("StoreName");
        storeMock.setId(1);

        when(storeRepositoryMock.findByStoreName(anyString())).thenReturn(Optional.of(storeMock));

        //Action
        var response = storeService.findStoreByStoreName("StoreNameToSearch");

        //Assert
        assertThat(response).isNotNull();
    }
}
