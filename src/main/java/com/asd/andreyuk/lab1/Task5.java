package com.asd.andreyuk.lab1;

import com.asd.andreyuk.Utils;

public class Task5 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        utils.startMeasuring();

        final String taskname = "lab1/task5";
        int[] array = utils.readIntArrayFromFile(taskname);
        choiceSort(array);
        utils.writeIntegersArrayToFile(taskname, array);

        utils.stopMeasuring();
    }

    /**
     * Сортировка выбором. Реализована как функция, чтобы сократить количество кода. Если понадобится неотсортированная
     * копия массива, можно использовать {@code Arrays.copyOf()}
     *
     * @param array массив для сортировки
     * @return отсортированный массив
     */
    public static int[] choiceSort(int[] array) {
        for (int step = 0; step < array.length; step++) {
            int index = minimumElementIndex(array, step);
            int temp = array[step];
            array[step] = array[index];
            array[index] = temp;
        }
        return array;
    }

    /**
     * Поиск индекса минимального элемента массива. Сканирует массив от стартового индекса до конца массива.
     *
     * @param array массив
     * @param start начальный элемент
     * @return индекс минимального элемента массива
     */
    public static int minimumElementIndex(int[] array, int start) {
        int min = array[start];
        int minIndex = start;
        for (int i = start + 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
