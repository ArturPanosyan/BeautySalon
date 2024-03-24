package am.itspace.beautysalon.service;

import am.itspace.beautysalon.entity.User;

import java.util.List;

public interface UserService {

    User save (User user);

    List<User> findAll();

    User findByEmail(String email);

    User findByToken(String token);
}
