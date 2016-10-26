package co.monos.blog.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Post {
	@Id
	@GeneratedValue
	int id;
	String title;
	String content;
}
