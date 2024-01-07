package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Faculty {

    private static Integer sequence = 0;

    {
        sequence++;
    }

    private Integer id = sequence;
    private String name;
}
