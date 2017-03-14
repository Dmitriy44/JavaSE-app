package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by Dima on 17.02.2017.
 */
public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    private Storage storage;

    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
        this.storage = storage;
    }

    @Test(expected = StorageException.class)
    public void testSaveOverflowStorage() throws Exception {
        for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
            try {
                storage.save(new Resume("Name" + i));
            } catch (StorageException e) {
                Assert.fail(e.getMessage());
            }
        }
        storage.save(new Resume("Overflow"));
    }

}