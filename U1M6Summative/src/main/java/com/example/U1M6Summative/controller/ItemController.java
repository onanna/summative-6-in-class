package com.example.U1M6Summative.controller;

import com.example.U1M6Summative.dto.Item;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {
    @RequestMapping(value = "/item", method = RequestMethod.POST)
    public Item addItem(@RequestBody Item item){

    }

    @RequestMapping(value = "/item{id}", method = RequestMethod.GET)
    public Item getItem(@PathVariable(name = "id") int id) {

    }

    @RequestMapping(value = "/item{id}", method = RequestMethod.PUT)
    public Item updateItem(@PathVariable(name = "id") @RequestBody Item item){

    }

    @RequestMapping(value = "/item{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable(name = "id") int id){
        //do nothing here
    }
    }
}
