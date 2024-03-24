package am.itspace.beautysalon.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainApi {
    @GetMapping("/")
    public String mainApi(){
        return "index";
    }

    @GetMapping("/login")
    public String loginApi(){
        return "login";
    }
//    @GetMapping("/services")
//    public String mainServices(){
//        return "services";
//    }
//
//    @GetMapping("/registration")
//    public String register() {
//        return "register";
//    }
//
//    @GetMapping("/search-results")
//    public String searchResults() {
//        return "search-results";
//    }
//
//        @GetMapping("/my-profile")
//        public String myProfile(){
//            return "my-profile";
//    }
//
//    @GetMapping("/faq")
//    public String faqsApi(){
//        return "faq";
//    }
//
//    @GetMapping("/barbers")
//    public String barbersApi(){
//        return "barbers";
//    }
//
//    @GetMapping("/our-team")
//    public String teamsApi(){
//        return "our-team";
//    }
//
//    @GetMapping("/appointment")
//    public String appointmentPage(){
//        return "appointment";
//    }
//

}
