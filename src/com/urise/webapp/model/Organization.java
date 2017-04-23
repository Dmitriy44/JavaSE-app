package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * Created by Dima on 01.04.2017.
 */
public class Organization {
    private final Link homePage;
    private final LocalDate startTime;
    private final LocalDate endTime;
    private final String title;
    private final String description;

    public Organization(String name, String url, LocalDate startTime, LocalDate endTime, String title, String description) {
        Objects.requireNonNull(startTime, "startTime must not be null");
        Objects.requireNonNull(endTime, "endTime must not be null");
        Objects.requireNonNull(title, "title must not be null");
        this.homePage = new Link(name, url);
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (!homePage.equals(that.homePage)) return false;
        if (!startTime.equals(that.startTime)) return false;
        if (!endTime.equals(that.endTime)) return false;
        if (!title.equals(that.title)) return false;
        return !(description != null ? !description.equals(that.description) : that.description != null);

    }

    @Override
    public int hashCode() {
        int result = homePage.hashCode();
        result = 31 * result + startTime.hashCode();
        result = 31 * result + endTime.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "homePage=" + homePage +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
