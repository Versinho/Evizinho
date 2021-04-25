package Evizinhotest2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Evizinhotest2.model.UnivPost;
import Evizinhotest2.repository.UnivPostRepository;


@Service
@Transactional
public class GamerPostService extends AbstractPostService<UnivPost>{
	@Autowired
	private UnivPostRepository univPostRepository;
	
	public GamerPostService(UnivPostRepository univPostRepository) {
		super(univPostRepository);
	}
	
	/*public List<GamerPost> getPostsByPlatform(String platform){
		return gamerPostRepository.findByPlatform(platform);
	}
	public List<GamerPost> getPostsByGenre(String genre){
		return gamerPostRepository.findByGenre(genre);
	}
	public List<GamerPost> getPostsByCondition(String condition){
		return gamerPostRepository.findByCondition(condition);
	}*/

	@Override
	public List<UnivPost> filter(String category, String subCategory) {
		if(category.equals("plataforma")) {
			return univPostRepository.findByPlatform(subCategory);
		}
		else if(category.equals("genero")) {
			return univPostRepository.findByGenre(subCategory);
		}
		else if(category.equals("condicao")) {
			return univPostRepository.findByCondition(subCategory);
		}
		else {
			return null;
		}
	}
}
