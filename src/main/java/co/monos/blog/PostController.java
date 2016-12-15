package co.monos.blog;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.monos.blog.domain.Post;
import co.monos.blog.service.PostService;

@Controller
@RequestMapping("/posts")
public class PostController {
	@Autowired
	private PostService postService;
	
	@GetMapping
	public String list(Model model) {
		List<Post> postList = postService.getList();
		model.addAttribute("postList", postList);
		return "posts/list";
	}
	
	@GetMapping("/{id}")
	public String view(@PathVariable int id, Model model) {
		Post post = postService.get(id);
		model.addAttribute("post", post);

		return "posts/view";
	}

	@GetMapping("/new")
	public String form(Post post) {
		return "posts/new";
	}

	@PostMapping("/new")
	public String write(@Valid Post post, BindingResult bindingResult, Model model) {
		Post newPost = postService.save(post);
		
		return "redirect:/posts/" + newPost.getId();
	}

	@DeleteMapping("/{id}")
	public @ResponseBody String delete(@PathVariable int id) {
		postService.delete(id);
		
		return "redirect:/posts";
	}
}
