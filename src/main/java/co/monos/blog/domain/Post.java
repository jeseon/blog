package co.monos.blog.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Post {
	@Id
	@GeneratedValue
	private int id;

	@NotNull
	@Size(min=1, max=255)
	private String title;
	
	@Null
	private String subtitle;

	@NotNull
	@Size(min=1, max=4000)
	private String content;

	private Date regDate;
}