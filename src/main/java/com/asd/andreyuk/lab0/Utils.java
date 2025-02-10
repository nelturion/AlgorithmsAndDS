package com.asd.andreyuk.lab0;

import java.io.*;
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

    public int readIntFromFile(String filename) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("txt/" + filename + "/input.txt");
        if (inputStream != null) {
            Scanner scanner = new Scanner(inputStream);
            return scanner.nextInt();
        } else {
            System.out.println("File not found");
            return Integer.MIN_VALUE;
        }
    }

    public int[] readIntArrayFromFile(String filename) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("txt/" + filename + "/input.txt");

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

    public void writeIntToFile(String taskName, int value) {
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
            writer.write(String.valueOf(value));
            writer.close();
            System.out.println("File written successfully. Check " + dirPath + "/output.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public void writeArrayToFile(String taskName, int[] arrayOfInt) throws IOException {
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
            }

            writer.write(stringBuilder.toString());
            System.out.println("File written successfully. Check " + dirPath + "/output.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    private long startTime;
    private long startMemory;

    public void startMeasuring() {
        startTime = System.nanoTime();
        startMemory = getUsedMemory();
    }

    public void stopMeasuring() {
        long endTime = System.nanoTime();
        long endMemory = getUsedMemory();

        long duration = (endTime - startTime);
        long memoryUsed = endMemory - startMemory;

        System.out.println("Time taken: " + duration / Math.pow(10, 9) + " seconds");
        System.out.println("Memory used: " + memoryUsed / 1024 + " kilobytes");
    }

    private long getUsedMemory() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }
}
