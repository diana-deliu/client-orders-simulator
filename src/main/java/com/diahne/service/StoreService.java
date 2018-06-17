package com.diahne.service;

import com.diahne.model.Order;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Diahne on 15.06.2018.
 */
@Service
public class StoreService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String DB_JSON_FILE_PATH = "src\\main\\resources\\db.json";
    private List<Order> orders;

    @PostConstruct
    private void init() {
        try {
            logger.info("Starting initialization...");
            orders = readJsonWithObjectMapper();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public List<Order> readJsonWithObjectMapper() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Order> orders = objectMapper.readValue(new File(DB_JSON_FILE_PATH), new TypeReference<List<Order>>() {
        });
        return orders;
    }

    public List<Order> getOrders() {
        logger.debug("Retrieving all orders...");
        return orders;
    }

    public boolean deleteOrder(int clientId) {
        logger.debug("Order with clientId: " + clientId + " is marked for deletion");
        return orders.removeIf((Order order) -> order.getClientId() == clientId);
    }

    public boolean addOrder(Order order) {
        if (!orders.contains(order)) {
            logger.debug("Your order will be added!");
            return orders.add(order);
        }
        logger.error("The same order already exists!");
        return false;
    }

}
