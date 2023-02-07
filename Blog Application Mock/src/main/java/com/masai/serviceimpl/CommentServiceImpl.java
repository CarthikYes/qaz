package com.masai.serviceimpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entities.Comment;
import com.masai.entities.Post;
import com.masai.exception.CommentException;
import com.masai.exception.PostException;
import com.masai.repository.CommentRepository;
import com.masai.repository.PostRepository;
import com.masai.service.CommentService;


@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	
	@Override
	public List<Comment> getAllComments() throws CommentException {
		
		List<Comment> comments = commentRepository.findAll();
		
		if(comments.isEmpty()) {
			throw new CommentException("Comment List is empty!");
		}
		else {
			return comments;
		}
		
	}

	@Override
	public Comment getCommentByID(Long commentId) throws CommentException {

		Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new CommentException("Comment not found!"));

		return comment;
	}

	@Override
	public String addComment(Comment comment, Long postId) throws CommentException, PostException {
		
		Post post2 = postRepository.findById(postId).orElseThrow(()-> new PostException("Post not found!"));
		
		if(post2 != null) {
			
			post2.getList().add(comment);
			
			postRepository.save(post2);
			
			return "Comment Added Successfully!";
		}
		
		throw new CommentException("Comment not added!");
	}

	@Override
	public String updateComment(Comment comment, Long postID) throws CommentException, PostException {
		
		String message = "Comment not updated!";
		
		Optional<Comment> commentOptional = commentRepository.findById(comment.getCommentId());
		
		if(commentOptional.isPresent()) {
			
			Post post = postRepository.findById(postID).orElseThrow(()-> new PostException("Post not found..."));
		
			if(post != null) {

				post.getList().set(0, comment);
				postRepository.save(post);
					
				message = "Comment updated Successfully!";
			}
			
		}
		
		return message;
		
		
	}

	@Override
	public String deleteComment(Long postID, Long commentId) throws CommentException, PostException {

		
		String message = "Comment not deleted!";
		
		
		Post post = postRepository.findById(postID).orElseThrow(()-> new PostException("Post not found..."));
		
		if(post != null) {
			
			Comment comment = commentRepository.findById(commentId).orElseThrow(()-> new CommentException("Comment not found!"));
		
			if(comment != null) {

				for(int i=0; i<post.getList().size(); i++) {
					
					if(post.getList().get(i).getCommentId()==commentId) {
						
						post.getList().remove(i);
					}
				}
				
				commentRepository.delete(comment);
				message = "Comment deleted Successfully!";
			}
			
		}
		
		return message;
		
	}

}











