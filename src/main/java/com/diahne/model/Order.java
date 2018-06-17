package com.diahne.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by Diahne on 15.06.2018.
 */
@Data
public class Order {
    private int clientId;
    private List<Product> products;

    public Order(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return clientId != order.clientId ? false : true;
    }

    @Override
    public int hashCode() {
        int result = clientId;
        result = 31 * result + (products != null ? products.hashCode() : 0);
        return result;
    }
}
