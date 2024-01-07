package org.example.domain;

import lombok.Data;

@Data
public class Subject {

    private static Integer sequence = 0;

    {
        sequence++;
    }

    private Integer id = sequence;
    private String name;

    public Subject(String name) {
        this.name = name;
    }
}
