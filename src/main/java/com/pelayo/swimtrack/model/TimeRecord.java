package com.pelayo.swimtrack.model;

import java.time.LocalDate;

public class TimeRecord {
    private Long id;
    private Long swimmerId;
    private String style;
    private String sessionType;
    private double seconds;
    private String notes;
    private LocalDate date;

    public TimeRecord() {
    }

    public TimeRecord(Long id, Long swimmerId, String style, String sessionType, double seconds, String notes, LocalDate date) {
        this.id = id;
        this.swimmerId = swimmerId;
        this.style = style;
        this.sessionType = sessionType;
        this.seconds = seconds;
        this.notes = notes;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public Long getSwimmerId() {
        return swimmerId;
    }

    public String getStyle() {
        return style;
    }

    public String getSessionType() {
        return sessionType;
    }

    public double getSeconds() {
        return seconds;
    }

    public String getNotes() {
        return notes;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSwimmerId(Long swimmerId) {
        this.swimmerId = swimmerId;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setSessionType(String sessionType) {
        this.sessionType = sessionType;
    }

    public void setSeconds(double seconds) {
        this.seconds = seconds;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
