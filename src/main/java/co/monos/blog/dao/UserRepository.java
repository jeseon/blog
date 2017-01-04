package co.monos.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.monos.blog.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByUsernameIgnoreCase(String username);
}
