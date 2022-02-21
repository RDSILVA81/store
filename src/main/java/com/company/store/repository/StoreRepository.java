package com.company.store.repository;

import com.company.store.entity.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<StoreEntity, Integer> {
    @Query("SELECT s FROM StoreEntity s WHERE s.storeName = ?1")
    Optional<StoreEntity> findByStoreName(String storeName);
}
