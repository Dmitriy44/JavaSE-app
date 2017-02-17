package com.urise.webapp.exception;

/**
 * Created by Dima on 15.02.2017.
 */
public class ExistStorageException extends StorageException {
    public ExistStorageException(String uuid) {
        super("Resume " + uuid + " already exist",uuid);
    }
}
