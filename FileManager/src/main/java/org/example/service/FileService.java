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
                 OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
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

    public void createFile() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите путь к файлу");
        String path = sc.nextLine().trim();

        System.out.println("Введите содержимое файла: ");
        StringBuilder fileContent = new StringBuilder();

        while (true) {
            String line = sc.nextLine();
            if (line.isEmpty()) {
                break;
            }
            fileContent.append(line).append(System.lineSeparator());
        }

        try {
            createFile(path, fileContent.toString());
        } catch (IOException e) {
            System.err.println("Ошибка при создании файла: " + e.getMessage());
        }
    }

    private void createFile(String path, String fileContent) throws IOException {
        File file = new File(path);

        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }

        if (file.createNewFile()) {
            System.out.println("Файл по пути " + path + " был успешно создан");
            if (!fileContent.isEmpty()) {
                fillFileWithContent(file, fileContent);
            }
        } else {
            System.out.println("Файл уже существует: " + path);
        }
    }

    private void fillFileWithContent(File file, String fileContent) throws IOException {
        Scanner sc = new Scanner(System.in); // Используем System.in вместо File
        System.out.println("Выберите вид записи - побайтовая = 1, посимвольная = 2");

        int choice;
        try {
            choice = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Неверный ввод, используется побайтовая запись по умолчанию");
            choice = 1;
        }

        switch (choice) {
            case 1: {
                fillFileWithBytes(file, fileContent);
                break;
            }
            case 2: {
                fillFileWithChars(file, fileContent);
                break;
            }
            default: {
                System.out.println("Неверный ввод, используется побайтовая запись по умолчанию");
                fillFileWithBytes(file, fileContent);
            }
        }
    }

    private void fillFileWithBytes(File file, String fileContent) throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            byte[] output = fileContent.getBytes();
            outputStream.write(output);
            outputStream.flush();
            System.out.println("Данные записаны побайтово");
        } catch (IOException e) {
            throw new IOException("Ошибка при побайтовой записи: " + e.getMessage(), e);
        }
    }

    private void fillFileWithChars(File file, String fileContent) throws IOException {
        try (OutputStreamWriter outputStream = new OutputStreamWriter(
                new FileOutputStream(file), "UTF-8")) {
            outputStream.write(fileContent);
            outputStream.flush();
            System.out.println("Данные записаны посимвольно");
        } catch (IOException e) {
            throw new IOException("Ошибка при посимвольной записи: " + e.getMessage(), e);
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