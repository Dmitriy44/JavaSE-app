package com.urise.webapp;

import com.urise.webapp.model.Resume;
import com.urise.webapp.model.SectionType;

import java.util.*;

/**
 * Created by Dima on 12.03.2017.
 */
public class TestSingleton {
    private static TestSingleton instance;

    public static TestSingleton getInstance() {
        if (instance == null) {
            instance = new TestSingleton();
        }
        return instance;
    }

    private TestSingleton() {
    }

    public static void main(String[] args) {
        /*TestSingleton.getInstance();
        Singleton instance = Singleton.valueOf("INSTANCE");
        System.out.println(instance.ordinal());
        for (SectionType type : SectionType.values()) {
            System.out.println(type.getTitle());
        }*/
        Resume test = new Resume("");
        test.setPersonal("text");
        System.out.println(test.getPersonal());
        test.setAchievement("ach1", "ach2", "ach3");
        System.out.println(test.getAchievement());
        Map<String, List<String>>data=new HashMap<>();
        List<String>info=new ArrayList<>();
        info.add("sdsd");
        info.add("sdsd");
        data.put("dd",info);
        test.setExperience(new String[]{"Company name","range","info","info"});
        System.out.println(Arrays.toString(test.getExperience()));
    }

    public enum Singleton {
        INSTANCE
    }
}
