package com.diahne.controller;

import com.diahne.model.Client;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Diahne on 15.06.2018.
 */
@RequestMapping("/api")
@RestController
public class StoreController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String DB_JSON_FILE_PATH = "src\\main\\resources\\db.json";


    /*@RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Client> index() {
        return new Widget("green", 10, 7);
    }*/


    public List<Client> readJsonWithObjectMapper() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Client> clients = Arrays.asList(objectMapper.readValue(new File(DB_JSON_FILE_PATH), Client[].class));
        logger.info("Successfully parsed the input JSON");
        return clients;
    }

}
