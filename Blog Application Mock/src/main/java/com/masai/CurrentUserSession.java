package com.masai;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class CurrentUserSession {
	
	@Id
	@Column(unique = true)
	private Integer userId;
	private String type;
	private String uuid;
	private LocalDateTime localDateTime;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		CurrentUserSession that = (CurrentUserSession) o;
		return userId != null && Objects.equals(userId, that.userId);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}


