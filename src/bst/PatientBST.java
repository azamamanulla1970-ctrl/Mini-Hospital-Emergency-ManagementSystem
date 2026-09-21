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

    public Patient search(int patientId) {
        Node currentNode = root;

        while (currentNode != null) {
            if (patientId == currentNode.patient.getPatientId()) {
                return currentNode.patient;
            }

            if (patientId < currentNode.patient.getPatientId()) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }

        return null;
    }

    public void delete(int patientId) {
        root = deletePatient(root, patientId);
    }

    private Node deletePatient(Node currentNode, int patientId) {
        if (currentNode == null) {
            return null;
        }

        if (patientId < currentNode.patient.getPatientId()) {
            currentNode.left = deletePatient(currentNode.left, patientId);
        } else if (patientId > currentNode.patient.getPatientId()) {
            currentNode.right = deletePatient(currentNode.right, patientId);
        } else {
            if (currentNode.left == null) {
                return currentNode.right;
            }

            if (currentNode.right == null) {
                return currentNode.left;
            }

            Node successor = findSmallestNode(currentNode.right);
            currentNode.patient = successor.patient;
            currentNode.right = deletePatient(currentNode.right, successor.patient.getPatientId());
        }

        return currentNode;
    }

    private Node findSmallestNode(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }

        return currentNode;
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node currentNode) {
        if (currentNode != null) {
            inOrderTraversal(currentNode.left);
            System.out.println(currentNode.patient);
            inOrderTraversal(currentNode.right);
        }
    }
}
