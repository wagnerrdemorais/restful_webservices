package com.wagnerrdemorais.restful_webservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int usersCount = 0;

    static {
        users.add(User.builder()
                .id(++usersCount)
                .name("Adam")
                .birthDate(LocalDate.now().minusYears(30))
                .build()
        );
        users.add(User.builder()
                .id(++usersCount)
                .name("Eve")
                .birthDate(LocalDate.now().minusYears(29))
                .build()
        );
        users.add(User.builder()
                .id(++usersCount)
                .name("Bartosz")
                .birthDate(LocalDate.now().minusYears(31))
                .build()
        );
    }

    public List<User> findAll() {
        return users;
    }

    public Optional<User> findById(int userId) {
        return users.stream()
                .filter(userById(userId))
                .findFirst();
    }

    private Predicate<User> userById(int userId) {
        return u -> u.getId() == userId;
    }

    public User addUser(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public boolean delete(Integer id) {
        return users.removeIf(userById(id));
    }
}
