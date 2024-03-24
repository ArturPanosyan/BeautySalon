package am.itspace.beautysalon.security;

import am.itspace.beautysalon.entity.User;
import am.itspace.beautysalon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurrentUserDetailServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEmail = userService.findByEmail(username);
        if (userEmail == null) {
            throw new UsernameNotFoundException("User with " + username + " does not exists!");
        }
        return new CurrentUser(userEmail);
    }
}

