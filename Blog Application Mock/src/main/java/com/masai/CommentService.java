package com.masai;

import java.util.List;

public interface CommentService {

	List<Comment> getAllComments() throws CommentException;
	
	Comment getCommentByID(Long commentId) throws CommentException;
	
	public String addComment(Comment comment, Long postId) throws CommentException, PostException;
	
	public String updateComment(Comment comment, Long postID) throws CommentException, PostException;
	
	public String deleteComment(Long postId, Long commentId) throws CommentException, PostException;
	
}
