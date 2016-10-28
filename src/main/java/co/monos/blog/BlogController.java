package co.monos.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BlogController {
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("name", "Test");
		return "index";
	}
}
