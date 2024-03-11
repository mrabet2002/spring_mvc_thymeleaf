package ma.enset.jpa_hibernate.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("security")
@RequiredArgsConstructor
public class SecurityController {
    @GetMapping("access-denied")
    public String getPatients() {
        return "403";
    }
    @GetMapping("login")
    public String login() {
        return "login";
    }

}
