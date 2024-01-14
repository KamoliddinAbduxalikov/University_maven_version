package org.example.service.impl;

import org.example.domain.Group;
import org.example.service.FacultyGroupService;

public class FacultyGroupServiceImpl implements FacultyGroupService {

    {
        FACULTY_GROUP_LIST.add(new Group(1, "gG34", 1));
        FACULTY_GROUP_LIST.add(new Group(1, "F34", 1));
        FACULTY_GROUP_LIST.add(new Group(2, "F4", 2));
        FACULTY_GROUP_LIST.add(new Group(2, "H34", 2));
        FACULTY_GROUP_LIST.add(new Group(3, "Y24", 3));
        FACULTY_GROUP_LIST.add(new Group(3, "g4", 3));
        FACULTY_GROUP_LIST.add(new Group(4, "gG3", 4));
        FACULTY_GROUP_LIST.add(new Group(4, "gY34", 4));
        FACULTY_GROUP_LIST.add(new Group(5, "gIG34", 5));
        FACULTY_GROUP_LIST.add(new Group(5, "gPG34", 5));
        FACULTY_GROUP_LIST.add(new Group(6, "gLG34", 6));
        FACULTY_GROUP_LIST.add(new Group(6, "gMG34", 6));
    }

    @Override
    public void showAllFacultyGroups(Integer facultyId) {
        FACULTY_GROUP_LIST.stream()
                .filter(group -> group.getFacultyId().equals(facultyId))
                .forEach(System.out::println);
    }

    @Override
    public void addFacultyGroup(Group group) {
        FACULTY_GROUP_LIST.add(group);
    }
}
