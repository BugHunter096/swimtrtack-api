package com.pelayo.swimtrack.repository;

import com.pelayo.swimtrack.model.Swimmer;
import com.pelayo.swimtrack.model.TimeRecord;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryDatabase {
    private final List<Swimmer> swimmers = new ArrayList<>();
    private final List<TimeRecord> records = new ArrayList<>();
    private final AtomicLong swimmerSequence = new AtomicLong(1);
    private final AtomicLong recordSequence = new AtomicLong(1);

    public InMemoryDatabase() {
        Swimmer demo = new Swimmer(swimmerSequence.getAndIncrement(), "Demo Nadador", "Junior", "M");
        swimmers.add(demo);
        records.add(new TimeRecord(recordSequence.getAndIncrement(), demo.getId(), "Libre", "Entrenamiento", 64.32, "Dato de ejemplo", LocalDate.now()));
    }

    public List<Swimmer> findAllSwimmers() {
        return List.copyOf(swimmers);
    }

    public Optional<Swimmer> findSwimmerById(Long id) {
        return swimmers.stream()
                .filter(swimmer -> swimmer.getId().equals(id))
                .findFirst();
    }

    public Swimmer saveSwimmer(Swimmer swimmer) {
        swimmer.setId(swimmerSequence.getAndIncrement());
        swimmers.add(swimmer);
        return swimmer;
    }

    public List<TimeRecord> findAllRecords() {
        return List.copyOf(records);
    }

    public List<TimeRecord> findRecordsBySwimmerId(Long swimmerId) {
        return records.stream()
                .filter(record -> record.getSwimmerId().equals(swimmerId))
                .toList();
    }

    public TimeRecord saveRecord(TimeRecord record) {
        record.setId(recordSequence.getAndIncrement());
        records.add(record);
        return record;
    }
}
