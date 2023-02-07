package com.masai.service;

import java.util.List;

import com.masai.entities.Comment;
import com.masai.exception.CommentException;
import com.masai.exception.PostException;

public interface CommentService {

	public List<Comment> getAllComments() throws CommentException;
	
	public Comment getCommentByID(Long commentId) throws CommentException;
	
	public String addComment(Comment comment, Long postId) throws CommentException, PostException;
	
	public String updateComment(Comment comment, Long postID) throws CommentException, PostException;
	
	public String deleteComment(Long postId, Long commentId) throws CommentException, PostException;
	
}
