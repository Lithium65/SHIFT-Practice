package org.example.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DirectoryService {
    public List<String> readDirectory(String path) throws IOException {
        File directory = new File(path);
        if (!directory.exists()) {
            throw new IOException("Directory not found");
        }

        if (!directory.isDirectory()) {
            throw new IOException("Not a directory");
        }

        File[] files = directory.listFiles();
        List<String> result = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                String name = file.getName();
                if (file.isDirectory()) {
                    name += "/";
                }
                result.add(name);
            }
        }
        return result;
    }

    public void deleteDirectory(String path) throws IOException {
        File directory = new File(path);

        if (!directory.exists()) {
            throw new FileNotFoundException("Folder not found: " + path);
        }

        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("The specified path is not a folder: " + path);
        }

        File[] contents = directory.listFiles();

        deleteFiles(contents);

        if (directory.delete()) {
            System.out.println("Folder is deleted: " + path);
        } else {
            throw new IOException("Folder could not be deleted: " + path);
        }
    }

    void deleteFiles(File[] contents) throws IOException {
        if (contents != null) {
            for (File file : contents) {
                if (file.isDirectory()) {
                    deleteDirectory(file.getAbsolutePath());
                } else {
                    if (!file.delete()) {
                        throw new IOException("File could not be deleted: " + file.getName());
                    }
                }
            }
        }
    }
}
