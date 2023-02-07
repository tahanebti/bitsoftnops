package com.tahanebti.bitoftnops.runner;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.tahanebti.bitoftnops.config.SecurityConfig;
import com.tahanebti.bitoftnops.roles.RoleName;
import com.tahanebti.bitoftnops.roles.UserRole;
import com.tahanebti.bitoftnops.users.User;
import com.tahanebti.bitoftnops.users.UserService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class DatabaseInitializer implements CommandLineRunner {
	
	private final UserService userService;

	private final PasswordEncoder passwordEncoder;
	
	  private static final List<User> USERS = Arrays.asList(
			  
			  User.builder()
			  .username("admin")
			  .password("admin")
			  .email("admin@gmail.com")
			  .activated(true)
			  .enabled(true)
			  .roles(Collections.singleton(UserRole.builder().name(RoleName.ROLE_ADMIN).build()))
			  .build(),
			  
			  User.builder()
			  .username("tahanebti")
			  .password("user")
			  .email("taha.nebti@gmail.com")
			  .activated(true)
			  .enabled(true)
			  .roles(Collections.singleton(UserRole.builder().name(RoleName.ROLE_USER).build()))
			  .build()

	    );
	
	@Override
	public void run(String... args) throws Exception {
	    if (!userService.getAll().isEmpty()) {
            return;
        }
        USERS.forEach(user -> {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.save(user);
        });
        
		
	}

	
}
