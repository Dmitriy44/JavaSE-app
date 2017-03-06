package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.*;

/**
 * Created by Dima on 12.02.2017.
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 100000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    protected abstract void insertElement(Resume r, int index);

    protected abstract void fillDeletedElement(int index);

    protected abstract Integer getSearchKey(String uuid);


    @Override
    protected void doSave(Resume r, Object index) {
        if (size < STORAGE_LIMIT) {
            insertElement(r, (Integer) index);
            size++;
        } else {
            throw new StorageException("Storage is full", r.getUuid());
        }
    }

    @Override
    protected void doUpdate(Resume r, Object index) {
        storage[((Integer) index)] = r;
    }

    @Override
    protected void doDelete(Object index) {
        fillDeletedElement((Integer) index);
        storage[--size] = null;
    }

    @Override
    protected Resume doGet(Object index) {
        return storage[((Integer) index)];
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected boolean isExist(Object index) {
        return ((Integer) index) >= 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<Resume> getAllSorted() {
        Resume[] result = Arrays.copyOfRange(storage, 0, size);
        Arrays.sort(result);
        return Arrays.asList(result);
    }
}
