package com.asd.andreyuk.lab2;

import java.util.Random;

public class Lab2Utils {
    private static final Random random = new Random();

    /**
     * Генерирует массив случайных целых чисел.
     *
     * @param size Размер массива.
     * @param min  Минимальное значение.
     * @param max  Максимальное значение.
     * @return Массив случайных целых чисел.
     */
    public int[] generateRandomArray(int size, int min, int max) {
        if (size <= 0) {
            throw new IllegalArgumentException("Размер массива должен быть больше нуля.");
        }

        if (min > max) {
            throw new IllegalArgumentException("Минимальное значение должно быть меньше или равно максимальному.");
        }

        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }

        return array;
    }

    public static void mergeSort(int[] array) {
        if (array == null || array.length < 2) {
            return; // Массив уже отсортирован, если содержит 0 или 1 элемент
        }

        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        // Копируем элементы в левый и правый подмассивы
        System.arraycopy(array, 0, left, 0, left.length);
        System.arraycopy(array, mid, right, 0, right.length);

        // Рекурсивно сортируем каждую половину
        mergeSort(left);
        mergeSort(right);

        // Объединяем отсортированные подмассивы
        merge(array, left, right);
    }

    private static void merge(int[] result, int[] left, int[] right) {
        int i = 0; // Индекс для левого подмассива
        int j = 0; // Индекс для правого подмассива
        int k = 0; // Индекс для результирующего массива

        // Сравниваем элементы из left и right и добавляем меньший в result
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        // Добавляем оставшиеся элементы из left и right (если есть)
        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }
    }
}
