package com.asd.andreyuk.lab1;

public class Task1 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        utils.startMeasuring();

        final String taskname = "lab1/task1";
        int[] array = utils.readIntArrayFromFile(taskname);

        insertionSort(array);
        utils.writeIntegersArrayToFile(taskname, array);

        utils.stopMeasuring();
    }

    /**
     * Сортировка вставками. Сравниваем элементы поочередно, сдвигая следующий элемент на позицию влево, пока он
     * больше нынешнего.
     * @param arr массив, который надо отсортировать
     * @return отсортированный массив
     */
    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }
}
