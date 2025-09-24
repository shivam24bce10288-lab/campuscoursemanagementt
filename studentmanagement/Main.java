// Main class for Student Management System
// Author: Student Developer
// Date: 2024

import java.util.*;

public class Main {
    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Welcome to Student Management System");
        System.out.println("=====================================");
        
        boolean running = true;
        while (running) {
            showMenu();
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    showStudents();
                    break;
                case 3:
                    findStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    running = false;
                    System.out.println("Thank you for using our system!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
    
    static void showMenu() {
        System.out.println("\n===== MAIN MENU =====");
        System.out.println("1. Add Student");
        System.out.println("2. Show All Students");
        System.out.println("3. Find Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }
    
    static void addStudent() {
        System.out.println("\n--- Add New Student ---");
        System.out.print("Enter student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // clear buffer
        
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        
        System.out.print("Enter student grade: ");
        String grade = sc.nextLine();
        
        Student s = new Student(id, name, grade);
        studentList.add(s);
        System.out.println("Student added successfully!");
    }
    
    static void showStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found!");
            return;
        }
        
        System.out.println("\n--- All Students ---");
        for (int i = 0; i < studentList.size(); i++) {
            Student s = studentList.get(i);
            System.out.println((i+1) + ". ID: " + s.id + ", Name: " + s.name + ", Grade: " + s.grade);
        }
    }
    
    static void findStudent() {
        System.out.print("Enter student ID to search: ");
        int searchId = sc.nextInt();
        
        for (Student s : studentList) {
            if (s.id == searchId) {
                System.out.println("Student found: " + s.name + " - Grade: " + s.grade);
                return;
            }
        }
        System.out.println("Student not found!");
    }
    
    static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int deleteId = sc.nextInt();
        
        for (
