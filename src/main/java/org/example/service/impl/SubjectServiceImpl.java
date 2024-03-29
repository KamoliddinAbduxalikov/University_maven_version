package org.example.service.impl;

import org.example.domain.Subject;
import org.example.service.SubjectService;

public class SubjectServiceImpl implements SubjectService {

    {
        SUBJECT_LIST.add(new Subject(1,"Kimyo"));
        SUBJECT_LIST.add(new Subject(2,"Fizika"));
        SUBJECT_LIST.add(new Subject(3,"Informatika"));
        SUBJECT_LIST.add(new Subject(4,"Algebra"));
        SUBJECT_LIST.add(new Subject(5,"Fizra"));
        SUBJECT_LIST.add(new Subject(6,"Tarix"));
    }

    @Override
    public Subject getSubjectById(Integer id) {
         return SUBJECT_LIST.stream().filter(subject -> subject.getId().equals(id)).findFirst().get();
    }

    @Override
    public void addSubject(Subject subject) {
        SUBJECT_LIST.add(subject);
    }
}
