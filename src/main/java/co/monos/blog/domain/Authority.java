package co.monos.blog.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Authority {
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	private String username;
	
	@NotNull
	private String autorityName;
}
