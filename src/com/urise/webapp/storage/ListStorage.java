package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dima on 27.02.2017.
 */
public class ListStorage extends AbstractStorage {

    protected List<Resume> storage = new LinkedList<>();



    protected Resume getResumeByUuid(String uuid){
        for (Resume r: storage){
            if (r.getUuid().equals(uuid)){
                return r;
            }
        }
        throw new NotExistStorageException(uuid);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public void save(Resume r) {
        if (!storage.contains(r)) {
            storage.add(r);
        }else {
            throw new ExistStorageException(r.getUuid());
        }
    }

    @Override
    public void update(Resume r) {
       Resume updateResume = getResumeByUuid(r.getUuid());
       storage.add(storage.indexOf(updateResume), r);
    }

    @Override
    public Resume get(String uuid) {
       return getResumeByUuid(uuid);
    }

    @Override
    public void delete(String uuid) {
        storage.remove(getResumeByUuid(uuid));
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[storage.size()]);
    }

    @Override
    public int size() {
        return storage.size();
    }
}
