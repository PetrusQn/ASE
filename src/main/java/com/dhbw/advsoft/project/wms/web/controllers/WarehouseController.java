package com.dhbw.advsoft.project.wms.web.controllers;

import com.dhbw.advsoft.project.wms.common.Constants;
import com.dhbw.advsoft.project.wms.domain.models.Product;
import com.dhbw.advsoft.project.wms.domain.models.Warehouse;
import com.dhbw.advsoft.project.wms.domain.repositories.WarehouseRepository;
import com.dhbw.advsoft.project.wms.web.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(Constants.API_VERSIONPATH)
public class WarehouseController {

    private static final String BASEPATH = "/warehouses";
    @Autowired
    private WarehouseRepository warehouseRepository;

    @GetMapping(BASEPATH)
    public List<Warehouse> getAllWarehouses() { return warehouseRepository.findAll(); }

    @PostMapping(BASEPATH)
    public Warehouse createWarehouse(@RequestBody Warehouse warehouse) { return warehouseRepository.save(warehouse); }

    @GetMapping(BASEPATH + "/{id}")
    public ResponseEntity<Warehouse> getWarehouseById(@PathVariable Long id) {
        Warehouse warehouse = warehouseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Warehouse not exist with id: " + id));
        return ResponseEntity.ok(warehouse);
    }

    @PutMapping(BASEPATH + "/{id}")
    public ResponseEntity<Warehouse> updateWarehouse(@PathVariable Long id, @RequestBody Warehouse warehouseDetails){
        Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Warehouse not exist with id: " + id));

        warehouse.setName(warehouseDetails.getName());

        Warehouse updatedWarehouse = warehouseRepository.save(warehouse);
        return ResponseEntity.ok(updatedWarehouse);
    }

    @DeleteMapping(BASEPATH + "/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteWarehouse(@PathVariable Long id){
        Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Warehouse not exist with id :" + id));

        warehouseRepository.delete(warehouse);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
