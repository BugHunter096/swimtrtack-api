package com.pelayo.swimtrack.controller;

import com.pelayo.swimtrack.dto.CreateTimeRecordRequest;
import com.pelayo.swimtrack.model.TimeRecord;
import com.pelayo.swimtrack.repository.InMemoryDatabase;
import com.pelayo.swimtrack.service.StatsService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/records")
public class TimeRecordController {
    private final InMemoryDatabase database;
    private final StatsService statsService;

    public TimeRecordController(InMemoryDatabase database, StatsService statsService) {
        this.database = database;
        this.statsService = statsService;
    }

    @GetMapping
    public List<TimeRecord> findAll(@RequestParam(required = false) Long swimmerId) {
        if (swimmerId == null) {
            return database.findAllRecords();
        }
        return database.findRecordsBySwimmerId(swimmerId);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CreateTimeRecordRequest request) {
        boolean swimmerExists = database.findSwimmerById(request.swimmerId()).isPresent();

        if (!swimmerExists) {
            return ResponseEntity.badRequest().body("No existe un nadador con id " + request.swimmerId());
        }

        TimeRecord record = new TimeRecord(
                null,
                request.swimmerId(),
                request.style(),
                request.sessionType(),
                request.seconds(),
                request.notes(),
                LocalDate.now()
        );

        TimeRecord saved = database.saveRecord(record);
        return ResponseEntity
                .created(URI.create("/api/records/" + saved.getId()))
                .body(saved);
    }

    @GetMapping("/best")
    public ResponseEntity<TimeRecord> best(@RequestParam Long swimmerId, @RequestParam String style) {
        List<TimeRecord> records = database.findRecordsBySwimmerId(swimmerId);
        return statsService.bestRecordByStyle(records, style)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
