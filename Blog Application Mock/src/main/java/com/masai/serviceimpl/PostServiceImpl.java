package com.masai.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.Post;
import com.masai.exception.PostException;
import com.masai.repository.PostRepository;
import com.masai.service.PostService;


@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepository postRepository;
	
	
	
	@Override
	public List<Post> getAllPosts() throws PostException {
		
		List<Post> posts = postRepository.findAll();
		
		if(posts.isEmpty()) {
			throw new PostException("Posts is empty!");
		}
		return posts;
	}

	@Override
	public Post getPostByID(Long postId) throws PostException {
		
		Post post = postRepository.findById(postId).orElseThrow(()-> new PostException("Post not found by id: "+postId));
		
		return post;
	}

	@Override
	public String addPost(Post post) throws PostException {
		
		Post post2 = postRepository.findByImageUrl(post.getPostImageUrl());
		
		if(post2 != null) {
			throw new PostException("can't add duplicate image url!");
		}
		else {
			postRepository.save(post);
			return "Post Added Successfully!";
		}

	}

	@Override
	public String updatePost(Post post, Long postID) throws PostException {
		
		String message = "not updated!";
		
		Post post2 = postRepository.findById(postID).orElseThrow(()-> new PostException("Post not found by id: "+postID));
		
		if(post2 != null) {
			postRepository.save(post);
			message = "Post Updated Successfully!";
		}
		
		return message;
	}

	@Override
	public String deletePost(Long postId) throws PostException {
		
		String message = "not updated!";
		
		Post post2 = postRepository.findById(postId).orElseThrow(()-> new PostException("Post not found by id: "+postId));
		
		if(post2 != null) {
			postRepository.delete(post2);
			message = "Post deleted Successfully!";
		}
		
		return message;
		

	}

}
