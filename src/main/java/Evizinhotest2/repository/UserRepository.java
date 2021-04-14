package Evizinhotest2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Evizinhotest2.model.AbstractUser;

@Repository
public interface UserRepository extends JpaRepository<AbstractUser, Integer> {
	AbstractUser findByUsername(String username);
}
