package com.asd.andreyuk.lab3;

import com.asd.andreyuk.Utils;
import org.w3c.dom.ls.LSOutput;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        utils.startMeasuring();

        Object[] data = customRead();
        int k = 0;
        int[] array = new int[0];
        if (data != null) {
            array = (int[]) data[0];
            k = (int) data[1];
        }

        utils.writeStringToFile("lab3/task3", sortableMessage(array, k));
        utils.stopMeasuring();
    }

    private static String sortableMessage(int[] array, int k) {
        return isSortable(array, k) ? "ДА" : "НЕТ";
    }

    private static boolean isSortable(int[] array, int k) {

        int[] sortedArray = Arrays.copyOf(array, array.length);
        pigeonSort(array, k);
        Arrays.sort(sortedArray);
        return Arrays.equals(array, sortedArray);
    }

    private static void pigeonSort(int[] array, int k) {
        for (int i = 0; i < array.length - k; i++) {
            if (array[i] > array[i + k]) {
                Utils.swap(array, i, i + k);
            }
        }
    }

    private static Object[] customRead() {
        ClassLoader classLoader = Task3.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("txt/lab3/task3/input.txt");

        if (inputStream != null) {
            Scanner scanner = new Scanner(inputStream);
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
            return new Object[]{array, k};
        } else {
            System.out.println("File not found");
            return null;
        }
    }
}
