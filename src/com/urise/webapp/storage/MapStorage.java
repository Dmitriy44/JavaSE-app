package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Dima on 27.02.2017.
 */
public class MapStorage extends AbstractStorage {

    private Map<String, Resume> storage = new TreeMap<>();

    protected Resume getResumeByUuid(String uuid){
        for (Map.Entry<String, Resume> entry:storage.entrySet()){
            if (entry.getKey().equals(uuid)){
                return entry.getValue();
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
        if (!storage.containsValue(r)) {
            storage.put(r.getUuid(), r);
        }else {
            throw new ExistStorageException(r.getUuid());
        }
    }

    @Override
    public void update(Resume r) {
        Resume updateResume = getResumeByUuid(r.getUuid());
        storage.put(updateResume.getUuid(), r);
    }

    @Override
    public Resume get(String uuid) {
        return getResumeByUuid(uuid);
    }

    @Override
    public void delete(String uuid) {
       storage.remove(uuid, getResumeByUuid(uuid));
    }

    @Override
    public Resume[] getAll() {
        return storage.values().toArray(new Resume[storage.size()]);
    }

    @Override
    public int size() {
        return storage.size();
    }
}
