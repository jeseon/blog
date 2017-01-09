package co.monos.blog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.monos.blog.dao.MemberRepository;

@Controller
@RequestMapping("/user")
public class MemberController {
	@Autowired
    MemberRepository membetRepository;
	
	@GetMapping("/login")
    public String login() {
        return "user/login";
    }
}