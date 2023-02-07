package com.masai;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

	@Autowired
	private PostServiceImpl postServiceImpl;
	
	
	@GetMapping("/getposts")
	public ResponseEntity<List<Post>> getAllPostsHandler() throws PostException {
		
		List<Post> getPosts = postServiceImpl.getAllPosts();
		
		return new ResponseEntity<List<Post>>(getPosts, HttpStatus.OK);
	}
	
	@GetMapping("/getpost/{postId}")
	public ResponseEntity<Post> getPostByIdHandler(@PathVariable Long postId) throws PostException {
		
		Post getPost = postServiceImpl.getPostByID(postId);
		
		return new ResponseEntity<Post>(getPost, HttpStatus.OK);
	}
	
	
	@PostMapping("/addpost")
	public ResponseEntity<String> addPostHandler(@RequestBody Post post) throws PostException {
		
		String addPost = postServiceImpl.addPost(post);
		
		return new ResponseEntity<String>(addPost, HttpStatus.ACCEPTED);
	}
	
	

	@PutMapping("/updatepost/{postId}")
	public ResponseEntity<String> updatePostHandler(@RequestBody Post post, @PathVariable Long postId) throws PostException {
		
		String updatePost = postServiceImpl.updatePost(post, postId);
		
		return new ResponseEntity<String>(updatePost, HttpStatus.ACCEPTED);
	}
	
	

	@DeleteMapping("/deletepost/{postId}")
	public ResponseEntity<String> deletePostHandler(@PathVariable Long postId) throws PostException {
		
		String deletePost = postServiceImpl.deletePost(postId);
		
		return new ResponseEntity<String>(deletePost, HttpStatus.OK);
	}
	
	
	
	
}

















