package co.monos.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.monos.blog.domain.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@GetMapping("/login")
    public String login() {
        return "user/login";
    }
	
	@PostMapping("/login")
    public String login(User user) {
        return "user/login";
    }
}