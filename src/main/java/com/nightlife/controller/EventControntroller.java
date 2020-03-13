package com.nightlife.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nightlife.model.EventRegistration;
import com.nightlife.repository.EventPlace;
import com.nightlife.repository.Events;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api")
public class EventControntroller {


    @Autowired
    private Events eventrepository;

    @Autowired
    private EventPlace eventPlace;

    @GetMapping("/eventregistration")
    public ResponseEntity<List<EventRegistration>> eventregistrations() {
        try {
            List<EventRegistration> listEvent = new ArrayList<>();
            listEvent = eventrepository.findAll();
            return ResponseEntity.ok().body(listEvent);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/eventregistration")
    public ResponseEntity<EventRegistration> eventregistrationssave(@RequestBody @Valid EventRegistration eventRegistration, UriComponentsBuilder uriBuilder) {
        try {
            eventRegistration.registerEventPlace(eventPlace);
            eventrepository.save(eventRegistration);
            URI uri = uriBuilder.path("{id}").buildAndExpand(eventRegistration.getId()).toUri();
            return ResponseEntity.created(uri).body(eventRegistration);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/eventregistration/{id}")
    public ResponseEntity<EventRegistration> eventRegistrationsid(@PathVariable Long id) {
        try {
            EventRegistration eventRegistration = eventrepository.findById(id).get();
            return ResponseEntity.ok().body(eventRegistration);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/eventregistration/edit/{id}")
    public ResponseEntity<EventRegistration> editeventregistration(@PathVariable Long id, @RequestBody @Valid EventRegistration eventRegistration) {
        try {
            eventRegistration.setId(id);
            eventRegistration.registerEventPlace(eventPlace);
            eventrepository.save(eventRegistration);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/eventregistration/delete/{id}")
    public ResponseEntity<EventRegistration> eventregistrationexclude(@PathVariable Long id) {
        try {
            EventRegistration eventRegistration = eventrepository.findById(id).get();
            eventrepository.delete(eventRegistration);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/eventregistration/eventCapacity/asc")
    public ResponseEntity<List<EventRegistration>> eventregistrationasc() {
        try {
            List<EventRegistration> eventRegistration = eventrepository.findAllByOrderByEventCapacityAsc();
            return ResponseEntity.ok().body(eventRegistration);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/eventregistration/eventCapacity/desc")
    public ResponseEntity<List<EventRegistration>> eventregistrationdesc() {
        try {
            List<EventRegistration> eventRegistration = eventrepository.findAllByOrderByEventCapacityDesc();
            return ResponseEntity.ok().body(eventRegistration);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/eventregistration/eventDate/desc")
    public ResponseEntity<List<EventRegistration>> eventregistrationeventdatedesc() {
        try {
            List<EventRegistration> eventRegistration = eventrepository.findAllByOrderByEventDateDesc();
            return ResponseEntity.ok().body(eventRegistration);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/eventregistration/eventDate/asc")
    public ResponseEntity<List<EventRegistration>> eventregistrationeventdateasc() {
        try {
            List<EventRegistration> eventRegistration = eventrepository.findAllByOrderByEventDateAsc();
            return ResponseEntity.ok().body(eventRegistration);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/eventregistration/eventName/desc")
    public ResponseEntity<List<EventRegistration>> eventregistrationeventnamedesc() {
        try {
            List<EventRegistration> eventRegistration = eventrepository.findAllByOrderByEventNameDesc();
            return ResponseEntity.ok().body(eventRegistration);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/eventregistration/eventName/asc")
    public ResponseEntity<List<EventRegistration>> eventregistrationeventnameasc() {
        try {
            List<EventRegistration> eventRegistration = eventrepository.findAllByOrderByEventNameAsc();
            return ResponseEntity.ok().body(eventRegistration);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/eventregistration/price/desc")
    public ResponseEntity<List<EventRegistration>> eventregistrationpricedesc() {
        try {
            List<EventRegistration> eventRegistration = eventrepository.findAllByOrderByPriceDesc();
            return ResponseEntity.ok().body(eventRegistration);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/eventregistration/price/asc")
    public ResponseEntity<List<EventRegistration>> eventregistrationpriceasc() {
        try {
            List<EventRegistration> eventRegistration = eventrepository.findAllByOrderByPriceAsc();
            return ResponseEntity.ok().body(eventRegistration);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
