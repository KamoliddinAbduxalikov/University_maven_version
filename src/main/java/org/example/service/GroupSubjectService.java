package org.example.service;

import org.example.domain.Student;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public interface GroupSubjectService {

    Map<Integer,Integer> GROUP_SUBJECT_MAP = Collections.synchronizedMap(new LinkedHashMap<>());
    //  groupId subjectsId

    void showAllSubjectsStudent(Student student);
}
