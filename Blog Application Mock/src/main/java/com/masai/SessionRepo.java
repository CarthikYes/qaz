package com.masai;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.CurrentUserSession;

public interface SessionRepo extends JpaRepository<CurrentUserSession, Integer>{
	
	public CurrentUserSession findByUuid(String uuid);
}
