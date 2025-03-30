package com.asd.andreyuk.lab4;

import java.util.EmptyStackException;

public class MyLinkedStack<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        private Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> top;

    public MyLinkedStack() {
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T poppedData = top.data;
        top = top.next;
        return poppedData;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public String print() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Node<T> current = top;
        StringBuilder s = new StringBuilder();
        s.append("Stack{");
        while (current != null) {
            s.append(current.data);
            current = current.next;
            if (current != null) {
                s.append(", ");
            }
        }
        s.append("}");
       return s.toString();
    }
}
