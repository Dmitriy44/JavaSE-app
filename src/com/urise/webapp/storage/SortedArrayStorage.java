package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Created by Dima on 12.02.2017.
 */
public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    public void save(Resume r) {
        if (!(getIndex(r.getUuid()) > -1)) {
            if (size < ARRAY_SIZE) {
                storage[size++] = r;
                Arrays.sort(storage,0,size);
            } else {
                System.out.println("Storage is full");
            }
        } else {
            System.out.println("Element with uuid = " + r.getUuid() + " contained in storage.");
        }
    }


}
