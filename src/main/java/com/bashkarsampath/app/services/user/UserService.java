package com.bashkarsampath.app.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bashkarsampath.app.entities.User;
import com.bashkarsampath.app.enums.Provider;
import com.bashkarsampath.app.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
	@Autowired
	private UserRepository repo;

	public void processOAuthPostLogin(String username) {
		User existUser = repo.getUserByUsername(username);
		if (existUser == null) {
			User newUser = new User();
			newUser.setUsername(username);
			newUser.setProvider(Provider.GOOGLE);
			newUser.setEnabled(true);
			repo.save(newUser);
			log.info("Created new user: " + username);
		}
	}
}