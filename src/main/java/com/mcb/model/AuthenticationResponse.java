package com.mcb.model;

public class AuthenticationResponse {
	
	private final String jwt;
	private final String role;
	private final long attempt;

	public AuthenticationResponse(String jwt,String role,long attempts) {
		super();
		this.jwt = jwt;
		this.role=role;
		this.attempt=attempts;
	}

	public String getJwt() {
		return jwt;
	}

	public String getRole() {
		return role;
	}

	public Long getAttempt() {
		return attempt;
	}
	
	
	
	

}
