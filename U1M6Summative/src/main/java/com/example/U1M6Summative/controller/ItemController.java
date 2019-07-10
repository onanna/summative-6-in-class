package com.example.U1M6Summative.controller;

import com.example.U1M6Summative.dto.Item;
import com.example.U1M6Summative.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ServiceLayer serviceLayer;

    @PostMapping
    public Item addItem(@RequestBody Item item){

        return serviceLayer.saveItem(item);
    }

    @GetMapping
    public List<Item> getAllItems() {
        return serviceLayer.findItems();
    }

    @GetMapping("/{id}")
    public Item getItem(@PathVariable(name = "id") int id) {
        return serviceLayer.findItem(id);
    }

    @PutMapping("/{id}")
    public void updateItem(@PathVariable(name = "id") int id, @RequestBody Item item){

        serviceLayer.updateItem(item);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable(name = "id") int id){
        serviceLayer.removeItem(id);
    }
}
