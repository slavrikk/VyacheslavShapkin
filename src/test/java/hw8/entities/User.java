package hw8.entities;

import com.epam.jdi.tools.DataClass;

public class User extends DataClass<User> {
    String name;
    String password;
    String fullName;

    public String getFullName() {
        return fullName;
    }

    public static User ROMAN = new User().set(c -> {
        c.name = "Roman";
        c.password = "Jdi1234";
        c.fullName = "ROMAN IOVLEV";
    });

}
