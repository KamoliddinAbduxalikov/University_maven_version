package org.example;

import org.example.domain.*;
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
                    3. Login 
                    0. Exit 
                    """);
            String userChoice = scStr.nextLine();
            if (userChoice.equals("0")) {
                break;
            }

            switch (userChoice) {
                case "1" -> {
                    rector();
                }
                case "2" -> {
                    admissionToUniversity();
                }
                case "3" -> {
                    System.out.println("Enter the name : ");
                    String name = scStr.nextLine();
                    System.out.println("Enter the password : ");
                    String password = scStr.nextLine();
                    var student = studentService.login(name, password);
                    if (student != null) {
                        student(student);
                    }
                }
                default -> System.out.println("Unknown command!");
            }
        }
    }

    public static void student(Student student) {
        while (true) {
            studentMenu();
            String studentChoice = scStr.nextLine();

            if (studentChoice.equals("0")) {
                break;
            }

            switch (studentChoice) {
                case "1" -> {
                    groupSubjectService.showAllSubjectsStudent(student);
                }
                default -> System.out.println("Unknown command!");
            }
        }
    }

    public static void admissionToUniversity() throws Exception {
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
        emailService.sendEmail(email, msg);

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
        Student student = new Student(name, age, phoneNumber, password, facultyId, email);

        emailService.addEmailHistory(email, msg);
        rectorService.addGuestToList(student);
    }

    public static void rector() {
        while (true) {
            rectorMenu();
            String rectorChoice = scStr.nextLine();

            if (rectorChoice.equals("0")) {
                break;
            }

            switch (rectorChoice) {
                case "1" -> {
                    rectorService.showAllRectorGuests();
                    System.out.println("Enter the student id : ");
                    Integer studentId = scInt.nextInt();
                    var student = rectorService.getRectorGuestsById(studentId);
                    facultyGroupService.showAllFacultyGroups(student.getFacultyId());
                    System.out.println("Enter the group id : ");
                    Integer groupId = scInt.nextInt();
                    rectorService.acceptStudentsRequest(student, groupId);
                }
                case "2" -> {
                    System.out.println("Enter the faculty name : ");
                    String facultyName = scStr.nextLine();
                    Faculty faculty = new Faculty(facultyName);
                    facultyService.addFaculty(faculty);
                }
                case "3" -> {
                    facultyService.showAllFaculties();
                }
                case "4" -> {
                    facultyService.showAllFaculties();
                    System.out.println("Enter the faculty id : ");
                    Integer facultyId = scInt.nextInt();
                    facultyService.deleteFaculty(facultyId);
                }
                case "5" -> {
                    facultyService.showAllFaculties();
                    System.out.println("Enter the faculty id : ");
                    Integer facultyId = scInt.nextInt();
                    facultyGroupService.showAllFacultyGroups(facultyId);
                }
                case "6" -> {
                    facultyService.showAllFaculties();
                    System.out.println("Enter the faculty id : ");
                    Integer facultyId = scInt.nextInt();
                    System.out.println("Enter the new group name : ");
                    String groupName = scStr.nextLine();
                    Group group = new Group(groupName,facultyId);
                    facultyGroupService.addFacultyGroup(group);
                }
                case "7" -> {
                    System.out.println("Enter the faculty id : ");
                    Integer facultyId = scInt.nextInt();
                    facultyGroupService.showAllFacultyGroups(facultyId);
                    System.out.println("Enter the group id : ");
                    Integer groupId = scInt.nextInt();
                    System.out.println("Enter the new subject name : ");
                    String groupName = scStr.nextLine();
                    Subject subject = new Subject(groupName);
                    groupSubjectService.addGroupSubject(groupId, subject.getId());
                }
                default -> System.out.println("Unknown command!");
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
                2. Add faculty
                3. Show faculties 
                4. Delete faculty
                5. Show faculty group
                6. Add group faculty 
                7. Add subject group
                0. Exit   
                """);
    }
}