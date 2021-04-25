package Evizinhotest2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;


import Evizinhotest2.model.AbstractUser;
import Evizinhotest2.repository.UserRepository;

@Service
@Transactional(readOnly = true)
public class UserService <T extends AbstractUser>{
	@Autowired
	public UserRepository userRepository;
		
	public List<AbstractUser> getAllUsers() {
		
	    List<AbstractUser> users = new ArrayList<>();
		
	    userRepository.findAll()
	    .forEach(users::add);
		
	    return users;
	}
	
	@Transactional(readOnly = false)
	public void addUser(T user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
	    userRepository.save(user);
	}
	
	public Optional<AbstractUser> getUser(Integer id) {
	     return userRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public T updateUser(Integer id, T user) {
	     userRepository.save(user);
	     return user;
	}
	
	@Transactional(readOnly = false)
	public void deleteUser(Integer id) {
	     userRepository.deleteById(id);
	}
	

}
