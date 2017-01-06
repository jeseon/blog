package co.monos.blog.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class UserInfo extends User {
	private static final long serialVersionUID = 7858240153992892402L;
	private int memberId;
	
	public UserInfo(int memberId, String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		
		this.memberId = memberId;
	}
}
