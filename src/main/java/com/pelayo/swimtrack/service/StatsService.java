package com.pelayo.swimtrack.service;

import com.pelayo.swimtrack.model.TimeRecord;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class StatsService {
    public Optional<TimeRecord> bestRecordByStyle(List<TimeRecord> records, String style) {
        return records.stream()
                .filter(record -> record.getStyle().equalsIgnoreCase(style))
                .min(Comparator.comparingDouble(TimeRecord::getSeconds));
    }
}
