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

	@GetMapping("/new")
	public String write(Post post) {
		return "posts/new";
	}

	@PostMapping("/new")
	public String write(@Valid Post post, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
	        return "posts/new";
	    }
		
		Post newPost = postService.save(post);
		
		return "redirect:/posts/" + newPost.getId();
	}
	
	@GetMapping("/{id}")
	public String view(@PathVariable int id, Model model) {
		Post post = postService.get(id);
		model.addAttribute("post", post);

		return "posts/view";
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		postService.delete(id);
		
		return "redirect:/posts";
	}
	
	@GetMapping("/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		Post post = postService.get(id);
		model.addAttribute("post", post);

		return "posts/new";
	}
}
