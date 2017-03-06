package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

/**
 * Created by Dima on 27.02.2017.
 */
public class MapUuidStorage extends AbstractStorage {

    private Map<String, Resume> map = new HashMap<>();


    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return map.containsKey(searchKey.toString());
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        map.put(r.getUuid(), r);
    }


    @Override
    protected void doDelete(Object searchKey) {
        map.remove(searchKey.toString());
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return map.get(searchKey.toString());
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume>result=new LinkedList<>();
        for (Map.Entry<String, Resume> entry:map.entrySet()){
            result.add(entry.getValue());
        }
        Collections.sort(result);
        return result;
    }


    @Override
    public int size() {
        return map.size();
    }
}
