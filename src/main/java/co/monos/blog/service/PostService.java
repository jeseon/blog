package co.monos.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.monos.blog.dao.MemberRepository;
import co.monos.blog.dao.PostRepository;
import co.monos.blog.domain.Member;
import co.monos.blog.domain.Post;
import co.monos.blog.domain.UserInfo;

@Service
@Transactional
public class PostService {
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	public Post save(Post post) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = (UserInfo) auth.getPrincipal();
		Member member = memberRepository.findOne(userInfo.getMemberId());
		
		post.setMember(member);
		
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