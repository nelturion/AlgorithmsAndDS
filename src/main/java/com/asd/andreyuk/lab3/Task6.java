package com.asd.andreyuk.lab3;

import com.asd.andreyuk.Utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        utils.startMeasuring();

        Object[] data = customRead();
        assert data != null;

        int[] a = (int[]) data[0];
        int[] b = (int[]) data[1];
        int n = a.length;
        int m = b.length;

        //создаем массив, содержащий все перемноженные элементы
        ArrayList<Integer> c = new ArrayList<>(n*m);
        for (int numA : a) {
            for (int numB : b) {
                c.add(numA * numB);
            }
        }
        c.sort(Integer::compareTo);
        int sum = 0;
        for (int i = 0; i < c.size(); i+=10) {
            sum += c.get(i);
        }

        utils.writeIntToFile("lab3/task6", sum);
        utils.stopMeasuring();
    }

    private static Object[] customRead() {
        ClassLoader classLoader = Task6.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("txt/lab3/task6/input.txt");

        if (inputStream != null) {
            Scanner scanner = new Scanner(inputStream);
            String dimensions = scanner.nextLine();
            int[] a = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] b = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            return new Object[] {a, b};
        } else {
            System.out.println("File not found");
            return null;
        }
    }


}