package com.example.U1M6Summative.controller;

import com.example.U1M6Summative.dto.Item;
import com.example.U1M6Summative.viewmodel.ItemViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {


    @PostMapping
    public ItemViewModel addItem(@RequestBody ItemViewModel item){
        return item;
    }

    @GetMapping("/{id}")
    public ItemViewModel getItem(@PathVariable(name = "id") int id) {
        return null;
    }

    @PutMapping("/{id}")
    public ItemViewModel updateItem(@PathVariable(name = "id") @RequestBody ItemViewModel item){
        return item;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable(name = "id") int id){
        //do nothing here
    }
}
