package co.monos.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.monos.blog.dao.UserRepository;
import co.monos.blog.domain.User;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User getUser(String email) {
		return userRepository.findByEmail(email);
	}
	
}
