package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.Rector;
import org.example.domain.Student;
import org.example.enums.UserType;
import org.example.service.RectorService;
import org.example.service.StudentService;

@Slf4j
public class RectorServiceImpl implements RectorService {

    {
        Rector rector = new Rector("John Hopkins");
    }

    @Override
    public void acceptStudentsRequest(Student student, Integer groupId) {
        StudentService studentService = new StudentServiceImpl();
        student.setGroupId(groupId);
        student.setUserType(UserType.STUDENT);
        studentService.addStudent(student);
        GUEST_LIST.remove(student);
    }

    @Override
    public void addGuestToList(Student student) {
        GUEST_LIST.add(student);
    }

    @Override
    public void showAllRectorGuests() {
        GUEST_LIST.forEach(System.out::println);
    }

    @Override
    public Student getRectorGuestsById(Integer id) {
        return GUEST_LIST.stream().filter(student -> student.getId().equals(id)).findFirst().get();
    }
}
