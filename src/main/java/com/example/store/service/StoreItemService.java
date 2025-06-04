package com.example.store.service;
import com.example.store.entity.StoreItem;
import com.example.store.repository.StoreItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StoreItemService {
    @Autowired private StoreItemRepo storeItemRepo;
    public StoreItem addItem(StoreItem item) { return storeItemRepo.save(item); }
    public StoreItem updateItem(Long id, StoreItem item) { item.setId(id); return storeItemRepo.save(item); }
    public void deleteItem(Long id) { storeItemRepo.deleteById(id); }
    public List<StoreItem> getAllItems() { return storeItemRepo.findAll(); }
    public List<StoreItem> searchByName(String name) { return storeItemRepo.findByNameContainingIgnoreCase(name); }
    public List<StoreItem> filterByType(String type) { return storeItemRepo.findByTypeIgnoreCase(type); }
    public List<StoreItem> filterByPriceRange(Double minPrice, Double maxPrice) { return storeItemRepo.findByPriceBetween(minPrice, maxPrice); }
    public StoreItem getItemById(Long id) { return storeItemRepo.findById(id).orElseThrow(() -> new RuntimeException("Item not found")); }
}

