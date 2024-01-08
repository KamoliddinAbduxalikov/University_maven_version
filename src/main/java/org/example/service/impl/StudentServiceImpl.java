package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.Student;
import org.example.service.StudentService;

@Slf4j
public class StudentServiceImpl implements StudentService {

    @Override
    public Student login(String name, String password) {
        for (Student student : STUDENT_LIST) {
            if (student.getName().equals(name) && student.getPassword().equals(password)) {
                return student;
            }
        }
        log.error("Student not found!");
        return null;
    }

    @Override
    public void addStudent(Student student) {
        STUDENT_LIST.add(student);
    }
}
