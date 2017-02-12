package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    protected int getIndex(String uuid) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                index = i;
                break;
            }
        }
        return index;
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



    /**
     * @return array, contains only Resumes in storage (without null)
     */


}
