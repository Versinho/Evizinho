package Evizinhotest2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Evizinhotest2.model.GamerPost;
import Evizinhotest2.repository.GamerPostRepository;


@Service
@Transactional
public class GamerPostService extends AbstractPostService<GamerPost>{
	@Autowired
	private GamerPostRepository gamerPostRepository;
	
	public GamerPostService(GamerPostRepository gamerPostRepository) {
		super(gamerPostRepository);
	}


	@Override
	public List<GamerPost> filter(String category, String subCategory) {
		if(category.equals("location")) {
			return gamerPostRepository.findByLocation(subCategory);
		}
		else if(category.equals("category")) {
			return gamerPostRepository.findByCategory(subCategory);
		}
		else {
			return null;
		}
	}
}
