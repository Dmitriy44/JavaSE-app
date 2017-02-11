package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final int ARRAY_SIZE = 10000;
    private Resume[] storage = new Resume[ARRAY_SIZE];
    private int size = 0;

    private int getIndex(String uuid) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void clear() {
        for (int i = 0; i < size; i++)
            storage[i] = null;
        size = 0;
    }

    public void save(Resume r) {
        if (!(getIndex(r.getUuid()) > -1)) {
            if (size < ARRAY_SIZE) {
                storage[size++] = r;
            } else {
                System.out.println("Storage is full");
            }
        } else {
            System.out.println("Element with uuid = " + r.getUuid() + " contained in storage.");
        }
    }

    public void update(Resume r) {
        if (getIndex(r.getUuid()) > -1) {
            storage[getIndex(r.getUuid())] = r;
        } else {
            System.out.println("Element with uuid = " + r.getUuid() + " is not found.");
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


    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public Resume[] getAll() {
        Resume[] newArray = new Resume[size];
        System.arraycopy(storage, 0, newArray, 0, size);
        return newArray;
    }

    public int size() {
        return size;
    }

}
