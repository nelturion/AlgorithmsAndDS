package com.asd.andreyuk.lab4;

import com.asd.andreyuk.Utils;


public class Task6 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        utils.startMeasuring();

        String[] data = utils.readStringArrayFromFile("lab4/task6");
        MyQueue<Integer> queue = new MyQueue();
                StringBuilder sb = new StringBuilder();
        for (String s : data) {
            if (s.startsWith("+")) {
                queue.enqueue(Integer.parseInt(s.split(" ")[1]));
            }
            if (s.startsWith("-")) {
                queue.dequeue();
            }
            if (s.startsWith("?")) {
                sb.append(queue.getMin());
                sb.append("\n");
            }
        }

        utils.writeStringToFile("lab4/task6", sb.toString());
        utils.stopMeasuring();
    }
}
