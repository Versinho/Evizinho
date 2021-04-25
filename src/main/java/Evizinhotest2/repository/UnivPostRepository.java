package Evizinhotest2.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import Evizinhotest2.model.UnivPost;

@Repository
public interface UnivPostRepository extends PostRepository<UnivPost>{
	public List<UnivPost> findByPlatform(String platform);
	public List<UnivPost> findByGenre(String genre);
	public List<UnivPost> findByCondition(String condition);
}
