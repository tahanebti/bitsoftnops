package com.tahanebti.bitoftnops.security;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tahanebti.bitoftnops.users.User;
import com.tahanebti.bitoftnops.users.UserService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

  @Override
  public UserDetails loadUserByUsername(String username) {
      User user = userService.validateAndGetUserByUsername(username);
              
      List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
				.map(r -> {
					return new SimpleGrantedAuthority(r.getAuthority());
				})
				.collect(Collectors.toList());   
      return mapUserToCustomUserDetails(user, authorities);
  }

  private CustomUserDetails mapUserToCustomUserDetails(User user, List<SimpleGrantedAuthority> authorities) {
      CustomUserDetails customUserDetails = new CustomUserDetails();
      customUserDetails.setId(user.getId());
      customUserDetails.setUsername(user.getUsername());
      customUserDetails.setPassword(user.getPassword());
    //  customUserDetails.setName(user.getName());
      customUserDetails.setEmail(user.getEmail());
      customUserDetails.setAuthorities(authorities);
      return customUserDetails;
  }
}