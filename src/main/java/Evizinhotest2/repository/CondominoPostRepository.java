package Evizinhotest2.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import Evizinhotest2.model.CondominoPost;

@Repository
public interface CondominoPostRepository extends PostRepository<CondominoPost>{
	public List<CondominoPost> findByTitle(String Title);
}
