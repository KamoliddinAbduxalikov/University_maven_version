package org.example.service;

import org.example.domain.Student;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public interface StudentService {

    List<Student> STUDENT_LIST = Collections.synchronizedList(new LinkedList<>());

    Student login(String name, String password);

    void addStudent(Student student);
}
