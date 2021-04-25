package Evizinhotest2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Evizinhotest2.model.FaculPost;
import Evizinhotest2.repository.UnivPostRepository;


@Service
@Transactional
public class UnivPostService extends AbstractPostService<FaculPost>{
	@Autowired
	private UnivPostRepository univPostRepository;
	
	public UnivPostService(UnivPostRepository univPostRepository) {
		super(univPostRepository);
	}


	@Override
	public List<FaculPost> filter(String category, String subCategory) {
		if(category.equals("location")) {
			return univPostRepository.findByLocation(subCategory);
		}
		else if(category.equals("category")) {
			return univPostRepository.findByCategory(subCategory);
		}
		else {
			return null;
		}
	}
}
