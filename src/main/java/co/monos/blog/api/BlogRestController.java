package co.monos.blog.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.monos.blog.domain.Post;
import co.monos.blog.service.PostService;

@RestController
public class BlogRestController {
	@Autowired
	private PostService postService;
	
	@RequestMapping("/api")
	public String index() {
		return "Index";
	}
	
	@RequestMapping("/api/add")
	public Post add(Post post) {
		return postService.save(post);
	}
	
	@RequestMapping("/api/list")
	public List<Post> list(Post post) {
		return postService.getList();
	}
}
