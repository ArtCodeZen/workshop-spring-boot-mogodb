package com.watpekin.workshopMongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.watpekin.workshopMongo.domain.User;
import com.watpekin.workshopMongo.repository.UserRepository;
import com.watpekin.workshopMongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired	
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(id));
	}
}
