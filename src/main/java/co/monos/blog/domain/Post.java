package co.monos.blog.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Post {
	@Id
	@GeneratedValue
	int id;
	
	@NotNull
	@Size(min=1, max=255)
	@Column(nullable=false)
	String title;
	
	@Size(max=255)
	String subtitle;
	
	@NotNull
	@Size(min=1, max=4000)
	@Column(length=4000, nullable=false)
	String content;
	Date regDate;
}
