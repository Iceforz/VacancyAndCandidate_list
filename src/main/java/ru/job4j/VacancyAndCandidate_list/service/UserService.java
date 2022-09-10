package ru.job4j.VacancyAndCandidate_list.service;

import org.springframework.stereotype.Service;
import ru.job4j.VacancyAndCandidate_list.model.User;
import ru.job4j.VacancyAndCandidate_list.store.UserDBStore;

import java.util.Optional;

@Service
public class UserService {
    private final UserDBStore store;

    public UserService(UserDBStore store) {
        this.store = store;
    }

    public Optional<User> add(User user) {
        return store.add(user);
    }

    public Optional<User> findUserByEmailAndPwd(String email, String password) {
        return store.findUserByEmailAndPwd(email, password);
    }
}
