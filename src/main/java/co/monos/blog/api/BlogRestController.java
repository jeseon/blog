package co.monos.blog.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.monos.blog.dao.PostDao;
import co.monos.blog.domain.Post;

@RestController
public class BlogRestController {
	@Autowired
	PostDao postDao;
	
	@RequestMapping("/api")
	public String index() {
		return "Index";
	}
	
	@RequestMapping("/api/add")
	public Post add(Post post) {
		return postDao.save(post);
	}
	
	@RequestMapping("/api/list")
	public List<Post> list(Post post) {
		return postDao.findAll();
	}
}
