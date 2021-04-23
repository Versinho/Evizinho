package Evizinhotest2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Evizinhotest2.model.CondominoPost;
import Evizinhotest2.repository.CondominoPostRepository;


@Service
@Transactional
public class PostService extends AbstractPostService<CondominoPost>{
	@Autowired
	private CondominoPostRepository condominoPostRepository;
	
	public PostService(CondominoPostRepository condominoPostRepository) {
		super(condominoPostRepository);
	}
	
	public List<CondominoPost> getPostsByTitle(String title){
		return condominoPostRepository.findByTitle(title);
	}
	

}
