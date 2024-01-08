package org.example.service;

import org.example.domain.Student;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public interface RectorService {

    List<Student> GUEST_LIST = Collections.synchronizedList(new LinkedList<>());
    // Oqishka kirmoqchi bogan stundetlani royxati

    void acceptStudentsRequest(Student student, Integer groupId);

    void addGuestToList(Student student);
    // royhatga qoshish

    void showAllRectorGuests();

    Student getRectorGuestsById(Integer id);
}
