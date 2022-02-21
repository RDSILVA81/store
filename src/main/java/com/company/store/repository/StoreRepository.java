package com.company.store.repository;

import com.company.store.entity.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<StoreEntity, Integer> {

    Optional<StoreEntity> findByStoreName(String storeName);

    @Query(value="SELECT s.* FROM store s join store_products sp on sp.store_id = s.id where sp.products_id = ?1 ", nativeQuery=true)
    List<StoreEntity> findStoreByProductID(final Integer productID);
}
