package com.urise.webapp;

import com.urise.webapp.model.Organization;

import java.io.File;

/**
 * Created by Dima on 20.04.2017.
 */
public class MainFile {
    public static void main(String[] args) {
        /*String filePath = "./.gitignore";
        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }
        File dir = new File("./src/com/urise/webapp");
        System.out.println(dir.isDirectory());
        String[] dirList = dir.list();
        if (dirList != null) {
            for (String name : dir.list()) {
                System.out.println(name);
            }
        }

        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        new MainFile().recursionFiles(new File("./"));
    }

    private void recursionFiles(File file) {
        System.out.println(file.getName());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    recursionFiles(f);
                }
            }
        }
    }
}
