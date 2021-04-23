package Evizinhotest2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import Evizinhotest2.model.Post;



@NoRepositoryBean
public interface PostRepository<T extends Post> extends JpaRepository<T, Integer> {
	public List<T> findByUserId(Integer userId);
}
