package org.example.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileService {

    public void createFileWithAutoName(String fileName) throws IOException {
        File file = new File(fileName);
        if (file.createNewFile()) {
            System.out.println("Файл создан: " + file.getAbsolutePath());
        } else {
            System.out.println("Файл уже существует: " + file.getAbsolutePath());
        }
    }

    public List<String> readFileText(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException(file.getAbsolutePath());
        }
        List<String> lines = new ArrayList<>();
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

    public byte[] readFileBytes(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException(file.getAbsolutePath());
        }
        try (FileInputStream fis = new FileInputStream(file);
             ByteArrayOutputStream bos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int n;
            while ((n = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, n);
            }
            return bos.toByteArray();
        }
    }

    public void update(File file, String newText) throws FileNotFoundException {
        if (fileExists(file)){
            try (FileOutputStream fos = new FileOutputStream(file, false);
                 OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
                 BufferedWriter bw = new BufferedWriter(osw)) {
                bw.write(newText);
                System.out.println("Файл успешно обновлен: " + file.getName());
            } catch (IOException e) {
                System.err.println("Error editing file: " + e.getMessage());
            }
        } else{
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