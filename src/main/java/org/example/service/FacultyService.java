package org.example.service;

import org.example.domain.Faculty;

import java.util.LinkedList;
import java.util.List;

public interface FacultyService {

    List<Faculty> FACULTY_LIST = new LinkedList<>();

    void showAllFaculties();

    Faculty getFacultyById(Integer id);

    void deleteFaculty(Integer facultyId);
}
