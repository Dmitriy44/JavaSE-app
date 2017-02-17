package com.urise.webapp.exception;

/**
 * Created by Dima on 15.02.2017.
 */
public class NotExistStorageException extends StorageException {
    public NotExistStorageException(String uuid) {
        super("Resume " + uuid + " not exist", uuid);
    }
}
