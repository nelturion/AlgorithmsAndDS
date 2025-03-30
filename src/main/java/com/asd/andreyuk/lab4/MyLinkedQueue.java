package com.asd.andreyuk.lab4;

import java.util.NoSuchElementException;

public class MyLinkedQueue<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            next = null;
        }
    }

    private Node<T> head, tail;
    private int size;
    private int capacity;

    public MyLinkedQueue() {
        this.head = this.tail = null;
        this.size = 0;
        this.capacity = Integer.MAX_VALUE;
    }

    public MyLinkedQueue(int maxCapacity) {
        this.head = this.tail = null;
        this.size = 0;
        this.capacity = maxCapacity;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(T data) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            head = tail = newNode;
            return;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T dequeuedData = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return dequeuedData;
    }

    public String printQueue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        StringBuilder sb = new StringBuilder("LinkedQueue{");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            current = current.next;
            if (current != null) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
