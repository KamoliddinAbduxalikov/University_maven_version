package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.enums.UserType;
@Data
@AllArgsConstructor
public class Rector {

    private String rectorName;
    private UserType userType = UserType.RECTOR;
}
