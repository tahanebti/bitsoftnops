package com.tahanebti.bitoftnops.users;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

public interface UserService  {

	
	public User save(User user);
	
	public void delete(User user);
	public void deleteById(UUID id);
	public void deleteAll(List<UUID> ids);
	
	public List<User> getAll();
	public Page<User> search(Specification<User> query, Integer _limit, Integer _offset, String _sort);

    Optional<User> getUserByUsername(String username);

    Optional<User> getUserByEmail(String email);

    boolean hasUserWithUsername(String username);

    boolean hasUserWithEmail(String email);

    User validateAndGetUserByUsername(String username);

    public User validateAndGetById(UUID id);
}