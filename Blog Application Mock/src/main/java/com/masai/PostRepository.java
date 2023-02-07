package com.masai;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.masai.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

	@Query("from Post where postImageUrl = ?1")
	public Post findByImageUrl(String url);
	
}
