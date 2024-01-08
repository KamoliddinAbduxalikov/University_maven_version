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
        GROUP_SUBJECT_MAP.put(1,1);
        GROUP_SUBJECT_MAP.put(2,2);
        GROUP_SUBJECT_MAP.put(3,3);
        GROUP_SUBJECT_MAP.put(4,4);
        GROUP_SUBJECT_MAP.put(5,5);
        GROUP_SUBJECT_MAP.put(6,6);
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

    @Override
    public void addGroupSubject(Integer groupId, Integer subjectId) {
        GROUP_SUBJECT_MAP.put(groupId,subjectId);
    }
}
