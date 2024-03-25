package am.itspace.beautysalon.service.impl;

import am.itspace.beautysalon.entity.User;
import am.itspace.beautysalon.repository.UserRepository;
import am.itspace.beautysalon.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public User save(User user) {
        String activationToken = UUID.randomUUID().toString();
        user.setActive(false);
        user.setToken(activationToken);
        User save = userRepository.save(user);
        String verifyUrl = "http://localhost:8080/user/verify?token=" + activationToken;
        //send mail
//        sendMailService.send(user.getEmail(), "Welcome",
//                String.format("Welcome %s . You have successfully registered to our website!!!." ,
//                        "Please open %s for activating your profile",
//                        user.getName(), verifyUrl));
        return save;
    }

    public List<User> findAll() {
        List<User> all = userRepository.findAll();
        log.info("Find all users, users list size {} ", all.size());
        return userRepository.findAll();
    }

    @Override
    public User findByEmail(String email) {

        return userRepository.findByEmail(email).orElse(null);
    }
    @Override
    public User findByToken(String token) {

        return userRepository.findByEmail(token).orElse(null);
    }
}
