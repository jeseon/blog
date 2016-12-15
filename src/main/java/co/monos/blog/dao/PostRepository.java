package co.monos.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.monos.blog.domain.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
