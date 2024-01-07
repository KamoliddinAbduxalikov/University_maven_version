package org.example.service.impl;

import org.example.domain.Group;
import org.example.service.FacultyGroupService;

public class FacultyGroupServiceImpl implements FacultyGroupService {

    @Override
    public void showAllFacultyGroups(Integer facultyId) {
        for (Group group : FACULTY_GROUP_LIST) {
            if (group.getFacultyId().equals(facultyId)) {
                System.out.println(group.getId() + " " + group);
            }
        }
    }
}
