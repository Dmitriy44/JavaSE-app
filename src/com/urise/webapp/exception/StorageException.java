package com.urise.webapp.exception;

/**
 * Created by Dima on 15.02.2017.
 */
public class StorageException extends RuntimeException {
    private final String uuid;


    public StorageException(String message, String uuid) {
        super(message);
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }
}
