package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.Faculty;
import org.example.service.FacultyService;

import java.util.Optional;
import java.util.stream.Stream;

@Slf4j
public class FacultyServiceImpl implements FacultyService {

    {
        FACULTY_LIST.add(new Faculty(1, "Kimyo fakulteti"));
        FACULTY_LIST.add(new Faculty(2, "IT fakulteti"));
        FACULTY_LIST.add(new Faculty(3, "Meditsina fakulteti"));
        FACULTY_LIST.add(new Faculty(4, "RobotoTexnika fakulteti"));
        FACULTY_LIST.add(new Faculty(5, "Mexnat fakulteti"));
        FACULTY_LIST.add(new Faculty(6, "Fizika fakulteti"));
    }

    @Override
    public void showAllFaculties() {
        FACULTY_LIST.forEach(faculty -> System.out.println(faculty.getId() + " " + faculty));
    }

    @Override
    public Faculty getFacultyById(Integer id) {
        return FACULTY_LIST.stream().filter(faculty -> faculty.getId().equals(id)).findFirst().get();
    }

    @Override
    public void deleteFaculty(Integer facultyId) {
        FACULTY_LIST.removeIf(faculty -> faculty.getId().equals(facultyId));
    }

    @Override
    public void addFaculty(Faculty faculty) {
        FACULTY_LIST.add(faculty);
    }
}
