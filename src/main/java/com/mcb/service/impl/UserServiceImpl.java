package com.mcb.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mcb.entity.User;
import com.mcb.model.UserDTO;
import com.mcb.repository.UserRepository;
import com.mcb.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
    private  UserRepository userRepository;
	@Autowired
    private  BCryptPasswordEncoder passwordEncoder;
    public User getUserByUsername (String username) {
        return userRepository.findByUsername(username).orElseGet(User::new);
    }
    
    public User updateAttempt(String username) {
    	User user=userRepository.findByUsername(username).orElseGet(User::new);
    	user.setAttempt(user.getAttempt()+1);
    	if(user.getAttempt()<=2)
    		user.setLastUpdatedDate(LocalDateTime.now());
    	return userRepository.save(user);
    }

	public User resetAttemptToZero(String username) {
		User user=userRepository.findByUsername(username).orElseGet(User::new);
    	user.setAttempt(0L);
    	System.out.println("save successful!");
    	return userRepository.save(user);
	}
    
	
	public void createUser(UserDTO userDTO) { 
		User user = new User(); 
		Optional<User> byUsername = userRepository.findByUsername(userDTO.getUsername()); 
		if(byUsername.isPresent()) { 
			throw new RuntimeException("User already registered. Please use different username.");
			} 
		user.setId(userDTO.getId());
		user.setUsername(userDTO.getUsername());
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		user.setRole(userDTO.getRole());
		userRepository.save(user); 
		}
}
