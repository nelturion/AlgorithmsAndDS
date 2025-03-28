package com.asd.andreyuk.lab2;

import com.asd.andreyuk.Utils;

public class Task3 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        utils.startMeasuring();

        int[] array = utils.readIntArrayFromFile("lab2/task3");
        int[] temp = new int[array.length];
        int inversions = mergeSortAndCount(array, temp, 0, array.length - 1);
        //System.out.println(naiveSolution(array));
        //System.out.println(inversions);
        utils.writeIntToFile("lab2/task3", inversions);
        utils.stopMeasuring();
    }

    private static int mergeSortAndCount(int[] array, int[] temp, int left, int right) {
        int count = 0;

        if (left < right) {
            int mid = left + (right - left) / 2;

            // Рекурсивно считаем инверсии в левой и правой половинах
            count += mergeSortAndCount(array, temp, left, mid);
            count += mergeSortAndCount(array, temp, mid + 1, right);

            // Считаем инверсии между двумя половинами
            count += mergeAndCount(array, temp, left, mid, right);

        }

        return count;
    }

    private static int mergeAndCount(int[] array, int[] temp, int left, int mid, int right) {
        int count = 0;

        int i = left;     // Индекс для левой половины
        int j = mid + 1;  // Индекс для правой половины
        int k = left;     // Индекс для временного массива

        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
                count += (mid - i + 1); // Количество инверсий
            }
        }

        // Копируем оставшиеся элементы из левой половины
        while (i <= mid) {
            temp[k++] = array[i++];
        }

        // Копируем оставшиеся элементы из правой половины
        while (j <= right) {
            temp[k++] = array[j++];
        }

        // Копируем обратно в оригинальный массив
        for (i = left; i <= right; i++) {
            array[i] = temp[i];
        }
        return count;
    }

    /**
     * Наивное решение задачи. Сложность O(n^2)
     *
     * @param array массив с инверсиями
     * @return количество инверсий в массиве
     */
    public static int naiveSolution(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
