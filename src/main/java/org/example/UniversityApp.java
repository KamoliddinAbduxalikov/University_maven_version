package org.example;

import org.example.domain.*;
import org.example.email.Email;
import org.example.enums.UserType;
import org.example.service.*;
import org.example.service.impl.*;


import java.util.Random;
import java.util.Scanner;


public class UniversityApp {

    static Scanner scStr = new Scanner(System.in);
    static Scanner scInt = new Scanner(System.in);
    static StudentService studentService = new StudentServiceImpl();
    static FacultyService facultyService = new FacultyServiceImpl();
    static FacultyGroupService facultyGroupService = new FacultyGroupServiceImpl();
    static SubjectService subjectService = new SubjectServiceImpl();
    static RectorService rectorService = new RectorServiceImpl();
    static EmailService emailService = new EmailServiceImpl();
    static GroupSubjectService groupSubjectService = new GroupSubjectServiceImpl();
    static Boolean inProcess = true;

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to University!");
        while (true) {
            System.out.println("""
                    1. Rector menu :
                    2. Admission to university :
                    3. Exit 
                    """);
            int userChoice = scInt.nextInt();
            if (userChoice == 0) {
                break;
            }

            switch (userChoice) {
                case 1 -> {
                    rector();
                }
                case 2 -> {
                    var student = admissionToUniversity();
                    if (student.getUserType().equals(UserType.GUEST)) {
                        student(student);
                    }
                }
            }
        }
    }

    public static void student(Student student) {
        var rectorStudent = rectorService.getRectorStudentById(student.getId());
        if (rectorStudent.getGroupId() == null) {
            System.out.println("You have not yet been accepted to university!");
            rector();
        } else {
            while (inProcess) {
                studentMenu();
                int studentChoice = scInt.nextInt();

                if (studentChoice == 0) {
                    inProcess = false;
                    break;
                }

                switch (studentChoice) {
                    case 1 -> {
                        groupSubjectService.showAllSubjectsStudent(student);
                    }
                }
            }
        }
    }

    public static Student admissionToUniversity() throws Exception {
        System.out.print("Enter the name : ");
        String name = scStr.nextLine();

        System.out.print("Enter the age : ");
        Integer age = scInt.nextInt();

        System.out.println("Enter the phone number : ");
        String phoneNumber = scStr.nextLine();

        System.out.println("Enter the your email : ");
        String email = scStr.nextLine();


        Random random = new Random();
        Integer msg = 10000 + random.nextInt(90000);
        Email.sendEmail(email, msg);

        boolean process = true;
        do {
            System.out.println("Enter the verification code ");
            Integer code = scInt.nextInt();
            if (code.equals(msg)) {
                process = false;
            }
        } while (process);

        System.out.println("Crete a new password : ");
        String password = scStr.nextLine();

        facultyService.showAllFaculties();
        System.out.print("Which faculty do you want to choose ?");
        Integer facultyId = scInt.nextInt();
        Student student = new Student(name, age, phoneNumber, password, facultyId);

        emailService.addEmailHistory(email, msg);
        rectorService.addStudent(student);
        return student;
    }

    public static void rector() {
        while (true) {
            rectorMenu();
            int rectorChoice = scInt.nextInt();

            if (rectorChoice == 0) {
                break;
            }

            switch (rectorChoice) {
                case 1 -> {
                    rectorService.showAllRectorStudents();
                    System.out.println("Enter the student id : ");
                    Integer studentId = scInt.nextInt();
                    var student = rectorService.getRectorStudentById(studentId);
                    facultyGroupService.showAllFacultyGroups(student.getFacultyId());
                    System.out.println("Enter the group id : ");
                    Integer groupId = scInt.nextInt();
                    rectorService.acceptStudentsRequest(student, groupId);
                }
                case 2 -> {
                    facultyService.showAllFaculties();
                }
                case 3 -> {
                    facultyService.showAllFaculties();
                    System.out.println("Enter the faculty id : ");
                    Integer facultyId = scInt.nextInt();
                    facultyService.deleteFaculty(facultyId);
                }
                case 4 -> {
                    facultyService.showAllFaculties();
                    System.out.println("Enter the faculty id : ");
                    Integer facultyId = scInt.nextInt();
                    facultyGroupService.showAllFacultyGroups(facultyId);
                }
            }
        }
    }

    public static void studentMenu() {
        System.out.println("""
                1. Show all subject 
                0. Exit 
                """);
    }

    public static void rectorMenu() {
        System.out.println("""
                1. Add a student to a group  
                2. Show faculties 
                3. Delete faculty
                4. Show faculty group
                0. Exit   
                """);
    }
}