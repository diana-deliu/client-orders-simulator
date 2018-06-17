package com.diahne.controller;

import com.diahne.model.Order;
import com.diahne.service.StoreService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Diahne on 15.06.2018.
 */
@RequestMapping("/orders")
@RestController
public class StoreController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StoreService storeService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Order> getOrders() {
        return storeService.getOrders();
    }

    @RequestMapping(value = "/{clientId}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public boolean deleteOrder(@PathVariable int clientId) {
        return storeService.deleteOrder(clientId);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
    public boolean addOrder(@RequestBody Order order) {
        return storeService.addOrder(order);
    }
}
