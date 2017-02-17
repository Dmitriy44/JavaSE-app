package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Dima on 17.02.2017.
 */
public abstract class AbstractArrayStorageTest {
    private Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void testClear() throws Exception {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void testUpdate() throws Exception {
         Resume testResume = storage.get("uuid1");
         storage.update(new Resume("uuid1"));
         Assert.assertFalse(testResume == storage.get("uuid1"));
    }

    @Test
    public void testSave() throws Exception {
        int testStorageSize = storage.size();
        storage.save(new Resume("uuid4"));
        Assert.assertEquals(testStorageSize + 1, storage.size());
        storage.get("uuid4");
    }

    @Test
    public void testDelete() throws Exception {
        storage.delete("uuid1");
        storage.delete("uuid2");
        storage.delete("uuid3");
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void testGet() throws Exception {
        storage.get("uuid1");
        storage.get("uuid2");
        storage.get("uuid3");
    }


    @Test
    public void testSize() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void testGetAll() throws Exception {
        Resume[] testStorage = storage.getAll();
        Assert.assertEquals(3, testStorage.length);
        for (Resume resume : testStorage) {
            storage.delete(resume.getUuid());
        }
        Assert.assertEquals(0, storage.size());
    }

    //TODO : special tests
    @Test(expected = NotExistStorageException.class)
    public void testGetNotExist() throws Exception {
        storage.get("uuid4");
    }

    @Test(expected = ExistStorageException.class)
    public void testGetExist() throws Exception {
        storage.save(new Resume("uuid1"));
    }

    @Test
    public void testIsFullStorage() throws Exception {
        for (int i=0;true; i++) {
            try {
                storage.save(new Resume(String.valueOf(i)));
            }catch (StorageException e){
                Assert.assertEquals("Storage is full",e.getMessage());
                break;
            }
        }
    }

}