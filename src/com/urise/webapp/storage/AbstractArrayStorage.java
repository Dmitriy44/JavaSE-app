package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Created by Dima on 12.02.2017.
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 100000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    protected abstract int getIndex(String uuid);

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            storage[index] = r;
        } else {
            throw new NotExistStorageException(r.getUuid());
        }
    }


    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index < 0) {
            if (size < STORAGE_LIMIT) {
                insertElement(r, index);
                size++;
            } else {
                throw new StorageException("Storage is full", r.getUuid());
            }
        } else {
            throw new ExistStorageException(r.getUuid());
        }
    }

    protected abstract void insertElement(Resume r, int index);


    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            fillDeletedElement(index);
            storage[--size] = null;
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    protected abstract void fillDeletedElement(int index);

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (getIndex(uuid) >= 0) {
            return storage[index];
        }
        throw new NotExistStorageException(uuid);
    }

    public int size() {
        return size;
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }
}
