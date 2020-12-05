package com.watpekin.workshopMongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watpekin.workshopMongo.domain.User;
import com.watpekin.workshopMongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired	
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
}
