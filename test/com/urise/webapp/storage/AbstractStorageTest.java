package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Dima on 27.02.2017.
 */
public class AbstractStorageTest {
    private Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String NAME_1 = "name1";
    private static final Resume RESUME_1 = new Resume(UUID_1, NAME_1);

    private static final String UUID_2 = "uuid2";
    private static final String NAME_2 = "name2";
    private static final Resume RESUME_2 = new Resume(UUID_2, NAME_2);

    private static final String UUID_3 = "uuid3";
    private static final String NAME_3 = "name3";
    private static final Resume RESUME_3 = new Resume(UUID_3, NAME_3);

    private static final String UUID_4 = "uuid4";
    private static final String NAME_4 = "name4";
    private static final Resume RESUME_4 = new Resume(UUID_4, NAME_4);

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    private void assertSize(int size){
        assertEquals(storage.size(), size);
    }

    private void assertGet(Resume resume){
        assertEquals(storage.get(resume.getUuid()),resume);
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void testClear() throws Exception {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void testUpdate() throws Exception {
        Resume testResume = storage.get(UUID_1);
        storage.update(new Resume(UUID_1));
        assertFalse(testResume == storage.get(UUID_1));
    }

    @Test
    public void testSave() throws Exception {
  /*      Resume[]testArrayResume=new Resume[]{new Resume("uuid1"),new Resume("uuid2"), new Resume("uuid3"), new Resume("uuid4")};
        storage.save(RESUME_4);
        Assert.assertArrayEquals(testArrayResume, storage.getAll());*/
        storage.save(RESUME_4);
        assertSize(4);
        assertGet(RESUME_4);
    }

    @Test(expected = NotExistStorageException.class)
    public void testDelete() throws Exception {
        /*Resume[]testArrayResume=new Resume[]{new Resume("uuid1"),new Resume("uuid2")};
        storage.delete("uuid3");
        assertArrayEquals(testArrayResume, storage.getAll());*/
        storage.delete(UUID_3);
        assertSize(2);
        storage.get(UUID_3);
    }

    @Test
    public void testGet() throws Exception {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }


    @Test
    public void testSize() throws Exception {
        assertSize(3);
    }

    @Test
    public void testGetAllSorted() throws Exception {
        List<Resume> testStorage = storage.getAllSorted();
        assertEquals(3, testStorage.size());
        assertEquals(RESUME_1, testStorage.get(0));
        assertEquals(RESUME_2, testStorage.get(1));
        assertEquals(RESUME_3, testStorage.get(2));
    }

    //TODO : special tests
    @Test(expected = NotExistStorageException.class)
    public void testGetNotExist() throws Exception {
        storage.get(UUID_4);
    }

    @Test(expected = NotExistStorageException.class)
    public void testDeleteNotExist() throws Exception {
        storage.get(UUID_4);
    }

    @Test(expected = NotExistStorageException.class)
    public void testUpdateNotExist() throws Exception {
        storage.update(RESUME_4);
    }

    @Test(expected = ExistStorageException.class)
    public void testSaveExist() throws Exception {
        storage.save(RESUME_3);
    }
}