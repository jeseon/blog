package co.monos.blog.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class User extends org.springframework.security.core.userdetails.User {
	private static final long serialVersionUID = -5051875946463295191L;
	private Member member;
	
	public Member getMember() {
		return member;
	}
	
	public User(Member member, String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		
		this.member = member;
	}
}
