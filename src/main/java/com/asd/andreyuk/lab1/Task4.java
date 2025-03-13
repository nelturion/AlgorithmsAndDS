package com.asd.andreyuk.lab1;

import com.asd.andreyuk.Utils;

import java.util.ArrayList;

public class Task4 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        utils.startMeasuring();

        int[] line = utils.readIntArrayFromFileT4("lab1/task4");

        // Вытаскиваем последний элемент из полученного массива. Его мы будем искать
        int element = line[line.length - 1];
        int[] originalLine = new int[line.length - 1];  // а это наш оригинальный массив данных
        System.arraycopy(line, 0, originalLine, 0, originalLine.length);

        // решение задачи:
        ArrayList<Integer> positionsArrayList = linearSearch(originalLine, element);
        int[] positions = new int[positionsArrayList.size()];
        for (int i = 0; i < positionsArrayList.size(); i++) {
            positions[i] = positionsArrayList.get(i);
        }

        utils.writeIntegersArrayToFile("lab1/task4", positions);

        utils.stopMeasuring();
    }

    /**
     * Линейный поиск по элементам массива
     *
     * @param array массив в котором ищем
     * @param n     элемент, который ищем
     * @return массив из индексов элементов, которые соответствуют условиям поиска. Если ничего не найдено функция
     * возвращает -1
     */
    private static ArrayList<Integer> linearSearch(int[] array, int n) {
        ArrayList<Integer> positions = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                positions.add(i);
            }
        }
        if (positions.isEmpty()) {
            positions.add(-1);
        }
        return positions;
    }
}
