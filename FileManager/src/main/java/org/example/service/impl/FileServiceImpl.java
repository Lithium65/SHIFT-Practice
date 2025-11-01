package org.example.service.impl;

import org.example.exception.FileManagerException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @ClassName FileService
 * @Description TODO
 * @Author dshparko
 * @Date 30.10.2025 19:24
 * @Version 1.0
 */
public class FileServiceImpl {

    public void deleteFile(File file) throws IOException {

        if (!file.exists()) {
            throw new FileManagerException("File wasn't found: " + file.getName());
        }

        if (!file.isFile()) {
            throw new FileManagerException("The specified path is not a file: " + file.getName());
        }

        boolean deleted = file.delete();
        if (!deleted) {
            throw new FileManagerException("Failed to delete file: " + file.getName());
        } else {
            System.out.println("File was deleted successfully: " + file.getName());
        }
    }

}
