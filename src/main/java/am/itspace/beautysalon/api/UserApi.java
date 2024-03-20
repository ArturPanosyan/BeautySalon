package am.itspace.beautysalon.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/v1")
public class UserApi {


    @GetMapping("/user-profile")
    public String userProfile(){
        return "user-profile";
    }





}
