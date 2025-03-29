package com.asd.andreyuk.lab3;

import com.asd.andreyuk.Utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        utils.startMeasuring();

        int[] citations = customRead();
        assert citations != null;
        utils.writeIntToFile("lab3/task5", hirschIndex(citations));
        utils.stopMeasuring();
    }

    private static int hirschIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int h = 0; h < n; h++) {
            if (n - h <= citations[h]) {
                return n - h;
            }
        }
        return 0;
    }

    private static int[] customRead() {
        ClassLoader classLoader = Task3.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("txt/lab3/task5/input.txt");

        if (inputStream != null) {
            Scanner scanner = new Scanner(inputStream);
            String[] numbers = scanner.nextLine().split(",");
            int[] citations = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                citations[i] = Integer.parseInt(numbers[i]);
            }

            return citations;
        } else {
            System.out.println("File not found");
            return null;
        }
    }
}
