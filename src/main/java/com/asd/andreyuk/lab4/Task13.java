package com.asd.andreyuk.lab4;

import com.asd.andreyuk.Utils;

public class Task13 {
    public static void main(String[] args) {
        Utils utils = new Utils();
        utils.startMeasuring();

        MyLinkedStack<Integer> stack = new MyLinkedStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        String stackString = stack.pop() + "\n" +
                    stack.peek() + "\n" +
                    stack.isEmpty() + "\n" +
                    stack.print() + "\n";

        MyLinkedQueue<Integer> queue = new MyLinkedQueue<>(4);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);
        String queueString = queue.dequeue() + "\n" +
                            queue.isEmpty() + "\n" +
                            queue.printQueue() + "\n";

        String errorMessage = "";
        try {
            queue.enqueue(11);
        } catch (Exception e) {
            errorMessage = e.toString();
        }
        utils.writeStringToFile("lab4/task13", stackString + queueString + "\n" + errorMessage);

        utils.stopMeasuring();
    }
}
