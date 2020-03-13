package com.nightlife.controller;

import com.nightlife.model.Client;
import com.nightlife.repository.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private User user;

    @GetMapping
    public ResponseEntity<List<Client>> listusers() {
        try {
            List<Client> clientList = user.findAll();
            return ResponseEntity.ok().body(clientList);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> listuser(@PathVariable Long id) {
        try {
            Client client = user.findById(id).get();
            return ResponseEntity.ok().body(client);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

}
