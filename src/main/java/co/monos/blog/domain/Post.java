package co.monos.blog.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Post {
	@Id
	@GeneratedValue
	private int id;

	@NotNull
	private String title;

	@NotNull
	private String content;

	private Date regDate;
}