package com.urise.webapp.storage;

/**
 * Created by Dima on 27.02.2017.
 */
public class MapStorageTest extends AbstractStorageTest {
    public MapStorageTest() {
        super(new MapUuidStorage());
    }
}