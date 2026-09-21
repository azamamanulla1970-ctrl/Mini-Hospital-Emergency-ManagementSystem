import bst.PatientBST;
import java.util.Scanner;
import linkedlist.VisitHistoryList;
import linkedlist.VisitRecord;
import model.Patient;
import queue.PatientQueue;
import stack.TreatmentRecord;
import stack.TreatmentStack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PatientBST patientBST = new PatientBST();
        PatientQueue patientQueue = new PatientQueue();
        TreatmentStack treatmentStack = new TreatmentStack();
        VisitHistoryList visitHistoryList = new VisitHistoryList();

        int choice;
        do {
            System.out.println("\nMini Hospital Emergency Management System");
            System.out.println("1. Patient Records");
            System.out.println("2. Emergency Patient Queue");
            System.out.println("3. Treatment History Stack");
            System.out.println("4. Patient Visit History");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    patientRecordsMenu(scanner, patientBST);
                    break;
                case 2:
                    patientQueueMenu(scanner, patientQueue);
                    break;
                case 3:
                    treatmentStackMenu(scanner, treatmentStack);
                    break;
                case 4:
                    visitHistoryMenu(scanner, visitHistoryList);
                    break;
                case 0:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void patientRecordsMenu(Scanner scanner, PatientBST patientBST) {
        System.out.println("\nPatient Records");
        System.out.println("1. Insert patient");
        System.out.println("2. Search patient");
        System.out.println("3. Delete patient");
        System.out.println("4. Display patients");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                patientBST.insert(readPatient(scanner));
                System.out.println("Patient added.");
                break;
            case 2:
                System.out.print("Enter patient ID: ");
                Patient foundPatient = patientBST.search(scanner.nextInt());
                scanner.nextLine();
                if (foundPatient == null) {
                    System.out.println("Patient not found.");
                } else {
                    System.out.println(foundPatient);
                }
                break;
            case 3:
                System.out.print("Enter patient ID: ");
                patientBST.delete(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Patient deleted if the ID existed.");
                break;
            case 4:
                patientBST.inOrderTraversal();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void patientQueueMenu(Scanner scanner, PatientQueue patientQueue) {
        System.out.println("\nEmergency Patient Queue");
        System.out.println("1. Add patient to queue");
        System.out.println("2. Remove patient from queue");
        System.out.println("3. Display waiting patients");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                patientQueue.enqueue(readPatient(scanner));
                System.out.println("Patient added to the queue.");
                break;
            case 2:
                Patient removedPatient = patientQueue.dequeue();
                if (removedPatient == null) {
                    System.out.println("Queue is empty.");
                } else {
                    System.out.println("Removed patient: " + removedPatient);
                }
                break;
            case 3:
                patientQueue.display();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void treatmentStackMenu(Scanner scanner, TreatmentStack treatmentStack) {
        System.out.println("\nTreatment History Stack");
        System.out.println("1. Add treatment record");
        System.out.println("2. Remove latest treatment record");
        System.out.println("3. Display treatment history");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter patient ID: ");
                int patientId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter treatment details: ");
                String treatmentDetails = scanner.nextLine();
                treatmentStack.push(new TreatmentRecord(patientId, treatmentDetails));
                System.out.println("Treatment record added.");
                break;
            case 2:
                TreatmentRecord removedTreatment = treatmentStack.pop();
                if (removedTreatment == null) {
                    System.out.println("Treatment history is empty.");
                } else {
                    System.out.println("Removed treatment: " + removedTreatment);
                }
                break;
            case 3:
                treatmentStack.display();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void visitHistoryMenu(Scanner scanner, VisitHistoryList visitHistoryList) {
        System.out.println("\nPatient Visit History");
        System.out.println("1. Add visit");
        System.out.println("2. Remove visit");
        System.out.println("3. Search visit");
        System.out.println("4. Display visit history");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                visitHistoryList.addVisit(readVisitRecord(scanner));
                System.out.println("Visit added.");
                break;
            case 2:
                System.out.print("Enter visit ID: ");
                int visitId = scanner.nextInt();
                scanner.nextLine();
                if (visitHistoryList.removeVisit(visitId)) {
                    System.out.println("Visit removed.");
                } else {
                    System.out.println("Visit not found.");
                }
                break;
            case 3:
                System.out.print("Enter visit ID: ");
                VisitRecord foundVisit = visitHistoryList.searchVisit(scanner.nextInt());
                scanner.nextLine();
                if (foundVisit == null) {
                    System.out.println("Visit not found.");
                } else {
                    System.out.println(foundVisit);
                }
                break;
            case 4:
                visitHistoryList.displayVisitHistory();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static Patient readPatient(Scanner scanner) {
        System.out.print("Enter patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter patient name: ");
        String patientName = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter contact number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Enter medical condition: ");
        String medicalCondition = scanner.nextLine();
        return new Patient(patientId, patientName, age, contactNumber, medicalCondition);
    }

    private static VisitRecord readVisitRecord(Scanner scanner) {
        System.out.print("Enter visit ID: ");
        int visitId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter visit date: ");
        String visitDate = scanner.nextLine();
        System.out.print("Enter doctor name: ");
        String doctorName = scanner.nextLine();
        System.out.print("Enter diagnosis: ");
        String diagnosis = scanner.nextLine();
        System.out.print("Enter treatment: ");
        String treatment = scanner.nextLine();
        return new VisitRecord(visitId, visitDate, doctorName, diagnosis, treatment);
    }
}
