package com.nightlife.controller;

import com.nightlife.model.RegisterEventPlace;
import com.nightlife.repository.EventPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PlaceRegistrationController {

    @Autowired
    private EventPlace eventPlace;

    @GetMapping
    public ResponseEntity<List<RegisterEventPlace>> eventplacelist() {
        try {
            List<RegisterEventPlace> placesRegistration = eventPlace.findAll();
            return ResponseEntity.ok().body(placesRegistration);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/eventPlace/{id}")
    public ResponseEntity<RegisterEventPlace> eventplaceid(@PathVariable Long id) {
        try {
            RegisterEventPlace placeRegistration = eventPlace.findById(id).get();
            return ResponseEntity.ok().body(placeRegistration);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/eventPlace/nome/{name}")
    public ResponseEntity<RegisterEventPlace> eventplacename(@PathVariable String name) {
        try {
            RegisterEventPlace eventPlaceName = eventPlace.findByPartyPlaceIgnoreCase(name);
            if (eventPlaceName != null) {
                return ResponseEntity.ok().body(eventPlaceName);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/eventPlace/asc")
    public ResponseEntity<List<RegisterEventPlace>> eventplaceasc() {
        try {
            List<RegisterEventPlace> registerEventPlaces = eventPlace.findAllByOrderByPartyPlaceAsc();
            return ResponseEntity.ok().body(registerEventPlaces);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/eventPlace/desc")
    public ResponseEntity<List<RegisterEventPlace>> eventplacedesc() {
        try {
            List<RegisterEventPlace> registerEventPlaceList = eventPlace.findAllByOrderByPartyPlaceDesc();
            return ResponseEntity.ok().body(registerEventPlaceList);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/eventPlace")
    public ResponseEntity<RegisterEventPlace> eventplacesave(@RequestBody @Valid RegisterEventPlace registerEventPlace, UriComponentsBuilder uriBuilder) {
        try {
            eventPlace.save(registerEventPlace);
            URI uri = uriBuilder.path("{id}").buildAndExpand(registerEventPlace.getId()).toUri();
            return ResponseEntity.created(uri).body(registerEventPlace);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/eventPlace/edit/{id}")
    public ResponseEntity<RegisterEventPlace> eventplaceupdate(@PathVariable Long id, @RequestBody @Valid RegisterEventPlace registerEventPlace) {
        try {
            registerEventPlace.setId(id);
            eventPlace.save(registerEventPlace);
            return ResponseEntity.ok().body(registerEventPlace);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/eventPlace/delete/{id}")
    public ResponseEntity<?> eventplacedelete(@PathVariable Long id) {
        try {
            RegisterEventPlace registerEventPlace = eventPlace.findById(id).get();
            eventPlace.delete(registerEventPlace);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }
}
