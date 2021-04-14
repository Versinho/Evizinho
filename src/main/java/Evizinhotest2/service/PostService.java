package Evizinhotest2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import Evizinhotest2.repository.PostRepository;
import Evizinhotest2.strategy.Post;

@Service
@Transactional(readOnly = true)
public class PostService {
	@Autowired
	public PostRepository postRepository;
		
	public List<Evizinhotest2.strategy.Post> getAllPosts() {
		
	    List<Post> posts = new ArrayList<>();
		
	    postRepository.findAll()
	    .forEach(posts::add);
		
	    return posts;		
	}
	
	@Transactional(readOnly = false)
	public void addPost(Post post) {
	     postRepository.save(post);
	}
	
	public Optional<Post> getPost(Integer id) {
	     return postRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public void updatePost(Integer id, Post post) {
	     postRepository.save(post);
	}
	
	@Transactional(readOnly = false)
	public void deletePost(Integer id) {
	     postRepository.deleteById(id);
	}
	
	public List<Post> getPostsByUser(Integer id) {
		List<Post> posts = new ArrayList<>();
		   
		postRepository.findByUserId(id)
		.forEach(posts::add);
		   
		return posts;	 
		}

}
