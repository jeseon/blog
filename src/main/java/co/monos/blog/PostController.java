package co.monos.blog;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.monos.blog.dao.PostDao;
import co.monos.blog.domain.Post;

@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostDao postDao;

	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String form(Post post) {
		return "new";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String write(@Valid Post post, BindingResult bindingResult) {
	    if (bindingResult.hasErrors()) {
	        return "new";
	    }
		post.setRegDate(new Date());
		return "redirect:/post/" + postDao.save(post).getId();
	}

	@RequestMapping("/list")
	public String list(Model model) {
		List<Post> postList = postDao.findAll();
		model.addAttribute("postList", postList);
		return "list";
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String view(Model model, @PathVariable int id) {
		Post post = postDao.findOne(id);
		model.addAttribute("post", post);
		return "post";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable int id) {
		postDao.delete(id);
		return "redirect:/post/list";
	}
}
