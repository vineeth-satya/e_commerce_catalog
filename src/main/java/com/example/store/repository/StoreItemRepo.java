package com.example.store.repository;
import com.example.store.entity.StoreItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface StoreItemRepo extends JpaRepository<StoreItem, Long> {
    List<StoreItem> findByNameContainingIgnoreCase(String name);
    List<StoreItem> findByTypeIgnoreCase(String type);
    @Query("SELECT s FROM StoreItem s WHERE s.price BETWEEN :minPrice AND :maxPrice")
    List<StoreItem> findByPriceBetween(Double minPrice, Double maxPrice);
}
