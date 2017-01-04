package co.monos.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.monos.blog.dao.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
    UserRepository userRepository;
	
	@GetMapping("/login")
    public String login() {
        return "user/login";
    }
}