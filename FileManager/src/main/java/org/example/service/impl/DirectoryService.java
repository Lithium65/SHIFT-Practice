package org.example.service.impl;

import org.example.exception.FileManagerException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class DirectoryService {

    public void deleteDirectory(String path) throws IOException {
        File directory = new File(path);

        if (!directory.exists()) {
            throw new FileManagerException("Folder not found: " + path);
        }

        if (!directory.isDirectory()) {
            throw new FileManagerException("The specified path is not a folder: " + path);
        }

        File[] contents = directory.listFiles();

        deleteFiles(contents);

        if (directory.delete()) {
            System.out.println("Folder is deleted: " + path);
        } else {
            throw new FileManagerException("Folder could not be deleted: " + path);
        }
    }

    void deleteFiles(File[] contents) throws IOException {
        if (contents != null) {
            for (File file : contents) {
                if (file.isDirectory()) {
                    deleteDirectory(file.getAbsolutePath());
                } else {
                    if (!file.delete()) {
                        throw new FileManagerException("File could not be deleted: " + file.getName());
                    }
                }
            }
        }
    }

}
