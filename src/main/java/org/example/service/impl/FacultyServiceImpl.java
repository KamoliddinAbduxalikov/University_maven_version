package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.Faculty;
import org.example.service.FacultyService;
@Slf4j
public class FacultyServiceImpl implements FacultyService {

    {
        FACULTY_LIST.add(new Faculty(1,"Kimyo fakulteti"));
        FACULTY_LIST.add(new Faculty(2,"IT fakulteti"));
        FACULTY_LIST.add(new Faculty(3,"Meditsina fakulteti"));
        FACULTY_LIST.add(new Faculty(4,"RobotoTexnika fakulteti"));
        FACULTY_LIST.add(new Faculty(5,"Mexnat fakulteti"));
        FACULTY_LIST.add(new Faculty(6,"Fizika fakulteti"));
    }

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
        log.error("Faculty not found !");
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

    @Override
    public void addFaculty(Faculty faculty) {
        FACULTY_LIST.add(faculty);
    }
}
