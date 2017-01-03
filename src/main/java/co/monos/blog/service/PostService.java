package co.monos.blog.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.monos.blog.dao.PostRepository;
import co.monos.blog.domain.Post;

@Service
@Transactional
public class PostService {
	@Autowired
	private PostRepository postRepository;
	
	public Post save(Post post) {
		post.setCreatedAt(new Date());
		
		return postRepository.save(post);
	}

	public void delete(int id) {
		postRepository.delete(id);
	}

	@Transactional(readOnly = true)
	public Post get(int id) {
		return postRepository.findOne(id);
	}
	
	@Transactional(readOnly = true)
	public List<Post> getList() {
		return postRepository.findAll();
	}
}