package com.nightlife.controller;

import com.nightlife.repository.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nightlife.model.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sales")
public class HistoricController {
    @Autowired
    private Ticket ticket;

    @GetMapping
    public ResponseEntity<List<Historic>> listusers() {
        try {
            List<Historic> historics = ticket.findAll();
            return ResponseEntity.ok().body(historics);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping("{id}")
    public ResponseEntity<Historic> userhistoric(@PathVariable Long id) {
        try {
            Historic historic = ticket.findById(id).get();
            return ResponseEntity.ok().body(historic);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
