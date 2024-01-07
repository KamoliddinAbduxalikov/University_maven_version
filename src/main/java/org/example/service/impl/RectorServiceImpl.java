package org.example.service.impl;

import org.example.domain.Student;
import org.example.enums.UserType;
import org.example.service.RectorService;

public class RectorServiceImpl implements RectorService {

    @Override
    public void acceptStudentsRequest(Student student, Integer groupId) {
        student.setGroupId(groupId);
        student.setUserType(UserType.STUDENT);
    }

    @Override
    public void addStudent(Student student) {
        RECTOR_STUDENT_LIST.add(student);
    }

    @Override
    public void showAllRectorStudents() {
        for (Student student : RECTOR_STUDENT_LIST) {
            System.out.println(student);
        }
    }

    @Override
    public Student getRectorStudentById(Integer id) {
        for (Student student : RECTOR_STUDENT_LIST) {
            if (student.getId().equals(id)){
                return student;
            }
        }
        return null;
    }
}
