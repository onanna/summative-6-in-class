package com.example.U1M6Summative.controller;

import com.example.U1M6Summative.dto.Item;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {
    @PostMapping
    public Item addItem(@RequestBody Item item){
        return item;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Item getItem(@PathVariable(name = "id") int id) {
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Item updateItem(@PathVariable(name = "id") @RequestBody Item item){
        return item;
    }

    @RequestMapping(value = "/item{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable(name = "id") int id){
        //do nothing here
    }
}
