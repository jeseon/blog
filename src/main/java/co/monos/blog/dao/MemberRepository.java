package co.monos.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.monos.blog.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	Member findByUsernameIgnoreCase(String username);
}
