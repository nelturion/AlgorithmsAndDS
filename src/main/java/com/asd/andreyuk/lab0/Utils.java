package com.asd.andreyuk.lab0;

import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.io.FileWriter;
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
     * This is an implementation of function that finds a number from Fibonacci sequence
     * at a specified index
     *
     * @param n index of number
     * @return number
     */
    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        int curr = 1, prev = 1;
        for (int i = 0; i < n - 2; i++) {
            int t = curr;
            curr += prev;
            prev = t;
        }
        return curr;
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
            return Integer.MIN_VALUE;
        }
    }

    /**
     * Read array of integers from {@code taskname} input file
     *
     * @param taskname name of a task in format {@code "labN/taskN"}
     * @return integer value read from file.
     */
    public int[] readIntArrayFromFile(String taskname) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("txt/" + taskname + "/input.txt");

        if (inputStream != null) {
            Scanner scanner = new Scanner(inputStream);
            ArrayList<Integer> list = new ArrayList<>();
            while (scanner.hasNextInt()) {
                list.add(scanner.nextInt());
            }
            scanner.close();

            int[] array = new int[list.size()];
            for (int i = 0; i < array.length; i++) {
                array[i] = list.get(i);
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
     * @param value value to be written in file
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
     * @param taskName name of a task in format {@code "labN/taskN"}
     * @param arrayOfInt array to be written to a file
     */
    public void writeArrayToFile(String taskName, int[] arrayOfInt) {
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
            for (int i : arrayOfInt) {
                stringBuilder.append(i);
                if (i < arrayOfInt.length - 1) {
                    stringBuilder.append(", ");
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
     * Performance measurement function. Measures time and memory that program took up
     */
    public void stopMeasuring() {
        long endTime = System.nanoTime();
        long endMemory = getUsedMemory();

        long duration = (endTime - startTime);
        long memoryUsed = endMemory - startMemory;

        System.out.println("Time taken: " + duration / Math.pow(10, 9) + " seconds");
        System.out.println("Memory used: " + memoryUsed + " bytes");
    }

    /**
     * Uses Runtime instance to measure memory heap
     * @return memory heap size acquired by JVM
     */
    private long getUsedMemory() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }
}
