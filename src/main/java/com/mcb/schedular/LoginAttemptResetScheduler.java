package com.mcb.schedular;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mcb.entity.User;
import com.mcb.repository.UserRepository;

@Component
public class LoginAttemptResetScheduler {
	@Autowired
	private com.mcb.service.UserService userService;
	
	@Autowired
	private UserRepository repository;
	
	
   @Scheduled(cron = "0 0 0/1 1/1 * ?")
   public void cronJob() {
      List<User> users= repository.findAll();
      List<String> usernames=users.stream().filter(s-> s.getAttempt()>=3 && s.getLastUpdatedDate().plusDays(1).isAfter(LocalDateTime.now())).map(s->s.getUsername()).collect(Collectors.toList());
      usernames.forEach(username->{
    		  userService.resetAttemptToZero(username);
      });
   }
}