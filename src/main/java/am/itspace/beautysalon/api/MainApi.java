package am.itspace.beautysalon.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainApi {
    @GetMapping("/")
    public String mainApi(){
        return "index";
    }

    @GetMapping("/services")
    public String mainServices(){
        return "services";
    }



}
