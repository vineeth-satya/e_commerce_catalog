package com.example.store.controller;
import com.example.store.entity.StoreItem;
import com.example.store.service.StoreItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/items")
public class StoreItemController {
    @Autowired private StoreItemService storeItemService;
    @PostMapping
    public ResponseEntity<StoreItem> addItem(@RequestBody StoreItem item) { return new ResponseEntity<>(storeItemService.addItem(item), HttpStatus.CREATED); }
    @PutMapping("/{id}")
    public ResponseEntity<StoreItem> updateItem(@PathVariable Long id, @RequestBody StoreItem item) { return new ResponseEntity<>(storeItemService.updateItem(id, item), HttpStatus.OK); }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) { storeItemService.deleteItem(id); return new ResponseEntity<>(HttpStatus.NO_CONTENT); }
    @GetMapping
    public ResponseEntity<List<StoreItem>> getAllItems() { return new ResponseEntity<>(storeItemService.getAllItems(), HttpStatus.OK); }
    @GetMapping("/search")
    public ResponseEntity<List<StoreItem>> searchByName(@RequestParam String name) { return new ResponseEntity<>(storeItemService.searchByName(name), HttpStatus.OK); }
    @GetMapping("/filter/type")
    public ResponseEntity<List<StoreItem>> filterByType(@RequestParam String type) { return new ResponseEntity<>(storeItemService.filterByType(type), HttpStatus.OK); }
    @GetMapping("/filter/price")
    public ResponseEntity<List<StoreItem>> filterByPriceRange(@RequestParam Double minPrice, @RequestParam Double maxPrice) { return new ResponseEntity<>(storeItemService.filterByPriceRange(minPrice, maxPrice), HttpStatus.OK); }
    @GetMapping("/{id}")
    public ResponseEntity<StoreItem> getItemById(@PathVariable Long id) { return new ResponseEntity<>(storeItemService.getItemById(id), HttpStatus.OK); }
}

