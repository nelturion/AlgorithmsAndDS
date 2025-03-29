package com.asd.andreyuk;

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
    private long startTime;
    private long startMemory;

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

        System.out.println("Time taken: " + duration / Math.pow(10, 6) + " ms");
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
     * Меняет местами две переменные. Использование:
     * <blockquote>
     * <pre>
     * b = swap(a, a = b);
     * </pre>
     * </blockquote>
     * <p>
     * Операция присвоения в JVM происходит интересным образом. У нас сначала происходит операция присвоения, а потом
     * операция передачи аргумента из функции.
     * <p>
     * В основной программе это можно провести следующим образом:
     * <blockquote>
     * <pre>
     * a = a + b - (b = a);
     * </pre>
     * </blockquote>
     * В данном случае код отработает в таком порядке:
     * <ol>
     * <li>присвоение b = a;</li>
     * <li>сложение/вычитание;</li>
     * <li>присвоение a = результат сложения</li>
     * </ol>
     * Однако, в целях выполнения задачи "использовать метод swap",
     *
     * @param a первый элемент перестановки
     * @param b второй элемент перестановки
     * @return {@code a}
     */
    public static int swap(int a, int b) {
        return a;
    }

    /**
     * Swap by index in array
     * @param array
     * @param a
     * @param b
     */
    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void generateRandomArray(String taskname, int n) {
        int[] arrayOfInt = new int[n];
        for (int i = 0; i < n; i++) {
            arrayOfInt[i] = (int) (Math.random() * 100);
        }
        String dirPath = "src/main/resources/txt/" + taskname;
        File directory = new File(dirPath);
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Directory created successfully.");
            } else {
                System.err.println("Failed to create directory.");
                return;
            }
        }

        try (FileWriter writer = new FileWriter(dirPath + "/input.txt")) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < arrayOfInt.length; i++) {
                stringBuilder.append(arrayOfInt[i]);
                if (i < arrayOfInt.length - 1) {
                    stringBuilder.append(" ");
                }
            }
            writer.write(Integer.toString(n) + "\n");
            writer.write(stringBuilder.toString());
            System.out.println("File written successfully. Check " + dirPath + "/input.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    /**
     * Записывает в файл строку, если того требует задание
     * @param taskname название задачи в формате "labN/taskN"
     * @param string строка, которую надо записать
     */
    public void writeStringToFile(String taskname, String string) {
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
            writer.write(string);
            System.out.println("File written successfully. Check " + dirPath + "/output.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    /**
     * Проверяет, отсортирован ли массив
     * @param array массив, сортировку которого необходимо проверить
     * @return true, если отсортирован, false в противном случае
     */
    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAntiSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
