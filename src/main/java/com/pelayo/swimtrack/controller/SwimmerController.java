package com.pelayo.swimtrack.controller;

import com.pelayo.swimtrack.dto.CreateSwimmerRequest;
import com.pelayo.swimtrack.model.Swimmer;
import com.pelayo.swimtrack.repository.InMemoryDatabase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/swimmers")
public class SwimmerController {
    private final InMemoryDatabase database;

    public SwimmerController(InMemoryDatabase database) {
        this.database = database;
    }

    @GetMapping
    public List<Swimmer> findAll() {
        return database.findAllSwimmers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Swimmer> findById(@PathVariable Long id) {
        return database.findSwimmerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Swimmer> create(@Valid @RequestBody CreateSwimmerRequest request) {
        Swimmer swimmer = new Swimmer(null, request.name(), request.category(), request.sex());
        Swimmer saved = database.saveSwimmer(swimmer);
        return ResponseEntity
                .created(URI.create("/api/swimmers/" + saved.getId()))
                .body(saved);
    }
}
