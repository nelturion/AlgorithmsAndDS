package com.asd.andreyuk.lab1;

import com.asd.andreyuk.Utils;

public class Task3 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        utils.startMeasuring();

        final String taskname = "lab1/task3";
        int[] array = utils.readIntArrayFromFile(taskname);
        reverseInsertionSort(array);
        utils.writeIntegersArrayToFile(taskname, array);

        utils.stopMeasuring();
    }

    /**
     * Sorts an array in non-ascending order. Uses swap method.
     *
     * @param array to be sorted
     */
    public static void reverseInsertionSort(int[] array) {
        for (int i = array.length - 2; i >= 0; i--) {
            // we begin from array.length - 2 because we need to start from pre-last element

            for (int j = i; j < array.length - 1 && array[j + 1] > array[j]; j++) {
                array[j] = Utils.swap(array[j + 1], array[j + 1] = array[j]);

            }
        }
    }


}
