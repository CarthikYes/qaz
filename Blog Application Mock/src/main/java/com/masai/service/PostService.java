package com.masai.service;

import java.util.List;

import com.masai.entities.Post;
import com.masai.exception.PostException;

public interface PostService {

	public List<Post> getAllPosts() throws PostException;
	
	public Post getPostByID(Long postId) throws PostException;
	
	public String addPost(Post post) throws PostException;
	
	public String updatePost(Post post, Long postID) throws PostException;
	
	public String deletePost(Long postId) throws PostException;
	
}
