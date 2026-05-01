package com.pelayo.swimtrack.service;

import com.pelayo.swimtrack.model.TimeRecord;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StatsServiceTest {
    private final StatsService statsService = new StatsService();

    @Test
    void returnsBestRecordByStyle() {
        List<TimeRecord> records = List.of(
                new TimeRecord(1L, 1L, "Libre", "Entrenamiento", 63.20, "", LocalDate.now()),
                new TimeRecord(2L, 1L, "Libre", "Competición", 61.10, "", LocalDate.now()),
                new TimeRecord(3L, 1L, "Espalda", "Competición", 70.00, "", LocalDate.now())
        );

        var best = statsService.bestRecordByStyle(records, "Libre");

        assertTrue(best.isPresent());
        assertEquals(61.10, best.get().getSeconds());
    }
}
