package com.asd.andreyuk.lab1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is a class that contains all frequently used methods
 */
public class Utils {
    /**
     * Class constructor
     */
    public Utils() {
    }

    /**
     * Read one integer from {@code taskname} input file
     *
     * @param taskname name of a task in format {@code "labN/taskN"}
     * @return integer value read from file.
     */
    public int readIntFromFile(String taskname) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("txt/" + taskname + "/input.txt");
        if (inputStream != null) {
            Scanner scanner = new Scanner(inputStream);
            return scanner.nextInt();
        } else {
            System.out.println("File not found");
            return Integer.MIN_VALUE;   // мб можно ловить исключение
        }
    }

    /**
     * Read array (of known length) of integers from {@code taskname} input file
     *
     * @param taskname name of a task in format {@code "labN/taskN"}
     * @return integer value read from file.
     */
    public int[] readIntArrayFromFile(String taskname) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("txt/" + taskname + "/input.txt");

        if (inputStream != null) {
            Scanner scanner = new Scanner(inputStream);
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

            return array;
        } else {
            System.out.println("File not found");
            return null;
        }
    }

    /**
     * Write one integer {@code value} to the output file
     *
     * @param taskname name of a task in format {@code "labN/taskN"}
     * @param value    value to be written in file
     */
    public void writeIntToFile(String taskname, int value) {
        String dirPath = "classes/txt/" + taskname;
        File directory = new File(dirPath);
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Directory created successfully.");
            } else {
                System.err.println("Failed to create directory.");
                return;
            }
        }


        try (FileWriter writer = new FileWriter(dirPath + "/output.txt")) {
            writer.write(String.valueOf(value));
            writer.close();
            System.out.println("File written successfully. Check " + dirPath + "/output.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    /**
     * Write multiple integers as an array in output file spicified by {@code taskname}
     *
     * @param taskName   name of a task in format {@code "labN/taskN"}
     * @param arrayOfInt array to be written to a file
     */
    public void writeIntegersArrayToFile(String taskName, int[] arrayOfInt) {
        String dirPath = "classes/txt/" + taskName;
        File directory = new File(dirPath);
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Directory created successfully.");
            } else {
                System.err.println("Failed to create directory.");
                return;
            }
        }

        try (FileWriter writer = new FileWriter(dirPath + "/output.txt")) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < arrayOfInt.length; i++) {
                stringBuilder.append(arrayOfInt[i]);
                if (i < arrayOfInt.length - 1) {
                    stringBuilder.append(" ");
                }
            }

            writer.write(stringBuilder.toString());
            System.out.println("File written successfully. Check " + dirPath + "/output.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    private long startTime;
    private long startMemory;

    /**
     * Performance measurement function. Starts counting memory and time used by a program
     */
    public void startMeasuring() {
        startTime = System.nanoTime();
        startMemory = getUsedMemory();
    }

    /**
     * Performance measurement function. Measures and outputs to console time and memory that program took up
     */
    public void stopMeasuring() {
        long endTime = System.nanoTime();
        long endMemory = getUsedMemory();

        long duration = (endTime - startTime);
        long memoryUsed = endMemory - startMemory;

        System.out.println("Time taken: " + duration / Math.pow(10, 9) + " seconds");
        System.out.println("Memory used: " + (float) memoryUsed / (1024 * 1024) + " megabytes");
    }

    /**
     * Uses Runtime instance to measure memory heap
     *
     * @return memory heap size acquired by JVM
     */
    private long getUsedMemory() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }

    /**
     * Специальная функция для задания 4. Так как входные данные организованы в отличном от стандартного порядке, нам
     * необходима другая функция. Последний элемент возвращаемого массива - значение из второй строчки считываемого
     * файла, которое по заданию надо найти в массиве
     *
     * @param taskname название задачи
     * @return массив, последний элемент которого - искомое значение
     */
    public int[] readIntArrayFromFileT4(String taskname) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("txt/" + taskname + "/input.txt");

        if (inputStream != null) {
            Scanner scanner = new Scanner(inputStream);
            ArrayList<Integer> array = new ArrayList<>();
            String[] firstLine = scanner.nextLine().split(" ");
            for (String element : firstLine) {
                array.add(Integer.parseInt(element));
            }

            array.add(scanner.nextInt());   // что мы ищем?

            // приводим к нормальному виду, в конце этого массива будет элемент, который мы ищем
            int[] arrayOfInt = new int[array.size()];
            for (int i = 0; i < array.size(); i++) {
                arrayOfInt[i] = array.get(i);
            }
            return arrayOfInt;
        } else {
            System.out.println("File not found");
            return null;
        }
        // возможный способ изменить подход к этой функции - возвращать объекты и использовать их тип
    }
}
