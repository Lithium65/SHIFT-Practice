package org.example.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileService {
    public List<String> readFileText(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException(file.getAbsolutePath());
        }
        List<String> lines = new ArrayList<String>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new IOException("Error while reading file " + file.getName());
        }
        return lines;
    }

    public void FileEditing(File name, String newText) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        if (fileExists(name)){
            try (FileOutputStream fos = new FileOutputStream(name, false);
                 OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
                 BufferedWriter bw = new BufferedWriter(osw)) {
                bw.write(newText);
            } catch (IOException e) {
                System.err.println("Error editing file: " + e.getMessage());
            }

        }else{
            throw new FileNotFoundException("File not found");
        }
    }

    public void deleteFile(File file) throws IOException {

        if (!file.exists()) {
            throw new FileNotFoundException("File wasn't found: " + file.getName());
        }

        if (!file.isFile()) {
            throw new IllegalArgumentException("The specified path is not a file: " + file.getName());
        }

        boolean deleted = file.delete();
        if (!deleted) {
            throw new IOException("Failed to delete file: " + file.getName());
        } else {
            System.out.println("File was deleted successfully: " + file.getName());
        }
    }

    private boolean fileExists(File file) {
        if (!file.exists()) {
            System.out.println("File wasn't found: " + file.getName());
        }
        return file.exists();
    }
}
