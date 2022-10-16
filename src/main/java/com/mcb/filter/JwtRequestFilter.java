package com.mcb.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mcb.constants.AuthenticationConfigConstants;
import com.mcb.service.AuthenticationUserDetailService;
import com.mcb.util.JwtUtil;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{

	@Autowired
	private AuthenticationUserDetailService authenticationUserDetailService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String authorizationHeader=request.getHeader(AuthenticationConfigConstants.HEADER_STRING);
		System.out.println("header: "+authorizationHeader);
		String username=null;
		String jwt=null;
		//take user name using token to verify token exists...
		if(authorizationHeader!=null && authorizationHeader.startsWith(AuthenticationConfigConstants.TOKEN_PREFIX)) {
			jwt=authorizationHeader.substring(7);
			username=jwtUtil.extractUsername(jwt);
			System.out.println("jwt: "+jwt +"user: "+username);
		}
		//set SecurityContextHolder->context . before that validate jwt and userDetails
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails userDetails=this.authenticationUserDetailService.loadUserByUsername(username);
			if(jwtUtil.validateToken(jwt, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(
						userDetails, null,userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				
				System.out.println("SecurityContextHolder->context: "+SecurityContextHolder.getContext().getAuthentication());
			}
		}
		filterChain.doFilter(request, response);
	}
	
	
	
	

}
