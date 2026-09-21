package linkedlist;

public class VisitHistoryList {
    private static class Node {
        private final VisitRecord visitRecord;
        private Node next;

        private Node(VisitRecord visitRecord) {
            this.visitRecord = visitRecord;
        }
    }

    private Node head;

    public void addVisit(VisitRecord visitRecord) {
        Node newNode = new Node(visitRecord);

        if (head == null) {
            head = newNode;
            return;
        }

        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
    }

    public boolean removeVisit(int visitId) {
        if (head == null) {
            return false;
        }

        if (head.visitRecord.getVisitId() == visitId) {
            head = head.next;
            return true;
        }

        Node currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.next.visitRecord.getVisitId() == visitId) {
                currentNode.next = currentNode.next.next;
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;
    }

    public VisitRecord searchVisit(int visitId) {
        Node currentNode = head;

        while (currentNode != null) {
            if (currentNode.visitRecord.getVisitId() == visitId) {
                return currentNode.visitRecord;
            }
            currentNode = currentNode.next;
        }

        return null;
    }

    public void displayVisitHistory() {
        if (head == null) {
            System.out.println("Visit history is empty.");
            return;
        }

        Node currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.visitRecord);
            currentNode = currentNode.next;
        }
    }
}