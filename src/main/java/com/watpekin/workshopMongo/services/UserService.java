package com.watpekin.workshopMongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watpekin.workshopMongo.domain.User;
import com.watpekin.workshopMongo.dto.UserDTO;
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
	public User insert(User obj) {
		return repo.insert(obj);
	}
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	public User update(User obj) {
		Optional<User> newObj = repo.findById(obj.getId());
		updateData(newObj.get(), obj);
		return repo.save(obj);
	}
	private void updateData(User newObj, User obj) {
		// TODO Auto-generated method stub
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
}
