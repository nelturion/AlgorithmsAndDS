package com.asd.andreyuk.lab2;

import com.asd.andreyuk.Utils;

public class Task5 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        utils.startMeasuring();

        // мы можем просто отсортировать всех кандидатов по возрастанию и тот, у которого >50% голосов будет в центре
        // полученного списка
        int[] array = utils.readIntArrayFromFile("lab2/task5");
        Lab2Utils.mergeSort(array);
        int mid = array[array.length / 2];
        // System.out.println(array[mid]);

        utils.writeIntToFile("lab2/task5", mid);
        utils.stopMeasuring();
    }
}
