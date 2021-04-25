package Evizinhotest2.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import Evizinhotest2.model.FaculPost;

@Repository
public interface UnivPostRepository extends PostRepository<FaculPost>{
	public List<FaculPost> findByLocation(String location);
	public List<FaculPost> findByCategory(String category);

}
