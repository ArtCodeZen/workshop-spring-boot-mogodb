package com.watpekin.workshopMongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.watpekin.workshopMongo.domain.Post;
import com.watpekin.workshopMongo.repository.PostRepository;
import com.watpekin.workshopMongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired	
	private PostRepository repo;
	
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(id));
	}
	public List<Post> findByTitle(String text){
		return repo.findByTitleContainingIgnoreCase(text);
	}
	
}
