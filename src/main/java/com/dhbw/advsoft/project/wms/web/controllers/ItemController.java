package com.dhbw.advsoft.project.wms.web.controllers;

import com.dhbw.advsoft.project.wms.common.Constants;
import com.dhbw.advsoft.project.wms.domain.models.Item;
import com.dhbw.advsoft.project.wms.domain.repositories.ItemRepository;
import com.dhbw.advsoft.project.wms.web.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(Constants.API_VERSIONPATH)
public class ItemController {

    private static final String BASEPATH = "/items";
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping(BASEPATH)
    public List<Item> getAllItems() { return itemRepository.findAll(); }

    @PostMapping(BASEPATH)
    public Item addItem(@RequestBody Item item) { return itemRepository.save(item); }

    @GetMapping(BASEPATH + "/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Item not exist with id: " + id));
        return ResponseEntity.ok(item);
    }

    @PutMapping(BASEPATH + "/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item itemDetails){
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not exist with id: " + id));

        item.setStock(itemDetails.getStock());
        item.setName(itemDetails.getName());
        item.setMinStock(itemDetails.getMinStock());
        item.setPricePerUnit(itemDetails.getPricePerUnit());

        Item updateditem = itemRepository.save(item);
        return ResponseEntity.ok(updateditem);
    }

    @DeleteMapping(BASEPATH + "/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteItem(@PathVariable Long id){
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not exist with id :" + id));

        itemRepository.delete(item);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
