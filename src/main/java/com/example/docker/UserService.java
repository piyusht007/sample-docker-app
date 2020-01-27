package com.example.docker;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> users;

    @PostConstruct
    public void init() {
        users = new ArrayList<>();
        final User akash = createUser("S01", "Akash", "Oist", "Electronics & Telecommunications", 29);
        final User piyush = createUser("S02", "Piyush", "Bist", "Information Technology", 30);

        users.add(akash);
        users.add(piyush);
    }

    private User createUser(final String id, final String name, final String collegeName, final String departmentName, final int age) {
        final User user = new User();

        user.setId(id);
        user.setName(name);
        user.setCollegeName(collegeName);
        user.setAge(age);
        user.setDepartmentName(departmentName);
        return user;
    }

    public List<User> getUsers() {
        return users;
    }
}
