package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

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

    Resume[] getAll();

    int size();
}
