# Mini Hospital Emergency Management System

## Description

This is a beginner-level Java console application for managing hospital emergency operations using data structures.

## Data Structures Used

- **Binary Search Tree:** Stores and manages patient records.
- **Queue:** Stores emergency patients in waiting order.
- **Stack:** Stores treatment history, with the latest treatment on top.
- **Singly Linked List:** Stores patient visit history.

## Basic System Operations

- Add, search, delete, and display patient records.
- Add, remove, and display emergency patients.
- Add, remove, and display treatment records.
- Add, remove, search, and display patient visits.

## How to Run

Open a terminal in the project folder and compile the Java files:

```text
javac -d out src\Main.java src\model\Patient.java src\bst\PatientBST.java src\queue\PatientQueue.java src\stack\TreatmentRecord.java src\stack\TreatmentStack.java src\linkedlist\VisitRecord.java src\linkedlist\VisitHistoryList.java
```

Run the program:

```text
java -cp out Main
```

Use the console menu to select an operation. Enter `0` to exit.

## Testing

The Binary Search Tree, Queue, Stack, and Singly Linked List operations were tested. Testing included adding, searching, removing, deleting, displaying records, and handling empty structures where applicable.
