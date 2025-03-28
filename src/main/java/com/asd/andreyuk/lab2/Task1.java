package com.asd.andreyuk.lab2;

import com.asd.andreyuk.Utils;

import static com.asd.andreyuk.lab2.Lab2Utils.mergeSort;

public class Task1 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        utils.startMeasuring();

        int size = utils.readIntFromFile("lab2/task1");
        Lab2Utils lab2Utils = new Lab2Utils();
        int[] array = lab2Utils.generateRandomArray(size, 0, 100);
        mergeSort(array);

        utils.writeIntegersArrayToFile("lab2/task1", array);
        utils.stopMeasuring();
    }
}
