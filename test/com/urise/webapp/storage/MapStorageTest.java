package com.urise.webapp.storage;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dima on 27.02.2017.
 */
public class MapStorageTest extends AbstractStorageTest {
    public MapStorageTest() {
        super(new MapStorage());
    }
}