package org.example.service.impl;

import org.example.domain.Subject;
import org.example.service.SubjectService;

public class SubjectServiceImpl implements SubjectService {
    @Override
    public Subject getSubjectById(Integer id) {
        for (Subject subject : SUBJECT_LIST) {
            if(subject.getId().equals(id)){
                return subject;
            }
        }
        return null;
    }
}
