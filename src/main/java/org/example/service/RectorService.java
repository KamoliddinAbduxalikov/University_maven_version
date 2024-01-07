package org.example.service;

import org.example.domain.Student;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public interface RectorService {

    List<Student> RECTOR_STUDENT_LIST = Collections.synchronizedList(new LinkedList<>());
    // Oqishka kirmoqchi bogan stundetlani royxati

    void acceptStudentsRequest(Student student, Integer groupId);

    void addStudent(Student student);
    // royhatga qoshish

    void showAllRectorStudents();

    Student getRectorStudentById(Integer id);
}
