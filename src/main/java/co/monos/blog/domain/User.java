package co.monos.blog.domain;

import java.util.Calendar;
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
	@Size(min=1, max=50)
	private String username;

	@NotNull
	@Size(min=1, max=50)
	private String password;
	
	@NotNull
	private Date createdAt = Calendar.getInstance().getTime();
}
