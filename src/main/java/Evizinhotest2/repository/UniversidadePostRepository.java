package Evizinhotest2.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import Evizinhotest2.model.UniversidadePost;

@Repository
public interface UniversidadePostRepository extends PostRepository<UniversidadePost>{
	public List<UniversidadePost> findByCategory(String category);
	public List<UniversidadePost> findByLocation(String location);
}
