package org.runner;

import org.example.service.DirectoryService;
import org.example.service.FileService;
import org.example.service.FileNameGenerator;
import org.example.service.TimeZoneInitializer;
import java.io.File;
import java.io.IOException;
import java.time.ZoneId;
import java.util.List;
import java.util.Scanner;

public class Runner {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        FileService fileService = new FileService();
        DirectoryService directoryService = new DirectoryService();

        ZoneId zoneId = TimeZoneInitializer.initializeTimeZone();

        while (true) {
            System.out.println("""
                    Выберите опцию:
                    1. Создать файл (имя по таймзоне)
                    2. Записать текст в файл
                    3. Прочитать файл (посимвольно)
                    4. Прочитать файл (побайтно)
                    5. Удалить файл
                    6. Создать папку
                    7. Удалить папку
                    8. Просмотреть содержимое папки
                    9. Выход
                    """);
            System.out.print("Ваш выбор: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод!");
                continue;
            }

            try {
                switch (choice) {
                    case 1 -> {
                        String fileName = FileNameGenerator.generateFileName(zoneId);
                        fileService.createFileWithAutoName(fileName);
                    }
                    case 2 -> {
                        System.out.print("Введите путь к файлу: ");
                        File file = new File(scanner.nextLine().trim());
                        System.out.println("Введите текст (пустая строка = конец):");
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String line = scanner.nextLine();
                            if (line.isEmpty()) break;
                            sb.append(line).append(System.lineSeparator());
                        }
                        fileService.update(file, sb.toString());
                    }
                    case 3 -> {
                        System.out.print("Введите путь к файлу: ");
                        File file = new File(scanner.nextLine().trim());
                        List<String> lines = fileService.readFileText(file);
                        System.out.println("Содержимое файла");
                        lines.forEach(System.out::println);
                    }
                    case 4 -> {
                        System.out.print("Введите путь к файлу: ");
                        File file = new File(scanner.nextLine().trim());
                        byte[] data = fileService.readFileBytes(file);
                        System.out.println("Прочитано " + data.length + " байт");
                        System.out.println(new String(data));
                    }
                    case 5 -> {
                        System.out.print("Введите путь к файлу: ");
                        File file = new File(scanner.nextLine().trim());
                        fileService.deleteFile(file);
                    }
                    case 6 -> {
                        System.out.print("Введите путь к папке: ");
                        String path = scanner.nextLine().trim();
                        directoryService.createDirectory(path);
                    }
                    case 7 -> {
                        System.out.print("Введите путь к папке: ");
                        String path = scanner.nextLine().trim();
                        directoryService.deleteDirectory(path);
                    }
                    case 8 -> {
                        System.out.print("Введите путь к папке: ");
                        String path = scanner.nextLine().trim();
                        List<String> items = directoryService.readDirectory(path);
                        System.out.println("Содержимое папки");
                        items.forEach(System.out::println);
                    }
                    case 9 -> {
                        System.out.println("Выход.");
                        return;
                    }
                    default -> System.out.println("Неверный выбор.");
                }
            } catch (IOException e) {
                System.err.println("Ошибка: " + e.getMessage());
            }
        }
    }
}