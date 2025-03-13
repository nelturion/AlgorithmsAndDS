package com.asd.andreyuk.lab1;

import com.asd.andreyuk.Utils;

public class Task6 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        utils.startMeasuring();

        final String taskname = "lab1/task6";
        int[] array = utils.readIntArrayFromFile(taskname);
        bubbleSort(array);
        utils.writeIntegersArrayToFile(taskname, array);

        utils.stopMeasuring();
    }

    /**
     * Сортировка пузырьком. Реализована как функция, чтобы сократить количество кода (перегрузка методов существует, но
     * не обязательна в данном случае). Если понадобится неотсортированная копия массива, можно использовать Arrays.copyOf()
     *
     * @param arr сортируемый массив
     * @return отсортированный массив
     */
    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
