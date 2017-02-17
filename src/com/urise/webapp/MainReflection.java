package com.urise.webapp;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.ArrayStorage;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Dima on 16.02.2017.
 */
public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume resume = new Resume();
        Field field = resume.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(resume));
        field.set(resume, "new_uuid");

       /* ArrayStorage storage =new ArrayStorage();
        Field field1 = storage.getClass().getDeclaredFields()[0];*/
        //TODO : invoke r.toString() via reflection
        //TODO : using a loop
        for (Method m:resume.getClass().getMethods()){
            String methodName=m.getName();
            if (methodName.equals("toString"))
            System.out.println(m.invoke(resume, new Object[]{}));
        }
        //TODO : using getMethod(String name)
        System.out.println(resume.getClass().getMethod("toString").invoke(resume));

        System.out.println(resume);
    }
}
