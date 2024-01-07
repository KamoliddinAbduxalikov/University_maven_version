package org.example.service.impl;

import org.example.domain.Group;
import org.example.domain.GroupSubject;
import org.example.domain.Student;
import org.example.domain.Subject;
import org.example.service.GroupSubjectService;
import org.example.service.SubjectService;

import java.util.Map;

public class GroupSubjectServiceImpl implements GroupSubjectService {

    {
        GROUP_SUBJECT_MAP.put(new Group("G34",1).getId(),new Subject("Fizika").getId());
        GROUP_SUBJECT_MAP.put(new Group("G36",2).getId(),new Subject("Kimyo").getId());
        GROUP_SUBJECT_MAP.put(new Group("F56",1).getId(),new Subject("Fizra").getId());
        GROUP_SUBJECT_MAP.put(new Group("F91",3).getId(),new Subject("Algebra").getId());
        GROUP_SUBJECT_MAP.put(new Group("G12",2).getId(),new Subject("Tarix").getId());
        GROUP_SUBJECT_MAP.put(new Group("G89",3).getId(),new Subject("Ona-tili").getId());
        GROUP_SUBJECT_MAP.put(new Group("G334",1).getId(),new Subject("Geometriya").getId());
    }

    @Override
    public void showAllSubjectsStudent(Student student) {
        SubjectService subjectService = new SubjectServiceImpl();
        for (Map.Entry<Integer, Integer> groupSubject: GROUP_SUBJECT_MAP.entrySet()) {
            if (student.getGroupId().equals(groupSubject.getKey())){
                System.out.println(subjectService.getSubjectById(groupSubject.getValue()));
            }
        }
    }
}
