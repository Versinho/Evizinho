package Evizinhotest2.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import Evizinhotest2.model.GamerPost;

@Repository
public interface GamerPostRepository extends PostRepository<GamerPost>{
	public List<GamerPost> findByLocation(String location);
	public List<GamerPost> findByCategory(String category);

}
