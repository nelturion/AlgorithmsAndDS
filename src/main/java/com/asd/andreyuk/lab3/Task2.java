package com.asd.andreyuk.lab3;

import com.asd.andreyuk.Utils;

public class Task2 {
    public static void main(String[] args) {
        Utils utils = new Utils();

        int[] array = antiQuickSort(utils.readIntFromFile("lab3/task2"));
        utils.writeIntegersArrayToFile("lab3/task2", array);

        utils.startMeasuring();
        quickSort(array, 0, array.length - 1);

        utils.stopMeasuring();
    }

    private static int[] antiQuickSort(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;   // создаем массив заполненный числами от 1 до n
        }

        for (int i = 2; i < array.length; i++) {
            Utils.swap(array, i, i/2);
        }
        return array;
    }

    private static void quickSort(int[] array, int left, int right) {
        int key = array[(left+right) / 2];
        int i = left;
        int j = right;
        while (i <= j) {
            while (array[i] < key) {
                i++;
            }
            while (array[j] > key) {
                j--;
            }
            if (i <= j) {
                Utils.swap(array, i, j);
                i++;
                j--;
            }
        }
        if (left < j) {
            quickSort(array, left, j);
        }
        if (right > i) {
            quickSort(array, i, right);
        }
    }
}
