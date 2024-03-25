package am.itspace.beautysalon.api;

import am.itspace.beautysalon.entity.User;
import am.itspace.beautysalon.security.CurrentUser;
import am.itspace.beautysalon.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MainApi {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String mainApi() {

        return "index";
    }


    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }


    @GetMapping("/services")
    public String mainServices() {
        return "services";
    }

    @GetMapping("/registration")
    public String register() {
        return "register";

    }

    @PostMapping("/register")
    public String registerPage(@ModelAttribute User user) {
        User byEmail = userService.findByEmail(user.getEmail());
        if (byEmail == null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.save(user);
            log.info("User with {} email already successfully", user.getEmail());
            return "redirect:/user/register?msg= User Registered";
        } else {
            log.info(" User with {} email already registered", user.getEmail());
            return "redirect:/user/register?msg=Email already in use";
        }
    }


    @GetMapping("/search-results")
    public String searchResults() {
        return "search-results";
    }

    @GetMapping("/my-profile")
    public String myProfilePage() {
        return "my-profile";
    }

    @GetMapping("/faq")
    public String faqsApi() {
        return "faq";
    }

    @GetMapping("/barbers")
    public String barbersApi() {
        return "barbers";
    }

    @GetMapping("/our-team")
    public String teamsApi() {
        return "our-team";
    }

    @GetMapping("/appointment")
    public String appointmentPage() {
        return "appointment";
    }

}

