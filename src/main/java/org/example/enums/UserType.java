package org.example.enums;


public enum UserType {

    RECTOR(1),
    STUDENT(2),
    GUEST(3);

    private final Integer index;

    UserType(Integer index) {
        this.index = index;
    }

    public static UserType getUserTypeByIndex(Integer index) {
        for (UserType userType : UserType.values()) {
            if (userType.index.equals(index)) {
                return userType;
            }
        }
        return null;
    }

    public static void showUserType() {
        for (UserType userType : UserType.values()) {
            System.out.println(userType.index + " " + userType.name());
        }
    }
}
