package am.itspace.beautysalon.api;

import am.itspace.beautysalon.entity.Role;
import am.itspace.beautysalon.entity.User;
import am.itspace.beautysalon.security.CurrentUser;
import am.itspace.beautysalon.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("v1/user")
public class UserApi {


    private final UserService userService;
    private final PasswordEncoder passwordEncoder;



    @GetMapping("/verify")
    public String verifyUser(@RequestParam("token") String token){
        User byToken = userService.findByToken(token);
        if(byToken == null){
            return "redirect:/";
        }
        if(byToken.isActive()){
            log.error("User already active! {} ", byToken.getEmail());
        }

        byToken.setActive(true);
        byToken.setToken(null);

        userService.save(byToken);
        return "redirect:/";
    }

    @GetMapping("/activationPage")
    public String activationPage(){
        return "activationPage";
    }


}

