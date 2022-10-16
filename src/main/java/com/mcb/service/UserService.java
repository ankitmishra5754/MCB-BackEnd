package com.mcb.service;

import com.mcb.entity.User;
import com.mcb.model.UserDTO;

public interface UserService {
	
	public User getUserByUsername (String username);
	public User updateAttempt(String username);
	public User resetAttemptToZero(String username);
	public void createUser(UserDTO userDTO);
}
