package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by Dima on 01.04.2017.
 */
public class Organization {
    private final Link homePage;
    private final String title;
    private final TimeInterval[] intervals;


    public Organization(String name, String url, String title, TimeInterval... intervals) {
        Objects.requireNonNull(title, "title must not be null");
        Objects.requireNonNull(intervals, "intervals must not be null");
        this.homePage = new Link(name, url);
        this.title = title;
        this.intervals = intervals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (!homePage.equals(that.homePage)) return false;
        if (!title.equals(that.title)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(intervals, that.intervals);

    }

    @Override
    public int hashCode() {
        int result = homePage.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + Arrays.hashCode(intervals);
        return result;
    }
}
