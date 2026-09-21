package queue;

import model.Patient;

public class PatientQueue {
    private static class Node {
        private final Patient patient;
        private Node next;

        private Node(Patient patient) {
            this.patient = patient;
        }
    }

    private Node front;
    private Node rear;

    public void enqueue(Patient patient) {
        Node newNode = new Node(patient);

        if (rear == null) {
            front = newNode;
            rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    public Patient dequeue() {
        if (front == null) {
            return null;
        }

        Patient patient = front.patient;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return patient;
    }

    public void display() {
        if (front == null) {
            System.out.println("Queue is empty.");
            return;
        }

        Node currentNode = front;
        while (currentNode != null) {
            System.out.println(currentNode.patient);
            currentNode = currentNode.next;
        }
    }
}
