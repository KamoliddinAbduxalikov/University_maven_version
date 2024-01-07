package org.example.service;

import org.example.domain.Subject;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public interface SubjectService {

    List<Subject> SUBJECT_LIST = Collections.synchronizedList(new LinkedList<>());

    Subject getSubjectById(Integer id);
}
