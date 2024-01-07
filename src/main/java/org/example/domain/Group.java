package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Group {

    private static Integer sequence = 0;

    {
        sequence++;
    }

    private Integer id = sequence;
    private String groupName;
    private Integer facultyId;

    public Group(String groupName, Integer facultyId) {
        this.groupName = groupName;
        this.facultyId = facultyId;
    }
}
