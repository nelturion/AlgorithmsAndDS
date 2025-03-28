package com.asd.andreyuk.lab1;

import com.asd.andreyuk.Utils;

import com.asd.andreyuk.Utils;

import java.io.InputStream;
import java.util.ArrayList;

public class Task4 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        utils.startMeasuring();

        int[] line = customRead("lab1/task4");

        // Вытаскиваем последний элемент из полученного массива. Его мы будем искать
        assert line != null;
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

    /**
     * Так как входные данные организованы в отличном от стандартного порядке, нам
     * необходима другая функция. Последний элемент возвращаемого массива - значение из второй строчки считываемого
     * файла, которое по заданию надо найти в массиве
     *
     * @param taskname название задачи
     * @return массив, последний элемент которого - искомое значение
     */
    private static int[] customRead(String taskname) {
        ClassLoader classLoader = Task4.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("txt/" + taskname + "/input.txt");

        if (inputStream != null) {
            Scanner scanner = new Scanner(inputStream);
            ArrayList<Integer> array = new ArrayList<>();
            String[] firstLine = scanner.nextLine().split(" ");
            for (String element : firstLine) {
                array.add(Integer.parseInt(element));
            }

            array.add(scanner.nextInt());   // что мы ищем?

            // приводим к нормальному виду, в конце этого массива будет элемент, который мы ищем
            int[] arrayOfInt = new int[array.size()];
            for (int i = 0; i < array.size(); i++) {
                arrayOfInt[i] = array.get(i);
            }
            return arrayOfInt;
        } else {
            System.out.println("File not found");
            return null;
        }
        // возможный способ изменить подход к этой функции - возвращать значения как объекты и использовать их тип
    }
}
