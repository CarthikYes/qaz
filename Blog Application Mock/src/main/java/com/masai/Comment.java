package com.masai;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commentId;
	
	private String commentDescription;
	
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Post post;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		Comment comment = (Comment) o;
		return commentId != null && Objects.equals(commentId, comment.commentId);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
