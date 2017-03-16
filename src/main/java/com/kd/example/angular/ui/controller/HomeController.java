package com.kd.example.angular.ui.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.kd.example.angular.ui.model.UserInfo;

@RestController
public class HomeController {
    private ObjectMapper MAPPER = new ObjectMapper();

    @RequestMapping(value = { "/home" })
    public ObjectNode home() throws IOException {
        ObjectNode objectNode = MAPPER.createObjectNode();
        ObjectNode response = MAPPER.createObjectNode();
        objectNode.put("msg", "Hello this is from home controller");
        response.set("data", objectNode);
        return objectNode;
    }

    @RequestMapping(value = { "/create" }, method = RequestMethod.POST)
    public ResponseEntity<ObjectNode> createResource(@RequestBody UserInfo userInfo, UriComponentsBuilder ucBuilder) {
        ObjectNode objectNode = MAPPER.createObjectNode();
        objectNode.put("msg", "user created");
        return new ResponseEntity<ObjectNode>(objectNode, HttpStatus.CREATED);
    }
}
