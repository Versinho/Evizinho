package Evizinhotest2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Evizinhotest2.model.UniversidadePost;
import Evizinhotest2.repository.UniversidadePostRepository;


@Service
@Transactional
public class UniversidadePostService extends AbstractPostService<UniversidadePost>{
	@Autowired
	private UniversidadePostRepository universidadePostRepository;
	
	public UniversidadePostService(UniversidadePostRepository universidadePostRepository) {
		super(universidadePostRepository);
	}

	@Override
	public List<UniversidadePost> filter(String category, String subCategory) {
		if(category.equals("category")) {
			return universidadePostRepository.findByCategory(subCategory);
		}
		else if (category.equals("location")) {
			return universidadePostRepository.findByLocation(subCategory);
		}
		else {
			return null;
		}
	}
}
