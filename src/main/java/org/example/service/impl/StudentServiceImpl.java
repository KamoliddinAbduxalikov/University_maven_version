package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.Student;
import org.example.service.StudentService;

@Slf4j
public class StudentServiceImpl implements StudentService {

    @Override
    public Student login(String name, String password) {
        return STUDENT_LIST.stream().
                filter(student -> student.getName().equals(name) &&
                        student.getPassword().equals(password)).findFirst().get();
    }

    @Override
    public void addStudent(Student student) {
        STUDENT_LIST.add(student);
    }
}
