package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected Integer getSearchKey(String uuid) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                index = i;
                break;
            }
        }
        return index;
    }


    @Override
    protected void insertElement(Resume r, int index) {
        storage[size]=r;
    }

    @Override
    protected void fillDeletedElement(int index) {
        storage[index]=storage[size-1];
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */


}
