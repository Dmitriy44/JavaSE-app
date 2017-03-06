package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Collection;
import java.util.List;

/**
 * Created by Dima on 12.02.2017.
 */
public interface Storage {
    void clear();

    void save(Resume r);

    void update(Resume r);

    Resume get(String uuid);

    void delete(String uuid);


    /**
     * @return array, contains only Resumes in storage (without null)
     */

    List<Resume> getAllSorted();

    int size();
}
