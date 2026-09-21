public class PatientBST {
    private static class Node {
        private Patient patient;
        private Node left;
        private Node right;

        private Node(Patient patient) {
            this.patient = patient;
        }
    }

    private Node root;

    public void insert(Patient patient) {
        if (root == null) {
            root = new Node(patient);
            return;
        }

        insertPatient(root, patient);
    }

    private void insertPatient(Node currentNode, Patient patient) {
        if (patient.getPatientId() < currentNode.patient.getPatientId()) {
            if (currentNode.left == null) {
                currentNode.left = new Node(patient);
            } else {
                insertPatient(currentNode.left, patient);
            }
        } else if (patient.getPatientId() > currentNode.patient.getPatientId()) {
            if (currentNode.right == null) {
                currentNode.right = new Node(patient);
            } else {
                insertPatient(currentNode.right, patient);
            }
        }
    }
}
