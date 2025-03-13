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
                array[j] = swap(array[j + 1], array[j + 1] = array[j]);

            }
        }
    }

    /**
     * Swaps two variables. Usage:
     * <blockquote>
     * <pre>
     * b = swap(a, a = b);
     * </pre>
     * </blockquote>
     * <p>
     * Операция присвоения в JVM происходит интересным образом. У нас сначала происходит операция присвоения, а потом
     * операция передачи аргумента из функции.
     * <p>
     * В основной программе это можно провести следующим образом:
     * <blockquote>
     * <pre>
     * a = a + b - (b = a);
     * </pre>
     * </blockquote>
     * В данном случае код отработает в таком порядке:
     * <ol>
     * <li>присвоение b = a;</li>
     * <li>сложение/вычитание;</li>
     * <li>присвоение a = результат сложения</li>
     * </ol>
     * Однако, в целях выполнения задачи "использовать метод swap",
     *
     * @param a первый элемент перестановки
     * @param b второй элемент перестановки
     * @return {@code a}
     */
    public static int swap(int a, int b) {
        return a;
    }
}
