package Evizinhotest2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Evizinhotest2.model.Post;
import Evizinhotest2.repository.PostRepository;

@Service
@Transactional
public abstract class AbstractPostService<T extends Post> {
	
	@Autowired
	private PostRepository<T> postRepository;
	
	public AbstractPostService(PostRepository<T> postRepository){
		this.postRepository = postRepository;
	}
	
	public List<T> getAllPosts(){
		return postRepository.findAll();
	}
	public void addPost(T post) throws Exception{
		if(post.verify()) {
			postRepository.save(post);
		}
		else {
			throw new Exception();
		}
	}
	public Optional<T> getPost(Integer id){
		return postRepository.findById(id);
	}
	public void updatePost(Integer id, T post) {
		postRepository.save(post);
	}
	public void deletePost(Integer id) {
		postRepository.deleteById(id);
	}
	public List<T> getPostsByUser(Integer userId){
		return postRepository.findByUserId(userId);
	}
}
