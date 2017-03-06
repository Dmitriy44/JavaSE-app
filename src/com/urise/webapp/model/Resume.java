package com.urise.webapp.model;

import java.util.UUID;

/**
 * com.urise.webapp.model.Resume class
 */
public class Resume implements Comparable<Resume> {

    // Unique identifier
    private final String uuid;

    private  String fullName;


    public Resume() {
        this(UUID.randomUUID().toString());
    }

    public Resume(String uuid) {
        this.uuid = uuid;
    }
    
    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        return uuid.equals(resume.uuid);

    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public String toString() {
        return uuid;
    }


    public String getUuid() {
        return uuid;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public int compareTo(Resume o) {
        return uuid.compareTo(o.getUuid());
    }
}
