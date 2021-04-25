package Evizinhotest2.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import Evizinhotest2.model.GamerPost;

@Repository
public interface GamerPostRepository extends PostRepository<GamerPost>{
	public List<GamerPost> findByPlatform(String platform);
	public List<GamerPost> findByGenre(String genre);
	public List<GamerPost> findByCondition(String condition);
}
