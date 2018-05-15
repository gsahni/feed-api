package com.socialmedia.feed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

	@Autowired
	PostRepository postrepository;

//	@GetMapping(name = "/posts")
//	public Page<Post> getPosts(Pageable pageable) {
//		return postrepository.findAll(pageable);
//	}
	
	@GetMapping(name="/posts")
	public List<Post> getPostsForAccount() {
		return postrepository.customMethod();
	}

	@PostMapping(name = "/posts")
	public Post savePost(@RequestBody Post post) {
		post.setSoftDeleted(false);
		return postrepository.save(post);
	}
}
