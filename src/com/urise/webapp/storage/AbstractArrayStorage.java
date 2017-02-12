package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Created by Dima on 12.02.2017.
 */
public abstract class AbstractArrayStorage implements Storage {
    protected final int ARRAY_SIZE = 100000;
    protected Resume[] storage = new Resume[ARRAY_SIZE];
    protected int size = 0;

    protected abstract int getIndex(String uuid);

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        if (getIndex(r.getUuid()) > -1) {
            storage[getIndex(r.getUuid())] = r;
        } else {
            System.out.println("Element with uuid = " + r.getUuid() + " is not found.");
        }
    }

    public void delete(String uuid) {
        if (getIndex(uuid) > -1) {
            int index = getIndex(uuid);
            int numMoved = size - index - 1;
            if (numMoved > 0)
                System.arraycopy(storage, index + 1, storage, index, numMoved);
            storage[--size] = null;
        } else {
            System.out.println("Element with uuid = " + uuid + " is not found.");
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (getIndex(uuid) > -1) {
            return storage[index];
        }
        System.out.println("Element with uuid = " + uuid + " is not found.");
        return null;
    }
    public int size() {
        return size;
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }
}
