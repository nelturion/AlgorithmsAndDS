package com.asd.andreyuk.lab2;

import com.asd.andreyuk.Utils;

import java.io.InputStream;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        utils.startMeasuring();

        int[] array = utils.readIntArrayFromFile("lab2/task4");
        int[] searchArray = customRead();
        assert searchArray != null;
        int[] results = new int[searchArray.length];
        int i = 0;
        for (int item : searchArray) {
            results[i++] = binarySearch(array, item);
        }

        utils.writeIntegersArrayToFile("lab2/task4", results);
        utils.stopMeasuring();
    }

    private static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int[] customRead() {
        ClassLoader classLoader = Task4.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("txt/" + "lab2/task4" + "/input.txt");

        if (inputStream != null) {
            Scanner scanner = new Scanner(inputStream);
            // это чтобы прочитать данные и забыть про них
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

            int k = scanner.nextInt();
            int[] searchArray = new int[k];
            for (int i = 0; i < k; i++) {
                searchArray[i] = scanner.nextInt();
            }
            return searchArray;
        } else {
            System.out.println("File not found");
            return null;
        }
    }
}
