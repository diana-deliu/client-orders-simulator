package com.diahne.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by Diahne on 15.06.2018.
 */
@Data
public class Client {
    private int clientId;
    private String clientName;
    private Date dateOfBirth;
    private List<Product> products;
}
