
package com.mcb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcb.entity.User;
import com.mcb.model.AuthenticationResponse;
import com.mcb.model.UserDTO;
import com.mcb.service.AuthenticationUserDetailService;
import com.mcb.service.UserService;
import com.mcb.util.JwtUtil;

@RestController
@RequestMapping("/user")
class UserController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private AuthenticationUserDetailService authenticationUserDetailService;

	@Autowired
	private UserService userService;

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody UserDTO userDTO)
			throws Exception {
		try {
			System.out.println(
					"inside authenticate : User Dto : " + userDTO.getUserName() + " ," + userDTO.getPassword());
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(userDTO.getUserName(), userDTO.getPassword()));
		} catch (BadCredentialsException e) {
			User user = userService.updateAttempt(userDTO.getUserName());
			if (user != null && user.getAttempt() >= 3) {
				return new ResponseEntity<AuthenticationResponse>(
						new AuthenticationResponse("User has been blocked", null, user.getAttempt()), HttpStatus.OK);
			}

			return new ResponseEntity<AuthenticationResponse>(
					new AuthenticationResponse(e.getMessage(), null, user.getAttempt()), HttpStatus.OK);
		}

		final UserDetails userDetails = authenticationUserDetailService.loadUserByUsername(userDTO.getUserName());
		final String jwt = jwtUtil.generateToken(userDetails);
		User user = userService.getUserByUsername(userDTO.getUserName());
		if (user != null && user.getAttempt() >= 3)
			return new ResponseEntity<AuthenticationResponse>(
					new AuthenticationResponse("User Blocked", null, user.getAttempt()), HttpStatus.OK);

		user = userService.resetAttemptToZero(userDTO.getUserName());
		return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse(jwt, user.getRole(), 0),
				HttpStatus.OK);
	}

	@PostMapping("/logout")
	public ResponseEntity<String> logOut(@RequestBody UserDTO userDTO) {
		return new ResponseEntity<String>(jwtUtil.invalidToken(userDTO.getUserName()), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {
		userService.createUser(userDTO);
		return new ResponseEntity<>("User Created", HttpStatus.OK);
	}

}
