package com.urise.webapp.model;

import java.time.LocalDate;

/**
 * Created by Dima on 25.04.2017.
 */
public class TimeInterval {
    private final LocalDate startTime;
    private final LocalDate endTime;
    private final String description;

    public TimeInterval(LocalDate startTime, LocalDate endTime, String description) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }
}
