package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dima on 27.02.2017.
 */
public class MapResumeStorage extends AbstractStorage<Resume> {

    private Map<String, Resume> map = new HashMap<>();


    @Override
    protected Resume getSearchKey(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected boolean isExist(Resume searchKey) {
        return searchKey != null;
    }

    @Override
    protected void doSave(Resume r, Resume searchKey) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected void doUpdate(Resume r, Resume searchKey) {
        map.put(r.getUuid(), r);
    }


    @Override
    protected void doDelete(Resume searchKey) {
        map.remove(searchKey.getUuid());
    }

    @Override
    protected Resume doGet(Resume searchKey) {
        return searchKey;
    }

    @Override
    protected List<Resume> doCopyAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public int size() {
        return map.size();
    }


}
