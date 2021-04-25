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
	public List<GamerPost> filter(String category, String subCategory) {
		if(category.equals("plataforma")) {
			return gamerPostRepository.findByPlatform(subCategory);
		}
		else if(category.equals("genero")) {
			return gamerPostRepository.findByGenre(subCategory);
		}
		else if(category.equals("condicao")) {
			return gamerPostRepository.findByCondition(subCategory);
		}
		else {
			return null;
		}
	}
}
