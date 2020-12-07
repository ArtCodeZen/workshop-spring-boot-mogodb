package com.watpekin.workshopMongo.config;



import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.watpekin.workshopMongo.domain.Post;
import com.watpekin.workshopMongo.domain.User;
import com.watpekin.workshopMongo.dto.AuthorDTO;
import com.watpekin.workshopMongo.dto.CommentDTO;
import com.watpekin.workshopMongo.repository.PostRepository;
import com.watpekin.workshopMongo.repository.UserRepository;
@Configuration
public class Instantiation implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository PostRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		userRepository.deleteAll();
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para SP", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("11/10/2020"), "Partiu ferias", "Vou ficar em casa", new AuthorDTO(alex));
		
		CommentDTO c1 = new CommentDTO("Boa viagem brother", sdf.parse("21/02/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Boa viagem brother", sdf.parse("10/02/2018"), new AuthorDTO(maria));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		
		PostRepository.saveAll(Arrays.asList(post1, post2));
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
	}

}
