public class TreatmentStack {
    private static class Node {
        private TreatmentRecord treatmentRecord;
        private Node next;

        private Node(TreatmentRecord treatmentRecord) {
            this.treatmentRecord = treatmentRecord;
        }
    }

    private Node top;

    public void push(TreatmentRecord treatmentRecord) {
        Node newNode = new Node(treatmentRecord);
        newNode.next = top;
        top = newNode;
    }

    public TreatmentRecord pop() {
        if (top == null) {
            return null;
        }

        TreatmentRecord treatmentRecord = top.treatmentRecord;
        top = top.next;
        return treatmentRecord;
    }

    public void display() {
        if (top == null) {
            System.out.println("Treatment history is empty.");
            return;
        }

        Node currentNode = top;
        while (currentNode != null) {
            System.out.println(currentNode.treatmentRecord);
            currentNode = currentNode.next;
        }
    }
}
