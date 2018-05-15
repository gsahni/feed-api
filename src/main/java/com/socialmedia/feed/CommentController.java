package com.socialmedia.feed;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	PostRepository postRepository;

	@GetMapping("/comments")
	public List<Comment> getComments() {
		return commentRepository.findAll();
	}

	@GetMapping("/comments/{post_id}")
	public List<Comment> getCommentsForPost(@PathVariable(value = "post_id") Long postId) {
		return commentRepository.findByPostId(postId);
	}

	@PostMapping("/posts/{postId}/comments")
	public Comment createComment(@PathVariable(value = "postId") Long postId,
			@Valid @RequestBody Comment comment) {
		Comment newComment = new Comment();
		newComment.setTitle(comment.getTitle());
		newComment.setSoftDeleted(false);

		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundExcption("PostId " + postId + " not found"));
		newComment.setPost(post);

		return commentRepository.save(newComment);
	}

}
