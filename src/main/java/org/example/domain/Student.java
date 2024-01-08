package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.enums.UserType;

@Data
public class Student {

    private static Integer sequence = 0;

    {
        sequence++;
    }

    private String name;
    private Integer age;
    private String studentPhoneNumber;
    private Integer id = sequence;
    private Integer groupId;
    private String password;
    private Integer facultyId;
    private UserType userType = UserType.GUEST;
    private String email;

    public Student(String name, Integer age, String studentPhoneNumber, String password, Integer facultyId, String email) {
        this.name = name;
        this.age = age;
        this.studentPhoneNumber = studentPhoneNumber;
        this.password = password;
        this.facultyId = facultyId;
        this.email = email;
    }
}
