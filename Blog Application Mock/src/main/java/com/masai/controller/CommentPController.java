package com.masai.controller;

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

import com.masai.entities.Comment;
import com.masai.exception.CommentException;
import com.masai.exception.PostException;
import com.masai.serviceimpl.CommentServiceImpl;

@RestController
public class CommentPController {

	@Autowired
	private CommentServiceImpl commentServiceImpl;
	
	@GetMapping("/getComments")
	public ResponseEntity<List<Comment>> getAllCommentsHandler() throws CommentException {
		
		List<Comment> comments = commentServiceImpl.getAllComments();
		
		return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
	}
	
	
	@GetMapping("/getComments/{commentId}")
	public ResponseEntity<Comment> getCommentByIdHandler(@PathVariable Long commentId) throws CommentException {
		
		Comment comment = commentServiceImpl.getCommentByID(commentId);
		
		return new ResponseEntity<Comment>(comment, HttpStatus.OK);
	}
	

	@PostMapping("/addComment/{postId}")
	public ResponseEntity<String> addCommentByIdHandler(@RequestBody Comment comment ,@PathVariable Long postId) throws CommentException, PostException {
		
		String addComment = commentServiceImpl.addComment(comment, postId);
		
		return new ResponseEntity<String>(addComment, HttpStatus.ACCEPTED);
	}
	
	
	@PutMapping("/updateComment/{postId}")
	public ResponseEntity<String> updateCommentByIdHandler(@RequestBody Comment comment ,@PathVariable Long postId) throws CommentException, PostException {
		
		String updateComment = commentServiceImpl.updateComment(comment, postId);
		
		return new ResponseEntity<String>(updateComment, HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/deleteComment/{postId}/{commentId}")
	public ResponseEntity<String> getCommentByIdHandler(@PathVariable Long postId, @PathVariable Long commentId) throws CommentException, PostException {
		
		String deleteComment = commentServiceImpl.deleteComment(postId, commentId);
		
		return new ResponseEntity<String>(deleteComment, HttpStatus.OK);
	}
	
	
}



















