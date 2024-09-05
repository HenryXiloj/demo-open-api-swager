package com.henry.openapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.henry.openapi.controller.ItemsApiDelegate;
import com.henry.openapi.model.Item;

@Service
public class ItemsServiceImpl implements ItemsApiDelegate{

	 // Mock in-memory database
    private final List<Item> items = new ArrayList<>();
    private Long currentId = 1L;

    public ItemsServiceImpl() {
        // Initialize with some mock data
    	var it1 = new Item();
    	it1.setId(1L);
    	it1.setName("Item 1");
        items.add(it1);
        
        var it2 = new Item();
        it2.setId(2L);
        it2.setName("Item 2");
        items.add(it2);
    }

    @Override
    public ResponseEntity<List<Item>> getAllItems() {
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Item> getItemById(Long id) {
        Optional<Item> item = items.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst();
        return item.map(i -> new ResponseEntity<>(i, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<Item> createItem(Item item) {
        item.setId(currentId++); // Simulate auto-increment ID
        items.add(item);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Item> updateItemById(Long id, Item item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                item.setId(id); // Keep the same ID
                items.set(i, item);
                return new ResponseEntity<>(item, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Void> deleteItemById(Long id) {
        boolean removed = items.removeIf(i -> i.getId().equals(id));
        if (removed) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
