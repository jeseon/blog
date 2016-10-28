package co.monos.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.monos.blog.domain.Post;

public interface PostDao extends JpaRepository<Post, Integer> {

}
