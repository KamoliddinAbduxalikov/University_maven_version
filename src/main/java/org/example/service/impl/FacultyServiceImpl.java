package org.example.service.impl;

import org.example.domain.Faculty;
import org.example.service.FacultyService;

public class FacultyServiceImpl implements FacultyService {

    @Override
    public void showAllFaculties() {
        for (Faculty faculty : FACULTY_LIST) {
            System.out.println(faculty.getId() + " " + faculty);
        }
    }

    @Override
    public Faculty getFacultyById(Integer id) {
        for (Faculty faculty : FACULTY_LIST) {
            if (faculty.getId().equals(id)){
                return faculty;
            }
        }
        return null;
    }

    @Override
    public void deleteFaculty(Integer facultyId) {
        for (Faculty faculty : FACULTY_LIST) {
            if (faculty.getId().equals(facultyId)){
                FACULTY_LIST.remove(faculty);
                break;
            }
        }
    }
}
