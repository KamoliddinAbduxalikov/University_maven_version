package org.example.service;

import org.example.domain.Group;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface FacultyGroupService {

    List<Group> FACULTY_GROUP_LIST = Collections.synchronizedList(new ArrayList<>());

    void showAllFacultyGroups(Integer facultyId);

    void addFacultyGroup(Group group);
}
