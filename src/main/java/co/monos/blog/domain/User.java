package co.monos.blog.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue
	private int id;

	@NotNull
	@Size(min=1, max=255)
	private String email;
	
	@NotNull
	@Size(min=1, max=255)
	private String username;

	@NotNull
	@Size(min=1, max=50)
	private String password;

	private Date createdAt;
	private boolean isEnabled;
	private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
}
